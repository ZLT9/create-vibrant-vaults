package net.zlt.create_vibrant_vaults.ct;

import com.simibubi.create.foundation.block.connected.AllCTTypes;
import com.simibubi.create.foundation.block.connected.CTSpriteShiftEntry;
import com.simibubi.create.foundation.block.connected.CTSpriteShifter;
import com.simibubi.create.foundation.utility.Couple;
import net.zlt.create_vibrant_vaults.CreateVibrantVaults;

public class AllSpriteShifts {
    private static Couple<CTSpriteShiftEntry> vault(String color, String name) {
        final String prefixed = "block/item_vault/" + color + "/vault_" + name;
        return Couple.createWithContext(medium -> CTSpriteShifter.getCT(AllCTTypes.RECTANGLE, CreateVibrantVaults.asResource(prefixed + "_small"), CreateVibrantVaults.asResource(medium ? prefixed + "_medium" : prefixed + "_large")));
    }

    private static Couple<CTSpriteShiftEntry> verticalVault(String color, String name) {
        final String prefixed = "block/vertical_item_vault/" + color + "/vault_" + name;
        return Couple.createWithContext(medium -> CTSpriteShifter.getCT(AllCTTypes.RECTANGLE, CreateVibrantVaults.asResource(prefixed + "_small"), CreateVibrantVaults.asResource(medium ? prefixed + "_medium" : prefixed + "_large")));
    }

    private static Couple<CTSpriteShiftEntry> shippingContainer(String color, String name) {
        final String prefixed = "block/shipping_container/" + color + "/vault_" + name;
        return Couple.createWithContext(medium -> CTSpriteShifter.getCT(AllCTTypes.RECTANGLE, CreateVibrantVaults.asResource(prefixed + "_small"), CreateVibrantVaults.asResource(medium ? prefixed + "_medium" : prefixed + "_large")));
    }

    private static Couple<CTSpriteShiftEntry> verticalShippingContainer(String color, String name) {
        final String prefixed = "block/vertical_shipping_container/" + color + "/vault_" + name;
        return Couple.createWithContext(medium -> CTSpriteShifter.getCT(AllCTTypes.RECTANGLE, CreateVibrantVaults.asResource(prefixed + "_small"), CreateVibrantVaults.asResource(medium ? prefixed + "_medium" : prefixed + "_large")));
    }

    private static Couple<CTSpriteShiftEntry> basicShippingContainer(String color, String name) {
        final String prefixed = "block/basic_shipping_container/" + color + "/vault_" + name;
        return Couple.createWithContext(medium -> CTSpriteShifter.getCT(AllCTTypes.RECTANGLE, CreateVibrantVaults.asResource(prefixed + "_small"), CreateVibrantVaults.asResource(medium ? prefixed + "_medium" : prefixed + "_large")));
    }

    private static Couple<CTSpriteShiftEntry> verticalBasicShippingContainer(String color, String name) {
        final String prefixed = "block/vertical_basic_shipping_container/" + color + "/vault_" + name;
        return Couple.createWithContext(medium -> CTSpriteShifter.getCT(AllCTTypes.RECTANGLE, CreateVibrantVaults.asResource(prefixed + "_small"), CreateVibrantVaults.asResource(medium ? prefixed + "_medium" : prefixed + "_large")));
    }

    public static final Couple<CTSpriteShiftEntry> BLACK_VAULT_TOP = vault("black", "top");
    public static final Couple<CTSpriteShiftEntry> BLACK_VAULT_FRONT = vault("black", "front");
    public static final Couple<CTSpriteShiftEntry> BLACK_VAULT_SIDE = vault("black", "side");
    public static final Couple<CTSpriteShiftEntry> BLACK_VAULT_BOTTOM = vault("black", "bottom");

    public static final Couple<CTSpriteShiftEntry> BLUE_VAULT_TOP = vault("blue", "top");
    public static final Couple<CTSpriteShiftEntry> BLUE_VAULT_FRONT = vault("blue", "front");
    public static final Couple<CTSpriteShiftEntry> BLUE_VAULT_SIDE = vault("blue", "side");
    public static final Couple<CTSpriteShiftEntry> BLUE_VAULT_BOTTOM = vault("blue", "bottom");

    public static final Couple<CTSpriteShiftEntry> BROWN_VAULT_TOP = vault("brown", "top");
    public static final Couple<CTSpriteShiftEntry> BROWN_VAULT_FRONT = vault("brown", "front");
    public static final Couple<CTSpriteShiftEntry> BROWN_VAULT_SIDE = vault("brown", "side");
    public static final Couple<CTSpriteShiftEntry> BROWN_VAULT_BOTTOM = vault("brown", "bottom");

    public static final Couple<CTSpriteShiftEntry> CYAN_VAULT_TOP = vault("cyan", "top");
    public static final Couple<CTSpriteShiftEntry> CYAN_VAULT_FRONT = vault("cyan", "front");
    public static final Couple<CTSpriteShiftEntry> CYAN_VAULT_SIDE = vault("cyan", "side");
    public static final Couple<CTSpriteShiftEntry> CYAN_VAULT_BOTTOM = vault("cyan", "bottom");

    public static final Couple<CTSpriteShiftEntry> GRAY_VAULT_TOP = vault("gray", "top");
    public static final Couple<CTSpriteShiftEntry> GRAY_VAULT_FRONT = vault("gray", "front");
    public static final Couple<CTSpriteShiftEntry> GRAY_VAULT_SIDE = vault("gray", "side");
    public static final Couple<CTSpriteShiftEntry> GRAY_VAULT_BOTTOM = vault("gray", "bottom");

    public static final Couple<CTSpriteShiftEntry> GREEN_VAULT_TOP = vault("green", "top");
    public static final Couple<CTSpriteShiftEntry> GREEN_VAULT_FRONT = vault("green", "front");
    public static final Couple<CTSpriteShiftEntry> GREEN_VAULT_SIDE = vault("green", "side");
    public static final Couple<CTSpriteShiftEntry> GREEN_VAULT_BOTTOM = vault("green", "bottom");

