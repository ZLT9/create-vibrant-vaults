package net.zlt.create_vibrant_vaults;

import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class RedItemVaultBlock extends AbstractItemVaultBlock<RedItemVaultBlockEntity> {
    public RedItemVaultBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected boolean isPlacingNbt() {
        return RedItemVaultItem.IS_PLACING_NBT;
    }

    @Override
    protected RedItemVaultBlockEntity getAsBE(BlockEntity blockEntity) {
        return blockEntity instanceof RedItemVaultBlockEntity ? (RedItemVaultBlockEntity) blockEntity : null;
    }

    public static boolean sIsVault(BlockState state) {
        return AllBlocks.RED_ITEM_VAULT.has(state);
    }

    public static Direction.Axis sGetVaultBlockAxis(BlockState state) {
        return !sIsVault(state) ? null : state.getValue(HORIZONTAL_AXIS);
    }

    public static boolean sIsLarge(BlockState state) {
        return sIsVault(state) && state.getValue(LARGE);
    }

    public static BlockEntityType<RedItemVaultBlockEntity> sGetBlockEntityType() {
        return AllBlockEntityTypes.RED_ITEM_VAULT.get();
    }

    @Override
    public boolean isVault(BlockState state) {
        return sIsVault(state);
    }

    @Override
    public BlockEntityType<RedItemVaultBlockEntity> getBlockEntityType() {
        return sGetBlockEntityType();
    }

    @Override
    public Class<RedItemVaultBlockEntity> getBlockEntityClass() {
        return RedItemVaultBlockEntity.class;
    }
}
