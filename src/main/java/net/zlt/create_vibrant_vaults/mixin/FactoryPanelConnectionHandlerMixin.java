package net.zlt.create_vibrant_vaults.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.simibubi.create.content.logistics.factoryBoard.FactoryPanelConnectionHandler;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_vibrant_vaults.block.ModBlockTags;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(FactoryPanelConnectionHandler.class)
public abstract class FactoryPanelConnectionHandlerMixin {
    @Unique
    private static BlockState createVibrantVaults$clientTickBlockState = null;

    @ModifyExpressionValue(method = "clientTick", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/multiplayer/ClientLevel;getBlockState(Lnet/minecraft/core/BlockPos;)Lnet/minecraft/world/level/block/state/BlockState;"))
    private static BlockState createVibrantVaults$grabClientTickBlockState(BlockState original) {
        createVibrantVaults$clientTickBlockState = original;
        return original;
    }

    @ModifyExpressionValue(method = "clientTick", at = @At(value = "INVOKE", target = "Lcom/tterrag/registrate/util/entry/BlockEntry;has(Lnet/minecraft/world/level/block/state/BlockState;)Z"))
    private static boolean createVibrantVaults$hasPackager(boolean original) {
        return original || createVibrantVaults$clientTickBlockState != null && ModBlockTags.VIBRANT_PACKAGERS.matches(createVibrantVaults$clientTickBlockState);
    }

    @Inject(method = "clientTick", at = @At("RETURN"), remap = false)
    private static void createVibrantVaults$clearClientTickBlockState(CallbackInfo ci) {
        createVibrantVaults$clientTickBlockState = null;
    }
}
