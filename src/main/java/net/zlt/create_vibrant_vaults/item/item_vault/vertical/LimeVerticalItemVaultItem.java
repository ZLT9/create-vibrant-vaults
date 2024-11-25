package net.zlt.create_vibrant_vaults.item.item_vault.vertical;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_vibrant_vaults.block.entity.item_vault.vertical.LimeVerticalItemVaultBlockEntity;
import net.zlt.create_vibrant_vaults.block.item_vault.vertical.LimeVerticalItemVaultBlock;
import net.zlt.create_vibrant_vaults.item.AbstractVerticalItemVaultItem;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class LimeVerticalItemVaultItem extends AbstractVerticalItemVaultItem<LimeVerticalItemVaultBlockEntity> {
    public LimeVerticalItemVaultItem(Block block, Properties properties) {
        super(block, properties);
    }

    @Override
    protected boolean isVault(BlockState state) {
        return LimeVerticalItemVaultBlock.sIsVault(state);
    }

    @Override
    protected BlockEntityType<LimeVerticalItemVaultBlockEntity> getBlockEntityType() {
        return LimeVerticalItemVaultBlock.sGetBlockEntityType();
    }

    @Override
    protected Direction.Axis getVaultBlockAxis(BlockState state) {
        return LimeVerticalItemVaultBlock.sGetVaultBlockAxis(state);
    }
}
