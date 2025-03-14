package net.zlt.create_vibrant_vaults.mixin.accessor;

import com.simibubi.create.content.logistics.packagePort.PackagePortBlockEntity;
import net.neoforged.neoforge.items.IItemHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(PackagePortBlockEntity.class)
public interface PackagePortBlockEntityAccessor {
    @Accessor("itemHandler")
    IItemHandler createVibrantVaults$getItemHandler();
}
