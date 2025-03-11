package net.zlt.create_vibrant_vaults.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import com.simibubi.create.content.logistics.vault.ItemVaultBlockEntity;
import com.simibubi.create.foundation.blockEntity.IMultiBlockEntityContainer;
import com.simibubi.create.foundation.blockEntity.SmartBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_vibrant_vaults.block.ItemVaultConnectivityHelper;
import net.zlt.create_vibrant_vaults.block.ModBlockTags;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ItemVaultBlockEntity.class)
public abstract class ItemVaultBlockEntityMixin extends SmartBlockEntity {
    @Shadow(remap = false)
    public abstract int getMaxWidth();

    @Shadow(remap = false)
    public abstract ItemVaultBlockEntity getControllerBE();

    private ItemVaultBlockEntityMixin(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    @Redirect(method = "removeController", at = @At(value = "INVOKE", target = "Lcom/simibubi/create/content/logistics/vault/ItemVaultBlock;isVault(Lnet/minecraft/world/level/block/state/BlockState;)Z"), remap = false)
    private boolean createVibrantVaults$removeControllerIsVault(BlockState state) {
        return ItemVaultConnectivityHelper.isVault(getBlockState(), state);
    }

    @Redirect(method = "notifyMultiUpdated", at = @At(value = "INVOKE", target = "Lcom/simibubi/create/content/logistics/vault/ItemVaultBlock;isVault(Lnet/minecraft/world/level/block/state/BlockState;)Z"), remap = false)
    private boolean createVibrantVaults$notifyMultiUpdatedIsVault(BlockState state) {
        return ItemVaultConnectivityHelper.isVault(state);
    }

    @Redirect(method = "updateConnectivity", at = @At(value = "INVOKE", target = "Lcom/simibubi/create/api/connectivity/ConnectivityHandler;formMulti(Lnet/minecraft/world/level/block/entity/BlockEntity;)V"), remap = false)
    private <T extends BlockEntity & IMultiBlockEntityContainer> void createVibrantVaults$formMulti(T be) {
        ItemVaultConnectivityHelper.formItemVaultMulti(be);
    }

    @Redirect(method = "initCapability", at = @At(value = "INVOKE", target = "Lcom/simibubi/create/api/connectivity/ConnectivityHandler;partAt(Lnet/minecraft/world/level/block/entity/BlockEntityType;Lnet/minecraft/world/level/BlockGetter;Lnet/minecraft/core/BlockPos;)Lnet/minecraft/world/level/block/entity/BlockEntity;"), remap = false)
    private <T extends BlockEntity & IMultiBlockEntityContainer> T createVibrantVaults$partAt(BlockEntityType<?> type, BlockGetter level, BlockPos pos) {
        return ItemVaultConnectivityHelper.partAt(this, level, pos);
    }

    @WrapOperation(method = "getMaxLength(Lnet/minecraft/core/Direction$Axis;I)I", at = @At(value = "INVOKE", target = "Lcom/simibubi/create/content/logistics/vault/ItemVaultBlockEntity;getMaxWidth()I"), remap = false)
    private int createVibrantVaults$getMaxHeight(ItemVaultBlockEntity instance, Operation<Integer> original, @Local(argsOnly = true) int width) {
        return ModBlockTags.VERTICAL_VAULTS.matches(getBlockState()) ? ItemVaultBlockEntity.getMaxLength(width) : original.call(instance);
    }

    @WrapOperation(method = "getMaxLength(Lnet/minecraft/core/Direction$Axis;I)I", at = @At(value = "INVOKE", target = "Lcom/simibubi/create/content/logistics/vault/ItemVaultBlockEntity;getMaxLength(I)I"), remap = false)
    private int createVibrantVaults$getMaxHeight(int radius, Operation<Integer> original, @Local(argsOnly = true) int width) {
        return ModBlockTags.VERTICAL_VAULTS.matches(getBlockState()) ? getMaxWidth() : original.call(radius);
    }

    @Inject(method = "updateComparators", at = @At("HEAD"), cancellable = true, remap = false)
    private void createVibrantVaults$updateComparators(CallbackInfo ci) {
        if (!ModBlockTags.VERTICAL_VAULTS.matches(getBlockState())) {
            return;
        }

        ItemVaultBlockEntity controllerBE = getControllerBE();
        if (controllerBE == null) {
            return;
        }

        level.blockEntityChanged(controllerBE.getBlockPos());

        BlockPos pos = controllerBE.getBlockPos();
        for (int y = 0; y < controllerBE.getHeight(); y++) {
            for (int z = 0; z < controllerBE.getWidth(); z++) {
                for (int x = 0; x < controllerBE.getWidth(); x++) {
                    level.updateNeighbourForOutputSignal(pos.offset(x, y, z), getBlockState().getBlock());
                }
            }
        }

        ci.cancel();
    }

    @ModifyExpressionValue(method = "initCapability", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/BlockPos;offset(III)Lnet/minecraft/core/BlockPos;", ordinal = 1))
    private BlockPos createVibrantVaults$getVaultPos(BlockPos original, @Local(ordinal = 0) int yOffset, @Local(ordinal = 1) int xOffset, @Local(ordinal = 2) int zOffset) {
        return ModBlockTags.VERTICAL_VAULTS.matches(getBlockState()) ? getBlockPos().offset(xOffset, yOffset, zOffset) : original;
    }
}
