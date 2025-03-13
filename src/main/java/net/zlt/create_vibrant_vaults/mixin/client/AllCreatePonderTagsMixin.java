package net.zlt.create_vibrant_vaults.mixin.client;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.simibubi.create.infrastructure.ponder.AllCreatePonderTags;
import com.tterrag.registrate.util.entry.BlockEntry;
import com.tterrag.registrate.util.entry.RegistryEntry;
import net.createmod.ponder.api.registration.MultiTagBuilder;
import net.createmod.ponder.api.registration.PonderTagRegistrationHelper;
import net.minecraft.resources.ResourceLocation;
import net.zlt.create_vibrant_vaults.CreateVibrantVaults;
import net.zlt.create_vibrant_vaults.block.*;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(AllCreatePonderTags.class)
public abstract class AllCreatePonderTagsMixin {
    @Shadow(remap = false)
    @Final
    public static ResourceLocation LOGISTICS;

    @Shadow(remap = false)
    @Final
    public static ResourceLocation THRESHOLD_SWITCH_TARGETS;

    @Shadow(remap = false)
    @Final
    public static ResourceLocation HIGH_LOGISTICS;

    @Unique
    private static PonderTagRegistrationHelper<RegistryEntry<?, ?>> createVibrantVaults$helper = null;

    @ModifyExpressionValue(method = "register", at = @At(value = "INVOKE", target = "Lnet/createmod/ponder/api/registration/PonderTagRegistrationHelper;withKeyFunction(Ljava/util/function/Function;)Lnet/createmod/ponder/api/registration/PonderTagRegistrationHelper;", ordinal = 0), remap = false)
    private static PonderTagRegistrationHelper<RegistryEntry<?, ?>> createVibrantVaults$grabPonderHelper(PonderTagRegistrationHelper<RegistryEntry<?, ?>> original) {
        createVibrantVaults$helper = original;
        return original;
    }

    @Inject(method = "register", at = @At("TAIL"), remap = false)
    private static void createVibrantVaults$addPonderTags(PonderTagRegistrationHelper<ResourceLocation> helper, CallbackInfo ci) {
        if (createVibrantVaults$helper == null) {
            CreateVibrantVaults.LOGGER.warn("Failed to add ponder tags");
            return;
        }

        MultiTagBuilder.Tag<RegistryEntry<?, ?>> logistics = createVibrantVaults$helper.addToTag(LOGISTICS);
        MultiTagBuilder.Tag<RegistryEntry<?, ?>> thresholdSwitchTargets = createVibrantVaults$helper.addToTag(THRESHOLD_SWITCH_TARGETS);
        MultiTagBuilder.Tag<RegistryEntry<?, ?>> highLogistics = createVibrantVaults$helper.addToTag(HIGH_LOGISTICS);

        for (List<BlockEntry<VibrantVaultBlock>> vaults : ModBlocks.VIBRANT_VAULTS) {
            for (BlockEntry<VibrantVaultBlock> vault : vaults) {
                logistics.add(vault);
                thresholdSwitchTargets.add(vault);
            }
        }

        for (BlockEntry<VibrantFrogportBlock> frogport : ModBlocks.VIBRANT_FROGPORTS) {
            highLogistics.add(frogport);
        }
        for (BlockEntry<VibrantStockLinkBlock> stockLink : ModBlocks.VIBRANT_STOCK_LINKS) {
            highLogistics.add(stockLink);
        }
        for (BlockEntry<VibrantRedstoneRequesterBlock> redstoneRequester : ModBlocks.VIBRANT_REDSTONE_REQUESTERS) {
            highLogistics.add(redstoneRequester);
        }
        for (BlockEntry<VibrantPackagerBlock> packager : ModBlocks.VIBRANT_PACKAGERS) {
            highLogistics.add(packager);
        }

        createVibrantVaults$helper = null;
    }
}
