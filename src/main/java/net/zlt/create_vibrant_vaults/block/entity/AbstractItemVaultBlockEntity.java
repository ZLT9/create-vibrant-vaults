package net.zlt.create_vibrant_vaults.block.entity;

import com.simibubi.create.api.connectivity.ConnectivityHandler;
import com.simibubi.create.foundation.blockEntity.IMultiBlockEntityContainer;
import com.simibubi.create.foundation.blockEntity.SmartBlockEntity;
import com.simibubi.create.foundation.blockEntity.behaviour.BlockEntityBehaviour;
import com.simibubi.create.foundation.blockEntity.behaviour.inventory.VersionedInventoryWrapper;
import com.simibubi.create.infrastructure.config.AllConfigs;
import io.github.fabricators_of_create.porting_lib.transfer.item.ItemStackHandler;
import net.fabricmc.fabric.api.transfer.v1.item.ItemVariant;
import net.fabricmc.fabric.api.transfer.v1.storage.Storage;
import net.fabricmc.fabric.api.transfer.v1.storage.base.CombinedStorage;
import net.fabricmc.fabric.api.transfer.v1.storage.base.SidedStorageBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_vibrant_vaults.block.AbstractItemVaultBlock;

import javax.annotation.Nullable;
import java.util.List;

public abstract class AbstractItemVaultBlockEntity<BE extends AbstractItemVaultBlockEntity<BE>> extends SmartBlockEntity implements IMultiBlockEntityContainer.Inventory, SidedStorageBlockEntity {
    @SuppressWarnings("UnstableApiUsage")
    protected Storage<ItemVariant> itemCapability;

    public ItemStackHandler inventory;
    protected BlockPos controller;
    protected BlockPos lastKnownPos;
    protected boolean updateConnectivity;
    public int radius;
    public int length;
    protected Direction.Axis axis;

    protected boolean recalculateComparatorsNextTick = false;

