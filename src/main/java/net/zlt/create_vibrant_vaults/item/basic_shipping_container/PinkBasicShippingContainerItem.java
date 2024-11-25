package net.zlt.create_vibrant_vaults.item.basic_shipping_container;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_vibrant_vaults.block.basic_shipping_container.PinkBasicShippingContainerBlock;
import net.zlt.create_vibrant_vaults.block.entity.basic_shipping_container.PinkBasicShippingContainerBlockEntity;
import net.zlt.create_vibrant_vaults.item.AbstractItemVaultItem;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class PinkBasicShippingContainerItem extends AbstractItemVaultItem<PinkBasicShippingContainerBlockEntity> {
    public PinkBasicShippingContainerItem(Block block, Properties properties) {
        super(block, properties);
    }

    @Override
    protected boolean isVault(BlockState state) {
        return PinkBasicShippingContainerBlock.sIsVault(state);
    }

    @Override
    protected BlockEntityType<PinkBasicShippingContainerBlockEntity> getBlockEntityType() {
        return PinkBasicShippingContainerBlock.sGetBlockEntityType();
    }

    @Override
    protected Direction.Axis getVaultBlockAxis(BlockState state) {
        return PinkBasicShippingContainerBlock.sGetVaultBlockAxis(state);
    }
}
