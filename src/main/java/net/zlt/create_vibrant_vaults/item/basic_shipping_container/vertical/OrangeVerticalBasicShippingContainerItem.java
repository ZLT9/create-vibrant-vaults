package net.zlt.create_vibrant_vaults.item.basic_shipping_container.vertical;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_vibrant_vaults.block.basic_shipping_container.vertical.OrangeVerticalBasicShippingContainerBlock;
import net.zlt.create_vibrant_vaults.block.entity.basic_shipping_container.vertical.OrangeVerticalBasicShippingContainerBlockEntity;
import net.zlt.create_vibrant_vaults.item.AbstractVerticalItemVaultItem;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class OrangeVerticalBasicShippingContainerItem extends AbstractVerticalItemVaultItem<OrangeVerticalBasicShippingContainerBlockEntity> {
    public OrangeVerticalBasicShippingContainerItem(Block block, Properties properties) {
        super(block, properties);
    }

    @Override
    protected boolean isVault(BlockState state) {
        return OrangeVerticalBasicShippingContainerBlock.sIsVault(state);
    }

    @Override
    protected BlockEntityType<OrangeVerticalBasicShippingContainerBlockEntity> getBlockEntityType() {
        return OrangeVerticalBasicShippingContainerBlock.sGetBlockEntityType();
    }

    @Override
    protected Direction.Axis getVaultBlockAxis(BlockState state) {
        return OrangeVerticalBasicShippingContainerBlock.sGetVaultBlockAxis(state);
    }
}
