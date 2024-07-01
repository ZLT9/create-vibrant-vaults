package net.zlt.create_vibrant_vaults;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class YellowItemVaultBlockEntity extends AbstractItemVaultBlockEntity<YellowItemVaultBlockEntity> {
    public YellowItemVaultBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    @Override
    protected YellowItemVaultBlockEntity getAsBE(BlockEntity blockEntity) {
        return blockEntity instanceof YellowItemVaultBlockEntity ? (YellowItemVaultBlockEntity) blockEntity : null;
    }

    @Override
    protected boolean isVault(BlockState state) {
        return YellowItemVaultBlock.sIsVault(state);
    }

    @Override
    protected Direction.Axis getVaultBlockAxis(BlockState state) {
        return YellowItemVaultBlock.sGetVaultBlockAxis(state);
    }

    @Override
    protected BlockEntityType<YellowItemVaultBlockEntity> getBlockEntityType() {
        return YellowItemVaultBlock.sGetBlockEntityType();
    }
}
