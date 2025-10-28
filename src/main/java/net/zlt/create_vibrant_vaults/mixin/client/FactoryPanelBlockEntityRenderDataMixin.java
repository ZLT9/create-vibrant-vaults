package net.zlt.create_vibrant_vaults.mixin.client;

import com.simibubi.create.content.logistics.factoryBoard.FactoryPanelBlockEntity;
import net.zlt.create_vibrant_vaults.block.ModBlocks;
import net.zlt.create_vibrant_vaults.duck.FactoryPanelBlockEntityRenderDataMixinDuck;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(FactoryPanelBlockEntity.RenderData.class)
public abstract class FactoryPanelBlockEntityRenderDataMixin implements FactoryPanelBlockEntityRenderDataMixinDuck {
    @Unique
    private ModBlocks.VibrantVaultColor createVibrantVaults$restockerColor = ModBlocks.VibrantVaultColor.BASE;

    @Unique
    @Override
    public ModBlocks.VibrantVaultColor createVibrantVaults$getRestockerColor() {
        return createVibrantVaults$restockerColor;
    }

    @Unique
    @Override
    public void createVibrantVaults$setRestockerColor(ModBlocks.VibrantVaultColor color) {
        createVibrantVaults$restockerColor = color;
    }
}