    public static final Couple<CTSpriteShiftEntry> LIGHT_BLUE_VAULT_TOP = vault("light_blue", "top");
    public static final Couple<CTSpriteShiftEntry> LIGHT_BLUE_VAULT_FRONT = vault("light_blue", "front");
    public static final Couple<CTSpriteShiftEntry> LIGHT_BLUE_VAULT_SIDE = vault("light_blue", "side");
    public static final Couple<CTSpriteShiftEntry> LIGHT_BLUE_VAULT_BOTTOM = vault("light_blue", "bottom");

    public static final Couple<CTSpriteShiftEntry> LIGHT_GRAY_VAULT_TOP = vault("light_gray", "top");
    public static final Couple<CTSpriteShiftEntry> LIGHT_GRAY_VAULT_FRONT = vault("light_gray", "front");
    public static final Couple<CTSpriteShiftEntry> LIGHT_GRAY_VAULT_SIDE = vault("light_gray", "side");
    public static final Couple<CTSpriteShiftEntry> LIGHT_GRAY_VAULT_BOTTOM = vault("light_gray", "bottom");

    public static final Couple<CTSpriteShiftEntry> LIME_VAULT_TOP = vault("lime", "top");
    public static final Couple<CTSpriteShiftEntry> LIME_VAULT_FRONT = vault("lime", "front");
    public static final Couple<CTSpriteShiftEntry> LIME_VAULT_SIDE = vault("lime", "side");
    public static final Couple<CTSpriteShiftEntry> LIME_VAULT_BOTTOM = vault("lime", "bottom");

    public static final Couple<CTSpriteShiftEntry> MAGENTA_VAULT_TOP = vault("magenta", "top");
    public static final Couple<CTSpriteShiftEntry> MAGENTA_VAULT_FRONT = vault("magenta", "front");
    public static final Couple<CTSpriteShiftEntry> MAGENTA_VAULT_SIDE = vault("magenta", "side");
    public static final Couple<CTSpriteShiftEntry> MAGENTA_VAULT_BOTTOM = vault("magenta", "bottom");

    public static final Couple<CTSpriteShiftEntry> ORANGE_VAULT_TOP = vault("orange", "top");
    public static final Couple<CTSpriteShiftEntry> ORANGE_VAULT_FRONT = vault("orange", "front");
    public static final Couple<CTSpriteShiftEntry> ORANGE_VAULT_SIDE = vault("orange", "side");
    public static final Couple<CTSpriteShiftEntry> ORANGE_VAULT_BOTTOM = vault("orange", "bottom");

    public static final Couple<CTSpriteShiftEntry> PINK_VAULT_TOP = vault("pink", "top");
    public static final Couple<CTSpriteShiftEntry> PINK_VAULT_FRONT = vault("pink", "front");
    public static final Couple<CTSpriteShiftEntry> PINK_VAULT_SIDE = vault("pink", "side");
    public static final Couple<CTSpriteShiftEntry> PINK_VAULT_BOTTOM = vault("pink", "bottom");

    public static final Couple<CTSpriteShiftEntry> PURPLE_VAULT_TOP = vault("purple", "top");
    public static final Couple<CTSpriteShiftEntry> PURPLE_VAULT_FRONT = vault("purple", "front");
    public static final Couple<CTSpriteShiftEntry> PURPLE_VAULT_SIDE = vault("purple", "side");
    public static final Couple<CTSpriteShiftEntry> PURPLE_VAULT_BOTTOM = vault("purple", "bottom");

    public static final Couple<CTSpriteShiftEntry> RED_VAULT_TOP = vault("red", "top");
    public static final Couple<CTSpriteShiftEntry> RED_VAULT_FRONT = vault("red", "front");
    public static final Couple<CTSpriteShiftEntry> RED_VAULT_SIDE = vault("red", "side");
    public static final Couple<CTSpriteShiftEntry> RED_VAULT_BOTTOM = vault("red", "bottom");

    public static final Couple<CTSpriteShiftEntry> WHITE_VAULT_TOP = vault("white", "top");
    public static final Couple<CTSpriteShiftEntry> WHITE_VAULT_FRONT = vault("white", "front");
    public static final Couple<CTSpriteShiftEntry> WHITE_VAULT_SIDE = vault("white", "side");
    public static final Couple<CTSpriteShiftEntry> WHITE_VAULT_BOTTOM = vault("white", "bottom");

    public static final Couple<CTSpriteShiftEntry> YELLOW_VAULT_TOP = vault("yellow", "top");
    public static final Couple<CTSpriteShiftEntry> YELLOW_VAULT_FRONT = vault("yellow", "front");
    public static final Couple<CTSpriteShiftEntry> YELLOW_VAULT_SIDE = vault("yellow", "side");
    public static final Couple<CTSpriteShiftEntry> YELLOW_VAULT_BOTTOM = vault("yellow", "bottom");

    public static final Couple<CTSpriteShiftEntry> VERTICAL_VAULT_TOP = verticalVault("base", "top");
    public static final Couple<CTSpriteShiftEntry> VERTICAL_VAULT_SIDE = verticalVault("base", "side");

    public static final Couple<CTSpriteShiftEntry> BLACK_VERTICAL_ITEM_VAULT_TOP = verticalVault("black", "top");
    public static final Couple<CTSpriteShiftEntry> BLACK_VERTICAL_ITEM_VAULT_SIDE = verticalVault("black", "side");

    public static final Couple<CTSpriteShiftEntry> BLUE_VERTICAL_ITEM_VAULT_TOP = verticalVault("blue", "top");
    public static final Couple<CTSpriteShiftEntry> BLUE_VERTICAL_ITEM_VAULT_SIDE = verticalVault("blue", "side");

    public static final Couple<CTSpriteShiftEntry> BROWN_VERTICAL_ITEM_VAULT_TOP = verticalVault("brown", "top");
    public static final Couple<CTSpriteShiftEntry> BROWN_VERTICAL_ITEM_VAULT_SIDE = verticalVault("brown", "side");

    public static final Couple<CTSpriteShiftEntry> CYAN_VERTICAL_ITEM_VAULT_TOP = verticalVault("cyan", "top");
    public static final Couple<CTSpriteShiftEntry> CYAN_VERTICAL_ITEM_VAULT_SIDE = verticalVault("cyan", "side");

    public static final Couple<CTSpriteShiftEntry> GRAY_VERTICAL_ITEM_VAULT_TOP = verticalVault("gray", "top");
    public static final Couple<CTSpriteShiftEntry> GRAY_VERTICAL_ITEM_VAULT_SIDE = verticalVault("gray", "side");

