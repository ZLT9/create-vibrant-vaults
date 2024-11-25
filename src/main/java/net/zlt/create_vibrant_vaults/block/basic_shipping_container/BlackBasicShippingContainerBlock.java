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
import net.zlt.create_vibrant_vaults.block.entity.basic_shipping_container.BlackBasicShippingContainerBlockEntity;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class BlackBasicShippingContainerBlock extends AbstractItemVaultBlock<BlackBasicShippingContainerBlockEntity> {
    public BlackBasicShippingContainerBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected BlackBasicShippingContainerBlockEntity getAsBE(BlockEntity blockEntity) {
        return blockEntity instanceof BlackBasicShippingContainerBlockEntity ? (BlackBasicShippingContainerBlockEntity) blockEntity : null;
    }

    public static boolean sIsVault(BlockState state) {
        return AllBlocks.BLACK_BASIC_SHIPPING_CONTAINER.has(state);
    }

    @Nullable
    public static Direction.Axis sGetVaultBlockAxis(BlockState state) {
        return !sIsVault(state) ? null : state.getValue(HORIZONTAL_AXIS);
    }

    public static boolean sIsLarge(BlockState state) {
        return sIsVault(state) && state.getValue(LARGE);
    }

    public static BlockEntityType<BlackBasicShippingContainerBlockEntity> sGetBlockEntityType() {
        return AllBlockEntityTypes.BLACK_BASIC_SHIPPING_CONTAINER.get();
    }

    @Override
    public boolean isVault(BlockState state) {
        return sIsVault(state);
    }

    @Override
    public BlockEntityType<BlackBasicShippingContainerBlockEntity> getBlockEntityType() {
        return sGetBlockEntityType();
    }

    @Override
    public Class<BlackBasicShippingContainerBlockEntity> getBlockEntityClass() {
        return BlackBasicShippingContainerBlockEntity.class;
    }

    @Override
    @Nullable
    public Block getVerticalVaultBlock() {
        return AllBlocks.BLACK_VERTICAL_BASIC_SHIPPING_CONTAINER.get();
    }
}
