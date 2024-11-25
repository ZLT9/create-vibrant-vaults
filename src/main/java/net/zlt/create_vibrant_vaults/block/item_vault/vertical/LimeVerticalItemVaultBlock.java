package net.zlt.create_vibrant_vaults.block.item_vault.vertical;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_vibrant_vaults.block.AbstractVerticalItemVaultBlock;
import net.zlt.create_vibrant_vaults.block.AllBlocks;
import net.zlt.create_vibrant_vaults.block.entity.AllBlockEntityTypes;
import net.zlt.create_vibrant_vaults.block.entity.item_vault.vertical.LimeVerticalItemVaultBlockEntity;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class LimeVerticalItemVaultBlock extends AbstractVerticalItemVaultBlock<LimeVerticalItemVaultBlockEntity> {
    public LimeVerticalItemVaultBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected LimeVerticalItemVaultBlockEntity getAsBE(BlockEntity blockEntity) {
        return blockEntity instanceof LimeVerticalItemVaultBlockEntity ? (LimeVerticalItemVaultBlockEntity) blockEntity : null;
    }

    public static boolean sIsVault(BlockState state) {
        return AllBlocks.LIME_VERTICAL_ITEM_VAULT.has(state);
    }

    @Nullable
    public static Direction.Axis sGetVaultBlockAxis(BlockState state) {
        return !sIsVault(state) ? null : Direction.Axis.Y;
    }

    public static boolean sIsLarge(BlockState state) {
        return sIsVault(state) && state.getValue(LARGE);
    }

    public static BlockEntityType<LimeVerticalItemVaultBlockEntity> sGetBlockEntityType() {
        return AllBlockEntityTypes.LIME_VERTICAL_ITEM_VAULT.get();
    }

    @Override
    public boolean isVault(BlockState state) {
        return sIsVault(state);
    }

    @Override
    public BlockEntityType<LimeVerticalItemVaultBlockEntity> getBlockEntityType() {
        return sGetBlockEntityType();
    }

    @Override
    public Class<LimeVerticalItemVaultBlockEntity> getBlockEntityClass() {
        return LimeVerticalItemVaultBlockEntity.class;
    }

    @Override
    @Nullable
    public Block getHorizontalVaultBlock() {
        return AllBlocks.LIME_ITEM_VAULT.get();
    }
}
