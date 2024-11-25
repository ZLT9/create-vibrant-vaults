package net.zlt.create_vibrant_vaults.block.entity.shipping_container;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_vibrant_vaults.block.entity.AbstractItemVaultBlockEntity;
import net.zlt.create_vibrant_vaults.block.shipping_container.WhiteShippingContainerBlock;

public class WhiteShippingContainerBlockEntity extends AbstractItemVaultBlockEntity<WhiteShippingContainerBlockEntity> {
    public WhiteShippingContainerBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    @Override
    protected WhiteShippingContainerBlockEntity getAsBE(BlockEntity blockEntity) {
        return blockEntity instanceof WhiteShippingContainerBlockEntity ? (WhiteShippingContainerBlockEntity) blockEntity : null;
    }

    @Override
    protected boolean isVault(BlockState state) {
        return WhiteShippingContainerBlock.sIsVault(state);
    }

    @Override
    protected Direction.Axis getVaultBlockAxis(BlockState state) {
        return WhiteShippingContainerBlock.sGetVaultBlockAxis(state);
    }

    @Override
    protected BlockEntityType<WhiteShippingContainerBlockEntity> getBlockEntityType() {
        return WhiteShippingContainerBlock.sGetBlockEntityType();
    }
}
