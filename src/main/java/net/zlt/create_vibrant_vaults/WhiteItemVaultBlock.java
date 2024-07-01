package net.zlt.create_vibrant_vaults;

import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class WhiteItemVaultBlock extends AbstractItemVaultBlock<WhiteItemVaultBlockEntity> {
    public WhiteItemVaultBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected boolean isPlacingNbt() {
        return WhiteItemVaultItem.IS_PLACING_NBT;
    }

    @Override
    protected WhiteItemVaultBlockEntity getAsBE(BlockEntity blockEntity) {
        return blockEntity instanceof WhiteItemVaultBlockEntity ? (WhiteItemVaultBlockEntity) blockEntity : null;
    }

    public static boolean sIsVault(BlockState state) {
        return AllBlocks.WHITE_ITEM_VAULT.has(state);
    }

    public static Direction.Axis sGetVaultBlockAxis(BlockState state) {
        return !sIsVault(state) ? null : state.getValue(HORIZONTAL_AXIS);
    }

    public static boolean sIsLarge(BlockState state) {
        return sIsVault(state) && state.getValue(LARGE);
    }

    public static BlockEntityType<WhiteItemVaultBlockEntity> sGetBlockEntityType() {
        return AllBlockEntityTypes.WHITE_ITEM_VAULT.get();
    }

    @Override
    public boolean isVault(BlockState state) {
        return sIsVault(state);
    }

    @Override
    public BlockEntityType<WhiteItemVaultBlockEntity> getBlockEntityType() {
        return sGetBlockEntityType();
    }

    @Override
    public Class<WhiteItemVaultBlockEntity> getBlockEntityClass() {
        return WhiteItemVaultBlockEntity.class;
    }
}
