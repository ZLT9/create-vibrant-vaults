package net.zlt.create_vibrant_vaults.block.shipping_container.vertical;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_vibrant_vaults.block.AbstractVerticalItemVaultBlock;
import net.zlt.create_vibrant_vaults.block.entity.AllBlockEntityTypes;
import net.zlt.create_vibrant_vaults.block.AllBlocks;
import net.zlt.create_vibrant_vaults.block.entity.shipping_container.vertical.RedVerticalShippingContainerBlockEntity;
import net.zlt.create_vibrant_vaults.item.shipping_container.vertical.RedVerticalShippingContainerItem;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class RedVerticalShippingContainerBlock extends AbstractVerticalItemVaultBlock<RedVerticalShippingContainerBlockEntity> {
    public RedVerticalShippingContainerBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected boolean isPlacingNbt() {
        return RedVerticalShippingContainerItem.IS_PLACING_NBT;
    }

    @Override
    protected RedVerticalShippingContainerBlockEntity getAsBE(BlockEntity blockEntity) {
        return blockEntity instanceof RedVerticalShippingContainerBlockEntity ? (RedVerticalShippingContainerBlockEntity) blockEntity : null;
    }

    public static boolean sIsVault(BlockState state) {
        return AllBlocks.RED_VERTICAL_SHIPPING_CONTAINER.has(state);
    }

    @Nullable
    public static Direction.Axis sGetVaultBlockAxis(BlockState state) {
        return !sIsVault(state) ? null : Direction.Axis.Y;
    }

    public static boolean sIsLarge(BlockState state) {
        return sIsVault(state) && state.getValue(LARGE);
    }

    public static BlockEntityType<RedVerticalShippingContainerBlockEntity> sGetBlockEntityType() {
        return AllBlockEntityTypes.RED_VERTICAL_SHIPPING_CONTAINER.get();
    }

    @Override
    public boolean isVault(BlockState state) {
        return sIsVault(state);
    }

    @Override
    public BlockEntityType<RedVerticalShippingContainerBlockEntity> getBlockEntityType() {
        return sGetBlockEntityType();
    }

    @Override
    public Class<RedVerticalShippingContainerBlockEntity> getBlockEntityClass() {
        return RedVerticalShippingContainerBlockEntity.class;
    }

    @Override
    @Nullable
    public Block getHorizontalVaultBlock() {
        return AllBlocks.RED_SHIPPING_CONTAINER.get();
    }
}
