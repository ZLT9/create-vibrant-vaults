package net.zlt.create_vibrant_vaults.block.shipping_container.vertical;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_vibrant_vaults.block.AbstractVerticalItemVaultBlock;
import net.zlt.create_vibrant_vaults.block.AllBlocks;
import net.zlt.create_vibrant_vaults.block.entity.AllBlockEntityTypes;
import net.zlt.create_vibrant_vaults.block.entity.shipping_container.vertical.GrayVerticalShippingContainerBlockEntity;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class GrayVerticalShippingContainerBlock extends AbstractVerticalItemVaultBlock<GrayVerticalShippingContainerBlockEntity> {
    public GrayVerticalShippingContainerBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected GrayVerticalShippingContainerBlockEntity getAsBE(BlockEntity blockEntity) {
        return blockEntity instanceof GrayVerticalShippingContainerBlockEntity ? (GrayVerticalShippingContainerBlockEntity) blockEntity : null;
    }

    public static boolean sIsVault(BlockState state) {
        return AllBlocks.GRAY_VERTICAL_SHIPPING_CONTAINER.has(state);
    }

    @Nullable
    public static Direction.Axis sGetVaultBlockAxis(BlockState state) {
        return !sIsVault(state) ? null : Direction.Axis.Y;
    }

    public static boolean sIsLarge(BlockState state) {
        return sIsVault(state) && state.getValue(LARGE);
    }

    public static BlockEntityType<GrayVerticalShippingContainerBlockEntity> sGetBlockEntityType() {
        return AllBlockEntityTypes.GRAY_VERTICAL_SHIPPING_CONTAINER.get();
    }

    @Override
    public boolean isVault(BlockState state) {
        return sIsVault(state);
    }

    @Override
    public BlockEntityType<GrayVerticalShippingContainerBlockEntity> getBlockEntityType() {
        return sGetBlockEntityType();
    }

    @Override
    public Class<GrayVerticalShippingContainerBlockEntity> getBlockEntityClass() {
        return GrayVerticalShippingContainerBlockEntity.class;
    }

    @Override
    @Nullable
    public Block getHorizontalVaultBlock() {
        return AllBlocks.GRAY_SHIPPING_CONTAINER.get();
    }
}
