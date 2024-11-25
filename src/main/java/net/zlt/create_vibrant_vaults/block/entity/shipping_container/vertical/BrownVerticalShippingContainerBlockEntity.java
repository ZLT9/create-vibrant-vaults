package net.zlt.create_vibrant_vaults.block.entity.shipping_container.vertical;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_vibrant_vaults.block.entity.AbstractVerticalItemVaultBlockEntity;
import net.zlt.create_vibrant_vaults.block.shipping_container.vertical.BrownVerticalShippingContainerBlock;

public class BrownVerticalShippingContainerBlockEntity extends AbstractVerticalItemVaultBlockEntity<BrownVerticalShippingContainerBlockEntity> {
    public BrownVerticalShippingContainerBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    @Override
    protected BrownVerticalShippingContainerBlockEntity getAsBE(BlockEntity blockEntity) {
        return blockEntity instanceof BrownVerticalShippingContainerBlockEntity ? (BrownVerticalShippingContainerBlockEntity) blockEntity : null;
    }

    @Override
    protected boolean isVault(BlockState state) {
        return BrownVerticalShippingContainerBlock.sIsVault(state);
    }

    @Override
    protected Direction.Axis getVaultBlockAxis(BlockState state) {
        return BrownVerticalShippingContainerBlock.sGetVaultBlockAxis(state);
    }

    @Override
    protected BlockEntityType<BrownVerticalShippingContainerBlockEntity> getBlockEntityType() {
        return BrownVerticalShippingContainerBlock.sGetBlockEntityType();
    }
}
