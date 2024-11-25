package net.zlt.create_vibrant_vaults.block.entity.basic_shipping_container.vertical;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_vibrant_vaults.block.basic_shipping_container.vertical.WhiteVerticalBasicShippingContainerBlock;
import net.zlt.create_vibrant_vaults.block.entity.AbstractVerticalItemVaultBlockEntity;

public class WhiteVerticalBasicShippingContainerBlockEntity extends AbstractVerticalItemVaultBlockEntity<WhiteVerticalBasicShippingContainerBlockEntity> {
    public WhiteVerticalBasicShippingContainerBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    @Override
    protected WhiteVerticalBasicShippingContainerBlockEntity getAsBE(BlockEntity blockEntity) {
        return blockEntity instanceof WhiteVerticalBasicShippingContainerBlockEntity ? (WhiteVerticalBasicShippingContainerBlockEntity) blockEntity : null;
    }

    @Override
    protected boolean isVault(BlockState state) {
        return WhiteVerticalBasicShippingContainerBlock.sIsVault(state);
    }

    @Override
    protected Direction.Axis getVaultBlockAxis(BlockState state) {
        return WhiteVerticalBasicShippingContainerBlock.sGetVaultBlockAxis(state);
    }

    @Override
    protected BlockEntityType<WhiteVerticalBasicShippingContainerBlockEntity> getBlockEntityType() {
        return WhiteVerticalBasicShippingContainerBlock.sGetBlockEntityType();
    }
}
