package net.zlt.create_vibrant_vaults.mixin;

import com.simibubi.create.content.contraptions.MountedStorage;
import io.github.fabricators_of_create.porting_lib.transfer.item.ItemStackHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(MountedStorage.class)
public interface MountedStorageAccessor {
    @Accessor(value = "handler", remap = false)
    ItemStackHandler getHandler();

    @Accessor(value = "handler", remap = false)
    void setHandler(ItemStackHandler handler);

    @Accessor(value = "noFuel", remap = false)
    void setNoFuel(boolean noFuel);

    @Accessor(value = "valid", remap = false)
    void setValid(boolean valid);
}
