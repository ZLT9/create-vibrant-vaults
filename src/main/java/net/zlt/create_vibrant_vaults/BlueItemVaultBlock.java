package net.zlt.create_vibrant_vaults;

import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class BlueItemVaultBlock extends AbstractItemVaultBlock<BlueItemVaultBlockEntity> {
    public BlueItemVaultBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected boolean isPlacingNbt() {
        return BlueItemVaultItem.IS_PLACING_NBT;
    }

    @Override
    protected BlueItemVaultBlockEntity getAsBE(BlockEntity blockEntity) {
        return blockEntity instanceof BlueItemVaultBlockEntity ? (BlueItemVaultBlockEntity) blockEntity : null;
    }

    public static boolean sIsVault(BlockState state) {
        return AllBlocks.BLUE_ITEM_VAULT.has(state);
    }

    public static Direction.Axis sGetVaultBlockAxis(BlockState state) {
        return !sIsVault(state) ? null : state.getValue(HORIZONTAL_AXIS);
    }

    public static boolean sIsLarge(BlockState state) {
        return sIsVault(state) && state.getValue(LARGE);
    }

    public static BlockEntityType<BlueItemVaultBlockEntity> sGetBlockEntityType() {
        return AllBlockEntityTypes.BLUE_ITEM_VAULT.get();
    }

    @Override
    public boolean isVault(BlockState state) {
        return sIsVault(state);
    }

    @Override
    public BlockEntityType<BlueItemVaultBlockEntity> getBlockEntityType() {
        return sGetBlockEntityType();
    }

    @Override
    public Class<BlueItemVaultBlockEntity> getBlockEntityClass() {
        return BlueItemVaultBlockEntity.class;
    }
}
