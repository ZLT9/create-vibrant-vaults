package net.zlt.create_vibrant_vaults.mixin;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.content.equipment.wrench.IWrenchable;
import com.simibubi.create.content.logistics.vault.ItemVaultBlock;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_vibrant_vaults.block.ModBlocks;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(IWrenchable.class)
public interface IWrenchableMixin {
    @Inject(method = "getRotatedBlockState", at = @At("HEAD"), cancellable = true)
    private void createVibrantVaults$rotateItemVault(BlockState originalState, Direction targetedFace, CallbackInfoReturnable<BlockState> cir) {
        if (originalState.getBlock() == AllBlocks.ITEM_VAULT.get() && targetedFace.getAxis().isHorizontal() && targetedFace.getAxis() != originalState.getValue(ItemVaultBlock.HORIZONTAL_AXIS)) {
            cir.setReturnValue(ModBlocks.getVibrantVault(ModBlocks.VibrantVaultType.ITEM_VAULT, ModBlocks.VibrantVaultColor.BASE, true).getDefaultState());
        }
    }
}
