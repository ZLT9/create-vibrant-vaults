package net.zlt.create_vibrant_vaults;

import com.mojang.logging.LogUtils;
import com.simibubi.create.CreateBuildInfo;
import com.simibubi.create.foundation.data.CreateRegistrate;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.zlt.create_vibrant_vaults.block.ModBlockTags;
import net.zlt.create_vibrant_vaults.block.ModBlocks;
import net.zlt.create_vibrant_vaults.ct.ModSpriteShifts;
import net.zlt.create_vibrant_vaults.data.CreateVibrantVaultsDatagen;
import net.zlt.create_vibrant_vaults.item.ModCreativeModeTabs;
import net.zlt.create_vibrant_vaults.item.ModItemTags;
import net.zlt.create_vibrant_vaults.item.crafting.ModRecipeSerializers;
import org.slf4j.Logger;

@Mod(CreateVibrantVaults.ID)
public class CreateVibrantVaults {
    public static final String ID = "create_vibrant_vaults";
    public static final String NAME = "Create: Vibrant Vaults";
    public static final Logger LOGGER = LogUtils.getLogger();
    public static final CreateRegistrate REGISTRATE = CreateRegistrate.create(ID);

    public CreateVibrantVaults(FMLJavaModLoadingContext context) {
        LOGGER.info("Create addon mod [{}] is loading alongside Create [{}]!", NAME, CreateBuildInfo.VERSION);

        IEventBus modEventBus = context.getModEventBus();

        REGISTRATE.registerEventListeners(modEventBus);

        ModBlockTags.init();
        ModItemTags.init();
        ModCreativeModeTabs.init(modEventBus);
        ModBlocks.init();
        ModSpriteShifts.init();
        ModRecipeSerializers.init(modEventBus);

        modEventBus.addListener(EventPriority.LOWEST, CreateVibrantVaultsDatagen::gatherData);
    }

    public static ResourceLocation asResource(String path) {
        return ResourceLocation.fromNamespaceAndPath(ID, path);
    }
}
