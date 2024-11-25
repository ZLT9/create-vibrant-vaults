package net.zlt.create_vibrant_vaults.block.entity.shipping_container;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_vibrant_vaults.block.entity.AbstractItemVaultBlockEntity;
import net.zlt.create_vibrant_vaults.block.shipping_container.LimeShippingContainerBlock;

public class LimeShippingContainerBlockEntity extends AbstractItemVaultBlockEntity<LimeShippingContainerBlockEntity> {
    public LimeShippingContainerBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    @Override
    protected LimeShippingContainerBlockEntity getAsBE(BlockEntity blockEntity) {
        return blockEntity instanceof LimeShippingContainerBlockEntity ? (LimeShippingContainerBlockEntity) blockEntity : null;
    }

    @Override
    protected boolean isVault(BlockState state) {
        return LimeShippingContainerBlock.sIsVault(state);
    }

    @Override
    protected Direction.Axis getVaultBlockAxis(BlockState state) {
        return LimeShippingContainerBlock.sGetVaultBlockAxis(state);
    }

    @Override
    protected BlockEntityType<LimeShippingContainerBlockEntity> getBlockEntityType() {
        return LimeShippingContainerBlock.sGetBlockEntityType();
    }
}
