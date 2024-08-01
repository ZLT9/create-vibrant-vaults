package net.zlt.create_vibrant_vaults.block.entity.item_vault;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_vibrant_vaults.block.entity.AbstractItemVaultBlockEntity;
import net.zlt.create_vibrant_vaults.block.item_vault.LimeItemVaultBlock;

public class LimeItemVaultBlockEntity extends AbstractItemVaultBlockEntity<LimeItemVaultBlockEntity> {
    public LimeItemVaultBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    @Override
    protected LimeItemVaultBlockEntity getAsBE(BlockEntity blockEntity) {
        return blockEntity instanceof LimeItemVaultBlockEntity ? (LimeItemVaultBlockEntity) blockEntity : null;
    }

    @Override
    protected boolean isVault(BlockState state) {
        return LimeItemVaultBlock.sIsVault(state);
    }

    @Override
    protected Direction.Axis getVaultBlockAxis(BlockState state) {
        return LimeItemVaultBlock.sGetVaultBlockAxis(state);
    }

    @Override
    protected BlockEntityType<LimeItemVaultBlockEntity> getBlockEntityType() {
        return LimeItemVaultBlock.sGetBlockEntityType();
    }
}