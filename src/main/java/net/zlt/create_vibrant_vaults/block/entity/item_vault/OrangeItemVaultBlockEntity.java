package net.zlt.create_vibrant_vaults.block.entity.item_vault;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_vibrant_vaults.block.entity.AbstractItemVaultBlockEntity;
import net.zlt.create_vibrant_vaults.block.item_vault.OrangeItemVaultBlock;

public class OrangeItemVaultBlockEntity extends AbstractItemVaultBlockEntity<OrangeItemVaultBlockEntity> {
    public OrangeItemVaultBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    @Override
    protected OrangeItemVaultBlockEntity getAsBE(BlockEntity blockEntity) {
        return blockEntity instanceof OrangeItemVaultBlockEntity ? (OrangeItemVaultBlockEntity) blockEntity : null;
    }

    @Override
    protected boolean isVault(BlockState state) {
        return OrangeItemVaultBlock.sIsVault(state);
    }

    @Override
    protected Direction.Axis getVaultBlockAxis(BlockState state) {
        return OrangeItemVaultBlock.sGetVaultBlockAxis(state);
    }

    @Override
    protected BlockEntityType<OrangeItemVaultBlockEntity> getBlockEntityType() {
        return OrangeItemVaultBlock.sGetBlockEntityType();
    }
}
