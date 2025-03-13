package net.zlt.create_vibrant_vaults.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import com.simibubi.create.content.logistics.packager.PackagerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_vibrant_vaults.block.ModBlockTags;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(PackagerBlockEntity.class)
public abstract class PackagerBlockEntityMixin {
    @ModifyExpressionValue(method = "submitNewArrivals", at = @At(value = "INVOKE", target = "Lcom/tterrag/registrate/util/entry/BlockEntry;has(Lnet/minecraft/world/level/block/state/BlockState;)Z", ordinal = 1), remap = false)
    private boolean createVibrantVaults$submitNewArrivalsHasStockLink(boolean original, @Local BlockState adjacentState) {
        return original || ModBlockTags.VIBRANT_STOCK_LINKS.matches(adjacentState);
    }

    @ModifyExpressionValue(method = "getLinkPos", at = @At(value = "INVOKE", target = "Lcom/tterrag/registrate/util/entry/BlockEntry;has(Lnet/minecraft/world/level/block/state/BlockState;)Z"), remap = false)
    private boolean createVibrantVaults$getLinkPosHasStockLink(boolean original, @Local BlockState adjacentState) {
        return original || ModBlockTags.VIBRANT_STOCK_LINKS.matches(adjacentState);
    }

    @ModifyExpressionValue(method = "flashLink", at = @At(value = "INVOKE", target = "Lcom/tterrag/registrate/util/entry/BlockEntry;has(Lnet/minecraft/world/level/block/state/BlockState;)Z"), remap = false)
    private boolean createVibrantVaults$flashLinkHasStockLink(boolean original, @Local BlockState adjacentState) {
        return original || ModBlockTags.VIBRANT_STOCK_LINKS.matches(adjacentState);
    }
}
