package net.zlt.create_vibrant_vaults.item.basic_shipping_container.vertical;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_vibrant_vaults.block.basic_shipping_container.vertical.RedVerticalBasicShippingContainerBlock;
import net.zlt.create_vibrant_vaults.block.entity.basic_shipping_container.vertical.RedVerticalBasicShippingContainerBlockEntity;
import net.zlt.create_vibrant_vaults.item.AbstractVerticalItemVaultItem;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class RedVerticalBasicShippingContainerItem extends AbstractVerticalItemVaultItem<RedVerticalBasicShippingContainerBlockEntity> {
    public RedVerticalBasicShippingContainerItem(Block block, Properties properties) {
        super(block, properties);
    }

    @Override
    protected boolean isVault(BlockState state) {
        return RedVerticalBasicShippingContainerBlock.sIsVault(state);
    }

    @Override
    protected BlockEntityType<RedVerticalBasicShippingContainerBlockEntity> getBlockEntityType() {
        return RedVerticalBasicShippingContainerBlock.sGetBlockEntityType();
    }

    @Override
    protected Direction.Axis getVaultBlockAxis(BlockState state) {
        return RedVerticalBasicShippingContainerBlock.sGetVaultBlockAxis(state);
    }
}
