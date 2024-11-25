package net.zlt.create_vibrant_vaults.block.basic_shipping_container;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_vibrant_vaults.block.AbstractItemVaultBlock;
import net.zlt.create_vibrant_vaults.block.AllBlocks;
import net.zlt.create_vibrant_vaults.block.entity.AllBlockEntityTypes;
import net.zlt.create_vibrant_vaults.block.entity.basic_shipping_container.BasicShippingContainerBlockEntity;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class BasicShippingContainerBlock extends AbstractItemVaultBlock<BasicShippingContainerBlockEntity> {
    public BasicShippingContainerBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected BasicShippingContainerBlockEntity getAsBE(BlockEntity blockEntity) {
        return blockEntity instanceof BasicShippingContainerBlockEntity ? (BasicShippingContainerBlockEntity) blockEntity : null;
    }

    public static boolean sIsVault(BlockState state) {
        return AllBlocks.BASIC_SHIPPING_CONTAINER.has(state);
    }

    @Nullable
    public static Direction.Axis sGetVaultBlockAxis(BlockState state) {
        return !sIsVault(state) ? null : state.getValue(HORIZONTAL_AXIS);
    }

    public static boolean sIsLarge(BlockState state) {
        return sIsVault(state) && state.getValue(LARGE);
    }

    public static BlockEntityType<BasicShippingContainerBlockEntity> sGetBlockEntityType() {
        return AllBlockEntityTypes.BASIC_SHIPPING_CONTAINER.get();
    }

    @Override
    public boolean isVault(BlockState state) {
        return sIsVault(state);
    }

    @Override
    public BlockEntityType<BasicShippingContainerBlockEntity> getBlockEntityType() {
        return sGetBlockEntityType();
    }

    @Override
    public Class<BasicShippingContainerBlockEntity> getBlockEntityClass() {
        return BasicShippingContainerBlockEntity.class;
    }

    @Override
    @Nullable
    public Block getVerticalVaultBlock() {
        return AllBlocks.VERTICAL_BASIC_SHIPPING_CONTAINER.get();
    }
}
