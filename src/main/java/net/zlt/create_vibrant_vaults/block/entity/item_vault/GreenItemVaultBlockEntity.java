package net.zlt.create_vibrant_vaults.block.entity.item_vault;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_vibrant_vaults.block.entity.AbstractItemVaultBlockEntity;
import net.zlt.create_vibrant_vaults.block.item_vault.GreenItemVaultBlock;

public class GreenItemVaultBlockEntity extends AbstractItemVaultBlockEntity<GreenItemVaultBlockEntity> {
    public GreenItemVaultBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    @Override
    protected GreenItemVaultBlockEntity getAsBE(BlockEntity blockEntity) {
        return blockEntity instanceof GreenItemVaultBlockEntity ? (GreenItemVaultBlockEntity) blockEntity : null;
    }

    @Override
    protected boolean isVault(BlockState state) {
        return GreenItemVaultBlock.sIsVault(state);
    }

    @Override
    protected Direction.Axis getVaultBlockAxis(BlockState state) {
        return GreenItemVaultBlock.sGetVaultBlockAxis(state);
    }

    @Override
    protected BlockEntityType<GreenItemVaultBlockEntity> getBlockEntityType() {
        return GreenItemVaultBlock.sGetBlockEntityType();
    }
}
