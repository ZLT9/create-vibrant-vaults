package net.zlt.create_vibrant_vaults.block.entity.basic_shipping_container.vertical;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_vibrant_vaults.block.entity.AbstractVerticalItemVaultBlockEntity;
import net.zlt.create_vibrant_vaults.block.basic_shipping_container.vertical.YellowVerticalBasicShippingContainerBlock;

public class YellowVerticalBasicShippingContainerBlockEntity extends AbstractVerticalItemVaultBlockEntity<YellowVerticalBasicShippingContainerBlockEntity> {
    public YellowVerticalBasicShippingContainerBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    @Override
    protected YellowVerticalBasicShippingContainerBlockEntity getAsBE(BlockEntity blockEntity) {
        return blockEntity instanceof YellowVerticalBasicShippingContainerBlockEntity ? (YellowVerticalBasicShippingContainerBlockEntity) blockEntity : null;
    }

    @Override
    protected boolean isVault(BlockState state) {
        return YellowVerticalBasicShippingContainerBlock.sIsVault(state);
    }

    @Override
    protected Direction.Axis getVaultBlockAxis(BlockState state) {
        return YellowVerticalBasicShippingContainerBlock.sGetVaultBlockAxis(state);
    }

    @Override
    protected BlockEntityType<YellowVerticalBasicShippingContainerBlockEntity> getBlockEntityType() {
        return YellowVerticalBasicShippingContainerBlock.sGetBlockEntityType();
    }
}
