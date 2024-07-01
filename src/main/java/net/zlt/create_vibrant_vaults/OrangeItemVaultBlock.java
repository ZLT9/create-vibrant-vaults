package net.zlt.create_vibrant_vaults;

import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class OrangeItemVaultBlock extends AbstractItemVaultBlock<OrangeItemVaultBlockEntity> {
    public OrangeItemVaultBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected boolean isPlacingNbt() {
        return OrangeItemVaultItem.IS_PLACING_NBT;
    }

    @Override
    protected OrangeItemVaultBlockEntity getAsBE(BlockEntity blockEntity) {
        return blockEntity instanceof OrangeItemVaultBlockEntity ? (OrangeItemVaultBlockEntity) blockEntity : null;
    }

    public static boolean sIsVault(BlockState state) {
        return AllBlocks.ORANGE_ITEM_VAULT.has(state);
    }

    public static Direction.Axis sGetVaultBlockAxis(BlockState state) {
        return !sIsVault(state) ? null : state.getValue(HORIZONTAL_AXIS);
    }

    public static boolean sIsLarge(BlockState state) {
        return sIsVault(state) && state.getValue(LARGE);
    }

    public static BlockEntityType<OrangeItemVaultBlockEntity> sGetBlockEntityType() {
        return AllBlockEntityTypes.ORANGE_ITEM_VAULT.get();
    }

    @Override
    public boolean isVault(BlockState state) {
        return sIsVault(state);
    }

    @Override
    public BlockEntityType<OrangeItemVaultBlockEntity> getBlockEntityType() {
        return sGetBlockEntityType();
    }

    @Override
    public Class<OrangeItemVaultBlockEntity> getBlockEntityClass() {
        return OrangeItemVaultBlockEntity.class;
    }
}
