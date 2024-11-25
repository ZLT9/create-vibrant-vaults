package net.zlt.create_vibrant_vaults.ct;

import com.simibubi.create.foundation.block.connected.CTSpriteShiftEntry;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public abstract class AbstractVerticalItemVaultCTBehaviour extends AbstractItemVaultCTBehaviour {
    @Override
    protected CTSpriteShiftEntry getFrontSpriteShiftEntry(boolean small) {
        return null;
    }

    @Override
    protected CTSpriteShiftEntry getBottomSpriteShiftEntry(boolean small) {
        return null;
    }

    @Override
    public CTSpriteShiftEntry getShift(BlockState state, Direction direction, @Nullable TextureAtlasSprite sprite) {
        if (getVaultBlockAxis(state) == null) {
            return null;
        }

        boolean small = !isLarge(state);
        return direction.getAxis().isVertical() ? getTopSpriteShiftEntry(small) : getSideSpriteShiftEntry(small);
    }

    @Override
    protected Direction getUpDirection(BlockAndTintGetter reader, BlockPos pos, BlockState state, Direction face) {
        return face.getAxis().isVertical() ? Direction.NORTH : Direction.UP;
    }

    @Override
    protected Direction getRightDirection(BlockAndTintGetter reader, BlockPos pos, BlockState state, Direction face) {
        return face.getAxis() == Direction.Axis.X ? Direction.SOUTH : Direction.WEST;
    }
}
