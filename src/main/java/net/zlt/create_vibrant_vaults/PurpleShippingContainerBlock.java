package net.zlt.create_vibrant_vaults;

import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class PurpleShippingContainerBlock extends AbstractItemVaultBlock<PurpleShippingContainerBlockEntity> {
    public PurpleShippingContainerBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected boolean isPlacingNbt() {
        return PurpleShippingContainerItem.IS_PLACING_NBT;
    }

    @Override
    protected PurpleShippingContainerBlockEntity getAsBE(BlockEntity blockEntity) {
        return blockEntity instanceof PurpleShippingContainerBlockEntity ? (PurpleShippingContainerBlockEntity) blockEntity : null;
    }

    public static boolean sIsVault(BlockState state) {
        return AllBlocks.PURPLE_SHIPPING_CONTAINER.has(state);
    }

    public static Direction.Axis sGetVaultBlockAxis(BlockState state) {
        return !sIsVault(state) ? null : state.getValue(HORIZONTAL_AXIS);
    }

    public static boolean sIsLarge(BlockState state) {
        return sIsVault(state) && state.getValue(LARGE);
    }

    public static BlockEntityType<PurpleShippingContainerBlockEntity> sGetBlockEntityType() {
        return AllBlockEntityTypes.PURPLE_SHIPPING_CONTAINER.get();
    }

    @Override
    public boolean isVault(BlockState state) {
        return sIsVault(state);
    }

    @Override
    public BlockEntityType<PurpleShippingContainerBlockEntity> getBlockEntityType() {
        return sGetBlockEntityType();
    }

    @Override
    public Class<PurpleShippingContainerBlockEntity> getBlockEntityClass() {
        return PurpleShippingContainerBlockEntity.class;
    }
}
