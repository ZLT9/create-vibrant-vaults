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
import net.zlt.create_vibrant_vaults.block.entity.item_vault.vertical.LightBlueVerticalItemVaultBlockEntity;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class LightBlueVerticalItemVaultBlock extends AbstractVerticalItemVaultBlock<LightBlueVerticalItemVaultBlockEntity> {
    public LightBlueVerticalItemVaultBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected LightBlueVerticalItemVaultBlockEntity getAsBE(BlockEntity blockEntity) {
        return blockEntity instanceof LightBlueVerticalItemVaultBlockEntity ? (LightBlueVerticalItemVaultBlockEntity) blockEntity : null;
    }

    public static boolean sIsVault(BlockState state) {
        return AllBlocks.LIGHT_BLUE_VERTICAL_ITEM_VAULT.has(state);
    }

    @Nullable
    public static Direction.Axis sGetVaultBlockAxis(BlockState state) {
        return !sIsVault(state) ? null : Direction.Axis.Y;
    }

    public static boolean sIsLarge(BlockState state) {
        return sIsVault(state) && state.getValue(LARGE);
    }

    public static BlockEntityType<LightBlueVerticalItemVaultBlockEntity> sGetBlockEntityType() {
        return AllBlockEntityTypes.LIGHT_BLUE_VERTICAL_ITEM_VAULT.get();
    }

    @Override
    public boolean isVault(BlockState state) {
        return sIsVault(state);
    }

    @Override
    public BlockEntityType<LightBlueVerticalItemVaultBlockEntity> getBlockEntityType() {
        return sGetBlockEntityType();
    }

    @Override
    public Class<LightBlueVerticalItemVaultBlockEntity> getBlockEntityClass() {
        return LightBlueVerticalItemVaultBlockEntity.class;
    }

    @Override
    @Nullable
    public Block getHorizontalVaultBlock() {
        return AllBlocks.LIGHT_BLUE_ITEM_VAULT.get();
    }
}
