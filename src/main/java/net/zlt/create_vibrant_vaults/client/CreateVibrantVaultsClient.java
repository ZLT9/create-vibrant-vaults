package net.zlt.create_vibrant_vaults.client;

import net.fabricmc.api.ClientModInitializer;
import net.zlt.create_vibrant_vaults.client.model.ModPartialModels;

public class CreateVibrantVaultsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ModPartialModels.init();
    }
}
