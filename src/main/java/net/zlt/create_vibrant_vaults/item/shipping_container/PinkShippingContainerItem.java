package net.zlt.create_vibrant_vaults.item.shipping_container;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_vibrant_vaults.block.entity.shipping_container.PinkShippingContainerBlockEntity;
import net.zlt.create_vibrant_vaults.block.shipping_container.PinkShippingContainerBlock;
import net.zlt.create_vibrant_vaults.item.AbstractItemVaultItem;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class PinkShippingContainerItem extends AbstractItemVaultItem<PinkShippingContainerBlockEntity> {
    public PinkShippingContainerItem(Block block, Properties properties) {
        super(block, properties);
    }

    @Override
    protected boolean isVault(BlockState state) {
        return PinkShippingContainerBlock.sIsVault(state);
    }

    @Override
    protected BlockEntityType<PinkShippingContainerBlockEntity> getBlockEntityType() {
        return PinkShippingContainerBlock.sGetBlockEntityType();
    }

    @Override
    protected Direction.Axis getVaultBlockAxis(BlockState state) {
        return PinkShippingContainerBlock.sGetVaultBlockAxis(state);
    }
}
