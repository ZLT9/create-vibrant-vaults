package net.zlt.create_vibrant_vaults.block.entity.basic_shipping_container.vertical;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_vibrant_vaults.block.basic_shipping_container.vertical.BlueVerticalBasicShippingContainerBlock;
import net.zlt.create_vibrant_vaults.block.entity.AbstractVerticalItemVaultBlockEntity;

public class BlueVerticalBasicShippingContainerBlockEntity extends AbstractVerticalItemVaultBlockEntity<BlueVerticalBasicShippingContainerBlockEntity> {
    public BlueVerticalBasicShippingContainerBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    @Override
    protected BlueVerticalBasicShippingContainerBlockEntity getAsBE(BlockEntity blockEntity) {
        return blockEntity instanceof BlueVerticalBasicShippingContainerBlockEntity ? (BlueVerticalBasicShippingContainerBlockEntity) blockEntity : null;
    }

    @Override
    protected boolean isVault(BlockState state) {
        return BlueVerticalBasicShippingContainerBlock.sIsVault(state);
    }

    @Override
    protected Direction.Axis getVaultBlockAxis(BlockState state) {
        return BlueVerticalBasicShippingContainerBlock.sGetVaultBlockAxis(state);
    }

    @Override
    protected BlockEntityType<BlueVerticalBasicShippingContainerBlockEntity> getBlockEntityType() {
        return BlueVerticalBasicShippingContainerBlock.sGetBlockEntityType();
    }
}
