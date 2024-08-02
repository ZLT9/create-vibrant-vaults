package net.zlt.create_vibrant_vaults.item.shipping_container.vertical;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_vibrant_vaults.block.entity.shipping_container.vertical.LightGrayVerticalShippingContainerBlockEntity;
import net.zlt.create_vibrant_vaults.block.shipping_container.vertical.LightGrayVerticalShippingContainerBlock;
import net.zlt.create_vibrant_vaults.item.AbstractVerticalItemVaultItem;
import org.jetbrains.annotations.ApiStatus;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class LightGrayVerticalShippingContainerItem extends AbstractVerticalItemVaultItem<LightGrayVerticalShippingContainerBlockEntity> {
    @ApiStatus.Internal
    public static boolean IS_PLACING_NBT = false;

    public LightGrayVerticalShippingContainerItem(Block block, Properties properties) {
        super(block, properties);
    }

    @Override
    protected void setIsPlacingNbt(boolean isPlacingNbt) {
        IS_PLACING_NBT = isPlacingNbt;
    }

    @Override
    protected boolean isVault(BlockState state) {
        return LightGrayVerticalShippingContainerBlock.sIsVault(state);
    }

    @Override
    protected BlockEntityType<LightGrayVerticalShippingContainerBlockEntity> getBlockEntityType() {
        return LightGrayVerticalShippingContainerBlock.sGetBlockEntityType();
    }

    @Override
    protected Direction.Axis getVaultBlockAxis(BlockState state) {
        return LightGrayVerticalShippingContainerBlock.sGetVaultBlockAxis(state);
    }
}
