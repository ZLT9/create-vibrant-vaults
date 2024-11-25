package net.zlt.create_vibrant_vaults.block.entity.basic_shipping_container.vertical;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_vibrant_vaults.block.basic_shipping_container.vertical.CyanVerticalBasicShippingContainerBlock;
import net.zlt.create_vibrant_vaults.block.entity.AbstractVerticalItemVaultBlockEntity;

public class CyanVerticalBasicShippingContainerBlockEntity extends AbstractVerticalItemVaultBlockEntity<CyanVerticalBasicShippingContainerBlockEntity> {
    public CyanVerticalBasicShippingContainerBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    @Override
    protected CyanVerticalBasicShippingContainerBlockEntity getAsBE(BlockEntity blockEntity) {
        return blockEntity instanceof CyanVerticalBasicShippingContainerBlockEntity ? (CyanVerticalBasicShippingContainerBlockEntity) blockEntity : null;
    }

    @Override
    protected boolean isVault(BlockState state) {
        return CyanVerticalBasicShippingContainerBlock.sIsVault(state);
    }

    @Override
    protected Direction.Axis getVaultBlockAxis(BlockState state) {
        return CyanVerticalBasicShippingContainerBlock.sGetVaultBlockAxis(state);
    }

    @Override
    protected BlockEntityType<CyanVerticalBasicShippingContainerBlockEntity> getBlockEntityType() {
        return CyanVerticalBasicShippingContainerBlock.sGetBlockEntityType();
    }
}
