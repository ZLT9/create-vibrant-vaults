package net.zlt.create_vibrant_vaults.block.entity.basic_shipping_container;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_vibrant_vaults.block.basic_shipping_container.LimeBasicShippingContainerBlock;
import net.zlt.create_vibrant_vaults.block.entity.AbstractItemVaultBlockEntity;

public class LimeBasicShippingContainerBlockEntity extends AbstractItemVaultBlockEntity<LimeBasicShippingContainerBlockEntity> {
    public LimeBasicShippingContainerBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    @Override
    protected LimeBasicShippingContainerBlockEntity getAsBE(BlockEntity blockEntity) {
        return blockEntity instanceof LimeBasicShippingContainerBlockEntity ? (LimeBasicShippingContainerBlockEntity) blockEntity : null;
    }

    @Override
    protected boolean isVault(BlockState state) {
        return LimeBasicShippingContainerBlock.sIsVault(state);
    }

    @Override
    protected Direction.Axis getVaultBlockAxis(BlockState state) {
        return LimeBasicShippingContainerBlock.sGetVaultBlockAxis(state);
    }

    @Override
    protected BlockEntityType<LimeBasicShippingContainerBlockEntity> getBlockEntityType() {
        return LimeBasicShippingContainerBlock.sGetBlockEntityType();
    }
}
