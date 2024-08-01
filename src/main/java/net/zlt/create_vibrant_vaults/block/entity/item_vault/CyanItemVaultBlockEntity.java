package net.zlt.create_vibrant_vaults.block.entity.item_vault;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_vibrant_vaults.block.entity.AbstractItemVaultBlockEntity;
import net.zlt.create_vibrant_vaults.block.item_vault.CyanItemVaultBlock;

public class CyanItemVaultBlockEntity extends AbstractItemVaultBlockEntity<CyanItemVaultBlockEntity> {
    public CyanItemVaultBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    @Override
    protected CyanItemVaultBlockEntity getAsBE(BlockEntity blockEntity) {
        return blockEntity instanceof CyanItemVaultBlockEntity ? (CyanItemVaultBlockEntity) blockEntity : null;
    }

    @Override
    protected boolean isVault(BlockState state) {
        return CyanItemVaultBlock.sIsVault(state);
    }

    @Override
    protected Direction.Axis getVaultBlockAxis(BlockState state) {
        return CyanItemVaultBlock.sGetVaultBlockAxis(state);
    }

    @Override
    protected BlockEntityType<CyanItemVaultBlockEntity> getBlockEntityType() {
        return CyanItemVaultBlock.sGetBlockEntityType();
    }
}
