package net.zlt.create_vibrant_vaults.block.entity.shipping_container;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_vibrant_vaults.block.entity.AbstractItemVaultBlockEntity;
import net.zlt.create_vibrant_vaults.block.shipping_container.ShippingContainerBlock;

public class ShippingContainerBlockEntity extends AbstractItemVaultBlockEntity<ShippingContainerBlockEntity> {
    public ShippingContainerBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    @Override
    protected ShippingContainerBlockEntity getAsBE(BlockEntity blockEntity) {
        return blockEntity instanceof ShippingContainerBlockEntity ? (ShippingContainerBlockEntity) blockEntity : null;
    }

    @Override
    protected boolean isVault(BlockState state) {
        return ShippingContainerBlock.sIsVault(state);
    }

    @Override
    protected Direction.Axis getVaultBlockAxis(BlockState state) {
        return ShippingContainerBlock.sGetVaultBlockAxis(state);
    }

    @Override
    protected BlockEntityType<ShippingContainerBlockEntity> getBlockEntityType() {
        return ShippingContainerBlock.sGetBlockEntityType();
    }
}
