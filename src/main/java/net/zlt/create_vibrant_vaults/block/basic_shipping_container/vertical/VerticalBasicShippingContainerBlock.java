package net.zlt.create_vibrant_vaults.block.basic_shipping_container.vertical;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_vibrant_vaults.block.AbstractVerticalItemVaultBlock;
import net.zlt.create_vibrant_vaults.block.entity.AllBlockEntityTypes;
import net.zlt.create_vibrant_vaults.block.AllBlocks;
import net.zlt.create_vibrant_vaults.block.entity.basic_shipping_container.vertical.VerticalBasicShippingContainerBlockEntity;
import net.zlt.create_vibrant_vaults.item.basic_shipping_container.vertical.VerticalBasicShippingContainerItem;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class VerticalBasicShippingContainerBlock extends AbstractVerticalItemVaultBlock<VerticalBasicShippingContainerBlockEntity> {
    public VerticalBasicShippingContainerBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected boolean isPlacingNbt() {
        return VerticalBasicShippingContainerItem.IS_PLACING_NBT;
    }

    @Override
    protected VerticalBasicShippingContainerBlockEntity getAsBE(BlockEntity blockEntity) {
        return blockEntity instanceof VerticalBasicShippingContainerBlockEntity ? (VerticalBasicShippingContainerBlockEntity) blockEntity : null;
    }

    public static boolean sIsVault(BlockState state) {
        return AllBlocks.VERTICAL_BASIC_SHIPPING_CONTAINER.has(state);
    }

    @Nullable
    public static Direction.Axis sGetVaultBlockAxis(BlockState state) {
        return !sIsVault(state) ? null : Direction.Axis.Y;
    }

    public static boolean sIsLarge(BlockState state) {
        return sIsVault(state) && state.getValue(LARGE);
    }

    public static BlockEntityType<VerticalBasicShippingContainerBlockEntity> sGetBlockEntityType() {
        return AllBlockEntityTypes.VERTICAL_BASIC_SHIPPING_CONTAINER.get();
    }

    @Override
    public boolean isVault(BlockState state) {
        return sIsVault(state);
    }

    @Override
    public BlockEntityType<VerticalBasicShippingContainerBlockEntity> getBlockEntityType() {
        return sGetBlockEntityType();
    }

    @Override
    public Class<VerticalBasicShippingContainerBlockEntity> getBlockEntityClass() {
        return VerticalBasicShippingContainerBlockEntity.class;
    }

    @Override
    @Nullable
    public Block getHorizontalVaultBlock() {
        return AllBlocks.BASIC_SHIPPING_CONTAINER.get();
    }
}
