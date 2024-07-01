package net.zlt.create_vibrant_vaults;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class GreenShippingContainerBlockEntity extends AbstractItemVaultBlockEntity<GreenShippingContainerBlockEntity> {
    public GreenShippingContainerBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    @Override
    protected GreenShippingContainerBlockEntity getAsBE(BlockEntity blockEntity) {
        return blockEntity instanceof GreenShippingContainerBlockEntity ? (GreenShippingContainerBlockEntity) blockEntity : null;
    }

    @Override
    protected boolean isVault(BlockState state) {
        return GreenShippingContainerBlock.sIsVault(state);
    }

    @Override
    protected Direction.Axis getVaultBlockAxis(BlockState state) {
        return GreenShippingContainerBlock.sGetVaultBlockAxis(state);
    }

    @Override
    protected BlockEntityType<GreenShippingContainerBlockEntity> getBlockEntityType() {
        return GreenShippingContainerBlock.sGetBlockEntityType();
    }
}
