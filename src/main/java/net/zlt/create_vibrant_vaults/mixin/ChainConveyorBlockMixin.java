package net.zlt.create_vibrant_vaults.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import com.simibubi.create.content.kinetics.chainConveyor.ChainConveyorBlock;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.zlt.create_vibrant_vaults.item.ModItemTags;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(ChainConveyorBlock.class)
public abstract class ChainConveyorBlockMixin {
    @ModifyExpressionValue(method = "use", at = @At(value = "INVOKE", target = "Lcom/tterrag/registrate/util/entry/BlockEntry;isIn(Lnet/minecraft/world/item/ItemStack;)Z"))
    private boolean createVibrantVaults$useIsFrogport(boolean original, @Local(argsOnly = true) Player pPlayer, @Local(argsOnly = true) InteractionHand pHand) {
        return original || ModItemTags.VIBRANT_FROGPORTS.matches(pPlayer.getItemInHand(pHand));
    }
}