    public static final Couple<CTSpriteShiftEntry> GREEN_VERTICAL_ITEM_VAULT_TOP = verticalVault("green", "top");
    public static final Couple<CTSpriteShiftEntry> GREEN_VERTICAL_ITEM_VAULT_SIDE = verticalVault("green", "side");

    public static final Couple<CTSpriteShiftEntry> LIGHT_BLUE_VERTICAL_ITEM_VAULT_TOP = verticalVault("light_blue", "top");
    public static final Couple<CTSpriteShiftEntry> LIGHT_BLUE_VERTICAL_ITEM_VAULT_SIDE = verticalVault("light_blue", "side");

    public static final Couple<CTSpriteShiftEntry> LIGHT_GRAY_VERTICAL_ITEM_VAULT_TOP = verticalVault("light_gray", "top");
    public static final Couple<CTSpriteShiftEntry> LIGHT_GRAY_VERTICAL_ITEM_VAULT_SIDE = verticalVault("light_gray", "side");

    public static final Couple<CTSpriteShiftEntry> LIME_VERTICAL_ITEM_VAULT_TOP = verticalVault("lime", "top");
    public static final Couple<CTSpriteShiftEntry> LIME_VERTICAL_ITEM_VAULT_SIDE = verticalVault("lime", "side");

    public static final Couple<CTSpriteShiftEntry> MAGENTA_VERTICAL_ITEM_VAULT_TOP = verticalVault("magenta", "top");
    public static final Couple<CTSpriteShiftEntry> MAGENTA_VERTICAL_ITEM_VAULT_SIDE = verticalVault("magenta", "side");

    public static final Couple<CTSpriteShiftEntry> ORANGE_VERTICAL_ITEM_VAULT_TOP = verticalVault("orange", "top");
    public static final Couple<CTSpriteShiftEntry> ORANGE_VERTICAL_ITEM_VAULT_SIDE = verticalVault("orange", "side");

    public static final Couple<CTSpriteShiftEntry> PINK_VERTICAL_ITEM_VAULT_TOP = verticalVault("pink", "top");
    public static final Couple<CTSpriteShiftEntry> PINK_VERTICAL_ITEM_VAULT_SIDE = verticalVault("pink", "side");

    public static final Couple<CTSpriteShiftEntry> PURPLE_VERTICAL_ITEM_VAULT_TOP = verticalVault("purple", "top");
    public static final Couple<CTSpriteShiftEntry> PURPLE_VERTICAL_ITEM_VAULT_SIDE = verticalVault("purple", "side");

    public static final Couple<CTSpriteShiftEntry> RED_VERTICAL_ITEM_VAULT_TOP = verticalVault("red", "top");
    public static final Couple<CTSpriteShiftEntry> RED_VERTICAL_ITEM_VAULT_SIDE = verticalVault("red", "side");

    public static final Couple<CTSpriteShiftEntry> WHITE_VERTICAL_ITEM_VAULT_TOP = verticalVault("white", "top");
    public static final Couple<CTSpriteShiftEntry> WHITE_VERTICAL_ITEM_VAULT_SIDE = verticalVault("white", "side");

    public static final Couple<CTSpriteShiftEntry> YELLOW_VERTICAL_ITEM_VAULT_TOP = verticalVault("yellow", "top");
    public static final Couple<CTSpriteShiftEntry> YELLOW_VERTICAL_ITEM_VAULT_SIDE = verticalVault("yellow", "side");

    public static final Couple<CTSpriteShiftEntry> SHIPPING_CONTAINER_TOP = shippingContainer("base", "top");
    public static final Couple<CTSpriteShiftEntry> SHIPPING_CONTAINER_FRONT = shippingContainer("base", "front");
    public static final Couple<CTSpriteShiftEntry> SHIPPING_CONTAINER_SIDE = shippingContainer("base", "side");
    public static final Couple<CTSpriteShiftEntry> SHIPPING_CONTAINER_BOTTOM = shippingContainer("base", "bottom");

    public static final Couple<CTSpriteShiftEntry> BLACK_SHIPPING_CONTAINER_TOP = shippingContainer("black", "top");
    public static final Couple<CTSpriteShiftEntry> BLACK_SHIPPING_CONTAINER_FRONT = shippingContainer("black", "front");
    public static final Couple<CTSpriteShiftEntry> BLACK_SHIPPING_CONTAINER_SIDE = shippingContainer("black", "side");
    public static final Couple<CTSpriteShiftEntry> BLACK_SHIPPING_CONTAINER_BOTTOM = shippingContainer("black", "bottom");

    public static final Couple<CTSpriteShiftEntry> BLUE_SHIPPING_CONTAINER_TOP = shippingContainer("blue", "top");
    public static final Couple<CTSpriteShiftEntry> BLUE_SHIPPING_CONTAINER_FRONT = shippingContainer("blue", "front");
    public static final Couple<CTSpriteShiftEntry> BLUE_SHIPPING_CONTAINER_SIDE = shippingContainer("blue", "side");
    public static final Couple<CTSpriteShiftEntry> BLUE_SHIPPING_CONTAINER_BOTTOM = shippingContainer("blue", "bottom");

    public static final Couple<CTSpriteShiftEntry> BROWN_SHIPPING_CONTAINER_TOP = shippingContainer("brown", "top");
    public static final Couple<CTSpriteShiftEntry> BROWN_SHIPPING_CONTAINER_FRONT = shippingContainer("brown", "front");
    public static final Couple<CTSpriteShiftEntry> BROWN_SHIPPING_CONTAINER_SIDE = shippingContainer("brown", "side");
    public static final Couple<CTSpriteShiftEntry> BROWN_SHIPPING_CONTAINER_BOTTOM = shippingContainer("brown", "bottom");

    public static final Couple<CTSpriteShiftEntry> CYAN_SHIPPING_CONTAINER_TOP = shippingContainer("cyan", "top");
    public static final Couple<CTSpriteShiftEntry> CYAN_SHIPPING_CONTAINER_FRONT = shippingContainer("cyan", "front");
    public static final Couple<CTSpriteShiftEntry> CYAN_SHIPPING_CONTAINER_SIDE = shippingContainer("cyan", "side");
    public static final Couple<CTSpriteShiftEntry> CYAN_SHIPPING_CONTAINER_BOTTOM = shippingContainer("cyan", "bottom");

