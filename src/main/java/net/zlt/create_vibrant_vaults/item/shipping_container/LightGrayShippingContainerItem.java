package net.zlt.create_vibrant_vaults.item.shipping_container;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_vibrant_vaults.block.entity.shipping_container.LightGrayShippingContainerBlockEntity;
import net.zlt.create_vibrant_vaults.block.shipping_container.LightGrayShippingContainerBlock;
import net.zlt.create_vibrant_vaults.item.AbstractItemVaultItem;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class LightGrayShippingContainerItem extends AbstractItemVaultItem<LightGrayShippingContainerBlockEntity> {
    public LightGrayShippingContainerItem(Block block, Properties properties) {
        super(block, properties);
    }

    @Override
    protected boolean isVault(BlockState state) {
        return LightGrayShippingContainerBlock.sIsVault(state);
    }

    @Override
    protected BlockEntityType<LightGrayShippingContainerBlockEntity> getBlockEntityType() {
        return LightGrayShippingContainerBlock.sGetBlockEntityType();
    }

    @Override
    protected Direction.Axis getVaultBlockAxis(BlockState state) {
        return LightGrayShippingContainerBlock.sGetVaultBlockAxis(state);
    }
}
