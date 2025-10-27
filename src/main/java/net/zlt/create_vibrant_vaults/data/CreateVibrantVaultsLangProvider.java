package net.zlt.create_vibrant_vaults.data;

import com.simibubi.create.infrastructure.data.TagLangGenerator;
import com.tterrag.registrate.providers.ProviderType;
import com.tterrag.registrate.providers.RegistrateLangProvider;
import net.zlt.create_vibrant_vaults.CreateVibrantVaults;
import net.zlt.create_vibrant_vaults.block.ModBlockTags;
import net.zlt.create_vibrant_vaults.item.ModItemTags;

public class CreateVibrantVaultsLangProvider {
    public static void addGenerators() {
        CreateVibrantVaults.REGISTRATE.addDataGenerator(ProviderType.LANG, CreateVibrantVaultsLangProvider::genItemTagLang);
    }

    private static void genItemTagLang(RegistrateLangProvider provider) {
        new TagLangGenerator(provider::add) {
            @Override
            public void generate() {
                // Block tags
                translate(ModBlockTags.VIBRANT_VAULTS.tag, "Vibrant Vaults");
                translate(ModBlockTags.HORIZONTAL_VAULTS.tag, "Horizontal Vaults");
                translate(ModBlockTags.VERTICAL_VAULTS.tag, "Vertical Vaults");
                translate(ModBlockTags.ITEM_VAULTS.tag, "Item Vaults");
                translate(ModBlockTags.SHIPPING_CONTAINERS.tag, "Shipping Containers");
                translate(ModBlockTags.BASIC_SHIPPING_CONTAINERS.tag, "Basic Shipping Containers");
                translate(ModBlockTags.WHITE_VAULTS.tag, "White Vaults");
                translate(ModBlockTags.ORANGE_VAULTS.tag, "Orange Vaults");
                translate(ModBlockTags.MAGENTA_VAULTS.tag, "Magenta Vaults");
                translate(ModBlockTags.LIGHT_BLUE_VAULTS.tag, "Light Blue Vaults");
                translate(ModBlockTags.YELLOW_VAULTS.tag, "Yellow Vaults");
                translate(ModBlockTags.LIME_VAULTS.tag, "Lime Vaults");
                translate(ModBlockTags.PINK_VAULTS.tag, "Pink Vaults");
                translate(ModBlockTags.GRAY_VAULTS.tag, "Gray Vaults");
                translate(ModBlockTags.LIGHT_GRAY_VAULTS.tag, "Light Gray Vaults");
                translate(ModBlockTags.CYAN_VAULTS.tag, "Cyan Vaults");
                translate(ModBlockTags.PURPLE_VAULTS.tag, "Purple Vaults");
                translate(ModBlockTags.BLUE_VAULTS.tag, "Blue Vaults");
                translate(ModBlockTags.BROWN_VAULTS.tag, "Brown Vaults");
                translate(ModBlockTags.GREEN_VAULTS.tag, "Green Vaults");
                translate(ModBlockTags.RED_VAULTS.tag, "Red Vaults");
                translate(ModBlockTags.BLACK_VAULTS.tag, "Black Vaults");
                translate(ModBlockTags.BASE_VAULTS.tag, "Base Vaults");
                translate(ModBlockTags.COLORED_HORIZONTAL_ITEM_VAULTS.tag, "Colored Horizontal Item Vaults");
                translate(ModBlockTags.COLORED_VERTICAL_ITEM_VAULTS.tag, "Colored Vertical Item Vaults");
                translate(ModBlockTags.COLORED_HORIZONTAL_SHIPPING_CONTAINERS.tag, "Colored Horizontal Shipping Containers");
                translate(ModBlockTags.COLORED_VERTICAL_SHIPPING_CONTAINERS.tag, "Colored Vertical Shipping Containers");
                translate(ModBlockTags.COLORED_HORIZONTAL_BASIC_SHIPPING_CONTAINERS.tag, "Colored Horizontal Basic Shipping Containers");
                translate(ModBlockTags.COLORED_VERTICAL_BASIC_SHIPPING_CONTAINERS.tag, "Colored Vertical Basic Shipping Containers");

                // Item tags
                translate(ModItemTags.VIBRANT_VAULTS.tag, "Vibrant Vaults");
                translate(ModItemTags.HORIZONTAL_VAULTS.tag, "Horizontal Vaults");
                translate(ModItemTags.VERTICAL_VAULTS.tag, "Vertical Vaults");
                translate(ModItemTags.ITEM_VAULTS.tag, "Item Vaults");
                translate(ModItemTags.SHIPPING_CONTAINERS.tag, "Shipping Containers");
                translate(ModItemTags.BASIC_SHIPPING_CONTAINERS.tag, "Basic Shipping Containers");
                translate(ModItemTags.WHITE_VAULTS.tag, "White Vaults");
                translate(ModItemTags.ORANGE_VAULTS.tag, "Orange Vaults");
                translate(ModItemTags.MAGENTA_VAULTS.tag, "Magenta Vaults");
                translate(ModItemTags.LIGHT_BLUE_VAULTS.tag, "Light Blue Vaults");
                translate(ModItemTags.YELLOW_VAULTS.tag, "Yellow Vaults");
                translate(ModItemTags.LIME_VAULTS.tag, "Lime Vaults");
                translate(ModItemTags.PINK_VAULTS.tag, "Pink Vaults");
                translate(ModItemTags.GRAY_VAULTS.tag, "Gray Vaults");
                translate(ModItemTags.LIGHT_GRAY_VAULTS.tag, "Light Gray Vaults");
                translate(ModItemTags.CYAN_VAULTS.tag, "Cyan Vaults");
                translate(ModItemTags.PURPLE_VAULTS.tag, "Purple Vaults");
                translate(ModItemTags.BLUE_VAULTS.tag, "Blue Vaults");
                translate(ModItemTags.BROWN_VAULTS.tag, "Brown Vaults");
                translate(ModItemTags.GREEN_VAULTS.tag, "Green Vaults");
                translate(ModItemTags.RED_VAULTS.tag, "Red Vaults");
                translate(ModItemTags.BLACK_VAULTS.tag, "Black Vaults");
                translate(ModItemTags.BASE_VAULTS.tag, "Base Vaults");
                translate(ModItemTags.COLORED_HORIZONTAL_ITEM_VAULTS.tag, "Colored Horizontal Item Vaults");
                translate(ModItemTags.COLORED_VERTICAL_ITEM_VAULTS.tag, "Colored Vertical Item Vaults");
                translate(ModItemTags.COLORED_HORIZONTAL_SHIPPING_CONTAINERS.tag, "Colored Horizontal Shipping Containers");
                translate(ModItemTags.COLORED_VERTICAL_SHIPPING_CONTAINERS.tag, "Colored Vertical Shipping Containers");
                translate(ModItemTags.COLORED_HORIZONTAL_BASIC_SHIPPING_CONTAINERS.tag, "Colored Horizontal Basic Shipping Containers");
                translate(ModItemTags.COLORED_VERTICAL_BASIC_SHIPPING_CONTAINERS.tag, "Colored Vertical Basic Shipping Containers");
            }
        }.generate();
    }
}
