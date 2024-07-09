package net.zlt.create_vibrant_vaults;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class CyanBasicShippingContainerBlockEntity extends AbstractItemVaultBlockEntity<CyanBasicShippingContainerBlockEntity> {
    public CyanBasicShippingContainerBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    @Override
    protected CyanBasicShippingContainerBlockEntity getAsBE(BlockEntity blockEntity) {
        return blockEntity instanceof CyanBasicShippingContainerBlockEntity ? (CyanBasicShippingContainerBlockEntity) blockEntity : null;
    }

    @Override
    protected boolean isVault(BlockState state) {
        return CyanBasicShippingContainerBlock.sIsVault(state);
    }

    @Override
    protected Direction.Axis getVaultBlockAxis(BlockState state) {
        return CyanBasicShippingContainerBlock.sGetVaultBlockAxis(state);
    }

    @Override
    protected BlockEntityType<CyanBasicShippingContainerBlockEntity> getBlockEntityType() {
        return CyanBasicShippingContainerBlock.sGetBlockEntityType();
    }
}
