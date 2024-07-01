package net.zlt.create_vibrant_vaults;

import com.simibubi.create.api.connectivity.ConnectivityHandler;
import com.simibubi.create.content.equipment.wrench.IWrenchable;
import com.simibubi.create.content.logistics.vault.ItemVaultBlock;
import com.simibubi.create.foundation.block.IBE;
import com.simibubi.create.foundation.item.ItemHelper;
import io.github.fabricators_of_create.porting_lib.block.CustomSoundTypeBlock;
import net.fabricmc.fabric.api.transfer.v1.transaction.Transaction;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.Property;

import javax.annotation.Nullable;

public abstract class AbstractItemVaultBlock<BE extends AbstractItemVaultBlockEntity> extends Block implements IWrenchable, IBE<BE>, CustomSoundTypeBlock {
    public static final Property<Direction.Axis> HORIZONTAL_AXIS = BlockStateProperties.HORIZONTAL_AXIS;
    public static final BooleanProperty LARGE = ItemVaultBlock.LARGE;
    public static final SoundType SILENCED_METAL = ItemVaultBlock.SILENCED_METAL;

    public AbstractItemVaultBlock(Properties properties) {
        super(properties);
        registerDefaultState(defaultBlockState().setValue(LARGE, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(HORIZONTAL_AXIS, LARGE);
        super.createBlockStateDefinition(pBuilder);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        if (pContext.getPlayer() == null || !pContext.getPlayer().isShiftKeyDown()) {
            BlockState placedOn = pContext.getLevel().getBlockState(pContext.getClickedPos().relative(pContext.getClickedFace().getOpposite()));
            Direction.Axis preferredAxis = getVaultBlockAxis(placedOn);

            if (preferredAxis != null) {
                return this.defaultBlockState().setValue(HORIZONTAL_AXIS, preferredAxis);
            }
        }

        return this.defaultBlockState().setValue(HORIZONTAL_AXIS, pContext.getHorizontalDirection().getAxis());
    }

    protected abstract boolean isPlacingNbt();

    @Override
    public void onPlace(BlockState pState, Level pLevel, BlockPos pPos, BlockState pOldState, boolean pIsMoving) {
        if (pOldState.getBlock() != pState.getBlock() && !pIsMoving) {
            withBlockEntityDo(pLevel, pPos, isPlacingNbt() ? AbstractItemVaultBlockEntity::queueConnectivityUpdate : AbstractItemVaultBlockEntity::updateConnectivity);
        }
    }

    protected abstract BE getAsBE(BlockEntity blockEntity);

    @Override
    public InteractionResult onWrenched(BlockState state, UseOnContext context) {
        if (context.getClickedFace().getAxis().isVertical()) {
            BE be = getAsBE(context.getLevel().getBlockEntity(context.getClickedPos()));
            if (be != null) {
                ConnectivityHandler.splitMulti(be);
                be.removeController(true);
            }

            state = state.setValue(LARGE, false);
        }

        return IWrenchable.super.onWrenched(state, context);
    }

    @Override
    public void onRemove(BlockState state, Level world, BlockPos pos, BlockState newState, boolean pIsMoving) {
        if ((state.hasBlockEntity() && (state.getBlock() != newState.getBlock() || !newState.hasBlockEntity()))) {
            BE be = getAsBE(world.getBlockEntity(pos));
            if (be != null) {
                ItemHelper.dropContents(world, pos, be.inventory);
                world.removeBlockEntity(pos);
                ConnectivityHandler.splitMulti(be);
            }
        }
    }

    public abstract boolean isVault(BlockState state);

    @Nullable
    public Direction.Axis getVaultBlockAxis(BlockState state) {
        return !isVault(state) ? null : state.getValue(HORIZONTAL_AXIS);
    }

    public boolean isLarge(BlockState state) {
        return isVault(state) && state.getValue(LARGE);
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rot) {
        return state.setValue(HORIZONTAL_AXIS, rot.rotate(Direction.fromAxisAndDirection(state.getValue(HORIZONTAL_AXIS), Direction.AxisDirection.POSITIVE)).getAxis());
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state;
    }

    @Override
    public SoundType getSoundType(BlockState state, LevelReader world, BlockPos pos, Entity entity) {
        return entity != null && entity.getCustomData().getBoolean("SilenceVaultSound") ? SILENCED_METAL : getSoundType(state);
    }

    @Override
    public boolean hasAnalogOutputSignal(BlockState state) {
        return true;
    }

    @Override
    public int getAnalogOutputSignal(BlockState pState, Level pLevel, BlockPos pPos) {
        return getBlockEntityOptional(pLevel, pPos)
            .filter(vte -> !Transaction.isOpen())
            .map(vte -> vte.getItemStorage(null))
            .map(ItemHelper::calcRedstoneFromInventory)
            .orElse(0);
    }

    @Override
    public abstract BlockEntityType<BE> getBlockEntityType();

    @Override
    public abstract Class<BE> getBlockEntityClass();
}
