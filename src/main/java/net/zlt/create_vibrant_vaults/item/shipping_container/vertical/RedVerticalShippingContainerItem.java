package net.zlt.create_vibrant_vaults.item.shipping_container.vertical;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_vibrant_vaults.block.entity.shipping_container.vertical.RedVerticalShippingContainerBlockEntity;
import net.zlt.create_vibrant_vaults.block.shipping_container.vertical.RedVerticalShippingContainerBlock;
import net.zlt.create_vibrant_vaults.item.AbstractVerticalItemVaultItem;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class RedVerticalShippingContainerItem extends AbstractVerticalItemVaultItem<RedVerticalShippingContainerBlockEntity> {
    public RedVerticalShippingContainerItem(Block block, Properties properties) {
        super(block, properties);
    }

    @Override
    protected boolean isVault(BlockState state) {
        return RedVerticalShippingContainerBlock.sIsVault(state);
    }

    @Override
    protected BlockEntityType<RedVerticalShippingContainerBlockEntity> getBlockEntityType() {
        return RedVerticalShippingContainerBlock.sGetBlockEntityType();
    }

    @Override
    protected Direction.Axis getVaultBlockAxis(BlockState state) {
        return RedVerticalShippingContainerBlock.sGetVaultBlockAxis(state);
    }
}
