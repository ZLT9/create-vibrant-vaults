package net.zlt.create_vibrant_vaults;

import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class GrayItemVaultBlock extends AbstractItemVaultBlock<GrayItemVaultBlockEntity> {
    public GrayItemVaultBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected boolean isPlacingNbt() {
        return GrayItemVaultItem.IS_PLACING_NBT;
    }

    @Override
    protected GrayItemVaultBlockEntity getAsBE(BlockEntity blockEntity) {
        return blockEntity instanceof GrayItemVaultBlockEntity ? (GrayItemVaultBlockEntity) blockEntity : null;
    }

    public static boolean sIsVault(BlockState state) {
        return AllBlocks.GRAY_ITEM_VAULT.has(state);
    }

    public static Direction.Axis sGetVaultBlockAxis(BlockState state) {
        return !sIsVault(state) ? null : state.getValue(HORIZONTAL_AXIS);
    }

    public static boolean sIsLarge(BlockState state) {
        return sIsVault(state) && state.getValue(LARGE);
    }

    public static BlockEntityType<GrayItemVaultBlockEntity> sGetBlockEntityType() {
        return AllBlockEntityTypes.GRAY_ITEM_VAULT.get();
    }

    @Override
    public boolean isVault(BlockState state) {
        return sIsVault(state);
    }

    @Override
    public BlockEntityType<GrayItemVaultBlockEntity> getBlockEntityType() {
        return sGetBlockEntityType();
    }

    @Override
    public Class<GrayItemVaultBlockEntity> getBlockEntityClass() {
        return GrayItemVaultBlockEntity.class;
    }
}
