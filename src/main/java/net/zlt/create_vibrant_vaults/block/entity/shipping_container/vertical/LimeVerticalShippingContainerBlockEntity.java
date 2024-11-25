package net.zlt.create_vibrant_vaults.block.entity.shipping_container.vertical;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_vibrant_vaults.block.entity.AbstractVerticalItemVaultBlockEntity;
import net.zlt.create_vibrant_vaults.block.shipping_container.vertical.LimeVerticalShippingContainerBlock;

public class LimeVerticalShippingContainerBlockEntity extends AbstractVerticalItemVaultBlockEntity<LimeVerticalShippingContainerBlockEntity> {
    public LimeVerticalShippingContainerBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    @Override
    protected LimeVerticalShippingContainerBlockEntity getAsBE(BlockEntity blockEntity) {
        return blockEntity instanceof LimeVerticalShippingContainerBlockEntity ? (LimeVerticalShippingContainerBlockEntity) blockEntity : null;
    }

    @Override
    protected boolean isVault(BlockState state) {
        return LimeVerticalShippingContainerBlock.sIsVault(state);
    }

    @Override
    protected Direction.Axis getVaultBlockAxis(BlockState state) {
        return LimeVerticalShippingContainerBlock.sGetVaultBlockAxis(state);
    }

    @Override
    protected BlockEntityType<LimeVerticalShippingContainerBlockEntity> getBlockEntityType() {
        return LimeVerticalShippingContainerBlock.sGetBlockEntityType();
    }
}
