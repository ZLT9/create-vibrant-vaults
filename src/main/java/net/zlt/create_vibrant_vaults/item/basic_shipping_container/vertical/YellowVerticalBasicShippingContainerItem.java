package net.zlt.create_vibrant_vaults.item.basic_shipping_container.vertical;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_vibrant_vaults.block.basic_shipping_container.vertical.YellowVerticalBasicShippingContainerBlock;
import net.zlt.create_vibrant_vaults.block.entity.basic_shipping_container.vertical.YellowVerticalBasicShippingContainerBlockEntity;
import net.zlt.create_vibrant_vaults.item.AbstractVerticalItemVaultItem;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class YellowVerticalBasicShippingContainerItem extends AbstractVerticalItemVaultItem<YellowVerticalBasicShippingContainerBlockEntity> {
    public YellowVerticalBasicShippingContainerItem(Block block, Properties properties) {
        super(block, properties);
    }

    @Override
    protected boolean isVault(BlockState state) {
        return YellowVerticalBasicShippingContainerBlock.sIsVault(state);
    }

    @Override
    protected BlockEntityType<YellowVerticalBasicShippingContainerBlockEntity> getBlockEntityType() {
        return YellowVerticalBasicShippingContainerBlock.sGetBlockEntityType();
    }

    @Override
    protected Direction.Axis getVaultBlockAxis(BlockState state) {
        return YellowVerticalBasicShippingContainerBlock.sGetVaultBlockAxis(state);
    }
}
