package net.zlt.create_vibrant_vaults.block.entity.shipping_container.vertical;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_vibrant_vaults.block.entity.AbstractVerticalItemVaultBlockEntity;
import net.zlt.create_vibrant_vaults.block.shipping_container.vertical.MagentaVerticalShippingContainerBlock;

public class MagentaVerticalShippingContainerBlockEntity extends AbstractVerticalItemVaultBlockEntity<MagentaVerticalShippingContainerBlockEntity> {
    public MagentaVerticalShippingContainerBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    @Override
    protected MagentaVerticalShippingContainerBlockEntity getAsBE(BlockEntity blockEntity) {
        return blockEntity instanceof MagentaVerticalShippingContainerBlockEntity ? (MagentaVerticalShippingContainerBlockEntity) blockEntity : null;
    }

    @Override
    protected boolean isVault(BlockState state) {
        return MagentaVerticalShippingContainerBlock.sIsVault(state);
    }

    @Override
    protected Direction.Axis getVaultBlockAxis(BlockState state) {
        return MagentaVerticalShippingContainerBlock.sGetVaultBlockAxis(state);
    }

    @Override
    protected BlockEntityType<MagentaVerticalShippingContainerBlockEntity> getBlockEntityType() {
        return MagentaVerticalShippingContainerBlock.sGetBlockEntityType();
    }
}
