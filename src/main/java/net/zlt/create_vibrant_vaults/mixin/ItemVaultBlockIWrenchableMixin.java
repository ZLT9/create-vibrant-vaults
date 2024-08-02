package net.zlt.create_vibrant_vaults.mixin;

import com.simibubi.create.content.equipment.wrench.IWrenchable;
import com.simibubi.create.content.logistics.vault.ItemVaultBlock;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_vibrant_vaults.block.AllBlocks;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(IWrenchable.class)
public interface ItemVaultBlockIWrenchableMixin {
    @Inject(method = "getRotatedBlockState", at = @At("HEAD"), cancellable = true)
    default void createVibrantVaults$getRotatedBlockState(BlockState originalState, Direction targetedFace, CallbackInfoReturnable<BlockState> cir) {
        if (!(originalState.getBlock() instanceof ItemVaultBlock)) {
            return;
        }

        Direction.Axis targetedAxis = targetedFace.getAxis();
        if (targetedAxis.isHorizontal() && targetedAxis != originalState.getValue(ItemVaultBlock.HORIZONTAL_AXIS)) {
            cir.setReturnValue(AllBlocks.VERTICAL_ITEM_VAULT.getDefaultState());
        }
    }
}