    public static final Couple<CTSpriteShiftEntry> GRAY_SHIPPING_CONTAINER_TOP = shippingContainer("gray", "top");
    public static final Couple<CTSpriteShiftEntry> GRAY_SHIPPING_CONTAINER_FRONT = shippingContainer("gray", "front");
    public static final Couple<CTSpriteShiftEntry> GRAY_SHIPPING_CONTAINER_SIDE = shippingContainer("gray", "side");
    public static final Couple<CTSpriteShiftEntry> GRAY_SHIPPING_CONTAINER_BOTTOM = shippingContainer("gray", "bottom");

    public static final Couple<CTSpriteShiftEntry> GREEN_SHIPPING_CONTAINER_TOP = shippingContainer("green", "top");
    public static final Couple<CTSpriteShiftEntry> GREEN_SHIPPING_CONTAINER_FRONT = shippingContainer("green", "front");
    public static final Couple<CTSpriteShiftEntry> GREEN_SHIPPING_CONTAINER_SIDE = shippingContainer("green", "side");
    public static final Couple<CTSpriteShiftEntry> GREEN_SHIPPING_CONTAINER_BOTTOM = shippingContainer("green", "bottom");

    public static final Couple<CTSpriteShiftEntry> LIGHT_BLUE_SHIPPING_CONTAINER_TOP = shippingContainer("light_blue", "top");
    public static final Couple<CTSpriteShiftEntry> LIGHT_BLUE_SHIPPING_CONTAINER_FRONT = shippingContainer("light_blue", "front");
    public static final Couple<CTSpriteShiftEntry> LIGHT_BLUE_SHIPPING_CONTAINER_SIDE = shippingContainer("light_blue", "side");
    public static final Couple<CTSpriteShiftEntry> LIGHT_BLUE_SHIPPING_CONTAINER_BOTTOM = shippingContainer("light_blue", "bottom");

    public static final Couple<CTSpriteShiftEntry> LIGHT_GRAY_SHIPPING_CONTAINER_TOP = shippingContainer("light_gray", "top");
    public static final Couple<CTSpriteShiftEntry> LIGHT_GRAY_SHIPPING_CONTAINER_FRONT = shippingContainer("light_gray", "front");
    public static final Couple<CTSpriteShiftEntry> LIGHT_GRAY_SHIPPING_CONTAINER_SIDE = shippingContainer("light_gray", "side");
    public static final Couple<CTSpriteShiftEntry> LIGHT_GRAY_SHIPPING_CONTAINER_BOTTOM = shippingContainer("light_gray", "bottom");

    public static final Couple<CTSpriteShiftEntry> LIME_SHIPPING_CONTAINER_TOP = shippingContainer("lime", "top");
    public static final Couple<CTSpriteShiftEntry> LIME_SHIPPING_CONTAINER_FRONT = shippingContainer("lime", "front");
    public static final Couple<CTSpriteShiftEntry> LIME_SHIPPING_CONTAINER_SIDE = shippingContainer("lime", "side");
    public static final Couple<CTSpriteShiftEntry> LIME_SHIPPING_CONTAINER_BOTTOM = shippingContainer("lime", "bottom");

    public static final Couple<CTSpriteShiftEntry> MAGENTA_SHIPPING_CONTAINER_TOP = shippingContainer("magenta", "top");
    public static final Couple<CTSpriteShiftEntry> MAGENTA_SHIPPING_CONTAINER_FRONT = shippingContainer("magenta", "front");
    public static final Couple<CTSpriteShiftEntry> MAGENTA_SHIPPING_CONTAINER_SIDE = shippingContainer("magenta", "side");
    public static final Couple<CTSpriteShiftEntry> MAGENTA_SHIPPING_CONTAINER_BOTTOM = shippingContainer("magenta", "bottom");

    public static final Couple<CTSpriteShiftEntry> ORANGE_SHIPPING_CONTAINER_TOP = shippingContainer("orange", "top");
    public static final Couple<CTSpriteShiftEntry> ORANGE_SHIPPING_CONTAINER_FRONT = shippingContainer("orange", "front");
    public static final Couple<CTSpriteShiftEntry> ORANGE_SHIPPING_CONTAINER_SIDE = shippingContainer("orange", "side");
    public static final Couple<CTSpriteShiftEntry> ORANGE_SHIPPING_CONTAINER_BOTTOM = shippingContainer("orange", "bottom");

    public static final Couple<CTSpriteShiftEntry> PINK_SHIPPING_CONTAINER_TOP = shippingContainer("pink", "top");
    public static final Couple<CTSpriteShiftEntry> PINK_SHIPPING_CONTAINER_FRONT = shippingContainer("pink", "front");
    public static final Couple<CTSpriteShiftEntry> PINK_SHIPPING_CONTAINER_SIDE = shippingContainer("pink", "side");
    public static final Couple<CTSpriteShiftEntry> PINK_SHIPPING_CONTAINER_BOTTOM = shippingContainer("pink", "bottom");

    public static final Couple<CTSpriteShiftEntry> PURPLE_SHIPPING_CONTAINER_TOP = shippingContainer("purple", "top");
    public static final Couple<CTSpriteShiftEntry> PURPLE_SHIPPING_CONTAINER_FRONT = shippingContainer("purple", "front");
    public static final Couple<CTSpriteShiftEntry> PURPLE_SHIPPING_CONTAINER_SIDE = shippingContainer("purple", "side");
    public static final Couple<CTSpriteShiftEntry> PURPLE_SHIPPING_CONTAINER_BOTTOM = shippingContainer("purple", "bottom");

    public static final Couple<CTSpriteShiftEntry> RED_SHIPPING_CONTAINER_TOP = shippingContainer("red", "top");
    public static final Couple<CTSpriteShiftEntry> RED_SHIPPING_CONTAINER_FRONT = shippingContainer("red", "front");
    public static final Couple<CTSpriteShiftEntry> RED_SHIPPING_CONTAINER_SIDE = shippingContainer("red", "side");
    public static final Couple<CTSpriteShiftEntry> RED_SHIPPING_CONTAINER_BOTTOM = shippingContainer("red", "bottom");

