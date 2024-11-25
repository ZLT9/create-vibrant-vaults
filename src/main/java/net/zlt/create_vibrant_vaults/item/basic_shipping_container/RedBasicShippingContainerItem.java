package net.zlt.create_vibrant_vaults.item.basic_shipping_container;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_vibrant_vaults.block.basic_shipping_container.RedBasicShippingContainerBlock;
import net.zlt.create_vibrant_vaults.block.entity.basic_shipping_container.RedBasicShippingContainerBlockEntity;
import net.zlt.create_vibrant_vaults.item.AbstractItemVaultItem;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class RedBasicShippingContainerItem extends AbstractItemVaultItem<RedBasicShippingContainerBlockEntity> {
    public RedBasicShippingContainerItem(Block block, Properties properties) {
        super(block, properties);
    }

    @Override
    protected boolean isVault(BlockState state) {
        return RedBasicShippingContainerBlock.sIsVault(state);
    }

    @Override
    protected BlockEntityType<RedBasicShippingContainerBlockEntity> getBlockEntityType() {
        return RedBasicShippingContainerBlock.sGetBlockEntityType();
    }

    @Override
    protected Direction.Axis getVaultBlockAxis(BlockState state) {
        return RedBasicShippingContainerBlock.sGetVaultBlockAxis(state);
    }
}
