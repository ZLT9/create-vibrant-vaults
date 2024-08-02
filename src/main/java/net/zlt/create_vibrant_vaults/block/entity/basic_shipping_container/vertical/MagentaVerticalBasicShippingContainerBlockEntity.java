package net.zlt.create_vibrant_vaults.block.entity.basic_shipping_container.vertical;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_vibrant_vaults.block.entity.AbstractVerticalItemVaultBlockEntity;
import net.zlt.create_vibrant_vaults.block.basic_shipping_container.vertical.MagentaVerticalBasicShippingContainerBlock;

public class MagentaVerticalBasicShippingContainerBlockEntity extends AbstractVerticalItemVaultBlockEntity<MagentaVerticalBasicShippingContainerBlockEntity> {
    public MagentaVerticalBasicShippingContainerBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    @Override
    protected MagentaVerticalBasicShippingContainerBlockEntity getAsBE(BlockEntity blockEntity) {
        return blockEntity instanceof MagentaVerticalBasicShippingContainerBlockEntity ? (MagentaVerticalBasicShippingContainerBlockEntity) blockEntity : null;
    }

    @Override
    protected boolean isVault(BlockState state) {
        return MagentaVerticalBasicShippingContainerBlock.sIsVault(state);
    }

    @Override
    protected Direction.Axis getVaultBlockAxis(BlockState state) {
        return MagentaVerticalBasicShippingContainerBlock.sGetVaultBlockAxis(state);
    }

    @Override
    protected BlockEntityType<MagentaVerticalBasicShippingContainerBlockEntity> getBlockEntityType() {
        return MagentaVerticalBasicShippingContainerBlock.sGetBlockEntityType();
    }
}
