package net.zlt.create_vibrant_vaults.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import com.simibubi.create.content.kinetics.chainConveyor.ChainConveyorInteractionHandler;
import net.minecraft.world.item.ItemStack;
import net.zlt.create_vibrant_vaults.item.ModItemTags;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(ChainConveyorInteractionHandler.class)
public abstract class ChainConveyorInteractionHandlerMixin {
    @ModifyExpressionValue(method = "isActive", at = @At(value = "INVOKE", target = "Lcom/tterrag/registrate/util/entry/BlockEntry;isIn(Lnet/minecraft/world/item/ItemStack;)Z"), remap = false)
    private static boolean createVibrantVaults$isActiveIsFrogport(boolean original, @Local ItemStack mainHandItem) {
        return original || ModItemTags.VIBRANT_FROGPORTS.matches(mainHandItem);
    }

    @ModifyExpressionValue(method = "onUse", at = @At(value = "INVOKE", target = "Lcom/tterrag/registrate/util/entry/BlockEntry;isIn(Lnet/minecraft/world/item/ItemStack;)Z"), remap = false)
    private static boolean createVibrantVaults$onUseIsFrogport(boolean original, @Local ItemStack mainHandItem) {
        return original || ModItemTags.VIBRANT_FROGPORTS.matches(mainHandItem);
    }
}
