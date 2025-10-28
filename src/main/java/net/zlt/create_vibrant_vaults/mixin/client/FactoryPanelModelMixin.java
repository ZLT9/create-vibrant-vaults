package net.zlt.create_vibrant_vaults.mixin.client;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import com.simibubi.create.content.logistics.factoryBoard.FactoryPanelBlockEntity;
import com.simibubi.create.content.logistics.factoryBoard.FactoryPanelModel;
import dev.engine_room.flywheel.lib.model.baked.PartialModel;
import net.fabricmc.fabric.api.renderer.v1.render.RenderContext;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_vibrant_vaults.block.ModBlocks;
import net.zlt.create_vibrant_vaults.client.model.ModPartialModels;
import net.zlt.create_vibrant_vaults.duck.FactoryPanelBlockEntityRenderDataMixinDuck;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.Supplier;

@Mixin(FactoryPanelModel.class)
public abstract class FactoryPanelModelMixin {
    @Unique
    private ModBlocks.VibrantVaultColor createVibrantVaults$restockerColor = ModBlocks.VibrantVaultColor.BASE;

    @Inject(method = "emitBlockQuads", at = @At(value = "INVOKE", target = "Lcom/simibubi/create/content/logistics/factoryBoard/FactoryPanelBlockEntity$RenderData;states()Ljava/util/Map;"), remap = false)
    private void createVibrantVaults$setRestockerColor(BlockAndTintGetter level, BlockState blockState, BlockPos pos, Supplier<RandomSource> randomSupplier, RenderContext context, CallbackInfo ci, @Local FactoryPanelBlockEntity.RenderData data) {
        createVibrantVaults$restockerColor = ((FactoryPanelBlockEntityRenderDataMixinDuck) (Object) data).createVibrantVaults$getRestockerColor();
    }

    @Inject(method = "emitBlockQuads", at = @At(value = "RETURN"), remap = false)
    private void createVibrantVaults$resetRestockerColor(BlockAndTintGetter level, BlockState blockState, BlockPos pos, Supplier<RandomSource> randomSupplier, RenderContext context, CallbackInfo ci) {
        createVibrantVaults$restockerColor = ModBlocks.VibrantVaultColor.BASE;
    }

    @ModifyExpressionValue(method = "emitPanel", at = @At(value = "FIELD", target = "Lcom/simibubi/create/AllPartialModels;FACTORY_PANEL_RESTOCKER:Ldev/engine_room/flywheel/lib/model/baked/PartialModel;"), remap = false)
    private PartialModel createVibrantVaults$getGaugeRestocker(PartialModel original) {
        return createVibrantVaults$restockerColor == ModBlocks.VibrantVaultColor.BASE ? original : ModPartialModels.ofVibrantGauge(createVibrantVaults$restockerColor).restocker;
    }

    @ModifyExpressionValue(method = "emitPanel", at = @At(value = "FIELD", target = "Lcom/simibubi/create/AllPartialModels;FACTORY_PANEL_RESTOCKER_WITH_BULB:Ldev/engine_room/flywheel/lib/model/baked/PartialModel;"), remap = false)
    private PartialModel createVibrantVaults$getGaugeRestockerWithBulb(PartialModel original) {
        return createVibrantVaults$restockerColor == ModBlocks.VibrantVaultColor.BASE ? original : ModPartialModels.ofVibrantGauge(createVibrantVaults$restockerColor).restockerWithBulb;
    }
}
