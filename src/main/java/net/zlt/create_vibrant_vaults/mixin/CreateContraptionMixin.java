package net.zlt.create_vibrant_vaults.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import com.simibubi.create.content.contraptions.Contraption;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.zlt.create_vibrant_vaults.AbstractItemVaultBlockEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Contraption.class)
public abstract class CreateContraptionMixin {
    @Shadow
    protected abstract BlockPos toLocalPos(BlockPos globalPos);

    @Inject(method = "getBlockEntityNBT", at = @At(value = "RETURN", ordinal = 1))
    private void createVibrantVaults$getBlockEntityNBT(Level world, BlockPos pos, CallbackInfoReturnable<CompoundTag> cir, @Local BlockEntity blockEntity, @Local CompoundTag nbt) {
        if (blockEntity instanceof AbstractItemVaultBlockEntity && nbt.contains("Controller")) {
            nbt.put("Controller", NbtUtils.writeBlockPos(toLocalPos(NbtUtils.readBlockPos(nbt.getCompound("Controller")))));
        }
    }
}
