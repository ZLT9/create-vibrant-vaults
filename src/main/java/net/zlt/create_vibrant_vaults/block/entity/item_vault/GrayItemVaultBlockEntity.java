package net.zlt.create_vibrant_vaults.block.entity.item_vault;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_vibrant_vaults.block.entity.AbstractItemVaultBlockEntity;
import net.zlt.create_vibrant_vaults.block.item_vault.GrayItemVaultBlock;

public class GrayItemVaultBlockEntity extends AbstractItemVaultBlockEntity<GrayItemVaultBlockEntity> {
    public GrayItemVaultBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    @Override
    protected GrayItemVaultBlockEntity getAsBE(BlockEntity blockEntity) {
        return blockEntity instanceof GrayItemVaultBlockEntity ? (GrayItemVaultBlockEntity) blockEntity : null;
    }

    @Override
    protected boolean isVault(BlockState state) {
        return GrayItemVaultBlock.sIsVault(state);
    }

    @Override
    protected Direction.Axis getVaultBlockAxis(BlockState state) {
        return GrayItemVaultBlock.sGetVaultBlockAxis(state);
    }

    @Override
    protected BlockEntityType<GrayItemVaultBlockEntity> getBlockEntityType() {
        return GrayItemVaultBlock.sGetBlockEntityType();
    }
}
