package net.zlt.create_vibrant_vaults.duck;

import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.model.generators.ModelBuilder;

public interface ModelBuilderMixinDuck<T extends ModelBuilder<T>> {
    T createVibrantVaults$uncheckedTexture(String key, ResourceLocation texture);
}
