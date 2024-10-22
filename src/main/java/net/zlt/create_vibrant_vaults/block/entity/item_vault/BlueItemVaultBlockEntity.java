package net.zlt.create_vibrant_vaults.block.entity.item_vault;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_vibrant_vaults.block.entity.AbstractItemVaultBlockEntity;
import net.zlt.create_vibrant_vaults.block.item_vault.BlueItemVaultBlock;

public class BlueItemVaultBlockEntity extends AbstractItemVaultBlockEntity<BlueItemVaultBlockEntity> {
    public BlueItemVaultBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    @Override
    protected BlueItemVaultBlockEntity getAsBE(BlockEntity blockEntity) {
        return blockEntity instanceof BlueItemVaultBlockEntity ? (BlueItemVaultBlockEntity) blockEntity : null;
    }

    @Override
    protected boolean isVault(BlockState state) {
        return BlueItemVaultBlock.sIsVault(state);
    }

    @Override
    protected Direction.Axis getVaultBlockAxis(BlockState state) {
        return BlueItemVaultBlock.sGetVaultBlockAxis(state);
    }

    @Override
    protected BlockEntityType<BlueItemVaultBlockEntity> getBlockEntityType() {
        return BlueItemVaultBlock.sGetBlockEntityType();
    }
}
