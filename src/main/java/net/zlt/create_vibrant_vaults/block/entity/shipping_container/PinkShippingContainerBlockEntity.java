package net.zlt.create_vibrant_vaults.block.entity.shipping_container;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_vibrant_vaults.block.entity.AbstractItemVaultBlockEntity;
import net.zlt.create_vibrant_vaults.block.shipping_container.PinkShippingContainerBlock;

public class PinkShippingContainerBlockEntity extends AbstractItemVaultBlockEntity<PinkShippingContainerBlockEntity> {
    public PinkShippingContainerBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    @Override
    protected PinkShippingContainerBlockEntity getAsBE(BlockEntity blockEntity) {
        return blockEntity instanceof PinkShippingContainerBlockEntity ? (PinkShippingContainerBlockEntity) blockEntity : null;
    }

    @Override
    protected boolean isVault(BlockState state) {
        return PinkShippingContainerBlock.sIsVault(state);
    }

    @Override
    protected Direction.Axis getVaultBlockAxis(BlockState state) {
        return PinkShippingContainerBlock.sGetVaultBlockAxis(state);
    }

    @Override
    protected BlockEntityType<PinkShippingContainerBlockEntity> getBlockEntityType() {
        return PinkShippingContainerBlock.sGetBlockEntityType();
    }
}
