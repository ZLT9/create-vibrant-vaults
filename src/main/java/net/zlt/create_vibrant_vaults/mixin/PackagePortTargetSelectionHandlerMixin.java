package net.zlt.create_vibrant_vaults.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import com.simibubi.create.content.logistics.packagePort.PackagePortTargetSelectionHandler;
import net.minecraft.client.player.LocalPlayer;
import net.zlt.create_vibrant_vaults.item.ModItemTags;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(PackagePortTargetSelectionHandler.class)
public abstract class PackagePortTargetSelectionHandlerMixin {
    @ModifyExpressionValue(method = "tick", at = @At(value = "INVOKE", target = "Lcom/tterrag/registrate/util/entry/BlockEntry;isIn(Lnet/minecraft/world/item/ItemStack;)Z"), remap = false)
    private static boolean createVibrantVaults$isFrogport(boolean original, @Local LocalPlayer player) {
        return original || ModItemTags.VIBRANT_FROGPORTS.matches(player.getMainHandItem());
    }
}
