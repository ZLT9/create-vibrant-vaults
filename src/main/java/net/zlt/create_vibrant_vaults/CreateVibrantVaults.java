package net.zlt.create_vibrant_vaults;

import com.simibubi.create.Create;

import com.simibubi.create.foundation.data.CreateRegistrate;

import com.simibubi.create.foundation.utility.Components;
import io.github.fabricators_of_create.porting_lib.util.EnvExecutor;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.minecraft.resources.ResourceLocation;

import net.zlt.create_vibrant_vaults.block.AllBlockEntityTypes;
import net.zlt.create_vibrant_vaults.block.AllBlocks;
import net.zlt.create_vibrant_vaults.ct.AllSpriteShifts;
import net.zlt.create_vibrant_vaults.item.AllCreativeModeTabs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateVibrantVaults implements ModInitializer {
    public static final String ID = "create_vibrant_vaults";
    public static final String NAME = "Create: Vibrant Vaults";
    public static final Logger LOGGER = LoggerFactory.getLogger(NAME);

    public static final CreateRegistrate REGISTRATE = CreateRegistrate.create(ID);

    @Override
    public void onInitialize() {
        LOGGER.info("Create addon mod [{}] is loading alongside Create [{}]!", NAME, Create.VERSION);
        LOGGER.info(EnvExecutor.unsafeRunForDist(
            () -> () -> "{} is accessing Porting Lib from the client!",
            () -> () -> "{} is accessing Porting Lib from the server!"
        ), NAME);

        AllCreativeModeTabs.register();
        AllBlocks.register();
        AllBlockEntityTypes.register();
        AllSpriteShifts.register();

        REGISTRATE.register();

        ModContainer createVibrantVaultsContainer = FabricLoader.getInstance().getModContainer(ID)
            .orElseThrow(() -> new IllegalStateException("Create: Vibrant Vaults ModContainer couldn't be found!"));
        ResourceLocation legacyVaultsPackId = asResource("legacy_vaults");
        ResourceManagerHelper.registerBuiltinResourcePack(legacyVaultsPackId, createVibrantVaultsContainer, Components.literal("C:VV Legacy Vaults"), ResourcePackActivationType.NORMAL);
    }

    public static ResourceLocation asResource(String path) {
        return new ResourceLocation(ID, path);
    }
}