    public static final Couple<CTSpriteShiftEntry> WHITE_SHIPPING_CONTAINER_TOP = shippingContainer("white", "top");
    public static final Couple<CTSpriteShiftEntry> WHITE_SHIPPING_CONTAINER_FRONT = shippingContainer("white", "front");
    public static final Couple<CTSpriteShiftEntry> WHITE_SHIPPING_CONTAINER_SIDE = shippingContainer("white", "side");
    public static final Couple<CTSpriteShiftEntry> WHITE_SHIPPING_CONTAINER_BOTTOM = shippingContainer("white", "bottom");

    public static final Couple<CTSpriteShiftEntry> YELLOW_SHIPPING_CONTAINER_TOP = shippingContainer("yellow", "top");
    public static final Couple<CTSpriteShiftEntry> YELLOW_SHIPPING_CONTAINER_FRONT = shippingContainer("yellow", "front");
    public static final Couple<CTSpriteShiftEntry> YELLOW_SHIPPING_CONTAINER_SIDE = shippingContainer("yellow", "side");
    public static final Couple<CTSpriteShiftEntry> YELLOW_SHIPPING_CONTAINER_BOTTOM = shippingContainer("yellow", "bottom");

    public static final Couple<CTSpriteShiftEntry> VERTICAL_SHIPPING_CONTAINER_TOP = verticalShippingContainer("base", "top");
    public static final Couple<CTSpriteShiftEntry> VERTICAL_SHIPPING_CONTAINER_SIDE = verticalShippingContainer("base", "side");

    public static final Couple<CTSpriteShiftEntry> BLACK_VERTICAL_SHIPPING_CONTAINER_TOP = verticalShippingContainer("black", "top");
    public static final Couple<CTSpriteShiftEntry> BLACK_VERTICAL_SHIPPING_CONTAINER_SIDE = verticalShippingContainer("black", "side");

    public static final Couple<CTSpriteShiftEntry> BLUE_VERTICAL_SHIPPING_CONTAINER_TOP = verticalShippingContainer("blue", "top");
    public static final Couple<CTSpriteShiftEntry> BLUE_VERTICAL_SHIPPING_CONTAINER_SIDE = verticalShippingContainer("blue", "side");

    public static final Couple<CTSpriteShiftEntry> BROWN_VERTICAL_SHIPPING_CONTAINER_TOP = verticalShippingContainer("brown", "top");
    public static final Couple<CTSpriteShiftEntry> BROWN_VERTICAL_SHIPPING_CONTAINER_SIDE = verticalShippingContainer("brown", "side");

    public static final Couple<CTSpriteShiftEntry> CYAN_VERTICAL_SHIPPING_CONTAINER_TOP = verticalShippingContainer("cyan", "top");
    public static final Couple<CTSpriteShiftEntry> CYAN_VERTICAL_SHIPPING_CONTAINER_SIDE = verticalShippingContainer("cyan", "side");

    public static final Couple<CTSpriteShiftEntry> GRAY_VERTICAL_SHIPPING_CONTAINER_TOP = verticalShippingContainer("gray", "top");
    public static final Couple<CTSpriteShiftEntry> GRAY_VERTICAL_SHIPPING_CONTAINER_SIDE = verticalShippingContainer("gray", "side");

    public static final Couple<CTSpriteShiftEntry> GREEN_VERTICAL_SHIPPING_CONTAINER_TOP = verticalShippingContainer("green", "top");
    public static final Couple<CTSpriteShiftEntry> GREEN_VERTICAL_SHIPPING_CONTAINER_SIDE = verticalShippingContainer("green", "side");

    public static final Couple<CTSpriteShiftEntry> LIGHT_BLUE_VERTICAL_SHIPPING_CONTAINER_TOP = verticalShippingContainer("light_blue", "top");
    public static final Couple<CTSpriteShiftEntry> LIGHT_BLUE_VERTICAL_SHIPPING_CONTAINER_SIDE = verticalShippingContainer("light_blue", "side");

    public static final Couple<CTSpriteShiftEntry> LIGHT_GRAY_VERTICAL_SHIPPING_CONTAINER_TOP = verticalShippingContainer("light_gray", "top");
    public static final Couple<CTSpriteShiftEntry> LIGHT_GRAY_VERTICAL_SHIPPING_CONTAINER_SIDE = verticalShippingContainer("light_gray", "side");

    public static final Couple<CTSpriteShiftEntry> LIME_VERTICAL_SHIPPING_CONTAINER_TOP = verticalShippingContainer("lime", "top");
    public static final Couple<CTSpriteShiftEntry> LIME_VERTICAL_SHIPPING_CONTAINER_SIDE = verticalShippingContainer("lime", "side");

    public static final Couple<CTSpriteShiftEntry> MAGENTA_VERTICAL_SHIPPING_CONTAINER_TOP = verticalShippingContainer("magenta", "top");
    public static final Couple<CTSpriteShiftEntry> MAGENTA_VERTICAL_SHIPPING_CONTAINER_SIDE = verticalShippingContainer("magenta", "side");

    public static final Couple<CTSpriteShiftEntry> ORANGE_VERTICAL_SHIPPING_CONTAINER_TOP = verticalShippingContainer("orange", "top");
    public static final Couple<CTSpriteShiftEntry> ORANGE_VERTICAL_SHIPPING_CONTAINER_SIDE = verticalShippingContainer("orange", "side");

    public static final Couple<CTSpriteShiftEntry> PINK_VERTICAL_SHIPPING_CONTAINER_TOP = verticalShippingContainer("pink", "top");
    public static final Couple<CTSpriteShiftEntry> PINK_VERTICAL_SHIPPING_CONTAINER_SIDE = verticalShippingContainer("pink", "side");

    public static final Couple<CTSpriteShiftEntry> PURPLE_VERTICAL_SHIPPING_CONTAINER_TOP = verticalShippingContainer("purple", "top");
    public static final Couple<CTSpriteShiftEntry> PURPLE_VERTICAL_SHIPPING_CONTAINER_SIDE = verticalShippingContainer("purple", "side");

    public static final Couple<CTSpriteShiftEntry> RED_VERTICAL_SHIPPING_CONTAINER_TOP = verticalShippingContainer("red", "top");
    public static final Couple<CTSpriteShiftEntry> RED_VERTICAL_SHIPPING_CONTAINER_SIDE = verticalShippingContainer("red", "side");

