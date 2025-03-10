package net.zlt.create_vibrant_vaults.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import com.simibubi.create.content.logistics.packager.PackagerBlock;
import net.minecraft.world.item.ItemStack;
import net.zlt.create_vibrant_vaults.item.ModItemTags;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(PackagerBlock.class)
public abstract class PackagerBlockMixin {
    @ModifyExpressionValue(method = "use", at = @At(value = "INVOKE", target = "Lcom/tterrag/registrate/util/entry/BlockEntry;isIn(Lnet/minecraft/world/item/ItemStack;)Z", ordinal = 2), remap = false)
    private boolean createVibrantVaults$useIsFrogport(boolean original, @Local ItemStack itemInHand) {
        return original || ModItemTags.VIBRANT_FROGPORTS.matches(itemInHand);
    }

    @ModifyExpressionValue(method = "use", at = @At(value = "INVOKE", target = "Lcom/tterrag/registrate/util/entry/BlockEntry;isIn(Lnet/minecraft/world/item/ItemStack;)Z", ordinal = 1), remap = false)
    private boolean createVibrantVaults$useIsStockLink(boolean original, @Local ItemStack itemInHand) {
        return original || ModItemTags.VIBRANT_STOCK_LINKS.matches(itemInHand);
    }
}
