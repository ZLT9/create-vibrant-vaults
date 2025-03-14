package net.zlt.create_vibrant_vaults.mixin.accessor;

import com.simibubi.create.content.logistics.packager.PackagerBlockEntity;
import com.simibubi.create.content.logistics.packager.PackagerItemHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(PackagerBlockEntity.class)
public interface PackagerBlockEntityAccessor {
    @Accessor("inventory")
    PackagerItemHandler createVibrantVaults$getInventory();
}
