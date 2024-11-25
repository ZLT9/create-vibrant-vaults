package net.zlt.create_vibrant_vaults.item.item_vault.vertical;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_vibrant_vaults.block.entity.item_vault.vertical.WhiteVerticalItemVaultBlockEntity;
import net.zlt.create_vibrant_vaults.block.item_vault.vertical.WhiteVerticalItemVaultBlock;
import net.zlt.create_vibrant_vaults.item.AbstractVerticalItemVaultItem;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class WhiteVerticalItemVaultItem extends AbstractVerticalItemVaultItem<WhiteVerticalItemVaultBlockEntity> {
    public WhiteVerticalItemVaultItem(Block block, Properties properties) {
        super(block, properties);
    }

    @Override
    protected boolean isVault(BlockState state) {
        return WhiteVerticalItemVaultBlock.sIsVault(state);
    }

    @Override
    protected BlockEntityType<WhiteVerticalItemVaultBlockEntity> getBlockEntityType() {
        return WhiteVerticalItemVaultBlock.sGetBlockEntityType();
    }

    @Override
    protected Direction.Axis getVaultBlockAxis(BlockState state) {
        return WhiteVerticalItemVaultBlock.sGetVaultBlockAxis(state);
    }
}
