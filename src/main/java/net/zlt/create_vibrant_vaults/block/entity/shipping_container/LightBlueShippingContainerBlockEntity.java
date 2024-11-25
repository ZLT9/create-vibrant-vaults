package net.zlt.create_vibrant_vaults.block.entity.shipping_container;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_vibrant_vaults.block.entity.AbstractItemVaultBlockEntity;
import net.zlt.create_vibrant_vaults.block.shipping_container.LightBlueShippingContainerBlock;

public class LightBlueShippingContainerBlockEntity extends AbstractItemVaultBlockEntity<LightBlueShippingContainerBlockEntity> {
    public LightBlueShippingContainerBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    @Override
    protected LightBlueShippingContainerBlockEntity getAsBE(BlockEntity blockEntity) {
        return blockEntity instanceof LightBlueShippingContainerBlockEntity ? (LightBlueShippingContainerBlockEntity) blockEntity : null;
    }

    @Override
    protected boolean isVault(BlockState state) {
        return LightBlueShippingContainerBlock.sIsVault(state);
    }

    @Override
    protected Direction.Axis getVaultBlockAxis(BlockState state) {
        return LightBlueShippingContainerBlock.sGetVaultBlockAxis(state);
    }

    @Override
    protected BlockEntityType<LightBlueShippingContainerBlockEntity> getBlockEntityType() {
        return LightBlueShippingContainerBlock.sGetBlockEntityType();
    }
}
