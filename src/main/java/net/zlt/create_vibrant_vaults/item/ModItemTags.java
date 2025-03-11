package net.zlt.create_vibrant_vaults.item;

import com.simibubi.create.AllTags;
import net.createmod.catnip.lang.Lang;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.ForgeRegistries;
import net.zlt.create_vibrant_vaults.CreateVibrantVaults;
import net.zlt.create_vibrant_vaults.block.ModBlocks;

public enum ModItemTags {
    /**
     * <ul>
     * <li>Type: any.</li>
     * <li>Color: any.</li>
     * <li>Orientation: any.</li>
     * <li>Source: Create: Vibrant Vaults.</li>
     * </ul>
     */
    VIBRANT_VAULTS,
    /**
     * <ul>
     * <li>Type: any.</li>
     * <li>Color: any.</li>
     * <li>Orientation: horizontal.</li>
     * <li>Source: Create: Vibrant Vaults, Create.</li>
     * </ul>
     */
    HORIZONTAL_VAULTS,
    /**
     * <ul>
     * <li>Type: any.</li>
     * <li>Color: any.</li>
     * <li>Orientation: vertical.</li>
     * <li>Source: Create: Vibrant Vaults.</li>
     * </ul>
     */
    VERTICAL_VAULTS,
    /**
     * <ul>
     * <li>Type: item vault.</li>
     * <li>Color: any.</li>
     * <li>Orientation: any.</li>
     * <li>Source: Create: Vibrant Vaults, Create.</li>
     * </ul>
     */
    ITEM_VAULTS,
    /**
     * <ul>
     * <li>Type: shipping container.</li>
     * <li>Color: any.</li>
     * <li>Orientation: any.</li>
     * <li>Source: Create: Vibrant Vaults.</li>
     * </ul>
     */
    SHIPPING_CONTAINERS,
    /**
     * <ul>
     * <li>Type: basic shipping container.</li>
     * <li>Color: any.</li>
     * <li>Orientation: any.</li>
     * <li>Source: Create: Vibrant Vaults.</li>
     */
    BASIC_SHIPPING_CONTAINERS,
    /**
     * <ul>
     * <li>Type: any.</li>
     * <li>Color: white.</li>
     * <li>Orientation: any.</li>
     * <li>Source: Create: Vibrant Vaults.</li>
     */
    WHITE_VAULTS,
    /**
     * <ul>
     * <li>Type: any.</li>
     * <li>Color: orange.</li>
     * <li>Orientation: any.</li>
     * <li>Source: Create: Vibrant Vaults.</li>
     */
    ORANGE_VAULTS,
    /**
     * <ul>
     * <li>Type: any.</li>
     * <li>Color: magenta.</li>
     * <li>Orientation: any.</li>
     * <li>Source: Create: Vibrant Vaults.</li>
     */
    MAGENTA_VAULTS,
    /**
     * <ul>
     * <li>Type: any.</li>
     * <li>Color: light blue.</li>
     * <li>Orientation: any.</li>
     * <li>Source: Create: Vibrant Vaults.</li>
     */
    LIGHT_BLUE_VAULTS,
    /**
     * <ul>
     * <li>Type: any.</li>
     * <li>Color: yellow.</li>
     * <li>Orientation: any.</li>
     * <li>Source: Create: Vibrant Vaults.</li>
     */
    YELLOW_VAULTS,
    /**
     * <ul>
     * <li>Type: any.</li>
     * <li>Color: lime.</li>
     * <li>Orientation: any.</li>
     * <li>Source: Create: Vibrant Vaults.</li>
     */
    LIME_VAULTS,
    /**
     * <ul>
     * <li>Type: any.</li>
     * <li>Color: pink.</li>
     * <li>Orientation: any.</li>
     * <li>Source: Create: Vibrant Vaults.</li>
     */
    PINK_VAULTS,
    /**
     * <ul>
     * <li>Type: any.</li>
     * <li>Color: gray.</li>
     * <li>Orientation: any.</li>
     * <li>Source: Create: Vibrant Vaults.</li>
     */
    GRAY_VAULTS,
    /**
     * <ul>
     * <li>Type: any.</li>
     * <li>Color: light gray.</li>
     * <li>Orientation: any.</li>
     * <li>Source: Create: Vibrant Vaults.</li>
     */
    LIGHT_GRAY_VAULTS,
    /**
     * <ul>
     * <li>Type: any.</li>
     * <li>Color: cyan.</li>
     * <li>Orientation: any.</li>
     * <li>Source: Create: Vibrant Vaults.</li>
     */
    CYAN_VAULTS,
    /**
     * <ul>
     * <li>Type: any.</li>
     * <li>Color: purple.</li>
     * <li>Orientation: any.</li>
     * <li>Source: Create: Vibrant Vaults.</li>
     */
    PURPLE_VAULTS,
    /**
     * <ul>
     * <li>Type: any.</li>
     * <li>Color: blue.</li>
     * <li>Orientation: any.</li>
     * <li>Source: Create: Vibrant Vaults.</li>
     */
    BLUE_VAULTS,
    /**
     * <ul>
     * <li>Type: any.</li>
     * <li>Color: brown.</li>
     * <li>Orientation: any.</li>
     * <li>Source: Create: Vibrant Vaults.</li>
     */
    BROWN_VAULTS,
    /**
     * <ul>
     * <li>Type: any.</li>
     * <li>Color: green.</li>
     * <li>Orientation: any.</li>
     * <li>Source: Create: Vibrant Vaults.</li>
     */
    GREEN_VAULTS,
    /**
     * <ul>
     * <li>Type: any.</li>
     * <li>Color: red.</li>
     * <li>Orientation: any.</li>
     * <li>Source: Create: Vibrant Vaults.</li>
     */
    RED_VAULTS,
    /**
     * <ul>
     * <li>Type: any.</li>
     * <li>Color: black.</li>
     * <li>Orientation: any.</li>
     * <li>Source: Create: Vibrant Vaults.</li>
     */
    BLACK_VAULTS,
    /**
     * <ul>
     * <li>Type: any.</li>
     * <li>Color: base.</li>
     * <li>Orientation: any.</li>
     * <li>Source: Create: Vibrant Vaults, Create.</li>
     */
    BASE_VAULTS,
    /**
     * <ul>
     * <li>Type: item vault.</li>
     * <li>Color: not base.</li>
     * <li>Orientation: horizontal.</li>
     * <li>Source: Create: Vibrant Vaults.</li>
     */
    COLORED_HORIZONTAL_ITEM_VAULTS,
    /**
     * <ul>
     * <li>Type: item vault.</li>
     * <li>Color: not base.</li>
     * <li>Orientation: vertical.</li>
     * <li>Source: Create: Vibrant Vaults.</li>
     */
    COLORED_VERTICAL_ITEM_VAULTS,
    /**
     * <ul>
     * <li>Type: shipping container.</li>
     * <li>Color: not base.</li>
     * <li>Orientation: horizontal.</li>
     * <li>Source: Create: Vibrant Vaults.</li>
     */
    COLORED_HORIZONTAL_SHIPPING_CONTAINERS,
    /**
     * <ul>
     * <li>Type: shipping container.</li>
     * <li>Color: not base.</li>
     * <li>Orientation: vertical.</li>
     * <li>Source: Create: Vibrant Vaults.</li>
     */
    COLORED_VERTICAL_SHIPPING_CONTAINERS,
    /**
     * <ul>
     * <li>Type: basic shipping container.</li>
     * <li>Color: not base.</li>
     * <li>Orientation: horizontal.</li>
     * <li>Source: Create: Vibrant Vaults.</li>
     */
    COLORED_HORIZONTAL_BASIC_SHIPPING_CONTAINERS,
    /**
     * <ul>
     * <li>Type: basic shipping container.</li>
     * <li>Color: not base.</li>
     * <li>Orientation: vertical.</li>
     * <li>Source: Create: Vibrant Vaults.</li>
     */
    COLORED_VERTICAL_BASIC_SHIPPING_CONTAINERS,
    /**
     * <ul>
     * <li>Source: Create: Vibrant Vaults, Create.</li>
     * </ul>
     */
    FROGPORTS,
    /**
     * <ul>
     * <li>Source: Create: Vibrant Vaults.</li>
     * </ul>
     */
    VIBRANT_FROGPORTS,
    /**
     * <ul>
     * <li>Source: Create: Vibrant Vaults, Create.</li>
     * </ul>
     */
    STOCK_LINKS,
    /**
     * <ul>
     * <li>Source: Create: Vibrant Vaults.</li>
     * </ul>
     */
    VIBRANT_STOCK_LINKS,
    VIBRANT_REDSTONE_REQUESTERS,
    VIBRANT_PACKAGERS;

