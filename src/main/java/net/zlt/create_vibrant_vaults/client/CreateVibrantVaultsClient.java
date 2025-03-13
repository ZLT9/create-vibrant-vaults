package net.zlt.create_vibrant_vaults.client;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.zlt.create_vibrant_vaults.CreateVibrantVaults;
import net.zlt.create_vibrant_vaults.client.model.ModPartialModels;

@Mod(value = CreateVibrantVaults.ID, dist = Dist.CLIENT)
public class CreateVibrantVaultsClient {
    public CreateVibrantVaultsClient(IEventBus modEventBus) {
        modEventBus.addListener(CreateVibrantVaultsClient::clientInit);
    }

    public static void clientInit(final FMLClientSetupEvent event) {
        ModPartialModels.init();
    }
}
