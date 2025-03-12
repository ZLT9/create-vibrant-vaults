package net.zlt.create_vibrant_vaults;

import com.mojang.logging.LogUtils;
import com.simibubi.create.CreateBuildInfo;
import com.simibubi.create.foundation.data.CreateRegistrate;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.zlt.create_vibrant_vaults.block.ModBlockTags;
import net.zlt.create_vibrant_vaults.block.ModBlocks;
import net.zlt.create_vibrant_vaults.client.CreateVibrantVaultsClient;
import net.zlt.create_vibrant_vaults.ct.ModSpriteShifts;
import net.zlt.create_vibrant_vaults.data.CreateVibrantVaultsDatagen;
import net.zlt.create_vibrant_vaults.item.ModCreativeModeTabs;
import net.zlt.create_vibrant_vaults.item.ModItemTags;
import org.slf4j.Logger;

@Mod(CreateVibrantVaults.ID)
public class CreateVibrantVaults {
    public static final String ID = "create_vibrant_vaults";
    public static final String NAME = "Create: Vibrant Vaults";
    public static final Logger LOGGER = LogUtils.getLogger();
    public static final CreateRegistrate REGISTRATE = CreateRegistrate.create(ID);

    @SuppressWarnings("removal")
    public CreateVibrantVaults() {
        LOGGER.info("Create addon mod [{}] is loading alongside Create [{}]!", NAME, CreateBuildInfo.VERSION);

        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        REGISTRATE.registerEventListeners(modEventBus);

        ModBlockTags.init();
        ModItemTags.init();
        ModCreativeModeTabs.init(modEventBus);
        ModBlocks.init();
        ModSpriteShifts.init();

        modEventBus.addListener(EventPriority.LOWEST, CreateVibrantVaultsDatagen::gatherData);

        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> CreateVibrantVaultsClient.initialize(modEventBus));
    }

    @SuppressWarnings("removal")
    public static ResourceLocation asResource(String path) {
        return new ResourceLocation(ID, path);
    }
}
