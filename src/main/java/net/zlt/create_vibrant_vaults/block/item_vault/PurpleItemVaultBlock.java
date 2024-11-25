package net.zlt.create_vibrant_vaults.block.item_vault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_vibrant_vaults.block.AbstractItemVaultBlock;
import net.zlt.create_vibrant_vaults.block.AllBlocks;
import net.zlt.create_vibrant_vaults.block.entity.AllBlockEntityTypes;
import net.zlt.create_vibrant_vaults.block.entity.item_vault.PurpleItemVaultBlockEntity;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class PurpleItemVaultBlock extends AbstractItemVaultBlock<PurpleItemVaultBlockEntity> {
    public PurpleItemVaultBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected PurpleItemVaultBlockEntity getAsBE(BlockEntity blockEntity) {
        return blockEntity instanceof PurpleItemVaultBlockEntity ? (PurpleItemVaultBlockEntity) blockEntity : null;
    }

    public static boolean sIsVault(BlockState state) {
        return AllBlocks.PURPLE_ITEM_VAULT.has(state);
    }

    @Nullable
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

    @Override
    @Nullable
    public Block getVerticalVaultBlock() {
        return AllBlocks.PURPLE_VERTICAL_ITEM_VAULT.get();
    }
}
