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
import net.zlt.create_vibrant_vaults.block.entity.basic_shipping_container.vertical.YellowVerticalBasicShippingContainerBlockEntity;
import net.zlt.create_vibrant_vaults.item.basic_shipping_container.vertical.YellowVerticalBasicShippingContainerItem;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class YellowVerticalBasicShippingContainerBlock extends AbstractVerticalItemVaultBlock<YellowVerticalBasicShippingContainerBlockEntity> {
    public YellowVerticalBasicShippingContainerBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected boolean isPlacingNbt() {
        return YellowVerticalBasicShippingContainerItem.IS_PLACING_NBT;
    }

    @Override
    protected YellowVerticalBasicShippingContainerBlockEntity getAsBE(BlockEntity blockEntity) {
        return blockEntity instanceof YellowVerticalBasicShippingContainerBlockEntity ? (YellowVerticalBasicShippingContainerBlockEntity) blockEntity : null;
    }

    public static boolean sIsVault(BlockState state) {
        return AllBlocks.YELLOW_VERTICAL_BASIC_SHIPPING_CONTAINER.has(state);
    }

    @Nullable
    public static Direction.Axis sGetVaultBlockAxis(BlockState state) {
        return !sIsVault(state) ? null : Direction.Axis.Y;
    }

    public static boolean sIsLarge(BlockState state) {
        return sIsVault(state) && state.getValue(LARGE);
    }

    public static BlockEntityType<YellowVerticalBasicShippingContainerBlockEntity> sGetBlockEntityType() {
        return AllBlockEntityTypes.YELLOW_VERTICAL_BASIC_SHIPPING_CONTAINER.get();
    }

    @Override
    public boolean isVault(BlockState state) {
        return sIsVault(state);
    }

    @Override
    public BlockEntityType<YellowVerticalBasicShippingContainerBlockEntity> getBlockEntityType() {
        return sGetBlockEntityType();
    }

    @Override
    public Class<YellowVerticalBasicShippingContainerBlockEntity> getBlockEntityClass() {
        return YellowVerticalBasicShippingContainerBlockEntity.class;
    }

    @Override
    @Nullable
    public Block getHorizontalVaultBlock() {
        return AllBlocks.YELLOW_BASIC_SHIPPING_CONTAINER.get();
    }
}
