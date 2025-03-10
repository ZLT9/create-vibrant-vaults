package net.zlt.create_vibrant_vaults.ct;

import com.simibubi.create.foundation.block.connected.AllCTTypes;
import com.simibubi.create.foundation.block.connected.CTSpriteShiftEntry;
import com.simibubi.create.foundation.block.connected.CTSpriteShifter;
import com.simibubi.create.foundation.utility.Couple;
import net.zlt.create_vibrant_vaults.CreateVibrantVaults;
import net.zlt.create_vibrant_vaults.block.ModBlocks;

import java.util.ArrayList;
import java.util.List;

public final class ModSpriteShifts {
    private ModSpriteShifts() {
    }

    public static final List<List<VibrantVaultSpriteShifts>> VIBRANT_VAULTS = getVibrantVaults();

    public static VibrantVaultSpriteShifts ofVibrantVault(ModBlocks.VibrantVaultType type, ModBlocks.VibrantVaultColor color, boolean vertical) {
        return VIBRANT_VAULTS.get(type.ordinal() * 2 + (vertical ? 1 : 0)).get(color.ordinal());
    }

    private static Couple<CTSpriteShiftEntry> vibrantVault(String name, String shiftName, ModBlocks.VibrantVaultColor color) {
        String prefix = "block/" + name + "/" + color.asId() + "/vault_" + shiftName;
        return Couple.createWithContext(medium -> CTSpriteShifter.getCT(
            AllCTTypes.RECTANGLE,
            CreateVibrantVaults.asResource(prefix + "_small"),
            CreateVibrantVaults.asResource(medium ? prefix + "_medium" : prefix + "_large")
        ));
    }

    private static List<List<VibrantVaultSpriteShifts>> getVibrantVaults() {
        ModBlocks.VibrantVaultType[] types = ModBlocks.VibrantVaultType.values();
        List<List<VibrantVaultSpriteShifts>> result = new ArrayList<>(types.length * 2);
        for (ModBlocks.VibrantVaultType type : types) {
            boolean includeBaseColor = type != ModBlocks.VibrantVaultType.ITEM_VAULT;
            String horizontalTypeId = type.asId(false);
            String verticalTypeId = type.asId(true);
            ModBlocks.VibrantVaultColor[] colors = ModBlocks.VibrantVaultColor.values();
            List<VibrantVaultSpriteShifts> horizontalShifts = new ArrayList<>(includeBaseColor ? colors.length : colors.length - 1);
            List<VibrantVaultSpriteShifts> verticalShifts = new ArrayList<>(colors.length);
            for (ModBlocks.VibrantVaultColor color : ModBlocks.VibrantVaultColor.values()) {
                if (color != ModBlocks.VibrantVaultColor.BASE || includeBaseColor) {
                    horizontalShifts.add(color.ordinal(), new VibrantVaultSpriteShifts(horizontalTypeId, color, false));
                }
                verticalShifts.add(color.ordinal(), new VibrantVaultSpriteShifts(verticalTypeId, color, true));
            }
            result.add(type.ordinal() * 2, horizontalShifts);
            result.add(type.ordinal() * 2 + 1, verticalShifts);
        }
        return result;
    }

    public static void init() {
    }

    public static class VibrantVaultSpriteShifts {
        public final Couple<CTSpriteShiftEntry> top;
        public final Couple<CTSpriteShiftEntry> front;
        public final Couple<CTSpriteShiftEntry> side;
        public final Couple<CTSpriteShiftEntry> bottom;

        public VibrantVaultSpriteShifts(String name, ModBlocks.VibrantVaultColor color, boolean vertical) {
            top = vibrantVault(name, "top", color);
            front = vertical ? null : vibrantVault(name, "front", color);
            side = vibrantVault(name, "side", color);
            bottom = vertical ? null : vibrantVault(name, "bottom", color);
        }
    }
}
