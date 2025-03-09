package net.zlt.create_vibrant_vaults.block;

import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class HorizontalVaultBlock extends VibrantVaultBlock {
    public HorizontalVaultBlock(ModBlocks.VibrantVaultType type, ModBlocks.VibrantVaultColor color, Properties properties) {
        super(type, color, properties);
    }

    @Override
    public BlockState getRotatedBlockState(BlockState originalState, Direction targetedFace) {
        if (targetedFace.getAxis() == Direction.Axis.Y) {
            return super.getRotatedBlockState(originalState, targetedFace);
        }

        if (targetedFace.getAxis() != originalState.getValue(HORIZONTAL_AXIS)) {
            return getVertical().defaultBlockState();
        }

        return originalState;
    }

    public Block getVertical() {
        return ModBlocks.getVibrantVault(type, color, true).get();
    }
}
