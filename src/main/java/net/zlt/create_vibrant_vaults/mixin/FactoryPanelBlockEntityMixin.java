package net.zlt.create_vibrant_vaults.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.simibubi.create.content.logistics.factoryBoard.FactoryPanelBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_vibrant_vaults.block.ModBlockTags;
import net.zlt.create_vibrant_vaults.block.ModBlocks;
import net.zlt.create_vibrant_vaults.block.VibrantPackagerBlock;
import net.zlt.create_vibrant_vaults.duck.FactoryPanelBlockEntityRenderDataMixinDuck;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(FactoryPanelBlockEntity.class)
public abstract class FactoryPanelBlockEntityMixin {
    @Shadow(remap = false)
    public boolean restocker;

    @Unique
    private static BlockState createVibrantVaults$lazyTickBlockState = null;

    @Unique
    private ModBlocks.VibrantVaultColor createVibrantVaults$restockerColor = null;

    @Inject(method = "<init>", at = @At("TAIL"), remap = false)
    private void createVibrantVaults$initRestockerColor(BlockEntityType<?> type, BlockPos pos, BlockState state, CallbackInfo ci) {
        createVibrantVaults$restockerColor = ModBlocks.VibrantVaultColor.BASE;
    }

    @ModifyExpressionValue(method = "lazyTick", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/Level;getBlockState(Lnet/minecraft/core/BlockPos;)Lnet/minecraft/world/level/block/state/BlockState;"))
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

    @Inject(method = "lazyTick", at = @At(value = "INVOKE", target = "Lcom/simibubi/create/content/logistics/factoryBoard/FactoryPanelBlockEntity;sendData()V"), remap = false)
    private void createVibrantVaults$setRestockerColor(CallbackInfo ci) {
        createVibrantVaults$restockerColor = restocker && createVibrantVaults$lazyTickBlockState.getBlock() instanceof VibrantPackagerBlock vibrantPackager ? vibrantPackager.color : ModBlocks.VibrantVaultColor.BASE;
    }

    @Inject(method = "read", at = @At("TAIL"), remap = false)
    private void createVibrantVaults$readRestockerColor(CompoundTag tag, boolean clientPacket, CallbackInfo ci) {
        createVibrantVaults$restockerColor = ModBlocks.VibrantVaultColor.byName(tag.getString("CreateVibrantVaultsRestockerColor"));
    }

    @Inject(method = "write", at = @At("TAIL"), remap = false)
    private void createVibrantVaults$writeRestockerColor(CompoundTag tag, boolean clientPacket, CallbackInfo ci) {
        if (createVibrantVaults$restockerColor != null) {
            tag.putString("CreateVibrantVaultsRestockerColor", createVibrantVaults$restockerColor.getSerializedName());
        }
    }

    @ModifyReturnValue(method = "getRenderData", at = @At(value = "RETURN"), remap = false)
    private Object createVibrantVaults$getExtraData(Object original) {
        ((FactoryPanelBlockEntityRenderDataMixinDuck) original).createVibrantVaults$setRestockerColor(createVibrantVaults$restockerColor);
        return original;
    }
}
