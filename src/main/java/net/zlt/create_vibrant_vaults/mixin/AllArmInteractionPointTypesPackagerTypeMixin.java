package net.zlt.create_vibrant_vaults.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import com.simibubi.create.content.kinetics.mechanicalArm.AllArmInteractionPointTypes;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_vibrant_vaults.block.ModBlockTags;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(AllArmInteractionPointTypes.PackagerType.class)
public abstract class AllArmInteractionPointTypesPackagerTypeMixin {
    @ModifyExpressionValue(method = "canCreatePoint", at = @At(value = "INVOKE", target = "Lcom/tterrag/registrate/util/entry/BlockEntry;has(Lnet/minecraft/world/level/block/state/BlockState;)Z", ordinal = 0))
    private boolean createVibrantVaults$hasPackager(boolean original, @Local(argsOnly = true) BlockState state) {
        return original || ModBlockTags.VIBRANT_PACKAGERS.matches(state);
    }
}
