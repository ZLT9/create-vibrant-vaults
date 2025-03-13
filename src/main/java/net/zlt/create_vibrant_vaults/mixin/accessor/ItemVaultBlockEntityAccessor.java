package net.zlt.create_vibrant_vaults.mixin.accessor;

import com.simibubi.create.content.logistics.vault.ItemVaultBlockEntity;
import com.simibubi.create.foundation.ICapabilityProvider;
import net.neoforged.neoforge.items.IItemHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(ItemVaultBlockEntity.class)
public interface ItemVaultBlockEntityAccessor {
    @Invoker("initCapability")
    void createVibrantVaults$callInitCapability();

    @Accessor("itemCapability")
    ICapabilityProvider<IItemHandler> createVibrantVaults$getItemCapability();
}
