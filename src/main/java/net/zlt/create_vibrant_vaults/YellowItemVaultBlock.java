package net.zlt.create_vibrant_vaults;

import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class YellowItemVaultBlock extends AbstractItemVaultBlock<YellowItemVaultBlockEntity> {
    public YellowItemVaultBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected boolean isPlacingNbt() {
        return YellowItemVaultItem.IS_PLACING_NBT;
    }

    @Override
    protected YellowItemVaultBlockEntity getAsBE(BlockEntity blockEntity) {
        return blockEntity instanceof YellowItemVaultBlockEntity ? (YellowItemVaultBlockEntity) blockEntity : null;
    }

    public static boolean sIsVault(BlockState state) {
        return AllBlocks.YELLOW_ITEM_VAULT.has(state);
    }

    public static Direction.Axis sGetVaultBlockAxis(BlockState state) {
        return !sIsVault(state) ? null : state.getValue(HORIZONTAL_AXIS);
    }

    public static boolean sIsLarge(BlockState state) {
        return sIsVault(state) && state.getValue(LARGE);
    }

    public static BlockEntityType<YellowItemVaultBlockEntity> sGetBlockEntityType() {
        return AllBlockEntityTypes.YELLOW_ITEM_VAULT.get();
    }

    @Override
    public boolean isVault(BlockState state) {
        return sIsVault(state);
    }

    @Override
    public BlockEntityType<YellowItemVaultBlockEntity> getBlockEntityType() {
        return sGetBlockEntityType();
    }

    @Override
    public Class<YellowItemVaultBlockEntity> getBlockEntityClass() {
        return YellowItemVaultBlockEntity.class;
    }
}