    public static final Couple<CTSpriteShiftEntry> WHITE_VERTICAL_SHIPPING_CONTAINER_TOP = verticalShippingContainer("white", "top");
    public static final Couple<CTSpriteShiftEntry> WHITE_VERTICAL_SHIPPING_CONTAINER_SIDE = verticalShippingContainer("white", "side");

    public static final Couple<CTSpriteShiftEntry> YELLOW_VERTICAL_SHIPPING_CONTAINER_TOP = verticalShippingContainer("yellow", "top");
    public static final Couple<CTSpriteShiftEntry> YELLOW_VERTICAL_SHIPPING_CONTAINER_SIDE = verticalShippingContainer("yellow", "side");

    public static final Couple<CTSpriteShiftEntry> BASIC_SHIPPING_CONTAINER_TOP = basicShippingContainer("base", "top");
    public static final Couple<CTSpriteShiftEntry> BASIC_SHIPPING_CONTAINER_FRONT = basicShippingContainer("base", "front");
    public static final Couple<CTSpriteShiftEntry> BASIC_SHIPPING_CONTAINER_SIDE = basicShippingContainer("base", "side");
    public static final Couple<CTSpriteShiftEntry> BASIC_SHIPPING_CONTAINER_BOTTOM = basicShippingContainer("base", "bottom");

    public static final Couple<CTSpriteShiftEntry> BLACK_BASIC_SHIPPING_CONTAINER_TOP = basicShippingContainer("black", "top");
    public static final Couple<CTSpriteShiftEntry> BLACK_BASIC_SHIPPING_CONTAINER_FRONT = basicShippingContainer("black", "front");
    public static final Couple<CTSpriteShiftEntry> BLACK_BASIC_SHIPPING_CONTAINER_SIDE = basicShippingContainer("black", "side");
    public static final Couple<CTSpriteShiftEntry> BLACK_BASIC_SHIPPING_CONTAINER_BOTTOM = basicShippingContainer("black", "bottom");

    public static final Couple<CTSpriteShiftEntry> BLUE_BASIC_SHIPPING_CONTAINER_TOP = basicShippingContainer("blue", "top");
    public static final Couple<CTSpriteShiftEntry> BLUE_BASIC_SHIPPING_CONTAINER_FRONT = basicShippingContainer("blue", "front");
    public static final Couple<CTSpriteShiftEntry> BLUE_BASIC_SHIPPING_CONTAINER_SIDE = basicShippingContainer("blue", "side");
    public static final Couple<CTSpriteShiftEntry> BLUE_BASIC_SHIPPING_CONTAINER_BOTTOM = basicShippingContainer("blue", "bottom");

    public static final Couple<CTSpriteShiftEntry> BROWN_BASIC_SHIPPING_CONTAINER_TOP = basicShippingContainer("brown", "top");
    public static final Couple<CTSpriteShiftEntry> BROWN_BASIC_SHIPPING_CONTAINER_FRONT = basicShippingContainer("brown", "front");
    public static final Couple<CTSpriteShiftEntry> BROWN_BASIC_SHIPPING_CONTAINER_SIDE = basicShippingContainer("brown", "side");
    public static final Couple<CTSpriteShiftEntry> BROWN_BASIC_SHIPPING_CONTAINER_BOTTOM = basicShippingContainer("brown", "bottom");

    public static final Couple<CTSpriteShiftEntry> CYAN_BASIC_SHIPPING_CONTAINER_TOP = basicShippingContainer("cyan", "top");
    public static final Couple<CTSpriteShiftEntry> CYAN_BASIC_SHIPPING_CONTAINER_FRONT = basicShippingContainer("cyan", "front");
    public static final Couple<CTSpriteShiftEntry> CYAN_BASIC_SHIPPING_CONTAINER_SIDE = basicShippingContainer("cyan", "side");
    public static final Couple<CTSpriteShiftEntry> CYAN_BASIC_SHIPPING_CONTAINER_BOTTOM = basicShippingContainer("cyan", "bottom");

    public static final Couple<CTSpriteShiftEntry> GRAY_BASIC_SHIPPING_CONTAINER_TOP = basicShippingContainer("gray", "top");
    public static final Couple<CTSpriteShiftEntry> GRAY_BASIC_SHIPPING_CONTAINER_FRONT = basicShippingContainer("gray", "front");
    public static final Couple<CTSpriteShiftEntry> GRAY_BASIC_SHIPPING_CONTAINER_SIDE = basicShippingContainer("gray", "side");
    public static final Couple<CTSpriteShiftEntry> GRAY_BASIC_SHIPPING_CONTAINER_BOTTOM = basicShippingContainer("gray", "bottom");

    public static final Couple<CTSpriteShiftEntry> GREEN_BASIC_SHIPPING_CONTAINER_TOP = basicShippingContainer("green", "top");
    public static final Couple<CTSpriteShiftEntry> GREEN_BASIC_SHIPPING_CONTAINER_FRONT = basicShippingContainer("green", "front");
    public static final Couple<CTSpriteShiftEntry> GREEN_BASIC_SHIPPING_CONTAINER_SIDE = basicShippingContainer("green", "side");
    public static final Couple<CTSpriteShiftEntry> GREEN_BASIC_SHIPPING_CONTAINER_BOTTOM = basicShippingContainer("green", "bottom");

    public static final Couple<CTSpriteShiftEntry> LIGHT_BLUE_BASIC_SHIPPING_CONTAINER_TOP = basicShippingContainer("light_blue", "top");
    public static final Couple<CTSpriteShiftEntry> LIGHT_BLUE_BASIC_SHIPPING_CONTAINER_FRONT = basicShippingContainer("light_blue", "front");
    public static final Couple<CTSpriteShiftEntry> LIGHT_BLUE_BASIC_SHIPPING_CONTAINER_SIDE = basicShippingContainer("light_blue", "side");
    public static final Couple<CTSpriteShiftEntry> LIGHT_BLUE_BASIC_SHIPPING_CONTAINER_BOTTOM = basicShippingContainer("light_blue", "bottom");

