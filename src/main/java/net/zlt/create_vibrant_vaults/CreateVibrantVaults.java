package net.zlt.create_vibrant_vaults;

import com.simibubi.create.foundation.data.CreateRegistrate;
import io.github.fabricators_of_create.porting_lib.util.EnvExecutor;
import net.fabricmc.api.ModInitializer;
import net.minecraft.resources.ResourceLocation;
import net.zlt.create_vibrant_vaults.block.ModBlockTags;
import net.zlt.create_vibrant_vaults.block.ModBlocks;
import net.zlt.create_vibrant_vaults.ct.ModSpriteShifts;
import net.zlt.create_vibrant_vaults.item.ModCreativeModeTabs;
import net.zlt.create_vibrant_vaults.item.ModItemTags;
import net.zlt.create_vibrant_vaults.item.crafting.ModRecipeSerializers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateVibrantVaults implements ModInitializer {
    public static final String ID = "create_vibrant_vaults";
    public static final String NAME = "Create: Vibrant Vaults";
    public static final Logger LOGGER = LoggerFactory.getLogger(NAME);
    public static final CreateRegistrate REGISTRATE = CreateRegistrate.create(ID);

    @Override
    public void onInitialize() {
        LOGGER.info("Create addon mod [{}] is loading alongside Create!", NAME);
        LOGGER.info(EnvExecutor.unsafeRunForDist(
            () -> () -> "{} is accessing Porting Lib from the client!",
            () -> () -> "{} is accessing Porting Lib from the server!"
        ), NAME);

        ModBlockTags.init();
        ModItemTags.init();
        ModCreativeModeTabs.init();
        ModBlocks.init();
        ModSpriteShifts.init();
        ModRecipeSerializers.init();

        REGISTRATE.register();
    }

    public static ResourceLocation asResource(String path) {
        return new ResourceLocation(ID, path);
    }
}
