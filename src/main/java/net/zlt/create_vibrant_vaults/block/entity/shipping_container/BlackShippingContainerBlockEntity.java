package net.zlt.create_vibrant_vaults.block.entity.shipping_container;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_vibrant_vaults.block.entity.AbstractItemVaultBlockEntity;
import net.zlt.create_vibrant_vaults.block.shipping_container.BlackShippingContainerBlock;

public class BlackShippingContainerBlockEntity extends AbstractItemVaultBlockEntity<BlackShippingContainerBlockEntity> {
    public BlackShippingContainerBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    @Override
    protected BlackShippingContainerBlockEntity getAsBE(BlockEntity blockEntity) {
        return blockEntity instanceof BlackShippingContainerBlockEntity ? (BlackShippingContainerBlockEntity) blockEntity : null;
    }

    @Override
    protected boolean isVault(BlockState state) {
        return BlackShippingContainerBlock.sIsVault(state);
    }

    @Override
    protected Direction.Axis getVaultBlockAxis(BlockState state) {
        return BlackShippingContainerBlock.sGetVaultBlockAxis(state);
    }

    @Override
    protected BlockEntityType<BlackShippingContainerBlockEntity> getBlockEntityType() {
        return BlackShippingContainerBlock.sGetBlockEntityType();
    }
}
