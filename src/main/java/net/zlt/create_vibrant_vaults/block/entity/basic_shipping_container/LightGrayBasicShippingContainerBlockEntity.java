package net.zlt.create_vibrant_vaults.block.entity.basic_shipping_container;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_vibrant_vaults.block.basic_shipping_container.LightGrayBasicShippingContainerBlock;
import net.zlt.create_vibrant_vaults.block.entity.AbstractItemVaultBlockEntity;

public class LightGrayBasicShippingContainerBlockEntity extends AbstractItemVaultBlockEntity<LightGrayBasicShippingContainerBlockEntity> {
    public LightGrayBasicShippingContainerBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    @Override
    protected LightGrayBasicShippingContainerBlockEntity getAsBE(BlockEntity blockEntity) {
        return blockEntity instanceof LightGrayBasicShippingContainerBlockEntity ? (LightGrayBasicShippingContainerBlockEntity) blockEntity : null;
    }

    @Override
    protected boolean isVault(BlockState state) {
        return LightGrayBasicShippingContainerBlock.sIsVault(state);
    }

    @Override
    protected Direction.Axis getVaultBlockAxis(BlockState state) {
        return LightGrayBasicShippingContainerBlock.sGetVaultBlockAxis(state);
    }

    @Override
    protected BlockEntityType<LightGrayBasicShippingContainerBlockEntity> getBlockEntityType() {
        return LightGrayBasicShippingContainerBlock.sGetBlockEntityType();
    }
}
