package net.zlt.create_vibrant_vaults.item.item_vault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_vibrant_vaults.block.entity.item_vault.RedItemVaultBlockEntity;
import net.zlt.create_vibrant_vaults.block.item_vault.RedItemVaultBlock;
import net.zlt.create_vibrant_vaults.item.AbstractItemVaultItem;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class RedItemVaultItem extends AbstractItemVaultItem<RedItemVaultBlockEntity> {
    public RedItemVaultItem(Block block, Properties properties) {
        super(block, properties);
    }

    @Override
    protected boolean isVault(BlockState state) {
        return RedItemVaultBlock.sIsVault(state);
    }

    @Override
    protected BlockEntityType<RedItemVaultBlockEntity> getBlockEntityType() {
        return RedItemVaultBlock.sGetBlockEntityType();
    }

    @Override
    @Nullable
    protected Direction.Axis getVaultBlockAxis(BlockState state) {
        return RedItemVaultBlock.sGetVaultBlockAxis(state);
    }
}
