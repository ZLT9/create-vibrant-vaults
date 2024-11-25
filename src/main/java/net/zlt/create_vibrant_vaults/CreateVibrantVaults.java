package net.zlt.create_vibrant_vaults;

import com.mojang.logging.LogUtils;
import com.simibubi.create.Create;
import com.simibubi.create.foundation.ModFilePackResources;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.foundation.utility.Components;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
import net.minecraftforge.event.AddPackFindersEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.forgespi.language.IModFileInfo;
import net.minecraftforge.forgespi.locating.IModFile;
import net.zlt.create_vibrant_vaults.block.AllBlocks;
import net.zlt.create_vibrant_vaults.block.entity.AllBlockEntityTypes;
import net.zlt.create_vibrant_vaults.ct.AllSpriteShifts;
import net.zlt.create_vibrant_vaults.item.AllCreativeModeTabs;
import org.slf4j.Logger;

@Mod(CreateVibrantVaults.ID)
public class CreateVibrantVaults {
    public static final String ID = "create_vibrant_vaults";
    public static final String NAME = "Create: Vibrant Vaults";
    public static final Logger LOGGER = LogUtils.getLogger();
    public static final CreateRegistrate REGISTRATE = CreateRegistrate.create(ID);

    public static ResourceLocation asResource(String path) {
        return new ResourceLocation(ID, path);
    }

    public CreateVibrantVaults() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        REGISTRATE.registerEventListeners(modEventBus);

        LOGGER.info("Create addon mod [{}] is loading alongside Create [{}]!", NAME, Create.VERSION);

        AllCreativeModeTabs.register(modEventBus);
        AllBlocks.register();
        AllBlockEntityTypes.register();
        AllSpriteShifts.register();
    }

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ModBusEvents {
        public ModBusEvents() {
        }

        @SubscribeEvent
        public static void addPackFinders(AddPackFindersEvent event) {
            if (event.getPackType() != PackType.CLIENT_RESOURCES) {
                return;
            }

            IModFileInfo modFileInfo = ModList.get().getModFileById(ID);
            if (modFileInfo == null) {
                LOGGER.info("Could not find Create: Vibrant Vaults mod file info; built-in resource packs will be missing!");
                return;
            }

            IModFile modFile = modFileInfo.getFile();
            event.addRepositorySource(consumer -> {
                Pack pack = Pack.readMetaAndCreate(asResource("legacy_vaults").toString(), Components.literal("C:VV Legacy Vaults"), false, id -> new ModFilePackResources(id, modFile, "resourcepacks/legacy_vaults"), PackType.CLIENT_RESOURCES, Pack.Position.TOP, PackSource.BUILT_IN);
                if (pack != null) {
                    consumer.accept(pack);
                }
            });
        }
    }
}
