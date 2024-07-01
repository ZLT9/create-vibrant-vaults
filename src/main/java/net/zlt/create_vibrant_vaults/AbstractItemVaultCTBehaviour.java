package net.zlt.create_vibrant_vaults;

import com.simibubi.create.api.connectivity.ConnectivityHandler;
import com.simibubi.create.foundation.block.connected.CTSpriteShiftEntry;
import com.simibubi.create.foundation.block.connected.ConnectedTextureBehaviour;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public abstract class AbstractItemVaultCTBehaviour extends ConnectedTextureBehaviour.Base {
    protected abstract Direction.Axis getVaultBlockAxis(BlockState state);

    protected abstract boolean isLarge(BlockState state);

    protected abstract CTSpriteShiftEntry getFrontSpriteShiftEntry(boolean small);

    protected abstract CTSpriteShiftEntry getTopSpriteShiftEntry(boolean small);

    protected abstract CTSpriteShiftEntry getBottomSpriteShiftEntry(boolean small);

    protected abstract CTSpriteShiftEntry getSideSpriteShiftEntry(boolean small);

    @Override
    public CTSpriteShiftEntry getShift(BlockState state, Direction direction, @Nullable TextureAtlasSprite sprite) {
        Direction.Axis vaultBlockAxis = getVaultBlockAxis(state);
        if (vaultBlockAxis == null) {
            return null;
        }

        boolean small = !isLarge(state);

        if (direction.getAxis() == vaultBlockAxis) {
            return getFrontSpriteShiftEntry(small);
        }

        if (direction == Direction.UP) {
            return getTopSpriteShiftEntry(small);
        }

        if (direction == Direction.DOWN) {
            return getBottomSpriteShiftEntry(small);
        }

        return getSideSpriteShiftEntry(small);
    }

    @Override
    protected Direction getUpDirection(BlockAndTintGetter reader, BlockPos pos, BlockState state, Direction face) {
        Direction.Axis vaultBlockAxis = getVaultBlockAxis(state);
        boolean alongX = vaultBlockAxis == Direction.Axis.X;

        if (face.getAxis().isVertical() && alongX) {
            return super.getUpDirection(reader, pos, state, face).getClockWise();
        }

        if (face.getAxis() == vaultBlockAxis || face.getAxis().isVertical()) {
            return super.getUpDirection(reader, pos, state, face);
        }

        return Direction.fromAxisAndDirection(vaultBlockAxis, alongX ? Direction.AxisDirection.POSITIVE : Direction.AxisDirection.NEGATIVE);
    }

    @Override
    protected Direction getRightDirection(BlockAndTintGetter reader, BlockPos pos, BlockState state, Direction face) {
        Direction.Axis vaultBlockAxis = getVaultBlockAxis(state);

        if (face.getAxis().isVertical() && vaultBlockAxis == Direction.Axis.X) {
            return super.getRightDirection(reader, pos, state, face).getClockWise();
        }

        if (face.getAxis() == vaultBlockAxis || face.getAxis().isVertical()) {
            return super.getRightDirection(reader, pos, state, face);
        }

        return Direction.fromAxisAndDirection(Direction.Axis.Y, face.getAxisDirection());
    }

    public boolean buildContextForOccludedDirections() {
        return super.buildContextForOccludedDirections();
    }

    @Override
    public boolean connectsTo(BlockState state, BlockState other, BlockAndTintGetter reader, BlockPos pos, BlockPos otherPos, Direction face) {
        return state == other && ConnectivityHandler.isConnected(reader, pos, otherPos);
    }
}
