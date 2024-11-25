package net.zlt.create_vibrant_vaults.item.shipping_container.vertical;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_vibrant_vaults.block.entity.shipping_container.vertical.LightBlueVerticalShippingContainerBlockEntity;
import net.zlt.create_vibrant_vaults.block.shipping_container.vertical.LightBlueVerticalShippingContainerBlock;
import net.zlt.create_vibrant_vaults.item.AbstractVerticalItemVaultItem;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class LightBlueVerticalShippingContainerItem extends AbstractVerticalItemVaultItem<LightBlueVerticalShippingContainerBlockEntity> {
    public LightBlueVerticalShippingContainerItem(Block block, Properties properties) {
        super(block, properties);
    }

    @Override
    protected boolean isVault(BlockState state) {
        return LightBlueVerticalShippingContainerBlock.sIsVault(state);
    }

    @Override
    protected BlockEntityType<LightBlueVerticalShippingContainerBlockEntity> getBlockEntityType() {
        return LightBlueVerticalShippingContainerBlock.sGetBlockEntityType();
    }

    @Override
    protected Direction.Axis getVaultBlockAxis(BlockState state) {
        return LightBlueVerticalShippingContainerBlock.sGetVaultBlockAxis(state);
    }
}