    public static final Couple<CTSpriteShiftEntry> LIGHT_GRAY_BASIC_SHIPPING_CONTAINER_TOP = basicShippingContainer("light_gray", "top");
    public static final Couple<CTSpriteShiftEntry> LIGHT_GRAY_BASIC_SHIPPING_CONTAINER_FRONT = basicShippingContainer("light_gray", "front");
    public static final Couple<CTSpriteShiftEntry> LIGHT_GRAY_BASIC_SHIPPING_CONTAINER_SIDE = basicShippingContainer("light_gray", "side");
    public static final Couple<CTSpriteShiftEntry> LIGHT_GRAY_BASIC_SHIPPING_CONTAINER_BOTTOM = basicShippingContainer("light_gray", "bottom");

    public static final Couple<CTSpriteShiftEntry> LIME_BASIC_SHIPPING_CONTAINER_TOP = basicShippingContainer("lime", "top");
    public static final Couple<CTSpriteShiftEntry> LIME_BASIC_SHIPPING_CONTAINER_FRONT = basicShippingContainer("lime", "front");
    public static final Couple<CTSpriteShiftEntry> LIME_BASIC_SHIPPING_CONTAINER_SIDE = basicShippingContainer("lime", "side");
    public static final Couple<CTSpriteShiftEntry> LIME_BASIC_SHIPPING_CONTAINER_BOTTOM = basicShippingContainer("lime", "bottom");

    public static final Couple<CTSpriteShiftEntry> MAGENTA_BASIC_SHIPPING_CONTAINER_TOP = basicShippingContainer("magenta", "top");
    public static final Couple<CTSpriteShiftEntry> MAGENTA_BASIC_SHIPPING_CONTAINER_FRONT = basicShippingContainer("magenta", "front");
    public static final Couple<CTSpriteShiftEntry> MAGENTA_BASIC_SHIPPING_CONTAINER_SIDE = basicShippingContainer("magenta", "side");
    public static final Couple<CTSpriteShiftEntry> MAGENTA_BASIC_SHIPPING_CONTAINER_BOTTOM = basicShippingContainer("magenta", "bottom");

    public static final Couple<CTSpriteShiftEntry> ORANGE_BASIC_SHIPPING_CONTAINER_TOP = basicShippingContainer("orange", "top");
    public static final Couple<CTSpriteShiftEntry> ORANGE_BASIC_SHIPPING_CONTAINER_FRONT = basicShippingContainer("orange", "front");
    public static final Couple<CTSpriteShiftEntry> ORANGE_BASIC_SHIPPING_CONTAINER_SIDE = basicShippingContainer("orange", "side");
    public static final Couple<CTSpriteShiftEntry> ORANGE_BASIC_SHIPPING_CONTAINER_BOTTOM = basicShippingContainer("orange", "bottom");

    public static final Couple<CTSpriteShiftEntry> PINK_BASIC_SHIPPING_CONTAINER_TOP = basicShippingContainer("pink", "top");
    public static final Couple<CTSpriteShiftEntry> PINK_BASIC_SHIPPING_CONTAINER_FRONT = basicShippingContainer("pink", "front");
    public static final Couple<CTSpriteShiftEntry> PINK_BASIC_SHIPPING_CONTAINER_SIDE = basicShippingContainer("pink", "side");
    public static final Couple<CTSpriteShiftEntry> PINK_BASIC_SHIPPING_CONTAINER_BOTTOM = basicShippingContainer("pink", "bottom");

    public static final Couple<CTSpriteShiftEntry> PURPLE_BASIC_SHIPPING_CONTAINER_TOP = basicShippingContainer("purple", "top");
    public static final Couple<CTSpriteShiftEntry> PURPLE_BASIC_SHIPPING_CONTAINER_FRONT = basicShippingContainer("purple", "front");
    public static final Couple<CTSpriteShiftEntry> PURPLE_BASIC_SHIPPING_CONTAINER_SIDE = basicShippingContainer("purple", "side");
    public static final Couple<CTSpriteShiftEntry> PURPLE_BASIC_SHIPPING_CONTAINER_BOTTOM = basicShippingContainer("purple", "bottom");

    public static final Couple<CTSpriteShiftEntry> RED_BASIC_SHIPPING_CONTAINER_TOP = basicShippingContainer("red", "top");
    public static final Couple<CTSpriteShiftEntry> RED_BASIC_SHIPPING_CONTAINER_FRONT = basicShippingContainer("red", "front");
    public static final Couple<CTSpriteShiftEntry> RED_BASIC_SHIPPING_CONTAINER_SIDE = basicShippingContainer("red", "side");
    public static final Couple<CTSpriteShiftEntry> RED_BASIC_SHIPPING_CONTAINER_BOTTOM = basicShippingContainer("red", "bottom");

    public static final Couple<CTSpriteShiftEntry> WHITE_BASIC_SHIPPING_CONTAINER_TOP = basicShippingContainer("white", "top");
    public static final Couple<CTSpriteShiftEntry> WHITE_BASIC_SHIPPING_CONTAINER_FRONT = basicShippingContainer("white", "front");
    public static final Couple<CTSpriteShiftEntry> WHITE_BASIC_SHIPPING_CONTAINER_SIDE = basicShippingContainer("white", "side");
    public static final Couple<CTSpriteShiftEntry> WHITE_BASIC_SHIPPING_CONTAINER_BOTTOM = basicShippingContainer("white", "bottom");

    public static final Couple<CTSpriteShiftEntry> YELLOW_BASIC_SHIPPING_CONTAINER_TOP = basicShippingContainer("yellow", "top");
    public static final Couple<CTSpriteShiftEntry> YELLOW_BASIC_SHIPPING_CONTAINER_FRONT = basicShippingContainer("yellow", "front");
    public static final Couple<CTSpriteShiftEntry> YELLOW_BASIC_SHIPPING_CONTAINER_SIDE = basicShippingContainer("yellow", "side");
    public static final Couple<CTSpriteShiftEntry> YELLOW_BASIC_SHIPPING_CONTAINER_BOTTOM = basicShippingContainer("yellow", "bottom");

    public static final Couple<CTSpriteShiftEntry> VERTICAL_BASIC_SHIPPING_CONTAINER_TOP = verticalBasicShippingContainer("base", "top");
    public static final Couple<CTSpriteShiftEntry> VERTICAL_BASIC_SHIPPING_CONTAINER_SIDE = verticalBasicShippingContainer("base", "side");

