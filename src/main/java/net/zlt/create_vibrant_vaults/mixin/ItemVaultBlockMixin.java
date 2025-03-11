package net.zlt.create_vibrant_vaults.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.simibubi.create.AllBlocks;
import com.simibubi.create.content.equipment.wrench.IWrenchable;
import com.simibubi.create.content.kinetics.base.GeneratingKineticBlockEntity;
import com.simibubi.create.content.kinetics.base.KineticBlockEntity;
import com.simibubi.create.content.logistics.vault.ItemVaultBlock;
import com.simibubi.create.foundation.blockEntity.IMultiBlockEntityContainer;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_vibrant_vaults.block.ItemVaultConnectivityHelper;
import net.zlt.create_vibrant_vaults.block.ModBlockTags;
import net.zlt.create_vibrant_vaults.block.ModBlocks;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ItemVaultBlock.class)
public abstract class ItemVaultBlockMixin extends Block implements IWrenchable {
    private ItemVaultBlockMixin(Properties properties) {
        super(properties);
    }

    @Redirect(method = "onWrenched", at = @At(value = "INVOKE", target = "Lcom/simibubi/create/api/connectivity/ConnectivityHandler;splitMulti(Lnet/minecraft/world/level/block/entity/BlockEntity;)V"), remap = false)
    private <T extends BlockEntity & IMultiBlockEntityContainer> void createVibrantVaults$onWrenchedSplitMulti(T be) {
        ItemVaultConnectivityHelper.splitItemVaultMulti(be);
    }

    @Redirect(method = "onRemove", at = @At(value = "INVOKE", target = "Lcom/simibubi/create/api/connectivity/ConnectivityHandler;splitMulti(Lnet/minecraft/world/level/block/entity/BlockEntity;)V"))
    private <T extends BlockEntity & IMultiBlockEntityContainer> void createVibrantVaults$onRemoveSplitMulti(T be) {
        ItemVaultConnectivityHelper.splitItemVaultMulti(be);
    }

    @Inject(method = "getVaultBlockAxis", at = @At("HEAD"), cancellable = true, remap = false)
    private static void createVibrantVaults$getVerticalVaultAxis(BlockState state, CallbackInfoReturnable<Direction.Axis> cir) {
        if (ModBlockTags.VERTICAL_VAULTS.matches(state)) {
            cir.setReturnValue(Direction.Axis.Y);
        }
    }

    @Redirect(method = "getVaultBlockAxis", at = @At(value = "INVOKE", target = "Lcom/simibubi/create/content/logistics/vault/ItemVaultBlock;isVault(Lnet/minecraft/world/level/block/state/BlockState;)Z"), remap = false)
    private static boolean createVibrantVaults$getVaultBlockAxisIsVault(BlockState state) {
        return ItemVaultConnectivityHelper.isVault(state);
    }

    @Redirect(method = "isLarge", at = @At(value = "INVOKE", target = "Lcom/simibubi/create/content/logistics/vault/ItemVaultBlock;isVault(Lnet/minecraft/world/level/block/state/BlockState;)Z"), remap = false)
    private static boolean createVibrantVaults$isLargeIsVault(BlockState state) {
        return ItemVaultConnectivityHelper.isVault(state);
    }

    @Redirect(method = "getStateForPlacement", at = @At(value = "INVOKE", target = "Lcom/simibubi/create/content/logistics/vault/ItemVaultBlock;getVaultBlockAxis(Lnet/minecraft/world/level/block/state/BlockState;)Lnet/minecraft/core/Direction$Axis;"))
    private Direction.Axis createVibrantVaults$getVaultPreferredAxis(BlockState state) {
        return ItemVaultConnectivityHelper.getItemVaultPreferredAxis(this, state);
    }

    // Equivalent to IWrenchableMixin.createVibrantVaults$rotateItemVault on Fabric
    @WrapOperation(method = "onWrenched", at = @At(value = "INVOKE", target = "Lcom/simibubi/create/content/equipment/wrench/IWrenchable;onWrenched(Lnet/minecraft/world/level/block/state/BlockState;Lnet/minecraft/world/item/context/UseOnContext;)Lnet/minecraft/world/InteractionResult;"), remap = false)
    private InteractionResult createVibrantVaults$onWrenched(ItemVaultBlock instance, BlockState state, UseOnContext context, Operation<InteractionResult> original) {
        if (!state.is(AllBlocks.ITEM_VAULT.get())) {
            return original.call(instance, state, context);
        }

        Direction targetedFace = context.getClickedFace();
        if (!targetedFace.getAxis().isHorizontal() || targetedFace.getAxis() == state.getValue(ItemVaultBlock.HORIZONTAL_AXIS)) {
            return original.call(instance, state, context);
        }

        Level world = context.getLevel();
        BlockState rotated = ModBlocks.getVibrantVault(ModBlocks.VibrantVaultType.ITEM_VAULT, ModBlocks.VibrantVaultColor.BASE, true).getDefaultState();

        if (!rotated.canSurvive(world, context.getClickedPos())) {
            return InteractionResult.PASS;
        }

        KineticBlockEntity.switchToBlockState(world, context.getClickedPos(), updateAfterWrenched(rotated, context));

        if (context.getLevel().getBlockEntity(context.getClickedPos()) instanceof GeneratingKineticBlockEntity be) {
            be.reActivateSource = true;
        }

        if (world.getBlockState(context.getClickedPos()) != state) {
            IWrenchable.playRotateSound(world, context.getClickedPos());
        }

        return InteractionResult.SUCCESS;
    }
}
