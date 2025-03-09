package net.zlt.create_vibrant_vaults.block;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.content.kinetics.base.GeneratingKineticBlockEntity;
import com.simibubi.create.content.kinetics.base.KineticBlockEntity;
import com.simibubi.create.content.logistics.vault.ItemVaultBlockEntity;
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

public class VerticalVaultBlock extends VibrantVaultBlock {
    public VerticalVaultBlock(ModBlocks.VibrantVaultType type, ModBlocks.VibrantVaultColor color, Properties properties) {
        super(type, color, properties);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(LARGE);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return defaultBlockState();
    }

    @Override
    public InteractionResult onWrenched(BlockState state, UseOnContext context) {
        if (context.getClickedFace().getAxis().isHorizontal()) {
            BlockEntity be = context.getLevel().getBlockEntity(context.getClickedPos());
            if (be instanceof ItemVaultBlockEntity vault) {
                ItemVaultConnectivityHelper.splitItemVaultMulti(vault);
                vault.removeController(true);
            }
            state = state.setValue(LARGE, false);
        }

        Level world = context.getLevel();
        BlockState rotated = getRotatedBlockState(state, context.getClickedFace());
        if (!rotated.canSurvive(world, context.getClickedPos())) {
            return InteractionResult.PASS;
        }

        KineticBlockEntity.switchToBlockState(world, context.getClickedPos(), updateAfterWrenched(rotated, context));

        if (context.getLevel().getBlockEntity(context.getClickedPos()) instanceof GeneratingKineticBlockEntity be) {
            be.reActivateSource = true;
        }

        if (world.getBlockState(context.getClickedPos()) != state) {
            playRotateSound(world, context.getClickedPos());
        }

        return InteractionResult.SUCCESS;
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rot) {
        return state;
    }

    @Override
    public BlockState getRotatedBlockState(BlockState originalState, Direction targetedFace) {
        if (targetedFace.getAxis().isHorizontal()) {
            return getHorizontal().defaultBlockState().setValue(HORIZONTAL_AXIS, targetedFace.getAxis() == Direction.Axis.X ? Direction.Axis.Z : Direction.Axis.X);
        }

        return originalState;
    }

    public Block getHorizontal() {
        return type == ModBlocks.VibrantVaultType.ITEM_VAULT && color == ModBlocks.VibrantVaultColor.BASE ? AllBlocks.ITEM_VAULT.get() : ModBlocks.getVibrantVault(type, color, false).get();
    }
}
