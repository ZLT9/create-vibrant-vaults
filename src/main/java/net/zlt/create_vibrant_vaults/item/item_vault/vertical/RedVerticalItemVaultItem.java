package net.zlt.create_vibrant_vaults.item.item_vault.vertical;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_vibrant_vaults.block.entity.item_vault.vertical.RedVerticalItemVaultBlockEntity;
import net.zlt.create_vibrant_vaults.block.item_vault.vertical.RedVerticalItemVaultBlock;
import net.zlt.create_vibrant_vaults.item.AbstractVerticalItemVaultItem;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class RedVerticalItemVaultItem extends AbstractVerticalItemVaultItem<RedVerticalItemVaultBlockEntity> {
    public RedVerticalItemVaultItem(Block block, Properties properties) {
        super(block, properties);
    }

    @Override
    protected boolean isVault(BlockState state) {
        return RedVerticalItemVaultBlock.sIsVault(state);
    }

    @Override
    protected BlockEntityType<RedVerticalItemVaultBlockEntity> getBlockEntityType() {
        return RedVerticalItemVaultBlock.sGetBlockEntityType();
    }

    @Override
    protected Direction.Axis getVaultBlockAxis(BlockState state) {
        return RedVerticalItemVaultBlock.sGetVaultBlockAxis(state);
    }
}
