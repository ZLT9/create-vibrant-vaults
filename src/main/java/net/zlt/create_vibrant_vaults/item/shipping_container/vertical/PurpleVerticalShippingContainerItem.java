package net.zlt.create_vibrant_vaults.item.shipping_container.vertical;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_vibrant_vaults.block.entity.shipping_container.vertical.PurpleVerticalShippingContainerBlockEntity;
import net.zlt.create_vibrant_vaults.block.shipping_container.vertical.PurpleVerticalShippingContainerBlock;
import net.zlt.create_vibrant_vaults.item.AbstractVerticalItemVaultItem;
import org.jetbrains.annotations.ApiStatus;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class PurpleVerticalShippingContainerItem extends AbstractVerticalItemVaultItem<PurpleVerticalShippingContainerBlockEntity> {
    @ApiStatus.Internal
    public static boolean IS_PLACING_NBT = false;

    public PurpleVerticalShippingContainerItem(Block block, Properties properties) {
        super(block, properties);
    }

    @Override
    protected void setIsPlacingNbt(boolean isPlacingNbt) {
        IS_PLACING_NBT = isPlacingNbt;
    }

    @Override
    protected boolean isVault(BlockState state) {
        return PurpleVerticalShippingContainerBlock.sIsVault(state);
    }

    @Override
    protected BlockEntityType<PurpleVerticalShippingContainerBlockEntity> getBlockEntityType() {
        return PurpleVerticalShippingContainerBlock.sGetBlockEntityType();
    }

    @Override
    protected Direction.Axis getVaultBlockAxis(BlockState state) {
        return PurpleVerticalShippingContainerBlock.sGetVaultBlockAxis(state);
    }
}
