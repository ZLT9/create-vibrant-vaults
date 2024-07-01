package net.zlt.create_vibrant_vaults;

import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class BlackItemVaultBlock extends AbstractItemVaultBlock<BlackItemVaultBlockEntity> {
    public BlackItemVaultBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected boolean isPlacingNbt() {
        return BlackItemVaultItem.IS_PLACING_NBT;
    }

    @Override
    protected BlackItemVaultBlockEntity getAsBE(BlockEntity blockEntity) {
        return blockEntity instanceof BlackItemVaultBlockEntity ? (BlackItemVaultBlockEntity) blockEntity : null;
    }

    public static boolean sIsVault(BlockState state) {
        return AllBlocks.BLACK_ITEM_VAULT.has(state);
    }

    public static Direction.Axis sGetVaultBlockAxis(BlockState state) {
        return !sIsVault(state) ? null : state.getValue(HORIZONTAL_AXIS);
    }

    public static boolean sIsLarge(BlockState state) {
        return sIsVault(state) && state.getValue(LARGE);
    }

    public static BlockEntityType<BlackItemVaultBlockEntity> sGetBlockEntityType() {
        return AllBlockEntityTypes.BLACK_ITEM_VAULT.get();
    }

    @Override
    public boolean isVault(BlockState state) {
        return sIsVault(state);
    }

    @Override
    public BlockEntityType<BlackItemVaultBlockEntity> getBlockEntityType() {
        return sGetBlockEntityType();
    }

    @Override
    public Class<BlackItemVaultBlockEntity> getBlockEntityClass() {
        return BlackItemVaultBlockEntity.class;
    }
}
