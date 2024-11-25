package net.zlt.create_vibrant_vaults.item.item_vault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_vibrant_vaults.block.entity.item_vault.BrownItemVaultBlockEntity;
import net.zlt.create_vibrant_vaults.block.item_vault.BrownItemVaultBlock;
import net.zlt.create_vibrant_vaults.item.AbstractItemVaultItem;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class BrownItemVaultItem extends AbstractItemVaultItem<BrownItemVaultBlockEntity> {
    public BrownItemVaultItem(Block block, Properties properties) {
        super(block, properties);
    }

    @Override
    protected boolean isVault(BlockState state) {
        return BrownItemVaultBlock.sIsVault(state);
    }

    @Override
    protected BlockEntityType<BrownItemVaultBlockEntity> getBlockEntityType() {
        return BrownItemVaultBlock.sGetBlockEntityType();
    }

    @Override
    protected Direction.Axis getVaultBlockAxis(BlockState state) {
        return BrownItemVaultBlock.sGetVaultBlockAxis(state);
    }
}
