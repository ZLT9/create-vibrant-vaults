package net.zlt.create_vibrant_vaults.block.entity.shipping_container.vertical;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_vibrant_vaults.block.entity.AbstractVerticalItemVaultBlockEntity;
import net.zlt.create_vibrant_vaults.block.shipping_container.vertical.WhiteVerticalShippingContainerBlock;

public class WhiteVerticalShippingContainerBlockEntity extends AbstractVerticalItemVaultBlockEntity<WhiteVerticalShippingContainerBlockEntity> {
    public WhiteVerticalShippingContainerBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    @Override
    protected WhiteVerticalShippingContainerBlockEntity getAsBE(BlockEntity blockEntity) {
        return blockEntity instanceof WhiteVerticalShippingContainerBlockEntity ? (WhiteVerticalShippingContainerBlockEntity) blockEntity : null;
    }

    @Override
    protected boolean isVault(BlockState state) {
        return WhiteVerticalShippingContainerBlock.sIsVault(state);
    }

    @Override
    protected Direction.Axis getVaultBlockAxis(BlockState state) {
        return WhiteVerticalShippingContainerBlock.sGetVaultBlockAxis(state);
    }

    @Override
    protected BlockEntityType<WhiteVerticalShippingContainerBlockEntity> getBlockEntityType() {
        return WhiteVerticalShippingContainerBlock.sGetBlockEntityType();
    }
}
