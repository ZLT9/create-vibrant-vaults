package net.zlt.create_vibrant_vaults.mixin;

import com.simibubi.create.content.logistics.vault.ItemVaultBlock;
import com.simibubi.create.foundation.blockEntity.IMultiBlockEntityContainer;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_vibrant_vaults.block.ItemVaultConnectivityHelper;
import net.zlt.create_vibrant_vaults.block.ModBlockTags;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ItemVaultBlock.class)
public abstract class ItemVaultBlockMixin extends Block {
    private ItemVaultBlockMixin(Properties properties) {
        super(properties);
    }

    @Redirect(method = "onWrenched", at = @At(value = "INVOKE", target = "Lcom/simibubi/create/api/connectivity/ConnectivityHandler;splitMulti(Lnet/minecraft/world/level/block/entity/BlockEntity;)V"), remap = false)
    private <T extends BlockEntity & IMultiBlockEntityContainer> void createVibrantVaults$onWrenchedSplitMulti(T be) {
        ItemVaultConnectivityHelper.splitItemVaultMulti(be);
    }

    @Redirect(method = "onRemove", at = @At(value = "INVOKE", target = "Lcom/simibubi/create/api/connectivity/ConnectivityHandler;splitMulti(Lnet/minecraft/world/level/block/entity/BlockEntity;)V"), remap = false)
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
}
