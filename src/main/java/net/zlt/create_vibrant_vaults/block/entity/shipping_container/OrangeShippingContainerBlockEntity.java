package net.zlt.create_vibrant_vaults.block.entity.shipping_container;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_vibrant_vaults.block.entity.AbstractItemVaultBlockEntity;
import net.zlt.create_vibrant_vaults.block.shipping_container.OrangeShippingContainerBlock;

public class OrangeShippingContainerBlockEntity extends AbstractItemVaultBlockEntity<OrangeShippingContainerBlockEntity> {
    public OrangeShippingContainerBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    @Override
    protected OrangeShippingContainerBlockEntity getAsBE(BlockEntity blockEntity) {
        return blockEntity instanceof OrangeShippingContainerBlockEntity ? (OrangeShippingContainerBlockEntity) blockEntity : null;
    }

    @Override
    protected boolean isVault(BlockState state) {
        return OrangeShippingContainerBlock.sIsVault(state);
    }

    @Override
    protected Direction.Axis getVaultBlockAxis(BlockState state) {
        return OrangeShippingContainerBlock.sGetVaultBlockAxis(state);
    }

    @Override
    protected BlockEntityType<OrangeShippingContainerBlockEntity> getBlockEntityType() {
        return OrangeShippingContainerBlock.sGetBlockEntityType();
    }
}
