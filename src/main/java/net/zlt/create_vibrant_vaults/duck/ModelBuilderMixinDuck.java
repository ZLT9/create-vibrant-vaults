package net.zlt.create_vibrant_vaults.duck;

import io.github.fabricators_of_create.porting_lib.models.generators.ModelBuilder;
import net.minecraft.resources.ResourceLocation;

public interface ModelBuilderMixinDuck<T extends ModelBuilder<T>> {
    T createVibrantVaults$uncheckedTexture(String key, ResourceLocation texture);
}
