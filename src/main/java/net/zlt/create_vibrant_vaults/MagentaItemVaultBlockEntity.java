package net.zlt.create_vibrant_vaults;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class MagentaItemVaultBlockEntity extends AbstractItemVaultBlockEntity<MagentaItemVaultBlockEntity> {
    public MagentaItemVaultBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    @Override
    protected MagentaItemVaultBlockEntity getAsBE(BlockEntity blockEntity) {
        return blockEntity instanceof MagentaItemVaultBlockEntity ? (MagentaItemVaultBlockEntity) blockEntity : null;
    }

    @Override
    protected boolean isVault(BlockState state) {
        return MagentaItemVaultBlock.sIsVault(state);
    }

    @Override
    protected Direction.Axis getVaultBlockAxis(BlockState state) {
        return MagentaItemVaultBlock.sGetVaultBlockAxis(state);
    }

    @Override
    protected BlockEntityType<MagentaItemVaultBlockEntity> getBlockEntityType() {
        return MagentaItemVaultBlock.sGetBlockEntityType();
    }
}
