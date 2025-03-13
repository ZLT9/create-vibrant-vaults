package net.zlt.create_vibrant_vaults.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import com.simibubi.create.content.logistics.redstoneRequester.RedstoneRequesterBlock;
import net.minecraft.world.item.ItemStack;
import net.zlt.create_vibrant_vaults.item.ModItemTags;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(RedstoneRequesterBlock.class)
public abstract class RedstoneRequesterBlockMixin {
    @ModifyExpressionValue(method = "programRequester", at = @At(value = "INVOKE", target = "Lcom/tterrag/registrate/util/entry/BlockEntry;isIn(Lnet/minecraft/world/item/ItemStack;)Z"), remap = false)
    private static boolean createVibrantVaults$isRequester(boolean original, @Local ItemStack stack) {
        return original || ModItemTags.VIBRANT_REDSTONE_REQUESTERS.matches(stack);
    }
}
