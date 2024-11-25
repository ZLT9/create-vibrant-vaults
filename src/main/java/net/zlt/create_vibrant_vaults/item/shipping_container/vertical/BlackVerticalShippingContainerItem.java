package net.zlt.create_vibrant_vaults.item.shipping_container.vertical;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_vibrant_vaults.block.entity.shipping_container.vertical.BlackVerticalShippingContainerBlockEntity;
import net.zlt.create_vibrant_vaults.block.shipping_container.vertical.BlackVerticalShippingContainerBlock;
import net.zlt.create_vibrant_vaults.item.AbstractVerticalItemVaultItem;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class BlackVerticalShippingContainerItem extends AbstractVerticalItemVaultItem<BlackVerticalShippingContainerBlockEntity> {
    public BlackVerticalShippingContainerItem(Block block, Properties properties) {
        super(block, properties);
    }

    @Override
    protected boolean isVault(BlockState state) {
        return BlackVerticalShippingContainerBlock.sIsVault(state);
    }

    @Override
    protected BlockEntityType<BlackVerticalShippingContainerBlockEntity> getBlockEntityType() {
        return BlackVerticalShippingContainerBlock.sGetBlockEntityType();
    }

    @Override
    protected Direction.Axis getVaultBlockAxis(BlockState state) {
        return BlackVerticalShippingContainerBlock.sGetVaultBlockAxis(state);
    }
}