    public static final Couple<CTSpriteShiftEntry> BLACK_VERTICAL_BASIC_SHIPPING_CONTAINER_TOP = verticalBasicShippingContainer("black", "top");
    public static final Couple<CTSpriteShiftEntry> BLACK_VERTICAL_BASIC_SHIPPING_CONTAINER_SIDE = verticalBasicShippingContainer("black", "side");

    public static final Couple<CTSpriteShiftEntry> BLUE_VERTICAL_BASIC_SHIPPING_CONTAINER_TOP = verticalBasicShippingContainer("blue", "top");
    public static final Couple<CTSpriteShiftEntry> BLUE_VERTICAL_BASIC_SHIPPING_CONTAINER_SIDE = verticalBasicShippingContainer("blue", "side");

    public static final Couple<CTSpriteShiftEntry> BROWN_VERTICAL_BASIC_SHIPPING_CONTAINER_TOP = verticalBasicShippingContainer("brown", "top");
    public static final Couple<CTSpriteShiftEntry> BROWN_VERTICAL_BASIC_SHIPPING_CONTAINER_SIDE = verticalBasicShippingContainer("brown", "side");

    public static final Couple<CTSpriteShiftEntry> CYAN_VERTICAL_BASIC_SHIPPING_CONTAINER_TOP = verticalBasicShippingContainer("cyan", "top");
    public static final Couple<CTSpriteShiftEntry> CYAN_VERTICAL_BASIC_SHIPPING_CONTAINER_SIDE = verticalBasicShippingContainer("cyan", "side");

    public static final Couple<CTSpriteShiftEntry> GRAY_VERTICAL_BASIC_SHIPPING_CONTAINER_TOP = verticalBasicShippingContainer("gray", "top");
    public static final Couple<CTSpriteShiftEntry> GRAY_VERTICAL_BASIC_SHIPPING_CONTAINER_SIDE = verticalBasicShippingContainer("gray", "side");

    public static final Couple<CTSpriteShiftEntry> GREEN_VERTICAL_BASIC_SHIPPING_CONTAINER_TOP = verticalBasicShippingContainer("green", "top");
    public static final Couple<CTSpriteShiftEntry> GREEN_VERTICAL_BASIC_SHIPPING_CONTAINER_SIDE = verticalBasicShippingContainer("green", "side");

    public static final Couple<CTSpriteShiftEntry> LIGHT_BLUE_VERTICAL_BASIC_SHIPPING_CONTAINER_TOP = verticalBasicShippingContainer("light_blue", "top");
    public static final Couple<CTSpriteShiftEntry> LIGHT_BLUE_VERTICAL_BASIC_SHIPPING_CONTAINER_SIDE = verticalBasicShippingContainer("light_blue", "side");

    public static final Couple<CTSpriteShiftEntry> LIGHT_GRAY_VERTICAL_BASIC_SHIPPING_CONTAINER_TOP = verticalBasicShippingContainer("light_gray", "top");
    public static final Couple<CTSpriteShiftEntry> LIGHT_GRAY_VERTICAL_BASIC_SHIPPING_CONTAINER_SIDE = verticalBasicShippingContainer("light_gray", "side");

    public static final Couple<CTSpriteShiftEntry> LIME_VERTICAL_BASIC_SHIPPING_CONTAINER_TOP = verticalBasicShippingContainer("lime", "top");
    public static final Couple<CTSpriteShiftEntry> LIME_VERTICAL_BASIC_SHIPPING_CONTAINER_SIDE = verticalBasicShippingContainer("lime", "side");

    public static final Couple<CTSpriteShiftEntry> MAGENTA_VERTICAL_BASIC_SHIPPING_CONTAINER_TOP = verticalBasicShippingContainer("magenta", "top");
    public static final Couple<CTSpriteShiftEntry> MAGENTA_VERTICAL_BASIC_SHIPPING_CONTAINER_SIDE = verticalBasicShippingContainer("magenta", "side");

    public static final Couple<CTSpriteShiftEntry> ORANGE_VERTICAL_BASIC_SHIPPING_CONTAINER_TOP = verticalBasicShippingContainer("orange", "top");
    public static final Couple<CTSpriteShiftEntry> ORANGE_VERTICAL_BASIC_SHIPPING_CONTAINER_SIDE = verticalBasicShippingContainer("orange", "side");

    public static final Couple<CTSpriteShiftEntry> PINK_VERTICAL_BASIC_SHIPPING_CONTAINER_TOP = verticalBasicShippingContainer("pink", "top");
    public static final Couple<CTSpriteShiftEntry> PINK_VERTICAL_BASIC_SHIPPING_CONTAINER_SIDE = verticalBasicShippingContainer("pink", "side");

    public static final Couple<CTSpriteShiftEntry> PURPLE_VERTICAL_BASIC_SHIPPING_CONTAINER_TOP = verticalBasicShippingContainer("purple", "top");
    public static final Couple<CTSpriteShiftEntry> PURPLE_VERTICAL_BASIC_SHIPPING_CONTAINER_SIDE = verticalBasicShippingContainer("purple", "side");

    public static final Couple<CTSpriteShiftEntry> RED_VERTICAL_BASIC_SHIPPING_CONTAINER_TOP = verticalBasicShippingContainer("red", "top");
    public static final Couple<CTSpriteShiftEntry> RED_VERTICAL_BASIC_SHIPPING_CONTAINER_SIDE = verticalBasicShippingContainer("red", "side");

    public static final Couple<CTSpriteShiftEntry> WHITE_VERTICAL_BASIC_SHIPPING_CONTAINER_TOP = verticalBasicShippingContainer("white", "top");
    public static final Couple<CTSpriteShiftEntry> WHITE_VERTICAL_BASIC_SHIPPING_CONTAINER_SIDE = verticalBasicShippingContainer("white", "side");

    public static final Couple<CTSpriteShiftEntry> YELLOW_VERTICAL_BASIC_SHIPPING_CONTAINER_TOP = verticalBasicShippingContainer("yellow", "top");
    public static final Couple<CTSpriteShiftEntry> YELLOW_VERTICAL_BASIC_SHIPPING_CONTAINER_SIDE = verticalBasicShippingContainer("yellow", "side");

    public static void register() {}
}
