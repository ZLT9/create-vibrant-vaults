package net.zlt.create_vibrant_vaults;

import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class OrangeBasicShippingContainerBlock extends AbstractItemVaultBlock<OrangeBasicShippingContainerBlockEntity> {
    public OrangeBasicShippingContainerBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected boolean isPlacingNbt() {
        return OrangeBasicShippingContainerItem.IS_PLACING_NBT;
    }

    @Override
    protected OrangeBasicShippingContainerBlockEntity getAsBE(BlockEntity blockEntity) {
        return blockEntity instanceof OrangeBasicShippingContainerBlockEntity ? (OrangeBasicShippingContainerBlockEntity) blockEntity : null;
    }

    public static boolean sIsVault(BlockState state) {
        return AllBlocks.ORANGE_BASIC_SHIPPING_CONTAINER.has(state);
    }

    public static Direction.Axis sGetVaultBlockAxis(BlockState state) {
        return !sIsVault(state) ? null : state.getValue(HORIZONTAL_AXIS);
    }

    public static boolean sIsLarge(BlockState state) {
        return sIsVault(state) && state.getValue(LARGE);
    }

    public static BlockEntityType<OrangeBasicShippingContainerBlockEntity> sGetBlockEntityType() {
        return AllBlockEntityTypes.ORANGE_BASIC_SHIPPING_CONTAINER.get();
    }

    @Override
    public boolean isVault(BlockState state) {
        return sIsVault(state);
    }

    @Override
    public BlockEntityType<OrangeBasicShippingContainerBlockEntity> getBlockEntityType() {
        return sGetBlockEntityType();
    }

    @Override
    public Class<OrangeBasicShippingContainerBlockEntity> getBlockEntityClass() {
        return OrangeBasicShippingContainerBlockEntity.class;
    }
}
