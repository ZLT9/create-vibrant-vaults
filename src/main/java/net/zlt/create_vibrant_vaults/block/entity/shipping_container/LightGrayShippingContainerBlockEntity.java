package net.zlt.create_vibrant_vaults.block.entity.shipping_container;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_vibrant_vaults.block.entity.AbstractItemVaultBlockEntity;
import net.zlt.create_vibrant_vaults.block.shipping_container.LightGrayShippingContainerBlock;

public class LightGrayShippingContainerBlockEntity extends AbstractItemVaultBlockEntity<LightGrayShippingContainerBlockEntity> {
    public LightGrayShippingContainerBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    @Override
    protected LightGrayShippingContainerBlockEntity getAsBE(BlockEntity blockEntity) {
        return blockEntity instanceof LightGrayShippingContainerBlockEntity ? (LightGrayShippingContainerBlockEntity) blockEntity : null;
    }

    @Override
    protected boolean isVault(BlockState state) {
        return LightGrayShippingContainerBlock.sIsVault(state);
    }

    @Override
    protected Direction.Axis getVaultBlockAxis(BlockState state) {
        return LightGrayShippingContainerBlock.sGetVaultBlockAxis(state);
    }

    @Override
    protected BlockEntityType<LightGrayShippingContainerBlockEntity> getBlockEntityType() {
        return LightGrayShippingContainerBlock.sGetBlockEntityType();
    }
}
