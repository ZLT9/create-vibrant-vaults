package net.zlt.create_vibrant_vaults.client.model;

import dev.engine_room.flywheel.lib.model.baked.PartialModel;
import net.zlt.create_vibrant_vaults.CreateVibrantVaults;
import net.zlt.create_vibrant_vaults.block.ModBlocks;

import java.util.ArrayList;
import java.util.List;

public final class ModPartialModels {
    private ModPartialModels() {
    }

    public static final List<VibrantFrogportPartialModels> VIBRANT_FROGPORTS = getVibrantFrogports();
    public static final List<VibrantPackagerPartialModels> VIBRANT_PACKAGERS = getVibrantPackagers();
    public static final List<VibrantGaugePartialModels> VIBRANT_GAUGES = getVibrantGauges();

    public static VibrantFrogportPartialModels ofVibrantFrogport(ModBlocks.VibrantVaultColor color) {
        return VIBRANT_FROGPORTS.get(color.ordinal());
    }

    public static VibrantPackagerPartialModels ofVibrantPackager(ModBlocks.VibrantVaultColor color) {
        return VIBRANT_PACKAGERS.get(color.ordinal());
    }

    public static VibrantGaugePartialModels ofVibrantGauge(ModBlocks.VibrantVaultColor color) {
        return VIBRANT_GAUGES.get(color.ordinal());
    }

    private static PartialModel block(String path) {
        return PartialModel.of(CreateVibrantVaults.asResource("block/" + path));
    }

    private static List<VibrantFrogportPartialModels> getVibrantFrogports() {
        ModBlocks.VibrantVaultColor[] colors = ModBlocks.VibrantVaultColor.values();
        List<VibrantFrogportPartialModels> result = new ArrayList<>(colors.length);
        for (int i = 0; i < colors.length; i++) result.add(null);
        for (ModBlocks.VibrantVaultColor color : colors) {
            if (color != ModBlocks.VibrantVaultColor.BASE) {
                result.set(color.ordinal(), new VibrantFrogportPartialModels(color));
            }
        }
        return result;
    }

    private static List<VibrantPackagerPartialModels> getVibrantPackagers() {
        ModBlocks.VibrantVaultColor[] colors = ModBlocks.VibrantVaultColor.values();
        List<VibrantPackagerPartialModels> result = new ArrayList<>(colors.length);
        for (int i = 0; i < colors.length; i++) result.add(null);
        for (ModBlocks.VibrantVaultColor color : colors) {
            if (color != ModBlocks.VibrantVaultColor.BASE) {
                result.set(color.ordinal(), new VibrantPackagerPartialModels(color));
            }
        }
        return result;
    }

    private static List<VibrantGaugePartialModels> getVibrantGauges() {
        ModBlocks.VibrantVaultColor[] colors = ModBlocks.VibrantVaultColor.values();
        List<VibrantGaugePartialModels> result = new ArrayList<>(colors.length);
        for (int i = 0; i < colors.length; i++) result.add(null);
        for (ModBlocks.VibrantVaultColor color : colors) {
            if (color != ModBlocks.VibrantVaultColor.BASE) {
                result.set(color.ordinal(), new VibrantGaugePartialModels(color));
            }
        }
        return result;
    }

    public static void init() {
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
