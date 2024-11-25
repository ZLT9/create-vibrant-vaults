package net.zlt.create_vibrant_vaults.block.entity.shipping_container.vertical;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_vibrant_vaults.block.entity.AbstractVerticalItemVaultBlockEntity;
import net.zlt.create_vibrant_vaults.block.shipping_container.vertical.GrayVerticalShippingContainerBlock;

public class GrayVerticalShippingContainerBlockEntity extends AbstractVerticalItemVaultBlockEntity<GrayVerticalShippingContainerBlockEntity> {
    public GrayVerticalShippingContainerBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    @Override
    protected GrayVerticalShippingContainerBlockEntity getAsBE(BlockEntity blockEntity) {
        return blockEntity instanceof GrayVerticalShippingContainerBlockEntity ? (GrayVerticalShippingContainerBlockEntity) blockEntity : null;
    }

    @Override
    protected boolean isVault(BlockState state) {
        return GrayVerticalShippingContainerBlock.sIsVault(state);
    }

    @Override
    protected Direction.Axis getVaultBlockAxis(BlockState state) {
        return GrayVerticalShippingContainerBlock.sGetVaultBlockAxis(state);
    }

    @Override
    protected BlockEntityType<GrayVerticalShippingContainerBlockEntity> getBlockEntityType() {
        return GrayVerticalShippingContainerBlock.sGetBlockEntityType();
    }
}
