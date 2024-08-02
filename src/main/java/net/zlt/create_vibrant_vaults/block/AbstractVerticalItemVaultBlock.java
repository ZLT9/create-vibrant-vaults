package net.zlt.create_vibrant_vaults.block;

import com.simibubi.create.api.connectivity.ConnectivityHandler;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.zlt.create_vibrant_vaults.block.entity.AbstractVerticalItemVaultBlockEntity;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public abstract class AbstractVerticalItemVaultBlock<BE extends AbstractVerticalItemVaultBlockEntity<BE>> extends AbstractItemVaultBlock<BE> {
    public AbstractVerticalItemVaultBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(LARGE);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return this.defaultBlockState();
    }

    @Override
    public void onPlace(BlockState pState, Level pLevel, BlockPos pPos, BlockState pOldState, boolean pIsMoving) {
        if (pOldState.getBlock() != pState.getBlock() && !pIsMoving) {
            withBlockEntityDo(pLevel, pPos, isPlacingNbt() ? AbstractVerticalItemVaultBlockEntity::queueConnectivityUpdate : AbstractVerticalItemVaultBlockEntity::updateConnectivity);
        }
    }

    @Override
    public InteractionResult onWrenched(BlockState state, UseOnContext context) {
        if (context.getClickedFace().getAxis().isHorizontal()) {
            BlockEntity blockEntity = context.getLevel().getBlockEntity(context.getClickedPos());
            BE be = blockEntity == null ? null : getAsBE(blockEntity);
            if (be != null) {
                ConnectivityHandler.splitMulti(be);
                be.removeController(true);
            }

            state = state.setValue(LARGE, false);
        }

        return defaultOnWrenched(state, context);
    }

    @Override
    public BlockState getRotatedBlockState(BlockState originalState, Direction targetedFace) {
        Direction.Axis targetedAxis = targetedFace.getAxis();
        if (targetedAxis.isHorizontal()) {
            Block horizontal = getHorizontalVaultBlock();
            if (horizontal == null) {
                return originalState;
            }

            BlockState horizontalState = horizontal.defaultBlockState();
            if (horizontalState.hasProperty(HORIZONTAL_AXIS)) {
                return horizontalState.setValue(HORIZONTAL_AXIS, targetedAxis == Direction.Axis.X ? Direction.Axis.Z : Direction.Axis.X);
            }

            return horizontalState;
        }

        return originalState;
    }

    @Nullable
    public Block getHorizontalVaultBlock() {
        return null;
    }

    @Override
    @Nullable
    public Direction.Axis getVaultBlockAxis(BlockState state) {
        return !isVault(state) ? null : Direction.Axis.Y;
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rot) {
        return state;
    }
}
