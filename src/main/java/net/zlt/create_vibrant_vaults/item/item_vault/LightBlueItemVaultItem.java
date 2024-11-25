package net.zlt.create_vibrant_vaults.item.item_vault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_vibrant_vaults.block.entity.item_vault.LightBlueItemVaultBlockEntity;
import net.zlt.create_vibrant_vaults.block.item_vault.LightBlueItemVaultBlock;
import net.zlt.create_vibrant_vaults.item.AbstractItemVaultItem;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class LightBlueItemVaultItem extends AbstractItemVaultItem<LightBlueItemVaultBlockEntity> {
    public LightBlueItemVaultItem(Block block, Properties properties) {
        super(block, properties);
    }

    @Override
    protected boolean isVault(BlockState state) {
        return LightBlueItemVaultBlock.sIsVault(state);
    }

    @Override
    protected BlockEntityType<LightBlueItemVaultBlockEntity> getBlockEntityType() {
        return LightBlueItemVaultBlock.sGetBlockEntityType();
    }

    @Override
    protected Direction.Axis getVaultBlockAxis(BlockState state) {
        return LightBlueItemVaultBlock.sGetVaultBlockAxis(state);
    }
}