    public AbstractItemVaultBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);

        inventory = new ItemStackHandler(AllConfigs.server().logistics.vaultCapacity.get()) {
            @Override
            protected void onContentsChanged(int slot) {
                super.onContentsChanged(slot);
                recalculateComparatorsNextTick = true;
            }
        };

        itemCapability = null;
        radius = 1;
        length = 1;
    }

    @Override
    public void addBehaviours(List<BlockEntityBehaviour> behaviours) {
    }

    public void updateConnectivity() {
        updateConnectivity = false;

        if (level != null && !level.isClientSide() && isController()) {
            ConnectivityHandler.formMulti(this);
        }
    }

    protected void updateComparators() {
        recalculateComparatorsNextTick = false;

        if (level == null) {
            return;
        }

        BE controllerBE = getControllerBE();
        if (controllerBE == null) {
            return;
        }

        level.blockEntityChanged(controllerBE.worldPosition);

        BlockPos pos = controllerBE.getBlockPos();
        for (int y = 0; y < controllerBE.radius; y++) {
            for (int z = 0; z < (controllerBE.axis == Direction.Axis.X ? controllerBE.radius : controllerBE.length); z++) {
                for (int x = 0; x < (controllerBE.axis == Direction.Axis.Z ? controllerBE.radius : controllerBE.length); x++) {
                    level.updateNeighbourForOutputSignal(pos.offset(x, y, z), getBlockState().getBlock());
                }
            }
        }
    }

    @Override
    public void tick() {
        super.tick();

        if (lastKnownPos == null) {
            lastKnownPos = getBlockPos();
        } else if (!lastKnownPos.equals(worldPosition)) {
            onPositionChanged();
            return;
        }

        if (updateConnectivity) {
            updateConnectivity();
        }

        if (recalculateComparatorsNextTick) {
            updateComparators();
        }
    }

    @Override
    public BlockPos getLastKnownPos() {
        return lastKnownPos;
    }

    @Override
    public boolean isController() {
        return controller == null || worldPosition.getX() == controller.getX() && worldPosition.getY() == controller.getY() && worldPosition.getZ() == controller.getZ();
    }

    private void onPositionChanged() {
        removeController(true);
        lastKnownPos = worldPosition;
    }

    protected abstract BE getAsBE(BlockEntity blockEntity);

    @SuppressWarnings("unchecked")
    @Override
    public BE getControllerBE() {
        if (isController()) {
            return (BE) this;
        }

        if (level == null) {
            return null;
        }

        return getAsBE(level.getBlockEntity(controller));
    }

    protected abstract boolean isVault(BlockState state);

    public void removeController(boolean keepContents) {
        if (level == null || level.isClientSide()) {
            return;
        }

        updateConnectivity = true;
        controller = null;
        radius = 1;
        length = 1;

        BlockState state = getBlockState();
        if (isVault(state)) {
            state = state.setValue(AbstractItemVaultBlock.LARGE, false);
            level.setBlock(worldPosition, state, 22);
        }

        itemCapability = null;
        setChanged();
        sendData();
    }

    @Override
    public void setController(BlockPos controller) {
        if (level == null || level.isClientSide && !isVirtual()) {
            return;
        }

        if (controller.equals(this.controller)) {
            return;
        }

        this.controller = controller;
        itemCapability = null;
        setChanged();
        sendData();
    }

    @Override
    public BlockPos getController() {
        return isController() ? worldPosition : controller;
    }

    @Override
    protected void read(CompoundTag compound, boolean clientPacket) {
        super.read(compound, clientPacket);

        BlockPos controllerBefore = controller;
        int prevSize = radius;
        int prevLength = length;

        updateConnectivity = compound.contains("Uninitialized");
        controller = null;
        lastKnownPos = null;

        if (compound.contains("LastKnownPos"))
            lastKnownPos = NbtUtils.readBlockPos(compound.getCompound("LastKnownPos"));
        if (compound.contains("Controller"))
            controller = NbtUtils.readBlockPos(compound.getCompound("Controller"));

        if (isController()) {
            radius = compound.getInt("Size");
            length = compound.getInt("Length");
        }

        if (!clientPacket) {
            inventory.deserializeNBT(compound.getCompound("Inventory"));
            return;
        }

        boolean changeOfController = controllerBefore == null ? controller != null : !controllerBefore.equals(controller);
        if (level != null && (changeOfController || prevSize != radius || prevLength != length)) {
            level.setBlocksDirty(getBlockPos(), Blocks.AIR.defaultBlockState(), getBlockState());
        }
    }

    @Override
    protected void write(CompoundTag compound, boolean clientPacket) {
        if (updateConnectivity) {
            compound.putBoolean("Uninitialized", true);
        }

        if (lastKnownPos != null) {
            compound.put("LastKnownPos", NbtUtils.writeBlockPos(lastKnownPos));
        }

        if (!isController()) {
            compound.put("Controller", NbtUtils.writeBlockPos(controller));
        }

        if (isController()) {
            compound.putInt("Size", radius);
            compound.putInt("Length", length);
        }

        super.write(compound, clientPacket);

        if (!clientPacket) {
            compound.putString("StorageType", "CombinedInv");
            compound.put("Inventory", inventory.serializeNBT());
        }
    }

    public ItemStackHandler getInventoryOfBlock() {
        return inventory;
    }

    public void applyInventoryToBlock(ItemStackHandler handler) {
        for (int i = 0; i < inventory.getSlotCount(); i++) {
            inventory.setStackInSlot(i, i < handler.getSlotCount() ? handler.getStackInSlot(i) : ItemStack.EMPTY);
        }
    }

    @SuppressWarnings("UnstableApiUsage")
    @Nullable
    @Override
    public Storage<ItemVariant> getItemStorage(@Nullable Direction face) {
        initCapability();
        return itemCapability;
    }

    protected abstract Direction.Axis getVaultBlockAxis(BlockState state);

    protected abstract BlockEntityType<BE> getBlockEntityType();

    protected void initCapability() {
        if (itemCapability != null) {
            return;
        }

        if (!isController()) {
            BE controllerBE = getControllerBE();

            if (controllerBE == null) {
                return;
            }

            controllerBE.initCapability();
            itemCapability = controllerBE.itemCapability;
            return;
        }

        if (level == null) {
            return;
        }

        boolean alongZ = getVaultBlockAxis(getBlockState()) == Direction.Axis.Z;
        ItemStackHandler[] invs = new ItemStackHandler[length * radius * radius];
        for (int yOffset = 0; yOffset < length; yOffset++) {
            for (int xOffset = 0; xOffset < radius; xOffset++) {
                for (int zOffset = 0; zOffset < radius; zOffset++) {
                    BE vaultAt = ConnectivityHandler.partAt(getBlockEntityType(), level, alongZ ? worldPosition.offset(xOffset, zOffset, yOffset) : worldPosition.offset(yOffset, xOffset, zOffset));
                    invs[yOffset * radius * radius + xOffset * radius + zOffset] = vaultAt != null ? vaultAt.inventory : new ItemStackHandler();
                }
            }
        }

        @SuppressWarnings("UnstableApiUsage")
        Storage<ItemVariant> combinedInvWrapper = new VersionedInventoryWrapper(new CombinedStorage<>(List.of(invs)));
        itemCapability = combinedInvWrapper;
    }

    public static int getMaxLength(int radius) {
        return radius * 3;
    }

    @Override
    public void preventConnectivityUpdate() {
        updateConnectivity = false;
    }

    public void queueConnectivityUpdate() {
        updateConnectivity = true;
    }

    @Override
    public void notifyMultiUpdated() {
        BlockState state = this.getBlockState();

        if (level != null && isVault(state)) {
            level.setBlock(getBlockPos(), state.setValue(AbstractItemVaultBlock.LARGE, radius > 2), 6);
        }

        itemCapability = null;
        setChanged();
    }

    @Override
    public Direction.Axis getMainConnectionAxis() {
        return getMainAxisOf(this);
    }

    @Override
    public int getMaxLength(Direction.Axis longAxis, int width) {
        return longAxis == Direction.Axis.Y ? getMaxWidth() : getMaxLength(width);
    }

    @Override
    public int getMaxWidth() {
        return 3;
    }

    @Override
    public int getHeight() {
        return length;
    }

    @Override
    public int getWidth() {
        return radius;
    }

    @Override
    public void setHeight(int height) {
        this.length = height;
    }

    @Override
    public void setWidth(int width) {
        this.radius = width;
    }

    @Override
    public boolean hasInventory() {
        return true;
    }
}
