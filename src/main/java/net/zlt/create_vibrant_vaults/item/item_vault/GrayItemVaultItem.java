package net.zlt.create_vibrant_vaults.item.item_vault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_vibrant_vaults.block.entity.item_vault.GrayItemVaultBlockEntity;
import net.zlt.create_vibrant_vaults.block.item_vault.GrayItemVaultBlock;
import net.zlt.create_vibrant_vaults.item.AbstractItemVaultItem;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class GrayItemVaultItem extends AbstractItemVaultItem<GrayItemVaultBlockEntity> {
    public GrayItemVaultItem(Block block, Properties properties) {
        super(block, properties);
    }

    @Override
    protected boolean isVault(BlockState state) {
        return GrayItemVaultBlock.sIsVault(state);
    }

    @Override
    protected BlockEntityType<GrayItemVaultBlockEntity> getBlockEntityType() {
        return GrayItemVaultBlock.sGetBlockEntityType();
    }

    @Override
    protected Direction.Axis getVaultBlockAxis(BlockState state) {
        return GrayItemVaultBlock.sGetVaultBlockAxis(state);
    }
}
