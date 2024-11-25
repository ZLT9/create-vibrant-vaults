package net.zlt.create_vibrant_vaults.item.shipping_container;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_vibrant_vaults.block.entity.shipping_container.LightBlueShippingContainerBlockEntity;
import net.zlt.create_vibrant_vaults.block.shipping_container.LightBlueShippingContainerBlock;
import net.zlt.create_vibrant_vaults.item.AbstractItemVaultItem;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class LightBlueShippingContainerItem extends AbstractItemVaultItem<LightBlueShippingContainerBlockEntity> {
    public LightBlueShippingContainerItem(Block block, Properties properties) {
        super(block, properties);
    }

    @Override
    protected boolean isVault(BlockState state) {
        return LightBlueShippingContainerBlock.sIsVault(state);
    }

    @Override
    protected BlockEntityType<LightBlueShippingContainerBlockEntity> getBlockEntityType() {
        return LightBlueShippingContainerBlock.sGetBlockEntityType();
    }

    @Override
    protected Direction.Axis getVaultBlockAxis(BlockState state) {
        return LightBlueShippingContainerBlock.sGetVaultBlockAxis(state);
    }
}
