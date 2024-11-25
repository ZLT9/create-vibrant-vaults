package net.zlt.create_vibrant_vaults.block.entity.basic_shipping_container.vertical;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_vibrant_vaults.block.basic_shipping_container.vertical.VerticalBasicShippingContainerBlock;
import net.zlt.create_vibrant_vaults.block.entity.AbstractVerticalItemVaultBlockEntity;

public class VerticalBasicShippingContainerBlockEntity extends AbstractVerticalItemVaultBlockEntity<VerticalBasicShippingContainerBlockEntity> {
    public VerticalBasicShippingContainerBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    @Override
    protected VerticalBasicShippingContainerBlockEntity getAsBE(BlockEntity blockEntity) {
        return blockEntity instanceof VerticalBasicShippingContainerBlockEntity ? (VerticalBasicShippingContainerBlockEntity) blockEntity : null;
    }

    @Override
    protected boolean isVault(BlockState state) {
        return VerticalBasicShippingContainerBlock.sIsVault(state);
    }

    @Override
    protected Direction.Axis getVaultBlockAxis(BlockState state) {
        return VerticalBasicShippingContainerBlock.sGetVaultBlockAxis(state);
    }

    @Override
    protected BlockEntityType<VerticalBasicShippingContainerBlockEntity> getBlockEntityType() {
        return VerticalBasicShippingContainerBlock.sGetBlockEntityType();
    }
}
