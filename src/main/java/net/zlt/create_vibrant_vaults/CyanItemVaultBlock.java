package net.zlt.create_vibrant_vaults;

import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class CyanItemVaultBlock extends AbstractItemVaultBlock<CyanItemVaultBlockEntity> {
    public CyanItemVaultBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected boolean isPlacingNbt() {
        return CyanItemVaultItem.IS_PLACING_NBT;
    }

    @Override
    protected CyanItemVaultBlockEntity getAsBE(BlockEntity blockEntity) {
        return blockEntity instanceof CyanItemVaultBlockEntity ? (CyanItemVaultBlockEntity) blockEntity : null;
    }

    public static boolean sIsVault(BlockState state) {
        return AllBlocks.CYAN_ITEM_VAULT.has(state);
    }

    public static Direction.Axis sGetVaultBlockAxis(BlockState state) {
        return !sIsVault(state) ? null : state.getValue(HORIZONTAL_AXIS);
    }

    public static boolean sIsLarge(BlockState state) {
        return sIsVault(state) && state.getValue(LARGE);
    }

    public static BlockEntityType<CyanItemVaultBlockEntity> sGetBlockEntityType() {
        return AllBlockEntityTypes.CYAN_ITEM_VAULT.get();
    }

    @Override
    public boolean isVault(BlockState state) {
        return sIsVault(state);
    }

    @Override
    public BlockEntityType<CyanItemVaultBlockEntity> getBlockEntityType() {
        return sGetBlockEntityType();
    }

    @Override
    public Class<CyanItemVaultBlockEntity> getBlockEntityClass() {
        return CyanItemVaultBlockEntity.class;
    }
}
