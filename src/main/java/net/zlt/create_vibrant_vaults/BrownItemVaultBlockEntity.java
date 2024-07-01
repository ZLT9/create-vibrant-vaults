package net.zlt.create_vibrant_vaults;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class BrownItemVaultBlockEntity extends AbstractItemVaultBlockEntity<BrownItemVaultBlockEntity> {
    public BrownItemVaultBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    @Override
    protected BrownItemVaultBlockEntity getAsBE(BlockEntity blockEntity) {
        return blockEntity instanceof BrownItemVaultBlockEntity ? (BrownItemVaultBlockEntity) blockEntity : null;
    }

    @Override
    protected boolean isVault(BlockState state) {
        return BrownItemVaultBlock.sIsVault(state);
    }

    @Override
    protected Direction.Axis getVaultBlockAxis(BlockState state) {
        return BrownItemVaultBlock.sGetVaultBlockAxis(state);
    }

    @Override
    protected BlockEntityType<BrownItemVaultBlockEntity> getBlockEntityType() {
        return BrownItemVaultBlock.sGetBlockEntityType();
    }
}
