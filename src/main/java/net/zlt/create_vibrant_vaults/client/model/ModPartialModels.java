package net.zlt.create_vibrant_vaults.client.model;

import com.simibubi.create.Create;
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

    private static final VibrantFrogportPartialModels FALLBACK_FROGPORT = new VibrantFrogportPartialModels(
        PartialModel.of(Create.asResource("block/package_frogport/body")),
        PartialModel.of(Create.asResource("block/package_frogport/head")),
        PartialModel.of(Create.asResource("block/package_frogport/head_goggles")),
        PartialModel.of(Create.asResource("block/package_frogport/tongue"))
    );

    private static final VibrantPackagerPartialModels FALLBACK_PACKAGER = new VibrantPackagerPartialModels(
        PartialModel.of(Create.asResource("block/packager/tray")),
        PartialModel.of(Create.asResource("block/packager/hatch_open")),
        PartialModel.of(Create.asResource("block/packager/hatch_closed"))
    );

    private static final VibrantGaugePartialModels FALLBACK_GAUGE = new VibrantGaugePartialModels(
        PartialModel.of(Create.asResource("block/factory_gauge/panel_restocker")),
        PartialModel.of(Create.asResource("block/factory_gauge/panel_restocker_with_bulb"))
    );

    public static VibrantFrogportPartialModels ofVibrantFrogport(ModBlocks.VibrantVaultColor color) {
        VibrantFrogportPartialModels pm = VIBRANT_FROGPORTS.get(color.ordinal());
        return pm == null ? FALLBACK_FROGPORT : pm;
    }

    public static VibrantPackagerPartialModels ofVibrantPackager(ModBlocks.VibrantVaultColor color) {
        VibrantPackagerPartialModels pm = VIBRANT_PACKAGERS.get(color.ordinal());
        return pm == null ? FALLBACK_PACKAGER : pm;
    }

    public static VibrantGaugePartialModels ofVibrantGauge(ModBlocks.VibrantVaultColor color) {
        VibrantGaugePartialModels pm = VIBRANT_GAUGES.get(color.ordinal());
        return pm == null ? FALLBACK_GAUGE : pm;
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

        public VibrantFrogportPartialModels(PartialModel body, PartialModel head, PartialModel headGoggles, PartialModel tongue) {
            this.body = body;
            this.head = head;
            this.headGoggles = headGoggles;
            this.tongue = tongue;
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

        public VibrantPackagerPartialModels(PartialModel trayRegular, PartialModel hatchOpen, PartialModel hatchClosed) {
            this.trayRegular = trayRegular;
            this.hatchOpen = hatchOpen;
            this.hatchClosed = hatchClosed;
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

        public VibrantGaugePartialModels(PartialModel restocker, PartialModel restockerWithBulb) {
            this.restocker = restocker;
            this.restockerWithBulb = restockerWithBulb;
        }
    }
}
