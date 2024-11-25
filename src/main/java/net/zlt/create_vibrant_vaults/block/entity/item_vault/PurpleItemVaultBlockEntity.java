package net.zlt.create_vibrant_vaults.block.entity.item_vault;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_vibrant_vaults.block.entity.AbstractItemVaultBlockEntity;
import net.zlt.create_vibrant_vaults.block.item_vault.PurpleItemVaultBlock;

public class PurpleItemVaultBlockEntity extends AbstractItemVaultBlockEntity<PurpleItemVaultBlockEntity> {
    public PurpleItemVaultBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    @Override
    protected PurpleItemVaultBlockEntity getAsBE(BlockEntity blockEntity) {
        return blockEntity instanceof PurpleItemVaultBlockEntity ? (PurpleItemVaultBlockEntity) blockEntity : null;
    }

    @Override
    protected boolean isVault(BlockState state) {
        return PurpleItemVaultBlock.sIsVault(state);
    }

    @Override
    protected Direction.Axis getVaultBlockAxis(BlockState state) {
        return PurpleItemVaultBlock.sGetVaultBlockAxis(state);
    }

    @Override
    protected BlockEntityType<PurpleItemVaultBlockEntity> getBlockEntityType() {
        return PurpleItemVaultBlock.sGetBlockEntityType();
    }
}
