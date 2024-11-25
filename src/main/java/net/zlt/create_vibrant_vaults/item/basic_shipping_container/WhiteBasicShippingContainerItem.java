package net.zlt.create_vibrant_vaults.item.basic_shipping_container;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_vibrant_vaults.block.basic_shipping_container.WhiteBasicShippingContainerBlock;
import net.zlt.create_vibrant_vaults.block.entity.basic_shipping_container.WhiteBasicShippingContainerBlockEntity;
import net.zlt.create_vibrant_vaults.item.AbstractItemVaultItem;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class WhiteBasicShippingContainerItem extends AbstractItemVaultItem<WhiteBasicShippingContainerBlockEntity> {
    public WhiteBasicShippingContainerItem(Block block, Properties properties) {
        super(block, properties);
    }

    @Override
    protected boolean isVault(BlockState state) {
        return WhiteBasicShippingContainerBlock.sIsVault(state);
    }

    @Override
    protected BlockEntityType<WhiteBasicShippingContainerBlockEntity> getBlockEntityType() {
        return WhiteBasicShippingContainerBlock.sGetBlockEntityType();
    }

    @Override
    protected Direction.Axis getVaultBlockAxis(BlockState state) {
        return WhiteBasicShippingContainerBlock.sGetVaultBlockAxis(state);
    }
}
