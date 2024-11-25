package net.zlt.create_vibrant_vaults.block.entity;

import com.simibubi.create.api.connectivity.ConnectivityHandler;
import com.simibubi.create.foundation.blockEntity.behaviour.inventory.VersionedInventoryWrapper;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.wrapper.CombinedInvWrapper;

public abstract class AbstractVerticalItemVaultBlockEntity<BE extends AbstractVerticalItemVaultBlockEntity<BE>> extends AbstractItemVaultBlockEntity<BE> {
    public AbstractVerticalItemVaultBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    @Override
    protected void updateComparators() {
        if (level == null) {
            return;
        }

        BE controllerBE = getControllerBE();
        if (controllerBE == null) {
            return;
        }

        level.blockEntityChanged(controllerBE.worldPosition);

        BlockPos pos = controllerBE.getBlockPos();
        for (int y = 0; y < controllerBE.length; y++) {
            for (int z = 0; z < controllerBE.radius; z++) {
                for (int x = 0; x < controllerBE.radius; x++) {
                    level.updateNeighbourForOutputSignal(pos.offset(x, y, z), getBlockState().getBlock());
                }
            }
        }
    }

    @Override
    protected void initCapability() {
        if (itemCapability.isPresent()) {
            return;
        }

        if (!isController()) {
            BE controllerBE = getControllerBE();
            if (controllerBE != null) {
                controllerBE.initCapability();
                itemCapability = controllerBE.itemCapability;
            }
            return;
        }

        if (level == null) {
            return;
        }

        IItemHandlerModifiable[] invs = new IItemHandlerModifiable[length * radius * radius];
        for (int yOffset = 0; yOffset < length; yOffset++) {
            for (int xOffset = 0; xOffset < radius; xOffset++) {
                for (int zOffset = 0; zOffset < radius; zOffset++) {
                    BE vaultAt = ConnectivityHandler.partAt(getBlockEntityType(), level, worldPosition.offset(xOffset, yOffset, zOffset));
                    invs[yOffset * radius * radius + xOffset * radius + zOffset] = vaultAt != null ? vaultAt.inventory : new ItemStackHandler();
                }
            }
        }

        IItemHandler itemHandler = new VersionedInventoryWrapper(new CombinedInvWrapper(invs));
        itemCapability = LazyOptional.of(() -> itemHandler);
    }

    @Override
    public Direction.Axis getMainConnectionAxis() {
        return Direction.Axis.Y;
    }

    @Override
    public int getMaxLength(Direction.Axis longAxis, int width) {
        return longAxis == Direction.Axis.Y ? getMaxLength(width) : getMaxWidth();
    }
}
