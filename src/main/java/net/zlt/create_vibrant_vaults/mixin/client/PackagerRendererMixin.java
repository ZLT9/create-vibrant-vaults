package net.zlt.create_vibrant_vaults.mixin.client;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import com.simibubi.create.content.logistics.packager.PackagerBlockEntity;
import com.simibubi.create.content.logistics.packager.PackagerRenderer;
import dev.engine_room.flywheel.lib.model.baked.PartialModel;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_vibrant_vaults.block.ModBlockTags;
import net.zlt.create_vibrant_vaults.block.VibrantPackagerBlock;
import net.zlt.create_vibrant_vaults.client.model.ModPartialModels;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(PackagerRenderer.class)
public abstract class PackagerRendererMixin {
    @ModifyExpressionValue(method = "getTrayModel", at = @At(value = "FIELD", target = "Lcom/simibubi/create/AllPartialModels;PACKAGER_TRAY_DEFRAG:Ldev/engine_room/flywheel/lib/model/baked/PartialModel;"), remap = false)
    private static PartialModel createVibrantVaults$getTrayRegular(PartialModel original, @Local(argsOnly = true) BlockState blockState) {
        return !ModBlockTags.VIBRANT_PACKAGERS.matches(blockState) || !(blockState.getBlock() instanceof VibrantPackagerBlock vibrantPackager) ? original : ModPartialModels.ofVibrantPackager(vibrantPackager.color).trayRegular;
    }

    @ModifyExpressionValue(method = "getHatchModel", at = @At(value = "FIELD", target = "Lcom/simibubi/create/AllPartialModels;PACKAGER_HATCH_OPEN:Ldev/engine_room/flywheel/lib/model/baked/PartialModel;"), remap = false)
    private static PartialModel createVibrantVaults$getHatchOpen(PartialModel original, @Local(argsOnly = true) PackagerBlockEntity be) {
        BlockState blockState = be.getBlockState();
        return !ModBlockTags.VIBRANT_PACKAGERS.matches(blockState) || !(blockState.getBlock() instanceof VibrantPackagerBlock vibrantPackager) ? original : ModPartialModels.ofVibrantPackager(vibrantPackager.color).hatchOpen;
    }

    @ModifyExpressionValue(method = "getHatchModel", at = @At(value = "FIELD", target = "Lcom/simibubi/create/AllPartialModels;PACKAGER_HATCH_CLOSED:Ldev/engine_room/flywheel/lib/model/baked/PartialModel;"), remap = false)
    private static PartialModel createVibrantVaults$getHatchClosed(PartialModel original, @Local(argsOnly = true) PackagerBlockEntity be) {
        BlockState blockState = be.getBlockState();
        return !ModBlockTags.VIBRANT_PACKAGERS.matches(blockState) || !(blockState.getBlock() instanceof VibrantPackagerBlock vibrantPackager) ? original : ModPartialModels.ofVibrantPackager(vibrantPackager.color).hatchClosed;
    }
}
