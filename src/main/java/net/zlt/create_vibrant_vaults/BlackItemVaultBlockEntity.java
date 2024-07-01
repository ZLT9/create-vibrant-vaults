package net.zlt.create_vibrant_vaults;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class BlackItemVaultBlockEntity extends AbstractItemVaultBlockEntity<BlackItemVaultBlockEntity> {
    public BlackItemVaultBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    @Override
    protected BlackItemVaultBlockEntity getAsBE(BlockEntity blockEntity) {
        return blockEntity instanceof BlackItemVaultBlockEntity ? (BlackItemVaultBlockEntity) blockEntity : null;
    }

    @Override
    protected boolean isVault(BlockState state) {
        return BlackItemVaultBlock.sIsVault(state);
    }

    @Override
    protected Direction.Axis getVaultBlockAxis(BlockState state) {
        return BlackItemVaultBlock.sGetVaultBlockAxis(state);
    }

    @Override
    protected BlockEntityType<BlackItemVaultBlockEntity> getBlockEntityType() {
        return BlackItemVaultBlock.sGetBlockEntityType();
    }
}
