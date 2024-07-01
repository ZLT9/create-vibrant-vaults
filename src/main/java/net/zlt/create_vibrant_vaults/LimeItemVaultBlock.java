package net.zlt.create_vibrant_vaults;

import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class LimeItemVaultBlock extends AbstractItemVaultBlock<LimeItemVaultBlockEntity> {
    public LimeItemVaultBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected boolean isPlacingNbt() {
        return LimeItemVaultItem.IS_PLACING_NBT;
    }

    @Override
    protected LimeItemVaultBlockEntity getAsBE(BlockEntity blockEntity) {
        return blockEntity instanceof LimeItemVaultBlockEntity ? (LimeItemVaultBlockEntity) blockEntity : null;
    }

    public static boolean sIsVault(BlockState state) {
        return AllBlocks.LIME_ITEM_VAULT.has(state);
    }

    public static Direction.Axis sGetVaultBlockAxis(BlockState state) {
        return !sIsVault(state) ? null : state.getValue(HORIZONTAL_AXIS);
    }

    public static boolean sIsLarge(BlockState state) {
        return sIsVault(state) && state.getValue(LARGE);
    }

    public static BlockEntityType<LimeItemVaultBlockEntity> sGetBlockEntityType() {
        return AllBlockEntityTypes.LIME_ITEM_VAULT.get();
    }

    @Override
    public boolean isVault(BlockState state) {
        return sIsVault(state);
    }

    @Override
    public BlockEntityType<LimeItemVaultBlockEntity> getBlockEntityType() {
        return sGetBlockEntityType();
    }

    @Override
    public Class<LimeItemVaultBlockEntity> getBlockEntityClass() {
        return LimeItemVaultBlockEntity.class;
    }
}
