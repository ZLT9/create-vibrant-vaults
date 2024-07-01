package net.zlt.create_vibrant_vaults;

import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class GrayShippingContainerBlock extends AbstractItemVaultBlock<GrayShippingContainerBlockEntity> {
    public GrayShippingContainerBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected boolean isPlacingNbt() {
        return GrayShippingContainerItem.IS_PLACING_NBT;
    }

    @Override
    protected GrayShippingContainerBlockEntity getAsBE(BlockEntity blockEntity) {
        return blockEntity instanceof GrayShippingContainerBlockEntity ? (GrayShippingContainerBlockEntity) blockEntity : null;
    }

    public static boolean sIsVault(BlockState state) {
        return AllBlocks.GRAY_SHIPPING_CONTAINER.has(state);
    }

    public static Direction.Axis sGetVaultBlockAxis(BlockState state) {
        return !sIsVault(state) ? null : state.getValue(HORIZONTAL_AXIS);
    }

    public static boolean sIsLarge(BlockState state) {
        return sIsVault(state) && state.getValue(LARGE);
    }

    public static BlockEntityType<GrayShippingContainerBlockEntity> sGetBlockEntityType() {
        return AllBlockEntityTypes.GRAY_SHIPPING_CONTAINER.get();
    }

    @Override
    public boolean isVault(BlockState state) {
        return sIsVault(state);
    }

    @Override
    public BlockEntityType<GrayShippingContainerBlockEntity> getBlockEntityType() {
        return sGetBlockEntityType();
    }

    @Override
    public Class<GrayShippingContainerBlockEntity> getBlockEntityClass() {
        return GrayShippingContainerBlockEntity.class;
    }
}
