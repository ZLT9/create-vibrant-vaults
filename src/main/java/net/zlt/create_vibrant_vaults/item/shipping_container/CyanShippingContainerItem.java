package net.zlt.create_vibrant_vaults.item.shipping_container;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_vibrant_vaults.block.entity.shipping_container.CyanShippingContainerBlockEntity;
import net.zlt.create_vibrant_vaults.block.shipping_container.CyanShippingContainerBlock;
import net.zlt.create_vibrant_vaults.item.AbstractItemVaultItem;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class CyanShippingContainerItem extends AbstractItemVaultItem<CyanShippingContainerBlockEntity> {
    public CyanShippingContainerItem(Block block, Properties properties) {
        super(block, properties);
    }

    @Override
    protected boolean isVault(BlockState state) {
        return CyanShippingContainerBlock.sIsVault(state);
    }

    @Override
    protected BlockEntityType<CyanShippingContainerBlockEntity> getBlockEntityType() {
        return CyanShippingContainerBlock.sGetBlockEntityType();
    }

    @Override
    protected Direction.Axis getVaultBlockAxis(BlockState state) {
        return CyanShippingContainerBlock.sGetVaultBlockAxis(state);
    }
}
