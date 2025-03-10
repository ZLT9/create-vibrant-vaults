package net.zlt.create_vibrant_vaults.mixin.client;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import com.simibubi.create.content.logistics.packagePort.frogport.FrogportBlockEntity;
import com.simibubi.create.content.logistics.packagePort.frogport.FrogportVisual;
import dev.engine_room.flywheel.api.visualization.VisualizationContext;
import dev.engine_room.flywheel.lib.model.baked.PartialModel;
import dev.engine_room.flywheel.lib.visual.AbstractBlockEntityVisual;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_vibrant_vaults.block.ModBlockTags;
import net.zlt.create_vibrant_vaults.block.VibrantFrogportBlock;
import net.zlt.create_vibrant_vaults.client.model.ModPartialModels;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(FrogportVisual.class)
public abstract class FrogportVisualMixin extends AbstractBlockEntityVisual<FrogportBlockEntity> {
    private FrogportVisualMixin(VisualizationContext ctx, FrogportBlockEntity blockEntity, float partialTick) {
        super(ctx, blockEntity, partialTick);
    }

    @ModifyExpressionValue(method = "<init>", at = @At(value = "FIELD", target = "Lcom/simibubi/create/AllPartialModels;FROGPORT_BODY:Ldev/engine_room/flywheel/lib/model/baked/PartialModel;"), remap = false)
    private PartialModel createVibrantVaults$getFrogportBody(PartialModel original, @Local(argsOnly = true) FrogportBlockEntity blockEntity) {
        BlockState blockState = blockEntity.getBlockState();
        return !ModBlockTags.VIBRANT_FROGPORTS.matches(blockState) || !(blockState.getBlock() instanceof VibrantFrogportBlock vibrantFrogport) ? original : ModPartialModels.ofVibrantFrogport(vibrantFrogport.color).body;
    }

    @ModifyExpressionValue(method = "<init>", at = @At(value = "FIELD", target = "Lcom/simibubi/create/AllPartialModels;FROGPORT_HEAD:Ldev/engine_room/flywheel/lib/model/baked/PartialModel;"), remap = false)
    private PartialModel createVibrantVaults$getFrogportHead(PartialModel original, @Local(argsOnly = true) FrogportBlockEntity blockEntity) {
        BlockState blockState = blockEntity.getBlockState();
        return !ModBlockTags.VIBRANT_FROGPORTS.matches(blockState) || !(blockState.getBlock() instanceof VibrantFrogportBlock vibrantFrogport) ? original : ModPartialModels.ofVibrantFrogport(vibrantFrogport.color).head;
    }

    @ModifyExpressionValue(method = "<init>", at = @At(value = "FIELD", target = "Lcom/simibubi/create/AllPartialModels;FROGPORT_TONGUE:Ldev/engine_room/flywheel/lib/model/baked/PartialModel;"), remap = false)
    private PartialModel createVibrantVaults$getFrogportTongue(PartialModel original, @Local(argsOnly = true) FrogportBlockEntity blockEntity) {
        BlockState blockState = blockEntity.getBlockState();
        return !ModBlockTags.VIBRANT_FROGPORTS.matches(blockState) || !(blockState.getBlock() instanceof VibrantFrogportBlock vibrantFrogport) ? original : ModPartialModels.ofVibrantFrogport(vibrantFrogport.color).tongue;
    }

    @ModifyExpressionValue(method = "updateGoggles", at = @At(value = "FIELD", target = "Lcom/simibubi/create/AllPartialModels;FROGPORT_HEAD_GOGGLES:Ldev/engine_room/flywheel/lib/model/baked/PartialModel;"), remap = false)
    private PartialModel createVibrantVaults$getFrogportHeadGoggles(PartialModel original) {
        BlockState blockState = blockEntity.getBlockState();
        return !ModBlockTags.VIBRANT_FROGPORTS.matches(blockState) || !(blockState.getBlock() instanceof VibrantFrogportBlock vibrantFrogport) ? original : ModPartialModels.ofVibrantFrogport(vibrantFrogport.color).headGoggles;
    }

    @ModifyExpressionValue(method = "updateGoggles", at = @At(value = "FIELD", target = "Lcom/simibubi/create/AllPartialModels;FROGPORT_HEAD:Ldev/engine_room/flywheel/lib/model/baked/PartialModel;"), remap = false)
    private PartialModel createVibrantVaults$updateGogglesGetFrogportHead(PartialModel original) {
        BlockState blockState = blockEntity.getBlockState();
        return !ModBlockTags.VIBRANT_FROGPORTS.matches(blockState) || !(blockState.getBlock() instanceof VibrantFrogportBlock vibrantFrogport) ? original : ModPartialModels.ofVibrantFrogport(vibrantFrogport.color).head;
    }
}
