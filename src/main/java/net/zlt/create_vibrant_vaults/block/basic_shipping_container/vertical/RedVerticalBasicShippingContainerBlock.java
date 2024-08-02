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
import net.zlt.create_vibrant_vaults.block.entity.basic_shipping_container.vertical.RedVerticalBasicShippingContainerBlockEntity;
import net.zlt.create_vibrant_vaults.item.basic_shipping_container.vertical.RedVerticalBasicShippingContainerItem;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class RedVerticalBasicShippingContainerBlock extends AbstractVerticalItemVaultBlock<RedVerticalBasicShippingContainerBlockEntity> {
    public RedVerticalBasicShippingContainerBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected boolean isPlacingNbt() {
        return RedVerticalBasicShippingContainerItem.IS_PLACING_NBT;
    }

    @Override
    protected RedVerticalBasicShippingContainerBlockEntity getAsBE(BlockEntity blockEntity) {
        return blockEntity instanceof RedVerticalBasicShippingContainerBlockEntity ? (RedVerticalBasicShippingContainerBlockEntity) blockEntity : null;
    }

    public static boolean sIsVault(BlockState state) {
        return AllBlocks.RED_VERTICAL_BASIC_SHIPPING_CONTAINER.has(state);
    }

    @Nullable
    public static Direction.Axis sGetVaultBlockAxis(BlockState state) {
        return !sIsVault(state) ? null : Direction.Axis.Y;
    }

    public static boolean sIsLarge(BlockState state) {
        return sIsVault(state) && state.getValue(LARGE);
    }

    public static BlockEntityType<RedVerticalBasicShippingContainerBlockEntity> sGetBlockEntityType() {
        return AllBlockEntityTypes.RED_VERTICAL_BASIC_SHIPPING_CONTAINER.get();
    }

    @Override
    public boolean isVault(BlockState state) {
        return sIsVault(state);
    }

    @Override
    public BlockEntityType<RedVerticalBasicShippingContainerBlockEntity> getBlockEntityType() {
        return sGetBlockEntityType();
    }

    @Override
    public Class<RedVerticalBasicShippingContainerBlockEntity> getBlockEntityClass() {
        return RedVerticalBasicShippingContainerBlockEntity.class;
    }

    @Override
    @Nullable
    public Block getHorizontalVaultBlock() {
        return AllBlocks.RED_BASIC_SHIPPING_CONTAINER.get();
    }
}
