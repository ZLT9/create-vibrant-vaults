package net.zlt.create_vibrant_vaults.block.entity.basic_shipping_container.vertical;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_vibrant_vaults.block.entity.AbstractVerticalItemVaultBlockEntity;
import net.zlt.create_vibrant_vaults.block.basic_shipping_container.vertical.GrayVerticalBasicShippingContainerBlock;

public class GrayVerticalBasicShippingContainerBlockEntity extends AbstractVerticalItemVaultBlockEntity<GrayVerticalBasicShippingContainerBlockEntity> {
    public GrayVerticalBasicShippingContainerBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    @Override
    protected GrayVerticalBasicShippingContainerBlockEntity getAsBE(BlockEntity blockEntity) {
        return blockEntity instanceof GrayVerticalBasicShippingContainerBlockEntity ? (GrayVerticalBasicShippingContainerBlockEntity) blockEntity : null;
    }

    @Override
    protected boolean isVault(BlockState state) {
        return GrayVerticalBasicShippingContainerBlock.sIsVault(state);
    }

    @Override
    protected Direction.Axis getVaultBlockAxis(BlockState state) {
        return GrayVerticalBasicShippingContainerBlock.sGetVaultBlockAxis(state);
    }

    @Override
    protected BlockEntityType<GrayVerticalBasicShippingContainerBlockEntity> getBlockEntityType() {
        return GrayVerticalBasicShippingContainerBlock.sGetBlockEntityType();
    }
}
