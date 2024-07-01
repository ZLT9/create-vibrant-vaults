package net.zlt.create_vibrant_vaults;

import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class LightBlueItemVaultBlock extends AbstractItemVaultBlock<LightBlueItemVaultBlockEntity> {
    public LightBlueItemVaultBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected boolean isPlacingNbt() {
        return LightBlueItemVaultItem.IS_PLACING_NBT;
    }

    @Override
    protected LightBlueItemVaultBlockEntity getAsBE(BlockEntity blockEntity) {
        return blockEntity instanceof LightBlueItemVaultBlockEntity ? (LightBlueItemVaultBlockEntity) blockEntity : null;
    }

    public static boolean sIsVault(BlockState state) {
        return AllBlocks.LIGHT_BLUE_ITEM_VAULT.has(state);
    }

    public static Direction.Axis sGetVaultBlockAxis(BlockState state) {
        return !sIsVault(state) ? null : state.getValue(HORIZONTAL_AXIS);
    }

    public static boolean sIsLarge(BlockState state) {
        return sIsVault(state) && state.getValue(LARGE);
    }

    public static BlockEntityType<LightBlueItemVaultBlockEntity> sGetBlockEntityType() {
        return AllBlockEntityTypes.LIGHT_BLUE_ITEM_VAULT.get();
    }

    @Override
    public boolean isVault(BlockState state) {
        return sIsVault(state);
    }

    @Override
    public BlockEntityType<LightBlueItemVaultBlockEntity> getBlockEntityType() {
        return sGetBlockEntityType();
    }

    @Override
    public Class<LightBlueItemVaultBlockEntity> getBlockEntityClass() {
        return LightBlueItemVaultBlockEntity.class;
    }
}
