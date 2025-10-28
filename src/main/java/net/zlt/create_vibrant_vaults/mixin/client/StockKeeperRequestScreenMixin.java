package net.zlt.create_vibrant_vaults.mixin.client;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.simibubi.create.content.logistics.stockTicker.StockKeeperRequestScreen;
import net.minecraft.world.item.ItemStack;
import net.zlt.create_vibrant_vaults.item.ModItemTags;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(StockKeeperRequestScreen.class)
public abstract class StockKeeperRequestScreenMixin {
    @Shadow(remap = false)
    ItemStack itemToProgram;

    @ModifyExpressionValue(method = "<init>", at = @At(value = "INVOKE", target = "Lcom/tterrag/registrate/util/entry/BlockEntry;isIn(Lnet/minecraft/world/item/ItemStack;)Z", ordinal = 0), remap = false)
    private boolean createVibrantVaults$isRedstoneRequester(boolean original) {
        return original || ModItemTags.VIBRANT_REDSTONE_REQUESTERS.matches(itemToProgram);
    }
}
