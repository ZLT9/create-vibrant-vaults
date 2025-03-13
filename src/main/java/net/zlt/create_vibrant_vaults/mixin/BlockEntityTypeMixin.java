package net.zlt.create_vibrant_vaults.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.llamalad7.mixinextras.sugar.Local;
import com.simibubi.create.AllBlockEntityTypes;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_vibrant_vaults.block.ModBlockTags;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(BlockEntityType.class)
public abstract class BlockEntityTypeMixin {
    @SuppressWarnings("EqualsBetweenInconvertibleTypes")
    @ModifyReturnValue(method = "isValid", at = @At("RETURN"))
    private boolean createVibrantVaults$isValid(boolean original, @Local(argsOnly = true) BlockState state) {
        if (original) {
            return true;
        }

        if (equals(AllBlockEntityTypes.ITEM_VAULT.get())) {
            return ModBlockTags.VIBRANT_VAULTS.matches(state);
        }

        if (equals(AllBlockEntityTypes.PACKAGE_FROGPORT.get())) {
            return ModBlockTags.VIBRANT_FROGPORTS.matches(state);
        }

        if (equals(AllBlockEntityTypes.PACKAGER_LINK.get())) {
            return ModBlockTags.VIBRANT_STOCK_LINKS.matches(state);
        }

        if (equals(AllBlockEntityTypes.REDSTONE_REQUESTER.get())) {
            return ModBlockTags.VIBRANT_REDSTONE_REQUESTERS.matches(state);
        }

        if (equals(AllBlockEntityTypes.PACKAGER.get())) {
            return ModBlockTags.VIBRANT_PACKAGERS.matches(state);
        }

        return false;
    }
}
