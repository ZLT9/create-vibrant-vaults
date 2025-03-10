package net.zlt.create_vibrant_vaults.client;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.zlt.create_vibrant_vaults.client.model.ModPartialModels;

public class CreateVibrantVaultsClient {
    public static void initialize(IEventBus modEventBus) {
        modEventBus.addListener(CreateVibrantVaultsClient::clientInit);
    }

    public static void clientInit(final FMLClientSetupEvent event) {
        ModPartialModels.init();
    }
}
