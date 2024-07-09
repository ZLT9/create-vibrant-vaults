package net.zlt.create_vibrant_vaults;

import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.ApiStatus;

public class BasicShippingContainerItem extends AbstractItemVaultItem<BasicShippingContainerBlockEntity> {
    @ApiStatus.Internal
    public static boolean IS_PLACING_NBT = false;

    public BasicShippingContainerItem(Block block, Properties properties) {
        super(block, properties);
    }

    @Override
    protected void setIsPlacingNbt(boolean isPlacingNbt) {
        IS_PLACING_NBT = isPlacingNbt;
    }

    @Override
    protected boolean isVault(BlockState state) {
        return BasicShippingContainerBlock.sIsVault(state);
    }

    @Override
    protected BlockEntityType<BasicShippingContainerBlockEntity> getBlockEntityType() {
        return BasicShippingContainerBlock.sGetBlockEntityType();
    }

    @Override
    protected Direction.Axis getVaultBlockAxis(BlockState state) {
        return BasicShippingContainerBlock.sGetVaultBlockAxis(state);
    }
}