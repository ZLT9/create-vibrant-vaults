package net.zlt.create_vibrant_vaults.item.shipping_container;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_vibrant_vaults.block.entity.shipping_container.PurpleShippingContainerBlockEntity;
import net.zlt.create_vibrant_vaults.block.shipping_container.PurpleShippingContainerBlock;
import net.zlt.create_vibrant_vaults.item.AbstractItemVaultItem;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class PurpleShippingContainerItem extends AbstractItemVaultItem<PurpleShippingContainerBlockEntity> {
    public PurpleShippingContainerItem(Block block, Properties properties) {
        super(block, properties);
    }

    @Override
    protected boolean isVault(BlockState state) {
        return PurpleShippingContainerBlock.sIsVault(state);
    }

    @Override
    protected BlockEntityType<PurpleShippingContainerBlockEntity> getBlockEntityType() {
        return PurpleShippingContainerBlock.sGetBlockEntityType();
    }

    @Override
    protected Direction.Axis getVaultBlockAxis(BlockState state) {
        return PurpleShippingContainerBlock.sGetVaultBlockAxis(state);
    }
}
