package net.zlt.create_vibrant_vaults;

import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class CyanShippingContainerBlock extends AbstractItemVaultBlock<CyanShippingContainerBlockEntity> {
    public CyanShippingContainerBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected boolean isPlacingNbt() {
        return CyanShippingContainerItem.IS_PLACING_NBT;
    }

    @Override
    protected CyanShippingContainerBlockEntity getAsBE(BlockEntity blockEntity) {
        return blockEntity instanceof CyanShippingContainerBlockEntity ? (CyanShippingContainerBlockEntity) blockEntity : null;
    }

    public static boolean sIsVault(BlockState state) {
        return AllBlocks.CYAN_SHIPPING_CONTAINER.has(state);
    }

    public static Direction.Axis sGetVaultBlockAxis(BlockState state) {
        return !sIsVault(state) ? null : state.getValue(HORIZONTAL_AXIS);
    }

    public static boolean sIsLarge(BlockState state) {
        return sIsVault(state) && state.getValue(LARGE);
    }

    public static BlockEntityType<CyanShippingContainerBlockEntity> sGetBlockEntityType() {
        return AllBlockEntityTypes.CYAN_SHIPPING_CONTAINER.get();
    }

    @Override
    public boolean isVault(BlockState state) {
        return sIsVault(state);
    }

    @Override
    public BlockEntityType<CyanShippingContainerBlockEntity> getBlockEntityType() {
        return sGetBlockEntityType();
    }

    @Override
    public Class<CyanShippingContainerBlockEntity> getBlockEntityClass() {
        return CyanShippingContainerBlockEntity.class;
    }
}
