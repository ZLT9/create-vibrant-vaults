package net.zlt.create_vibrant_vaults.block.entity.item_vault.vertical;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_vibrant_vaults.block.entity.AbstractVerticalItemVaultBlockEntity;
import net.zlt.create_vibrant_vaults.block.item_vault.vertical.PinkVerticalItemVaultBlock;

public class PinkVerticalItemVaultBlockEntity extends AbstractVerticalItemVaultBlockEntity<PinkVerticalItemVaultBlockEntity> {
    public PinkVerticalItemVaultBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    @Override
    protected PinkVerticalItemVaultBlockEntity getAsBE(BlockEntity blockEntity) {
        return blockEntity instanceof PinkVerticalItemVaultBlockEntity ? (PinkVerticalItemVaultBlockEntity) blockEntity : null;
    }

    @Override
    protected boolean isVault(BlockState state) {
        return PinkVerticalItemVaultBlock.sIsVault(state);
    }

    @Override
    protected Direction.Axis getVaultBlockAxis(BlockState state) {
        return PinkVerticalItemVaultBlock.sGetVaultBlockAxis(state);
    }

    @Override
    protected BlockEntityType<PinkVerticalItemVaultBlockEntity> getBlockEntityType() {
        return PinkVerticalItemVaultBlock.sGetBlockEntityType();
    }
}
