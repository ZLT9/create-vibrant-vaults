package net.zlt.create_vibrant_vaults.block.entity.basic_shipping_container;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_vibrant_vaults.block.basic_shipping_container.OrangeBasicShippingContainerBlock;
import net.zlt.create_vibrant_vaults.block.entity.AbstractItemVaultBlockEntity;

public class OrangeBasicShippingContainerBlockEntity extends AbstractItemVaultBlockEntity<OrangeBasicShippingContainerBlockEntity> {
    public OrangeBasicShippingContainerBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    @Override
    protected OrangeBasicShippingContainerBlockEntity getAsBE(BlockEntity blockEntity) {
        return blockEntity instanceof OrangeBasicShippingContainerBlockEntity ? (OrangeBasicShippingContainerBlockEntity) blockEntity : null;
    }

    @Override
    protected boolean isVault(BlockState state) {
        return OrangeBasicShippingContainerBlock.sIsVault(state);
    }

    @Override
    protected Direction.Axis getVaultBlockAxis(BlockState state) {
        return OrangeBasicShippingContainerBlock.sGetVaultBlockAxis(state);
    }

    @Override
    protected BlockEntityType<OrangeBasicShippingContainerBlockEntity> getBlockEntityType() {
        return OrangeBasicShippingContainerBlock.sGetBlockEntityType();
    }
}
