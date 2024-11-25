package net.zlt.create_vibrant_vaults.block.entity.item_vault;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_vibrant_vaults.block.entity.AbstractItemVaultBlockEntity;
import net.zlt.create_vibrant_vaults.block.item_vault.WhiteItemVaultBlock;

public class WhiteItemVaultBlockEntity extends AbstractItemVaultBlockEntity<WhiteItemVaultBlockEntity> {
    public WhiteItemVaultBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    @Override
    protected WhiteItemVaultBlockEntity getAsBE(BlockEntity blockEntity) {
        return blockEntity instanceof WhiteItemVaultBlockEntity ? (WhiteItemVaultBlockEntity) blockEntity : null;
    }

    @Override
    protected boolean isVault(BlockState state) {
        return WhiteItemVaultBlock.sIsVault(state);
    }

    @Override
    protected Direction.Axis getVaultBlockAxis(BlockState state) {
        return WhiteItemVaultBlock.sGetVaultBlockAxis(state);
    }

    @Override
    protected BlockEntityType<WhiteItemVaultBlockEntity> getBlockEntityType() {
        return WhiteItemVaultBlock.sGetBlockEntityType();
    }
}
