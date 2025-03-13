package net.zlt.create_vibrant_vaults;

import com.mojang.logging.LogUtils;
import com.simibubi.create.CreateBuildInfo;
import com.simibubi.create.foundation.data.CreateRegistrate;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.zlt.create_vibrant_vaults.block.ModBlockTags;
import net.zlt.create_vibrant_vaults.block.ModBlocks;
import net.zlt.create_vibrant_vaults.ct.ModSpriteShifts;
import net.zlt.create_vibrant_vaults.data.CreateVibrantVaultsDatagen;
import net.zlt.create_vibrant_vaults.item.ModCreativeModeTabs;
import net.zlt.create_vibrant_vaults.item.ModInventoryIdentifiers;
import net.zlt.create_vibrant_vaults.item.ModItemTags;
import org.slf4j.Logger;

@Mod(CreateVibrantVaults.ID)
public class CreateVibrantVaults {
    public static final String ID = "create_vibrant_vaults";
    public static final String NAME = "Create: Vibrant Vaults";
    public static final Logger LOGGER = LogUtils.getLogger();
    public static final CreateRegistrate REGISTRATE = CreateRegistrate.create(ID);

    public CreateVibrantVaults(IEventBus modEventBus, ModContainer modContainer) {
        LOGGER.info("Create addon mod [{}] is loading alongside Create [{}]!", NAME, CreateBuildInfo.VERSION);

        REGISTRATE.registerEventListeners(modEventBus);

        ModBlockTags.init();
        ModItemTags.init();
        ModCreativeModeTabs.init(modEventBus);
        ModBlocks.init();
        ModSpriteShifts.init();

        modEventBus.addListener(CreateVibrantVaults::init);
        modEventBus.addListener(EventPriority.LOWEST, CreateVibrantVaultsDatagen::gatherData);
    }

    public static void init(final FMLCommonSetupEvent event) {
        event.enqueueWork(ModInventoryIdentifiers::init);
    }

    public static ResourceLocation asResource(String path) {
        return ResourceLocation.fromNamespaceAndPath(ID, path);
    }
}
