package net.zlt.create_vibrant_vaults.block.entity.item_vault.vertical;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_vibrant_vaults.block.entity.AbstractVerticalItemVaultBlockEntity;
import net.zlt.create_vibrant_vaults.block.item_vault.vertical.PurpleVerticalItemVaultBlock;

public class PurpleVerticalItemVaultBlockEntity extends AbstractVerticalItemVaultBlockEntity<PurpleVerticalItemVaultBlockEntity> {
    public PurpleVerticalItemVaultBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    @Override
    protected PurpleVerticalItemVaultBlockEntity getAsBE(BlockEntity blockEntity) {
        return blockEntity instanceof PurpleVerticalItemVaultBlockEntity ? (PurpleVerticalItemVaultBlockEntity) blockEntity : null;
    }

    @Override
    protected boolean isVault(BlockState state) {
        return PurpleVerticalItemVaultBlock.sIsVault(state);
    }

    @Override
    protected Direction.Axis getVaultBlockAxis(BlockState state) {
        return PurpleVerticalItemVaultBlock.sGetVaultBlockAxis(state);
    }

    @Override
    protected BlockEntityType<PurpleVerticalItemVaultBlockEntity> getBlockEntityType() {
        return PurpleVerticalItemVaultBlock.sGetBlockEntityType();
    }
}
