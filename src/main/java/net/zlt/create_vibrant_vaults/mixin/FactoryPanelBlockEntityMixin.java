package net.zlt.create_vibrant_vaults.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.simibubi.create.content.logistics.factoryBoard.FactoryPanelBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_vibrant_vaults.block.ModBlockTags;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(FactoryPanelBlockEntity.class)
public abstract class FactoryPanelBlockEntityMixin {
    @Unique
    private static BlockState createVibrantVaults$lazyTickBlockState = null;

    @ModifyExpressionValue(method = "lazyTick", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/Level;getBlockState(Lnet/minecraft/core/BlockPos;)Lnet/minecraft/world/level/block/state/BlockState;"), remap = false)
    private BlockState createVibrantVaults$grabLazyTickBlockState(BlockState original) {
        createVibrantVaults$lazyTickBlockState = original;
        return original;
    }

    @ModifyExpressionValue(method = "lazyTick", at = @At(value = "INVOKE", target = "Lcom/tterrag/registrate/util/entry/BlockEntry;has(Lnet/minecraft/world/level/block/state/BlockState;)Z", ordinal = 1), remap = false)
    private boolean createVibrantVaults$hasPackager(boolean original) {
        return original || createVibrantVaults$lazyTickBlockState != null && ModBlockTags.VIBRANT_PACKAGERS.matches(createVibrantVaults$lazyTickBlockState);
    }

    @Inject(method = "lazyTick", at = @At("RETURN"), remap = false)
    private void createVibrantVaults$clearLazyTickBlockState(CallbackInfo ci) {
        createVibrantVaults$lazyTickBlockState = null;
    }
}
