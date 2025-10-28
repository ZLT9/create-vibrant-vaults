package net.zlt.create_vibrant_vaults.mixin.client;

import com.google.common.base.Preconditions;
import io.github.fabricators_of_create.porting_lib.models.generators.ModelBuilder;
import net.minecraft.resources.ResourceLocation;
import net.zlt.create_vibrant_vaults.duck.ModelBuilderMixinDuck;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;

import java.util.Map;

@Mixin(ModelBuilder.class)
public abstract class ModelBuilderMixin<T extends ModelBuilder<T>> implements ModelBuilderMixinDuck<T> {
    @Shadow(remap = false)
    @Final
    protected Map<String, String> textures;

    @Shadow(remap = false)
    protected abstract T self();

    @Unique
    @Override
    public T createVibrantVaults$uncheckedTexture(String key, ResourceLocation texture) {
        Preconditions.checkNotNull(key, "Key must not be null");
        Preconditions.checkNotNull(texture, "Texture must not be null");
        textures.put(key, texture.toString());
        return self();
    }
}
