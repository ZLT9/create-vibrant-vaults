package net.zlt.create_vibrant_vaults.block.entity.item_vault;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_vibrant_vaults.block.entity.AbstractItemVaultBlockEntity;
import net.zlt.create_vibrant_vaults.block.item_vault.LightBlueItemVaultBlock;

public class LightBlueItemVaultBlockEntity extends AbstractItemVaultBlockEntity<LightBlueItemVaultBlockEntity> {
    public LightBlueItemVaultBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    @Override
    protected LightBlueItemVaultBlockEntity getAsBE(BlockEntity blockEntity) {
        return blockEntity instanceof LightBlueItemVaultBlockEntity ? (LightBlueItemVaultBlockEntity) blockEntity : null;
    }

    @Override
    protected boolean isVault(BlockState state) {
        return LightBlueItemVaultBlock.sIsVault(state);
    }

    @Override
    protected Direction.Axis getVaultBlockAxis(BlockState state) {
        return LightBlueItemVaultBlock.sGetVaultBlockAxis(state);
    }

    @Override
    protected BlockEntityType<LightBlueItemVaultBlockEntity> getBlockEntityType() {
        return LightBlueItemVaultBlock.sGetBlockEntityType();
    }
}
