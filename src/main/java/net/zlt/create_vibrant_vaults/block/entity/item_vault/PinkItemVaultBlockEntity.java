package net.zlt.create_vibrant_vaults.block.entity.item_vault;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_vibrant_vaults.block.entity.AbstractItemVaultBlockEntity;
import net.zlt.create_vibrant_vaults.block.item_vault.PinkItemVaultBlock;

public class PinkItemVaultBlockEntity extends AbstractItemVaultBlockEntity<PinkItemVaultBlockEntity> {
    public PinkItemVaultBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    @Override
    protected PinkItemVaultBlockEntity getAsBE(BlockEntity blockEntity) {
        return blockEntity instanceof PinkItemVaultBlockEntity ? (PinkItemVaultBlockEntity) blockEntity : null;
    }

    @Override
    protected boolean isVault(BlockState state) {
        return PinkItemVaultBlock.sIsVault(state);
    }

    @Override
    protected Direction.Axis getVaultBlockAxis(BlockState state) {
        return PinkItemVaultBlock.sGetVaultBlockAxis(state);
    }

    @Override
    protected BlockEntityType<PinkItemVaultBlockEntity> getBlockEntityType() {
        return PinkItemVaultBlock.sGetBlockEntityType();
    }
}
