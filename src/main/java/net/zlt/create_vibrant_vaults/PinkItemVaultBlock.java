package net.zlt.create_vibrant_vaults;

import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class PinkItemVaultBlock extends AbstractItemVaultBlock<PinkItemVaultBlockEntity> {
    public PinkItemVaultBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected boolean isPlacingNbt() {
        return PinkItemVaultItem.IS_PLACING_NBT;
    }

    @Override
    protected PinkItemVaultBlockEntity getAsBE(BlockEntity blockEntity) {
        return blockEntity instanceof PinkItemVaultBlockEntity ? (PinkItemVaultBlockEntity) blockEntity : null;
    }

    public static boolean sIsVault(BlockState state) {
        return AllBlocks.PINK_ITEM_VAULT.has(state);
    }

    public static Direction.Axis sGetVaultBlockAxis(BlockState state) {
        return !sIsVault(state) ? null : state.getValue(HORIZONTAL_AXIS);
    }

    public static boolean sIsLarge(BlockState state) {
        return sIsVault(state) && state.getValue(LARGE);
    }

    public static BlockEntityType<PinkItemVaultBlockEntity> sGetBlockEntityType() {
        return AllBlockEntityTypes.PINK_ITEM_VAULT.get();
    }

    @Override
    public boolean isVault(BlockState state) {
        return sIsVault(state);
    }

    @Override
    public BlockEntityType<PinkItemVaultBlockEntity> getBlockEntityType() {
        return sGetBlockEntityType();
    }

    @Override
    public Class<PinkItemVaultBlockEntity> getBlockEntityClass() {
        return PinkItemVaultBlockEntity.class;
    }
}
