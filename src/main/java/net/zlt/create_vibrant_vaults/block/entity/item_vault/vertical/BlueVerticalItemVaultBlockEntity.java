package net.zlt.create_vibrant_vaults.block.entity.item_vault.vertical;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_vibrant_vaults.block.entity.AbstractVerticalItemVaultBlockEntity;
import net.zlt.create_vibrant_vaults.block.item_vault.vertical.BlueVerticalItemVaultBlock;

public class BlueVerticalItemVaultBlockEntity extends AbstractVerticalItemVaultBlockEntity<BlueVerticalItemVaultBlockEntity> {
    public BlueVerticalItemVaultBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    @Override
    protected BlueVerticalItemVaultBlockEntity getAsBE(BlockEntity blockEntity) {
        return blockEntity instanceof BlueVerticalItemVaultBlockEntity ? (BlueVerticalItemVaultBlockEntity) blockEntity : null;
    }

    @Override
    protected boolean isVault(BlockState state) {
        return BlueVerticalItemVaultBlock.sIsVault(state);
    }

    @Override
    protected Direction.Axis getVaultBlockAxis(BlockState state) {
        return BlueVerticalItemVaultBlock.sGetVaultBlockAxis(state);
    }

    @Override
    protected BlockEntityType<BlueVerticalItemVaultBlockEntity> getBlockEntityType() {
        return BlueVerticalItemVaultBlock.sGetBlockEntityType();
    }
}
