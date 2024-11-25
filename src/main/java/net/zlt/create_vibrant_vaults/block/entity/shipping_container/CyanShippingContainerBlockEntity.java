package net.zlt.create_vibrant_vaults.block.entity.shipping_container;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_vibrant_vaults.block.entity.AbstractItemVaultBlockEntity;
import net.zlt.create_vibrant_vaults.block.shipping_container.CyanShippingContainerBlock;

public class CyanShippingContainerBlockEntity extends AbstractItemVaultBlockEntity<CyanShippingContainerBlockEntity> {
    public CyanShippingContainerBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    @Override
    protected CyanShippingContainerBlockEntity getAsBE(BlockEntity blockEntity) {
        return blockEntity instanceof CyanShippingContainerBlockEntity ? (CyanShippingContainerBlockEntity) blockEntity : null;
    }

    @Override
    protected boolean isVault(BlockState state) {
        return CyanShippingContainerBlock.sIsVault(state);
    }

    @Override
    protected Direction.Axis getVaultBlockAxis(BlockState state) {
        return CyanShippingContainerBlock.sGetVaultBlockAxis(state);
    }

    @Override
    protected BlockEntityType<CyanShippingContainerBlockEntity> getBlockEntityType() {
        return CyanShippingContainerBlock.sGetBlockEntityType();
    }
}
