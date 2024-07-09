package net.zlt.create_vibrant_vaults;

import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class MagentaBasicShippingContainerBlock extends AbstractItemVaultBlock<MagentaBasicShippingContainerBlockEntity> {
    public MagentaBasicShippingContainerBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected boolean isPlacingNbt() {
        return MagentaBasicShippingContainerItem.IS_PLACING_NBT;
    }

    @Override
    protected MagentaBasicShippingContainerBlockEntity getAsBE(BlockEntity blockEntity) {
        return blockEntity instanceof MagentaBasicShippingContainerBlockEntity ? (MagentaBasicShippingContainerBlockEntity) blockEntity : null;
    }

    public static boolean sIsVault(BlockState state) {
        return AllBlocks.MAGENTA_BASIC_SHIPPING_CONTAINER.has(state);
    }

    public static Direction.Axis sGetVaultBlockAxis(BlockState state) {
        return !sIsVault(state) ? null : state.getValue(HORIZONTAL_AXIS);
    }

    public static boolean sIsLarge(BlockState state) {
        return sIsVault(state) && state.getValue(LARGE);
    }

    public static BlockEntityType<MagentaBasicShippingContainerBlockEntity> sGetBlockEntityType() {
        return AllBlockEntityTypes.MAGENTA_BASIC_SHIPPING_CONTAINER.get();
    }

    @Override
    public boolean isVault(BlockState state) {
        return sIsVault(state);
    }

    @Override
    public BlockEntityType<MagentaBasicShippingContainerBlockEntity> getBlockEntityType() {
        return sGetBlockEntityType();
    }

    @Override
    public Class<MagentaBasicShippingContainerBlockEntity> getBlockEntityClass() {
        return MagentaBasicShippingContainerBlockEntity.class;
    }
}