package net.zlt.create_vibrant_vaults.item.item_vault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_vibrant_vaults.block.entity.item_vault.BlackItemVaultBlockEntity;
import net.zlt.create_vibrant_vaults.block.item_vault.BlackItemVaultBlock;
import net.zlt.create_vibrant_vaults.item.AbstractItemVaultItem;
import org.jetbrains.annotations.ApiStatus;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class BlackItemVaultItem extends AbstractItemVaultItem<BlackItemVaultBlockEntity> {
    @ApiStatus.Internal
    public static boolean IS_PLACING_NBT = false;

    public BlackItemVaultItem(Block block, Properties properties) {
        super(block, properties);
    }

    @Override
    protected void setIsPlacingNbt(boolean isPlacingNbt) {
        IS_PLACING_NBT = isPlacingNbt;
    }

    @Override
    protected boolean isVault(BlockState state) {
        return BlackItemVaultBlock.sIsVault(state);
    }

    @Override
    protected BlockEntityType<BlackItemVaultBlockEntity> getBlockEntityType() {
        return BlackItemVaultBlock.sGetBlockEntityType();
    }

    @Override
    protected Direction.Axis getVaultBlockAxis(BlockState state) {
        return BlackItemVaultBlock.sGetVaultBlockAxis(state);
    }
}