    public final TagKey<Item> tag;

    ModItemTags() {
        tag = AllTags.optionalTag(ForgeRegistries.ITEMS, CreateVibrantVaults.asResource(Lang.asId(name())));
    }

    @SuppressWarnings("deprecation")
    public boolean matches(Item item) {
        return item.builtInRegistryHolder().is(tag);
    }

    public boolean matches(ItemStack stack) {
        return stack.is(tag);
    }

    public static ModItemTags ofType(ModBlocks.VibrantVaultType type) {
        return switch (type) {
            case ITEM_VAULT -> ITEM_VAULTS;
            case SHIPPING_CONTAINER -> SHIPPING_CONTAINERS;
            case BASIC_SHIPPING_CONTAINER -> BASIC_SHIPPING_CONTAINERS;
        };
    }

    public static ModItemTags ofColor(ModBlocks.VibrantVaultColor color) {
        return switch (color) {
            case WHITE -> WHITE_VAULTS;
            case ORANGE -> ORANGE_VAULTS;
            case MAGENTA -> MAGENTA_VAULTS;
            case LIGHT_BLUE -> LIGHT_BLUE_VAULTS;
            case YELLOW -> YELLOW_VAULTS;
            case LIME -> LIME_VAULTS;
            case PINK -> PINK_VAULTS;
            case GRAY -> GRAY_VAULTS;
            case LIGHT_GRAY -> LIGHT_GRAY_VAULTS;
            case CYAN -> CYAN_VAULTS;
            case PURPLE -> PURPLE_VAULTS;
            case BLUE -> BLUE_VAULTS;
            case BROWN -> BROWN_VAULTS;
            case GREEN -> GREEN_VAULTS;
            case RED -> RED_VAULTS;
            case BLACK -> BLACK_VAULTS;
            case BASE -> BASE_VAULTS;
        };
    }

    public static ModItemTags ofOrientation(boolean vertical) {
        return vertical ? VERTICAL_VAULTS : HORIZONTAL_VAULTS;
    }

    public static ModItemTags ofColored(ModBlocks.VibrantVaultType type, boolean vertical) {
        return switch (type) {
            case ITEM_VAULT -> vertical ? COLORED_VERTICAL_ITEM_VAULTS : COLORED_HORIZONTAL_ITEM_VAULTS;
            case SHIPPING_CONTAINER -> vertical ? COLORED_VERTICAL_SHIPPING_CONTAINERS : COLORED_HORIZONTAL_SHIPPING_CONTAINERS;
            case BASIC_SHIPPING_CONTAINER -> vertical ? COLORED_VERTICAL_BASIC_SHIPPING_CONTAINERS : COLORED_HORIZONTAL_BASIC_SHIPPING_CONTAINERS;
        };
    }

    public static void init() {
    }
}
