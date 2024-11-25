package net.zlt.create_vibrant_vaults.item.item_vault.vertical;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_vibrant_vaults.block.entity.item_vault.vertical.LightBlueVerticalItemVaultBlockEntity;
import net.zlt.create_vibrant_vaults.block.item_vault.vertical.LightBlueVerticalItemVaultBlock;
import net.zlt.create_vibrant_vaults.item.AbstractVerticalItemVaultItem;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class LightBlueVerticalItemVaultItem extends AbstractVerticalItemVaultItem<LightBlueVerticalItemVaultBlockEntity> {
    public LightBlueVerticalItemVaultItem(Block block, Properties properties) {
        super(block, properties);
    }

    @Override
    protected boolean isVault(BlockState state) {
        return LightBlueVerticalItemVaultBlock.sIsVault(state);
    }

    @Override
    protected BlockEntityType<LightBlueVerticalItemVaultBlockEntity> getBlockEntityType() {
        return LightBlueVerticalItemVaultBlock.sGetBlockEntityType();
    }

    @Override
    protected Direction.Axis getVaultBlockAxis(BlockState state) {
        return LightBlueVerticalItemVaultBlock.sGetVaultBlockAxis(state);
    }
}
