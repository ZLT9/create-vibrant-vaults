package net.zlt.create_vibrant_vaults.item.shipping_container;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_vibrant_vaults.block.entity.shipping_container.YellowShippingContainerBlockEntity;
import net.zlt.create_vibrant_vaults.block.shipping_container.YellowShippingContainerBlock;
import net.zlt.create_vibrant_vaults.item.AbstractItemVaultItem;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class YellowShippingContainerItem extends AbstractItemVaultItem<YellowShippingContainerBlockEntity> {
    public YellowShippingContainerItem(Block block, Properties properties) {
        super(block, properties);
    }

    @Override
    protected boolean isVault(BlockState state) {
        return YellowShippingContainerBlock.sIsVault(state);
    }

    @Override
    protected BlockEntityType<YellowShippingContainerBlockEntity> getBlockEntityType() {
        return YellowShippingContainerBlock.sGetBlockEntityType();
    }

    @Override
    protected Direction.Axis getVaultBlockAxis(BlockState state) {
        return YellowShippingContainerBlock.sGetVaultBlockAxis(state);
    }
}
