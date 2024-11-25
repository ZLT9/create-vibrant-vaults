package net.zlt.create_vibrant_vaults.block.entity.basic_shipping_container;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_vibrant_vaults.block.basic_shipping_container.LightBlueBasicShippingContainerBlock;
import net.zlt.create_vibrant_vaults.block.entity.AbstractItemVaultBlockEntity;

public class LightBlueBasicShippingContainerBlockEntity extends AbstractItemVaultBlockEntity<LightBlueBasicShippingContainerBlockEntity> {
    public LightBlueBasicShippingContainerBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    @Override
    protected LightBlueBasicShippingContainerBlockEntity getAsBE(BlockEntity blockEntity) {
        return blockEntity instanceof LightBlueBasicShippingContainerBlockEntity ? (LightBlueBasicShippingContainerBlockEntity) blockEntity : null;
    }

    @Override
    protected boolean isVault(BlockState state) {
        return LightBlueBasicShippingContainerBlock.sIsVault(state);
    }

    @Override
    protected Direction.Axis getVaultBlockAxis(BlockState state) {
        return LightBlueBasicShippingContainerBlock.sGetVaultBlockAxis(state);
    }

    @Override
    protected BlockEntityType<LightBlueBasicShippingContainerBlockEntity> getBlockEntityType() {
        return LightBlueBasicShippingContainerBlock.sGetBlockEntityType();
    }
}
