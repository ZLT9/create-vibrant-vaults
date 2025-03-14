package net.zlt.create_vibrant_vaults.events;

import com.simibubi.create.AllBlockEntityTypes;
import com.simibubi.create.foundation.ICapabilityProvider;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.items.IItemHandler;
import net.zlt.create_vibrant_vaults.block.ModBlocks;
import net.zlt.create_vibrant_vaults.mixin.accessor.ItemVaultBlockEntityAccessor;
import net.zlt.create_vibrant_vaults.mixin.accessor.PackagePortBlockEntityAccessor;
import net.zlt.create_vibrant_vaults.mixin.accessor.PackagerBlockEntityAccessor;

import java.util.List;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public final class ModBusEvents {
    private ModBusEvents() {
    }

    @SubscribeEvent
    public static void registerCapabilities(RegisterCapabilitiesEvent event) {
        event.registerBlock(
            Capabilities.ItemHandler.BLOCK,
            (level, pos, state, blockEntity, context) -> {
                if (blockEntity == null || blockEntity.getType() != AllBlockEntityTypes.ITEM_VAULT.get()) {
                    return null;
                }

                ItemVaultBlockEntityAccessor beAccess = (ItemVaultBlockEntityAccessor) blockEntity;
                beAccess.createVibrantVaults$callInitCapability();
                ICapabilityProvider<IItemHandler> itemCapability = beAccess.createVibrantVaults$getItemCapability();
                return itemCapability == null ? null : itemCapability.getCapability();
            },
            ModBlocks.VIBRANT_VAULTS.stream()
                .flatMap(List::stream)
                .map(BlockEntry::get)
                .toArray(Block[]::new)
        );
        event.registerBlock(
            Capabilities.ItemHandler.BLOCK,
            (level, pos, state, blockEntity, context) -> blockEntity == null || blockEntity.getType() != AllBlockEntityTypes.PACKAGE_FROGPORT.get() ? null : ((PackagePortBlockEntityAccessor) blockEntity).createVibrantVaults$getItemHandler(),
            ModBlocks.VIBRANT_FROGPORTS.stream()
                .map(BlockEntry::get)
                .toArray(Block[]::new)
        );
        event.registerBlock(
            Capabilities.ItemHandler.BLOCK,
            (level, pos, state, blockEntity, context) -> blockEntity == null || blockEntity.getType() != AllBlockEntityTypes.PACKAGER.get() ? null : ((PackagerBlockEntityAccessor) blockEntity).createVibrantVaults$getInventory(),
            ModBlocks.VIBRANT_PACKAGERS.stream()
                .map(BlockEntry::get)
                .toArray(Block[]::new)
        );
    }
}
