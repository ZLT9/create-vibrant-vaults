package net.zlt.create_vibrant_vaults;

import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class BrownItemVaultBlock extends AbstractItemVaultBlock<BrownItemVaultBlockEntity> {
    public BrownItemVaultBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected boolean isPlacingNbt() {
        return BrownItemVaultItem.IS_PLACING_NBT;
    }

    @Override
    protected BrownItemVaultBlockEntity getAsBE(BlockEntity blockEntity) {
        return blockEntity instanceof BrownItemVaultBlockEntity ? (BrownItemVaultBlockEntity) blockEntity : null;
    }

    public static boolean sIsVault(BlockState state) {
        return AllBlocks.BROWN_ITEM_VAULT.has(state);
    }

    public static Direction.Axis sGetVaultBlockAxis(BlockState state) {
        return !sIsVault(state) ? null : state.getValue(HORIZONTAL_AXIS);
    }

    public static boolean sIsLarge(BlockState state) {
        return sIsVault(state) && state.getValue(LARGE);
    }

    public static BlockEntityType<BrownItemVaultBlockEntity> sGetBlockEntityType() {
        return AllBlockEntityTypes.BROWN_ITEM_VAULT.get();
    }

    @Override
    public boolean isVault(BlockState state) {
        return sIsVault(state);
    }

    @Override
    public BlockEntityType<BrownItemVaultBlockEntity> getBlockEntityType() {
        return sGetBlockEntityType();
    }

    @Override
    public Class<BrownItemVaultBlockEntity> getBlockEntityClass() {
        return BrownItemVaultBlockEntity.class;
    }
}
