package net.zlt.create_vibrant_vaults.block.entity.item_vault.vertical;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_vibrant_vaults.block.entity.AbstractVerticalItemVaultBlockEntity;
import net.zlt.create_vibrant_vaults.block.item_vault.vertical.BrownVerticalItemVaultBlock;

public class BrownVerticalItemVaultBlockEntity extends AbstractVerticalItemVaultBlockEntity<BrownVerticalItemVaultBlockEntity> {
    public BrownVerticalItemVaultBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    @Override
    protected BrownVerticalItemVaultBlockEntity getAsBE(BlockEntity blockEntity) {
        return blockEntity instanceof BrownVerticalItemVaultBlockEntity ? (BrownVerticalItemVaultBlockEntity) blockEntity : null;
    }

    @Override
    protected boolean isVault(BlockState state) {
        return BrownVerticalItemVaultBlock.sIsVault(state);
    }

    @Override
    protected Direction.Axis getVaultBlockAxis(BlockState state) {
        return BrownVerticalItemVaultBlock.sGetVaultBlockAxis(state);
    }

    @Override
    protected BlockEntityType<BrownVerticalItemVaultBlockEntity> getBlockEntityType() {
        return BrownVerticalItemVaultBlock.sGetBlockEntityType();
    }
}
