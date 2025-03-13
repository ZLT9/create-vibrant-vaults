package net.zlt.create_vibrant_vaults.mixin.client;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import com.simibubi.create.content.logistics.factoryBoard.FactoryPanelBehaviour;
import com.simibubi.create.content.logistics.factoryBoard.FactoryPanelModel;
import dev.engine_room.flywheel.lib.model.baked.PartialModel;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.client.model.data.ModelData;
import net.neoforged.neoforge.client.model.data.ModelProperty;
import net.zlt.create_vibrant_vaults.block.ModBlocks;
import net.zlt.create_vibrant_vaults.client.model.FactoryPanelModelExtraData;
import net.zlt.create_vibrant_vaults.client.model.ModPartialModels;
import net.zlt.create_vibrant_vaults.duck.FactoryPanelBlockEntityMixinDuck;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(FactoryPanelModel.class)
public abstract class FactoryPanelModelMixin {
    @Unique
    private static final ModelProperty<FactoryPanelModelExtraData> PANEL_EXTRA_PROPERTY = new ModelProperty<>();

    @Unique
    private static FactoryPanelModelExtraData createVibrantVaults$extraData = null;

    @Inject(method = "gatherModelData", at = @At("HEAD"), remap = false)
    private void createVibrantVaults$initExtraData(ModelData.Builder builder, BlockAndTintGetter world, BlockPos pos, BlockState state, ModelData blockEntityData, CallbackInfoReturnable<ModelData.Builder> cir) {
        createVibrantVaults$extraData = new FactoryPanelModelExtraData();
    }

    @Inject(method = "gatherModelData", at = @At(value = "INVOKE", target = "Ljava/util/EnumMap;put(Ljava/lang/Enum;Ljava/lang/Object;)Ljava/lang/Object;"), remap = false)
    private void createVibrantVaults$gatherRestockerColor(ModelData.Builder builder, BlockAndTintGetter world, BlockPos pos, BlockState state, ModelData blockEntityData, CallbackInfoReturnable<ModelData.Builder> cir, @Local FactoryPanelBehaviour behaviour) {
        if (createVibrantVaults$extraData != null) {
            createVibrantVaults$extraData.restockerColor = ((FactoryPanelBlockEntityMixinDuck) behaviour.panelBE()).createVibrantVaults$getRestockerColor();
        }
    }

    @ModifyExpressionValue(method = "gatherModelData", at = @At(value = "INVOKE", target = "Lnet/neoforged/neoforge/client/model/data/ModelData$Builder;with(Lnet/neoforged/neoforge/client/model/data/ModelProperty;Ljava/lang/Object;)Lnet/neoforged/neoforge/client/model/data/ModelData$Builder;"), remap = false)
    private ModelData.Builder createVibrantVaults$withExtraData(ModelData.Builder original) {
        if (createVibrantVaults$extraData != null) {
            original.with(PANEL_EXTRA_PROPERTY, createVibrantVaults$extraData);
            createVibrantVaults$extraData = null;
        }
        return original;
    }

    @ModifyExpressionValue(method = "addPanel", at = @At(value = "FIELD", target = "Lcom/simibubi/create/AllPartialModels;FACTORY_PANEL_RESTOCKER:Ldev/engine_room/flywheel/lib/model/baked/PartialModel;"), remap = false)
    private PartialModel createVibrantVaults$getGaugeRestocker(PartialModel original, @Local(argsOnly = true) ModelData data) {
        if (data.has(PANEL_EXTRA_PROPERTY)) {
            FactoryPanelModelExtraData extraData = data.get(PANEL_EXTRA_PROPERTY);
            if (extraData != null && extraData.restockerColor != ModBlocks.VibrantVaultColor.BASE) {
                return ModPartialModels.ofVibrantGauge(extraData.restockerColor).restocker;
            }
        }
        return original;
    }

    @ModifyExpressionValue(method = "addPanel", at = @At(value = "FIELD", target = "Lcom/simibubi/create/AllPartialModels;FACTORY_PANEL_RESTOCKER_WITH_BULB:Ldev/engine_room/flywheel/lib/model/baked/PartialModel;"), remap = false)
    private PartialModel createVibrantVaults$getGaugeRestockerWithBulb(PartialModel original, @Local(argsOnly = true) ModelData data) {
        if (data.has(PANEL_EXTRA_PROPERTY)) {
            FactoryPanelModelExtraData extraData = data.get(PANEL_EXTRA_PROPERTY);
            if (extraData != null && extraData.restockerColor != ModBlocks.VibrantVaultColor.BASE) {
                return ModPartialModels.ofVibrantGauge(extraData.restockerColor).restockerWithBulb;
            }
        }
        return original;
    }
}
