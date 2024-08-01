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
    public CTSpriteShiftEntry getShift(BlockState state, Direction direction, @Nullable TextureAtlasSprite sprite) {
        if (getVaultBlockAxis(state) == null) {
            return null;
        }

        boolean small = !isLarge(state);

        if (direction.getAxis().isVertical()) {
            return getFrontSpriteShiftEntry(small);
        }

        return getTopSpriteShiftEntry(small);
    }

    @Override
    protected Direction getUpDirection(BlockAndTintGetter reader, BlockPos pos, BlockState state, Direction face) {
        if (face == Direction.SOUTH) {
            return Direction.UP;
        }
        if (face == Direction.UP) {
            return Direction.NORTH;
        }
        if (face == Direction.DOWN) {
            return Direction.SOUTH;
        }
        return Direction.DOWN;
    }

    @Override
    protected Direction getRightDirection(BlockAndTintGetter reader, BlockPos pos, BlockState state, Direction face) {
        if (face == Direction.NORTH) {
            return Direction.EAST;
        }
        if (face == Direction.SOUTH) {
            return Direction.WEST;
        }
        if (face == Direction.WEST) {
            return Direction.SOUTH;
        }
        if (face == Direction.EAST) {
            return Direction.NORTH;
        }
        if (face == Direction.UP) {
            return Direction.WEST;
        }
        return Direction.EAST;
    }
}
