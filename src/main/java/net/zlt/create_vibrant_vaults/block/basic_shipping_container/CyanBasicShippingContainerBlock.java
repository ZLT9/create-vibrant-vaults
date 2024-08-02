package net.zlt.create_vibrant_vaults.block.basic_shipping_container;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_vibrant_vaults.item.basic_shipping_container.CyanBasicShippingContainerItem;
import net.zlt.create_vibrant_vaults.block.AbstractItemVaultBlock;
import net.zlt.create_vibrant_vaults.block.entity.AllBlockEntityTypes;
import net.zlt.create_vibrant_vaults.block.AllBlocks;
import net.zlt.create_vibrant_vaults.block.entity.basic_shipping_container.CyanBasicShippingContainerBlockEntity;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class CyanBasicShippingContainerBlock extends AbstractItemVaultBlock<CyanBasicShippingContainerBlockEntity> {
    public CyanBasicShippingContainerBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected boolean isPlacingNbt() {
        return CyanBasicShippingContainerItem.IS_PLACING_NBT;
    }

    @Override
    protected CyanBasicShippingContainerBlockEntity getAsBE(BlockEntity blockEntity) {
        return blockEntity instanceof CyanBasicShippingContainerBlockEntity ? (CyanBasicShippingContainerBlockEntity) blockEntity : null;
    }

    public static boolean sIsVault(BlockState state) {
        return AllBlocks.CYAN_BASIC_SHIPPING_CONTAINER.has(state);
    }

    @Nullable
    public static Direction.Axis sGetVaultBlockAxis(BlockState state) {
        return !sIsVault(state) ? null : state.getValue(HORIZONTAL_AXIS);
    }

    public static boolean sIsLarge(BlockState state) {
        return sIsVault(state) && state.getValue(LARGE);
    }

    public static BlockEntityType<CyanBasicShippingContainerBlockEntity> sGetBlockEntityType() {
        return AllBlockEntityTypes.CYAN_BASIC_SHIPPING_CONTAINER.get();
    }

    @Override
    public boolean isVault(BlockState state) {
        return sIsVault(state);
    }

    @Override
    public BlockEntityType<CyanBasicShippingContainerBlockEntity> getBlockEntityType() {
        return sGetBlockEntityType();
    }

    @Override
    public Class<CyanBasicShippingContainerBlockEntity> getBlockEntityClass() {
        return CyanBasicShippingContainerBlockEntity.class;
    }

    @Override
    @Nullable
    public Block getVerticalVaultBlock() {
        return AllBlocks.CYAN_VERTICAL_BASIC_SHIPPING_CONTAINER.get();
    }
}
