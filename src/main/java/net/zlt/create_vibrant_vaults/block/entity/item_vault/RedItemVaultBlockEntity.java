package net.zlt.create_vibrant_vaults.block.entity.item_vault;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_vibrant_vaults.block.entity.AbstractItemVaultBlockEntity;
import net.zlt.create_vibrant_vaults.block.item_vault.RedItemVaultBlock;

public class RedItemVaultBlockEntity extends AbstractItemVaultBlockEntity<RedItemVaultBlockEntity> {
    public RedItemVaultBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    @Override
    protected RedItemVaultBlockEntity getAsBE(BlockEntity blockEntity) {
        return blockEntity instanceof RedItemVaultBlockEntity ? (RedItemVaultBlockEntity) blockEntity : null;
    }

    @Override
    protected boolean isVault(BlockState state) {
        return RedItemVaultBlock.sIsVault(state);
    }

    @Override
    protected Direction.Axis getVaultBlockAxis(BlockState state) {
        return RedItemVaultBlock.sGetVaultBlockAxis(state);
    }

    @Override
    protected BlockEntityType<RedItemVaultBlockEntity> getBlockEntityType() {
        return RedItemVaultBlock.sGetBlockEntityType();
    }
}
