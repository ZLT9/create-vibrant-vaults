package net.zlt.create_vibrant_vaults.item.shipping_container.vertical;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_vibrant_vaults.block.entity.shipping_container.vertical.CyanVerticalShippingContainerBlockEntity;
import net.zlt.create_vibrant_vaults.block.shipping_container.vertical.CyanVerticalShippingContainerBlock;
import net.zlt.create_vibrant_vaults.item.AbstractVerticalItemVaultItem;
import org.jetbrains.annotations.ApiStatus;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class CyanVerticalShippingContainerItem extends AbstractVerticalItemVaultItem<CyanVerticalShippingContainerBlockEntity> {
    @ApiStatus.Internal
    public static boolean IS_PLACING_NBT = false;

    public CyanVerticalShippingContainerItem(Block block, Properties properties) {
        super(block, properties);
    }

    @Override
    protected void setIsPlacingNbt(boolean isPlacingNbt) {
        IS_PLACING_NBT = isPlacingNbt;
    }

    @Override
    protected boolean isVault(BlockState state) {
        return CyanVerticalShippingContainerBlock.sIsVault(state);
    }

    @Override
    protected BlockEntityType<CyanVerticalShippingContainerBlockEntity> getBlockEntityType() {
        return CyanVerticalShippingContainerBlock.sGetBlockEntityType();
    }

    @Override
    protected Direction.Axis getVaultBlockAxis(BlockState state) {
        return CyanVerticalShippingContainerBlock.sGetVaultBlockAxis(state);
    }
}
