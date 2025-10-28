package net.zlt.create_vibrant_vaults.duck;

import net.zlt.create_vibrant_vaults.block.ModBlocks;

public interface FactoryPanelBlockEntityRenderDataMixinDuck {
    ModBlocks.VibrantVaultColor createVibrantVaults$getRestockerColor();

    void createVibrantVaults$setRestockerColor(ModBlocks.VibrantVaultColor color);
}
