package net.zlt.create_vibrant_vaults;

import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class PurpleItemVaultBlock extends AbstractItemVaultBlock<PurpleItemVaultBlockEntity> {
    public PurpleItemVaultBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected boolean isPlacingNbt() {
        return PurpleItemVaultItem.IS_PLACING_NBT;
    }

    @Override
    protected PurpleItemVaultBlockEntity getAsBE(BlockEntity blockEntity) {
        return blockEntity instanceof PurpleItemVaultBlockEntity ? (PurpleItemVaultBlockEntity) blockEntity : null;
    }

    public static boolean sIsVault(BlockState state) {
        return AllBlocks.PURPLE_ITEM_VAULT.has(state);
    }

    public static Direction.Axis sGetVaultBlockAxis(BlockState state) {
        return !sIsVault(state) ? null : state.getValue(HORIZONTAL_AXIS);
    }

    public static boolean sIsLarge(BlockState state) {
        return sIsVault(state) && state.getValue(LARGE);
    }

    public static BlockEntityType<PurpleItemVaultBlockEntity> sGetBlockEntityType() {
        return AllBlockEntityTypes.PURPLE_ITEM_VAULT.get();
    }

    @Override
    public boolean isVault(BlockState state) {
        return sIsVault(state);
    }

    @Override
    public BlockEntityType<PurpleItemVaultBlockEntity> getBlockEntityType() {
        return sGetBlockEntityType();
    }

    @Override
    public Class<PurpleItemVaultBlockEntity> getBlockEntityClass() {
        return PurpleItemVaultBlockEntity.class;
    }
}
