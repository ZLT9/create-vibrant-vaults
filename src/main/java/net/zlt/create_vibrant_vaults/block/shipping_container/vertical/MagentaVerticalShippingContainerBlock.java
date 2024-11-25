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
import net.zlt.create_vibrant_vaults.block.entity.shipping_container.vertical.MagentaVerticalShippingContainerBlockEntity;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class MagentaVerticalShippingContainerBlock extends AbstractVerticalItemVaultBlock<MagentaVerticalShippingContainerBlockEntity> {
    public MagentaVerticalShippingContainerBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected MagentaVerticalShippingContainerBlockEntity getAsBE(BlockEntity blockEntity) {
        return blockEntity instanceof MagentaVerticalShippingContainerBlockEntity ? (MagentaVerticalShippingContainerBlockEntity) blockEntity : null;
    }

    public static boolean sIsVault(BlockState state) {
        return AllBlocks.MAGENTA_VERTICAL_SHIPPING_CONTAINER.has(state);
    }

    @Nullable
    public static Direction.Axis sGetVaultBlockAxis(BlockState state) {
        return !sIsVault(state) ? null : Direction.Axis.Y;
    }

    public static boolean sIsLarge(BlockState state) {
        return sIsVault(state) && state.getValue(LARGE);
    }

    public static BlockEntityType<MagentaVerticalShippingContainerBlockEntity> sGetBlockEntityType() {
        return AllBlockEntityTypes.MAGENTA_VERTICAL_SHIPPING_CONTAINER.get();
    }

    @Override
    public boolean isVault(BlockState state) {
        return sIsVault(state);
    }

    @Override
    public BlockEntityType<MagentaVerticalShippingContainerBlockEntity> getBlockEntityType() {
        return sGetBlockEntityType();
    }

    @Override
    public Class<MagentaVerticalShippingContainerBlockEntity> getBlockEntityClass() {
        return MagentaVerticalShippingContainerBlockEntity.class;
    }

    @Override
    @Nullable
    public Block getHorizontalVaultBlock() {
        return AllBlocks.MAGENTA_SHIPPING_CONTAINER.get();
    }
}
