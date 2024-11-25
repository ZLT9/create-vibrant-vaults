package net.zlt.create_vibrant_vaults.block.basic_shipping_container.vertical;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_vibrant_vaults.block.AbstractVerticalItemVaultBlock;
import net.zlt.create_vibrant_vaults.block.AllBlocks;
import net.zlt.create_vibrant_vaults.block.entity.AllBlockEntityTypes;
import net.zlt.create_vibrant_vaults.block.entity.basic_shipping_container.vertical.MagentaVerticalBasicShippingContainerBlockEntity;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class MagentaVerticalBasicShippingContainerBlock extends AbstractVerticalItemVaultBlock<MagentaVerticalBasicShippingContainerBlockEntity> {
    public MagentaVerticalBasicShippingContainerBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected MagentaVerticalBasicShippingContainerBlockEntity getAsBE(BlockEntity blockEntity) {
        return blockEntity instanceof MagentaVerticalBasicShippingContainerBlockEntity ? (MagentaVerticalBasicShippingContainerBlockEntity) blockEntity : null;
    }

    public static boolean sIsVault(BlockState state) {
        return AllBlocks.MAGENTA_VERTICAL_BASIC_SHIPPING_CONTAINER.has(state);
    }

    @Nullable
    public static Direction.Axis sGetVaultBlockAxis(BlockState state) {
        return !sIsVault(state) ? null : Direction.Axis.Y;
    }

    public static boolean sIsLarge(BlockState state) {
        return sIsVault(state) && state.getValue(LARGE);
    }

    public static BlockEntityType<MagentaVerticalBasicShippingContainerBlockEntity> sGetBlockEntityType() {
        return AllBlockEntityTypes.MAGENTA_VERTICAL_BASIC_SHIPPING_CONTAINER.get();
    }

    @Override
    public boolean isVault(BlockState state) {
        return sIsVault(state);
    }

    @Override
    public BlockEntityType<MagentaVerticalBasicShippingContainerBlockEntity> getBlockEntityType() {
        return sGetBlockEntityType();
    }

    @Override
    public Class<MagentaVerticalBasicShippingContainerBlockEntity> getBlockEntityClass() {
        return MagentaVerticalBasicShippingContainerBlockEntity.class;
    }

    @Override
    @Nullable
    public Block getHorizontalVaultBlock() {
        return AllBlocks.MAGENTA_BASIC_SHIPPING_CONTAINER.get();
    }
}
