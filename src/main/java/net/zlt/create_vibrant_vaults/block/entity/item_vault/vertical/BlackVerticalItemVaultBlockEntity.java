package net.zlt.create_vibrant_vaults.block.entity.item_vault.vertical;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_vibrant_vaults.block.entity.AbstractVerticalItemVaultBlockEntity;
import net.zlt.create_vibrant_vaults.block.item_vault.vertical.BlackVerticalItemVaultBlock;

public class BlackVerticalItemVaultBlockEntity extends AbstractVerticalItemVaultBlockEntity<BlackVerticalItemVaultBlockEntity> {
    public BlackVerticalItemVaultBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    @Override
    protected BlackVerticalItemVaultBlockEntity getAsBE(BlockEntity blockEntity) {
        return blockEntity instanceof BlackVerticalItemVaultBlockEntity ? (BlackVerticalItemVaultBlockEntity) blockEntity : null;
    }

    @Override
    protected boolean isVault(BlockState state) {
        return BlackVerticalItemVaultBlock.sIsVault(state);
    }

    @Override
    protected Direction.Axis getVaultBlockAxis(BlockState state) {
        return BlackVerticalItemVaultBlock.sGetVaultBlockAxis(state);
    }

    @Override
    protected BlockEntityType<BlackVerticalItemVaultBlockEntity> getBlockEntityType() {
        return BlackVerticalItemVaultBlock.sGetBlockEntityType();
    }
}
