package net.zlt.create_vibrant_vaults.mixin.client;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.simibubi.create.infrastructure.ponder.AllCreatePonderScenes;
import com.simibubi.create.infrastructure.ponder.scenes.highLogistics.FrogAndConveyorScenes;
import com.simibubi.create.infrastructure.ponder.scenes.highLogistics.PackagerScenes;
import com.simibubi.create.infrastructure.ponder.scenes.highLogistics.RequesterAndShopScenes;
import com.simibubi.create.infrastructure.ponder.scenes.highLogistics.StockLinkScenes;
import com.tterrag.registrate.util.entry.ItemProviderEntry;
import net.createmod.ponder.api.registration.PonderSceneRegistrationHelper;
import net.minecraft.resources.ResourceLocation;
import net.zlt.create_vibrant_vaults.CreateVibrantVaults;
import net.zlt.create_vibrant_vaults.block.ModBlocks;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AllCreatePonderScenes.class)
public abstract class AllCreatePonderScenesMixin {
    @Unique
    private static PonderSceneRegistrationHelper<ItemProviderEntry<?>> createVibrantVaults$helper = null;

    @ModifyExpressionValue(method = "register", at = @At(value = "INVOKE", target = "Lnet/createmod/ponder/api/registration/PonderSceneRegistrationHelper;withKeyFunction(Ljava/util/function/Function;)Lnet/createmod/ponder/api/registration/PonderSceneRegistrationHelper;"), remap = false)
    private static PonderSceneRegistrationHelper<ItemProviderEntry<?>> createVibrantVaults$grabPonderHelper(PonderSceneRegistrationHelper<ItemProviderEntry<?>> original) {
        createVibrantVaults$helper = original;
        return original;
    }

    @Inject(method = "register", at = @At("TAIL"), remap = false)
    private static void createVibrantVaults$addPonderScenes(PonderSceneRegistrationHelper<ResourceLocation> helper, CallbackInfo ci) {
        if (createVibrantVaults$helper == null) {
            CreateVibrantVaults.LOGGER.warn("Failed to add ponder scenes");
            return;
        }

        // TODO: add vaults

        createVibrantVaults$helper.forComponents(ModBlocks.VIBRANT_FROGPORTS)
            .addStoryBoard("high_logistics/package_frogport", FrogAndConveyorScenes::frogPort);

        createVibrantVaults$helper.forComponents(ModBlocks.VIBRANT_PACKAGERS)
                .addStoryBoard("high_logistics/packager", PackagerScenes::packager)
                .addStoryBoard("high_logistics/packager_address", PackagerScenes::packagerAddress);

        createVibrantVaults$helper.forComponents(ModBlocks.VIBRANT_STOCK_LINKS)
            .addStoryBoard("high_logistics/stock_link", StockLinkScenes::stockLink);

        createVibrantVaults$helper.forComponents(ModBlocks.VIBRANT_REDSTONE_REQUESTERS)
            .addStoryBoard("high_logistics/redstone_requester", RequesterAndShopScenes::requester);
    }
}
