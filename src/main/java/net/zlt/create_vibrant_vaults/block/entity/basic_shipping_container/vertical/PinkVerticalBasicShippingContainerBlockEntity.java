package net.zlt.create_vibrant_vaults.block.entity.basic_shipping_container.vertical;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_vibrant_vaults.block.basic_shipping_container.vertical.PinkVerticalBasicShippingContainerBlock;
import net.zlt.create_vibrant_vaults.block.entity.AbstractVerticalItemVaultBlockEntity;

public class PinkVerticalBasicShippingContainerBlockEntity extends AbstractVerticalItemVaultBlockEntity<PinkVerticalBasicShippingContainerBlockEntity> {
    public PinkVerticalBasicShippingContainerBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    @Override
    protected PinkVerticalBasicShippingContainerBlockEntity getAsBE(BlockEntity blockEntity) {
        return blockEntity instanceof PinkVerticalBasicShippingContainerBlockEntity ? (PinkVerticalBasicShippingContainerBlockEntity) blockEntity : null;
    }

    @Override
    protected boolean isVault(BlockState state) {
        return PinkVerticalBasicShippingContainerBlock.sIsVault(state);
    }

    @Override
    protected Direction.Axis getVaultBlockAxis(BlockState state) {
        return PinkVerticalBasicShippingContainerBlock.sGetVaultBlockAxis(state);
    }

    @Override
    protected BlockEntityType<PinkVerticalBasicShippingContainerBlockEntity> getBlockEntityType() {
        return PinkVerticalBasicShippingContainerBlock.sGetBlockEntityType();
    }
}
