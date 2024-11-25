package net.zlt.create_vibrant_vaults.item;

import com.simibubi.create.foundation.utility.Components;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.zlt.create_vibrant_vaults.CreateVibrantVaults;

public class AllCreativeModeTabs {
    private static final DeferredRegister<CreativeModeTab> REGISTER = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CreateVibrantVaults.ID);
    public static final RegistryObject<CreativeModeTab> BASE_CREATIVE_TAB = REGISTER.register("base",
        () -> CreativeModeTab.builder()
            .title(Components.translatable("itemGroup.create_vibrant_vaults.base"))
            .withTabsBefore(com.simibubi.create.AllCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
            .icon(com.simibubi.create.AllBlocks.ITEM_VAULT::asStack)
            .build());

    public static void register(IEventBus modEventBus) {
        REGISTER.register(modEventBus);
    }
}
