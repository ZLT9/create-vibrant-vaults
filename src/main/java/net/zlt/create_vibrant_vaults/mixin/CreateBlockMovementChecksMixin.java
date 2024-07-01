package net.zlt.create_vibrant_vaults.mixin;

import com.simibubi.create.api.connectivity.ConnectivityHandler;
import com.simibubi.create.content.contraptions.BlockMovementChecks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_vibrant_vaults.AbstractItemVaultBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BlockMovementChecks.class)
public class CreateBlockMovementChecksMixin {
    @Inject(method = "isBlockAttachedTowardsFallback", at = @At("HEAD"), cancellable = true)
    private static void createVibrantVaults$isBlockAttachedTowardsFallback(BlockState state, Level world, BlockPos pos, Direction direction, CallbackInfoReturnable<Boolean> cir) {
        if (state.getBlock() instanceof AbstractItemVaultBlock) {
            cir.setReturnValue(ConnectivityHandler.isConnected(world, pos, pos.relative(direction)));
        }
    }
}
