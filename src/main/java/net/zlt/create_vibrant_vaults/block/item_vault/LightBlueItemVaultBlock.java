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
import net.zlt.create_vibrant_vaults.block.entity.item_vault.LightBlueItemVaultBlockEntity;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class LightBlueItemVaultBlock extends AbstractItemVaultBlock<LightBlueItemVaultBlockEntity> {
    public LightBlueItemVaultBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected LightBlueItemVaultBlockEntity getAsBE(BlockEntity blockEntity) {
        return blockEntity instanceof LightBlueItemVaultBlockEntity ? (LightBlueItemVaultBlockEntity) blockEntity : null;
    }

    public static boolean sIsVault(BlockState state) {
        return AllBlocks.LIGHT_BLUE_ITEM_VAULT.has(state);
    }

    @Nullable
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

    @Override
    @Nullable
    public Block getVerticalVaultBlock() {
        return AllBlocks.LIGHT_BLUE_VERTICAL_ITEM_VAULT.get();
    }
}
