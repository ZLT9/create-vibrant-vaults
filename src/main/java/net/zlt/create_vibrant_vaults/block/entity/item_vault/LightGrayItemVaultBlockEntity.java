package net.zlt.create_vibrant_vaults.block.entity.item_vault;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_vibrant_vaults.block.entity.AbstractItemVaultBlockEntity;
import net.zlt.create_vibrant_vaults.block.item_vault.LightGrayItemVaultBlock;

public class LightGrayItemVaultBlockEntity extends AbstractItemVaultBlockEntity<LightGrayItemVaultBlockEntity> {
    public LightGrayItemVaultBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    @Override
    protected LightGrayItemVaultBlockEntity getAsBE(BlockEntity blockEntity) {
        return blockEntity instanceof LightGrayItemVaultBlockEntity ? (LightGrayItemVaultBlockEntity) blockEntity : null;
    }

    @Override
    protected boolean isVault(BlockState state) {
        return LightGrayItemVaultBlock.sIsVault(state);
    }

    @Override
    protected Direction.Axis getVaultBlockAxis(BlockState state) {
        return LightGrayItemVaultBlock.sGetVaultBlockAxis(state);
    }

    @Override
    protected BlockEntityType<LightGrayItemVaultBlockEntity> getBlockEntityType() {
        return LightGrayItemVaultBlock.sGetBlockEntityType();
    }
}
