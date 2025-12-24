package net.zlt.create_vibrant_vaults.client.model;

import dev.engine_room.flywheel.lib.model.baked.PartialModel;
import net.zlt.create_vibrant_vaults.CreateVibrantVaults;
import net.zlt.create_vibrant_vaults.block.ModBlocks;

import java.util.EnumMap;
import java.util.Map;

public final class ModPartialModels {
    private ModPartialModels() {
    }

    // Use EnumMaps for safer and more efficient lookups
    private static final Map<ModBlocks.VibrantVaultColor, VibrantFrogportPartialModels> FROGPORTS = new EnumMap<>(ModBlocks.VibrantVaultColor.class);
    private static final Map<ModBlocks.VibrantVaultColor, VibrantPackagerPartialModels> PACKAGERS = new EnumMap<>(ModBlocks.VibrantVaultColor.class);
    private static final Map<ModBlocks.VibrantVaultColor, VibrantGaugePartialModels> GAUGES = new EnumMap<>(ModBlocks.VibrantVaultColor.class);

    static {
        // Initialize all colored variants, skipping the BASE variant
        for (ModBlocks.VibrantVaultColor color : ModBlocks.VibrantVaultColor.values()) {
            if (color != ModBlocks.VibrantVaultColor.BASE) {
                FROGPORTS.put(color, new VibrantFrogportPartialModels(color));
                PACKAGERS.put(color, new VibrantPackagerPartialModels(color));
                GAUGES.put(color, new VibrantGaugePartialModels(color));
            }
        }
    }

    public static VibrantFrogportPartialModels ofVibrantFrogport(ModBlocks.VibrantVaultColor color) {
        return FROGPORTS.get(color);
    }

    public static VibrantPackagerPartialModels ofVibrantPackager(ModBlocks.VibrantVaultColor color) {
        return PACKAGERS.get(color);
    }

    public static VibrantGaugePartialModels ofVibrantGauge(ModBlocks.VibrantVaultColor color) {
        return GAUGES.get(color);
    }

    private static PartialModel block(String path) {
        return PartialModel.of(CreateVibrantVaults.asResource("block/" + path));
    }

    public static void init() {
        // Just used to trigger the static block above
    }

    public static class VibrantFrogportPartialModels {
        public final PartialModel body;
        public final PartialModel head;
        public final PartialModel headGoggles;
        public final PartialModel tongue;

        public VibrantFrogportPartialModels(ModBlocks.VibrantVaultColor color) {
            String vibrantFrogportName = color.asId() + "_package_frogport";
            body = block(vibrantFrogportName + "/body");
            head = block(vibrantFrogportName + "/head");
            headGoggles = block(vibrantFrogportName + "/head_goggles");
            tongue = block(vibrantFrogportName + "/tongue");
        }
    }

    public static class VibrantPackagerPartialModels {
        public final PartialModel trayRegular;
        public final PartialModel hatchOpen;
        public final PartialModel hatchClosed;

        public VibrantPackagerPartialModels(ModBlocks.VibrantVaultColor color) {
            String vibrantPackagerName = color.asId() + "_packager";
            trayRegular = block(vibrantPackagerName + "/tray");
            hatchOpen = block(vibrantPackagerName + "/hatch_open");
            hatchClosed = block(vibrantPackagerName + "/hatch_closed");
        }
    }

    public static class VibrantGaugePartialModels {
        public final PartialModel restocker;
        public final PartialModel restockerWithBulb;

        public VibrantGaugePartialModels(ModBlocks.VibrantVaultColor color) {
            String vibrantGaugeName = color.asId() + "_factory_gauge";
            restocker = block(vibrantGaugeName + "/panel_restocker");
            restockerWithBulb = block(vibrantGaugeName + "/panel_restocker_with_bulb");
        }
    }
}