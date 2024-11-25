package net.zlt.create_vibrant_vaults.block.entity.basic_shipping_container;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_vibrant_vaults.block.basic_shipping_container.RedBasicShippingContainerBlock;
import net.zlt.create_vibrant_vaults.block.entity.AbstractItemVaultBlockEntity;

public class RedBasicShippingContainerBlockEntity extends AbstractItemVaultBlockEntity<RedBasicShippingContainerBlockEntity> {
    public RedBasicShippingContainerBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    @Override
    protected RedBasicShippingContainerBlockEntity getAsBE(BlockEntity blockEntity) {
        return blockEntity instanceof RedBasicShippingContainerBlockEntity ? (RedBasicShippingContainerBlockEntity) blockEntity : null;
    }

    @Override
    protected boolean isVault(BlockState state) {
        return RedBasicShippingContainerBlock.sIsVault(state);
    }

    @Override
    protected Direction.Axis getVaultBlockAxis(BlockState state) {
        return RedBasicShippingContainerBlock.sGetVaultBlockAxis(state);
    }

    @Override
    protected BlockEntityType<RedBasicShippingContainerBlockEntity> getBlockEntityType() {
        return RedBasicShippingContainerBlock.sGetBlockEntityType();
    }
}
