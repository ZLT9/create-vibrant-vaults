package net.zlt.create_vibrant_vaults.block.entity;

import com.tterrag.registrate.util.entry.BlockEntityEntry;
import net.zlt.create_vibrant_vaults.CreateVibrantVaults;
import net.zlt.create_vibrant_vaults.block.AllBlocks;
import net.zlt.create_vibrant_vaults.block.entity.basic_shipping_container.*;
import net.zlt.create_vibrant_vaults.block.entity.basic_shipping_container.vertical.*;
import net.zlt.create_vibrant_vaults.block.entity.item_vault.*;
import net.zlt.create_vibrant_vaults.block.entity.item_vault.vertical.*;
import net.zlt.create_vibrant_vaults.block.entity.shipping_container.*;
import net.zlt.create_vibrant_vaults.block.entity.shipping_container.vertical.*;

public class AllBlockEntityTypes {
    public static final BlockEntityEntry<BlackItemVaultBlockEntity> BLACK_ITEM_VAULT = CreateVibrantVaults.REGISTRATE.blockEntity("black_item_vault", BlackItemVaultBlockEntity::new)
        .validBlocks(AllBlocks.BLACK_ITEM_VAULT)
        .register();

    public static final BlockEntityEntry<BlueItemVaultBlockEntity> BLUE_ITEM_VAULT = CreateVibrantVaults.REGISTRATE.blockEntity("blue_item_vault", BlueItemVaultBlockEntity::new)
        .validBlocks(AllBlocks.BLUE_ITEM_VAULT)
        .register();

    public static final BlockEntityEntry<BrownItemVaultBlockEntity> BROWN_ITEM_VAULT = CreateVibrantVaults.REGISTRATE.blockEntity("brown_item_vault", BrownItemVaultBlockEntity::new)
        .validBlocks(AllBlocks.BROWN_ITEM_VAULT)
        .register();

    public static final BlockEntityEntry<CyanItemVaultBlockEntity> CYAN_ITEM_VAULT = CreateVibrantVaults.REGISTRATE.blockEntity("cyan_item_vault", CyanItemVaultBlockEntity::new)
        .validBlocks(AllBlocks.CYAN_ITEM_VAULT)
        .register();

    public static final BlockEntityEntry<GrayItemVaultBlockEntity> GRAY_ITEM_VAULT = CreateVibrantVaults.REGISTRATE.blockEntity("gray_item_vault", GrayItemVaultBlockEntity::new)
        .validBlocks(AllBlocks.GRAY_ITEM_VAULT)
        .register();

    public static final BlockEntityEntry<GreenItemVaultBlockEntity> GREEN_ITEM_VAULT = CreateVibrantVaults.REGISTRATE.blockEntity("green_item_vault", GreenItemVaultBlockEntity::new)
        .validBlocks(AllBlocks.GREEN_ITEM_VAULT)
        .register();

    public static final BlockEntityEntry<LightBlueItemVaultBlockEntity> LIGHT_BLUE_ITEM_VAULT = CreateVibrantVaults.REGISTRATE.blockEntity("light_blue_item_vault", LightBlueItemVaultBlockEntity::new)
        .validBlocks(AllBlocks.LIGHT_BLUE_ITEM_VAULT)
        .register();

    public static final BlockEntityEntry<LightGrayItemVaultBlockEntity> LIGHT_GRAY_ITEM_VAULT = CreateVibrantVaults.REGISTRATE.blockEntity("light_gray_item_vault", LightGrayItemVaultBlockEntity::new)
        .validBlocks(AllBlocks.LIGHT_GRAY_ITEM_VAULT)
        .register();

    public static final BlockEntityEntry<LimeItemVaultBlockEntity> LIME_ITEM_VAULT = CreateVibrantVaults.REGISTRATE.blockEntity("lime_item_vault", LimeItemVaultBlockEntity::new)
        .validBlocks(AllBlocks.LIME_ITEM_VAULT)
        .register();

    public static final BlockEntityEntry<MagentaItemVaultBlockEntity> MAGENTA_ITEM_VAULT = CreateVibrantVaults.REGISTRATE.blockEntity("magenta_item_vault", MagentaItemVaultBlockEntity::new)
        .validBlocks(AllBlocks.MAGENTA_ITEM_VAULT)
        .register();

    public static final BlockEntityEntry<OrangeItemVaultBlockEntity> ORANGE_ITEM_VAULT = CreateVibrantVaults.REGISTRATE.blockEntity("orange_item_vault", OrangeItemVaultBlockEntity::new)
        .validBlocks(AllBlocks.ORANGE_ITEM_VAULT)
        .register();

    public static final BlockEntityEntry<PinkItemVaultBlockEntity> PINK_ITEM_VAULT = CreateVibrantVaults.REGISTRATE.blockEntity("pink_item_vault", PinkItemVaultBlockEntity::new)
        .validBlocks(AllBlocks.PINK_ITEM_VAULT)
        .register();

    public static final BlockEntityEntry<PurpleItemVaultBlockEntity> PURPLE_ITEM_VAULT = CreateVibrantVaults.REGISTRATE.blockEntity("purple_item_vault", PurpleItemVaultBlockEntity::new)
        .validBlocks(AllBlocks.PURPLE_ITEM_VAULT)
        .register();

    public static final BlockEntityEntry<RedItemVaultBlockEntity> RED_ITEM_VAULT = CreateVibrantVaults.REGISTRATE.blockEntity("red_item_vault", RedItemVaultBlockEntity::new)
        .validBlocks(AllBlocks.RED_ITEM_VAULT)
        .register();

    public static final BlockEntityEntry<WhiteItemVaultBlockEntity> WHITE_ITEM_VAULT = CreateVibrantVaults.REGISTRATE.blockEntity("white_item_vault", WhiteItemVaultBlockEntity::new)
        .validBlocks(AllBlocks.WHITE_ITEM_VAULT)
        .register();

    public static final BlockEntityEntry<YellowItemVaultBlockEntity> YELLOW_ITEM_VAULT = CreateVibrantVaults.REGISTRATE.blockEntity("yellow_item_vault", YellowItemVaultBlockEntity::new)
        .validBlocks(AllBlocks.YELLOW_ITEM_VAULT)
        .register();

    public static final BlockEntityEntry<VerticalItemVaultBlockEntity> VERTICAL_ITEM_VAULT = CreateVibrantVaults.REGISTRATE.blockEntity("vertical_item_vault", VerticalItemVaultBlockEntity::new)
        .validBlocks(AllBlocks.VERTICAL_ITEM_VAULT)
        .register();

    public static final BlockEntityEntry<BlackVerticalItemVaultBlockEntity> BLACK_VERTICAL_ITEM_VAULT = CreateVibrantVaults.REGISTRATE.blockEntity("black_vertical_item_vault", BlackVerticalItemVaultBlockEntity::new)
        .validBlocks(AllBlocks.BLACK_VERTICAL_ITEM_VAULT)
        .register();

    public static final BlockEntityEntry<BlueVerticalItemVaultBlockEntity> BLUE_VERTICAL_ITEM_VAULT = CreateVibrantVaults.REGISTRATE.blockEntity("blue_vertical_item_vault", BlueVerticalItemVaultBlockEntity::new)
        .validBlocks(AllBlocks.BLUE_VERTICAL_ITEM_VAULT)
        .register();

    public static final BlockEntityEntry<BrownVerticalItemVaultBlockEntity> BROWN_VERTICAL_ITEM_VAULT = CreateVibrantVaults.REGISTRATE.blockEntity("brown_vertical_item_vault", BrownVerticalItemVaultBlockEntity::new)
        .validBlocks(AllBlocks.BROWN_VERTICAL_ITEM_VAULT)
        .register();

    public static final BlockEntityEntry<CyanVerticalItemVaultBlockEntity> CYAN_VERTICAL_ITEM_VAULT = CreateVibrantVaults.REGISTRATE.blockEntity("cyan_vertical_item_vault", CyanVerticalItemVaultBlockEntity::new)
        .validBlocks(AllBlocks.CYAN_VERTICAL_ITEM_VAULT)
        .register();

    public static final BlockEntityEntry<GrayVerticalItemVaultBlockEntity> GRAY_VERTICAL_ITEM_VAULT = CreateVibrantVaults.REGISTRATE.blockEntity("gray_vertical_item_vault", GrayVerticalItemVaultBlockEntity::new)
        .validBlocks(AllBlocks.GRAY_VERTICAL_ITEM_VAULT)
        .register();

    public static final BlockEntityEntry<GreenVerticalItemVaultBlockEntity> GREEN_VERTICAL_ITEM_VAULT = CreateVibrantVaults.REGISTRATE.blockEntity("green_vertical_item_vault", GreenVerticalItemVaultBlockEntity::new)
        .validBlocks(AllBlocks.GREEN_VERTICAL_ITEM_VAULT)
        .register();

    public static final BlockEntityEntry<LightBlueVerticalItemVaultBlockEntity> LIGHT_BLUE_VERTICAL_ITEM_VAULT = CreateVibrantVaults.REGISTRATE.blockEntity("light_blue_vertical_item_vault", LightBlueVerticalItemVaultBlockEntity::new)
        .validBlocks(AllBlocks.LIGHT_BLUE_VERTICAL_ITEM_VAULT)
        .register();

    public static final BlockEntityEntry<LightGrayVerticalItemVaultBlockEntity> LIGHT_GRAY_VERTICAL_ITEM_VAULT = CreateVibrantVaults.REGISTRATE.blockEntity("light_gray_vertical_item_vault", LightGrayVerticalItemVaultBlockEntity::new)
        .validBlocks(AllBlocks.LIGHT_GRAY_VERTICAL_ITEM_VAULT)
        .register();

    public static final BlockEntityEntry<LimeVerticalItemVaultBlockEntity> LIME_VERTICAL_ITEM_VAULT = CreateVibrantVaults.REGISTRATE.blockEntity("lime_vertical_item_vault", LimeVerticalItemVaultBlockEntity::new)
        .validBlocks(AllBlocks.LIME_VERTICAL_ITEM_VAULT)
        .register();

    public static final BlockEntityEntry<MagentaVerticalItemVaultBlockEntity> MAGENTA_VERTICAL_ITEM_VAULT = CreateVibrantVaults.REGISTRATE.blockEntity("magenta_vertical_item_vault", MagentaVerticalItemVaultBlockEntity::new)
        .validBlocks(AllBlocks.MAGENTA_VERTICAL_ITEM_VAULT)
        .register();

    public static final BlockEntityEntry<OrangeVerticalItemVaultBlockEntity> ORANGE_VERTICAL_ITEM_VAULT = CreateVibrantVaults.REGISTRATE.blockEntity("orange_vertical_item_vault", OrangeVerticalItemVaultBlockEntity::new)
        .validBlocks(AllBlocks.ORANGE_VERTICAL_ITEM_VAULT)
        .register();

    public static final BlockEntityEntry<PinkVerticalItemVaultBlockEntity> PINK_VERTICAL_ITEM_VAULT = CreateVibrantVaults.REGISTRATE.blockEntity("pink_vertical_item_vault", PinkVerticalItemVaultBlockEntity::new)
        .validBlocks(AllBlocks.PINK_VERTICAL_ITEM_VAULT)
        .register();

    public static final BlockEntityEntry<PurpleVerticalItemVaultBlockEntity> PURPLE_VERTICAL_ITEM_VAULT = CreateVibrantVaults.REGISTRATE.blockEntity("purple_vertical_item_vault", PurpleVerticalItemVaultBlockEntity::new)
        .validBlocks(AllBlocks.PURPLE_VERTICAL_ITEM_VAULT)
        .register();

    public static final BlockEntityEntry<RedVerticalItemVaultBlockEntity> RED_VERTICAL_ITEM_VAULT = CreateVibrantVaults.REGISTRATE.blockEntity("red_vertical_item_vault", RedVerticalItemVaultBlockEntity::new)
        .validBlocks(AllBlocks.RED_VERTICAL_ITEM_VAULT)
        .register();

    public static final BlockEntityEntry<WhiteVerticalItemVaultBlockEntity> WHITE_VERTICAL_ITEM_VAULT = CreateVibrantVaults.REGISTRATE.blockEntity("white_vertical_item_vault", WhiteVerticalItemVaultBlockEntity::new)
        .validBlocks(AllBlocks.WHITE_VERTICAL_ITEM_VAULT)
        .register();

    public static final BlockEntityEntry<YellowVerticalItemVaultBlockEntity> YELLOW_VERTICAL_ITEM_VAULT = CreateVibrantVaults.REGISTRATE.blockEntity("yellow_vertical_item_vault", YellowVerticalItemVaultBlockEntity::new)
        .validBlocks(AllBlocks.YELLOW_VERTICAL_ITEM_VAULT)
        .register();

    public static final BlockEntityEntry<ShippingContainerBlockEntity> SHIPPING_CONTAINER = CreateVibrantVaults.REGISTRATE.blockEntity("shipping_container", ShippingContainerBlockEntity::new)
        .validBlocks(AllBlocks.SHIPPING_CONTAINER)
        .register();

    public static final BlockEntityEntry<BlackShippingContainerBlockEntity> BLACK_SHIPPING_CONTAINER = CreateVibrantVaults.REGISTRATE.blockEntity("black_shipping_container", BlackShippingContainerBlockEntity::new)
        .validBlocks(AllBlocks.BLACK_SHIPPING_CONTAINER)
        .register();

    public static final BlockEntityEntry<BlueShippingContainerBlockEntity> BLUE_SHIPPING_CONTAINER = CreateVibrantVaults.REGISTRATE.blockEntity("blue_shipping_container", BlueShippingContainerBlockEntity::new)
        .validBlocks(AllBlocks.BLUE_SHIPPING_CONTAINER)
        .register();

    public static final BlockEntityEntry<BrownShippingContainerBlockEntity> BROWN_SHIPPING_CONTAINER = CreateVibrantVaults.REGISTRATE.blockEntity("brown_shipping_container", BrownShippingContainerBlockEntity::new)
        .validBlocks(AllBlocks.BROWN_SHIPPING_CONTAINER)
        .register();

    public static final BlockEntityEntry<CyanShippingContainerBlockEntity> CYAN_SHIPPING_CONTAINER = CreateVibrantVaults.REGISTRATE.blockEntity("cyan_shipping_container", CyanShippingContainerBlockEntity::new)
        .validBlocks(AllBlocks.CYAN_SHIPPING_CONTAINER)
        .register();

    public static final BlockEntityEntry<GrayShippingContainerBlockEntity> GRAY_SHIPPING_CONTAINER = CreateVibrantVaults.REGISTRATE.blockEntity("gray_shipping_container", GrayShippingContainerBlockEntity::new)
        .validBlocks(AllBlocks.GRAY_SHIPPING_CONTAINER)
        .register();

    public static final BlockEntityEntry<GreenShippingContainerBlockEntity> GREEN_SHIPPING_CONTAINER = CreateVibrantVaults.REGISTRATE.blockEntity("green_shipping_container", GreenShippingContainerBlockEntity::new)
        .validBlocks(AllBlocks.GREEN_SHIPPING_CONTAINER)
        .register();

    public static final BlockEntityEntry<LightBlueShippingContainerBlockEntity> LIGHT_BLUE_SHIPPING_CONTAINER = CreateVibrantVaults.REGISTRATE.blockEntity("light_blue_shipping_container", LightBlueShippingContainerBlockEntity::new)
        .validBlocks(AllBlocks.LIGHT_BLUE_SHIPPING_CONTAINER)
        .register();

    public static final BlockEntityEntry<LightGrayShippingContainerBlockEntity> LIGHT_GRAY_SHIPPING_CONTAINER = CreateVibrantVaults.REGISTRATE.blockEntity("light_gray_shipping_container", LightGrayShippingContainerBlockEntity::new)
        .validBlocks(AllBlocks.LIGHT_GRAY_SHIPPING_CONTAINER)
        .register();

    public static final BlockEntityEntry<LimeShippingContainerBlockEntity> LIME_SHIPPING_CONTAINER = CreateVibrantVaults.REGISTRATE.blockEntity("lime_shipping_container", LimeShippingContainerBlockEntity::new)
        .validBlocks(AllBlocks.LIME_SHIPPING_CONTAINER)
        .register();

    public static final BlockEntityEntry<MagentaShippingContainerBlockEntity> MAGENTA_SHIPPING_CONTAINER = CreateVibrantVaults.REGISTRATE.blockEntity("magenta_shipping_container", MagentaShippingContainerBlockEntity::new)
        .validBlocks(AllBlocks.MAGENTA_SHIPPING_CONTAINER)
        .register();

    public static final BlockEntityEntry<OrangeShippingContainerBlockEntity> ORANGE_SHIPPING_CONTAINER = CreateVibrantVaults.REGISTRATE.blockEntity("orange_shipping_container", OrangeShippingContainerBlockEntity::new)
        .validBlocks(AllBlocks.ORANGE_SHIPPING_CONTAINER)
        .register();

    public static final BlockEntityEntry<PinkShippingContainerBlockEntity> PINK_SHIPPING_CONTAINER = CreateVibrantVaults.REGISTRATE.blockEntity("pink_shipping_container", PinkShippingContainerBlockEntity::new)
        .validBlocks(AllBlocks.PINK_SHIPPING_CONTAINER)
        .register();

    public static final BlockEntityEntry<PurpleShippingContainerBlockEntity> PURPLE_SHIPPING_CONTAINER = CreateVibrantVaults.REGISTRATE.blockEntity("purple_shipping_container", PurpleShippingContainerBlockEntity::new)
        .validBlocks(AllBlocks.PURPLE_SHIPPING_CONTAINER)
        .register();

    public static final BlockEntityEntry<RedShippingContainerBlockEntity> RED_SHIPPING_CONTAINER = CreateVibrantVaults.REGISTRATE.blockEntity("red_shipping_container", RedShippingContainerBlockEntity::new)
        .validBlocks(AllBlocks.RED_SHIPPING_CONTAINER)
        .register();

    public static final BlockEntityEntry<WhiteShippingContainerBlockEntity> WHITE_SHIPPING_CONTAINER = CreateVibrantVaults.REGISTRATE.blockEntity("white_shipping_container", WhiteShippingContainerBlockEntity::new)
        .validBlocks(AllBlocks.WHITE_SHIPPING_CONTAINER)
        .register();

    public static final BlockEntityEntry<YellowShippingContainerBlockEntity> YELLOW_SHIPPING_CONTAINER = CreateVibrantVaults.REGISTRATE.blockEntity("yellow_shipping_container", YellowShippingContainerBlockEntity::new)
        .validBlocks(AllBlocks.YELLOW_SHIPPING_CONTAINER)
        .register();

    public static final BlockEntityEntry<VerticalShippingContainerBlockEntity> VERTICAL_SHIPPING_CONTAINER = CreateVibrantVaults.REGISTRATE.blockEntity("vertical_shipping_container", VerticalShippingContainerBlockEntity::new)
        .validBlocks(AllBlocks.VERTICAL_SHIPPING_CONTAINER)
        .register();

    public static final BlockEntityEntry<BlackVerticalShippingContainerBlockEntity> BLACK_VERTICAL_SHIPPING_CONTAINER = CreateVibrantVaults.REGISTRATE.blockEntity("black_vertical_shipping_container", BlackVerticalShippingContainerBlockEntity::new)
        .validBlocks(AllBlocks.BLACK_VERTICAL_SHIPPING_CONTAINER)
        .register();

    public static final BlockEntityEntry<BlueVerticalShippingContainerBlockEntity> BLUE_VERTICAL_SHIPPING_CONTAINER = CreateVibrantVaults.REGISTRATE.blockEntity("blue_vertical_shipping_container", BlueVerticalShippingContainerBlockEntity::new)
        .validBlocks(AllBlocks.BLUE_VERTICAL_SHIPPING_CONTAINER)
        .register();

    public static final BlockEntityEntry<BrownVerticalShippingContainerBlockEntity> BROWN_VERTICAL_SHIPPING_CONTAINER = CreateVibrantVaults.REGISTRATE.blockEntity("brown_vertical_shipping_container", BrownVerticalShippingContainerBlockEntity::new)
        .validBlocks(AllBlocks.BROWN_VERTICAL_SHIPPING_CONTAINER)
        .register();

    public static final BlockEntityEntry<CyanVerticalShippingContainerBlockEntity> CYAN_VERTICAL_SHIPPING_CONTAINER = CreateVibrantVaults.REGISTRATE.blockEntity("cyan_vertical_shipping_container", CyanVerticalShippingContainerBlockEntity::new)
        .validBlocks(AllBlocks.CYAN_VERTICAL_SHIPPING_CONTAINER)
        .register();

    public static final BlockEntityEntry<GrayVerticalShippingContainerBlockEntity> GRAY_VERTICAL_SHIPPING_CONTAINER = CreateVibrantVaults.REGISTRATE.blockEntity("gray_vertical_shipping_container", GrayVerticalShippingContainerBlockEntity::new)
        .validBlocks(AllBlocks.GRAY_VERTICAL_SHIPPING_CONTAINER)
        .register();

    public static final BlockEntityEntry<GreenVerticalShippingContainerBlockEntity> GREEN_VERTICAL_SHIPPING_CONTAINER = CreateVibrantVaults.REGISTRATE.blockEntity("green_vertical_shipping_container", GreenVerticalShippingContainerBlockEntity::new)
        .validBlocks(AllBlocks.GREEN_VERTICAL_SHIPPING_CONTAINER)
        .register();

    public static final BlockEntityEntry<LightBlueVerticalShippingContainerBlockEntity> LIGHT_BLUE_VERTICAL_SHIPPING_CONTAINER = CreateVibrantVaults.REGISTRATE.blockEntity("light_blue_vertical_shipping_container", LightBlueVerticalShippingContainerBlockEntity::new)
        .validBlocks(AllBlocks.LIGHT_BLUE_VERTICAL_SHIPPING_CONTAINER)
        .register();

    public static final BlockEntityEntry<LightGrayVerticalShippingContainerBlockEntity> LIGHT_GRAY_VERTICAL_SHIPPING_CONTAINER = CreateVibrantVaults.REGISTRATE.blockEntity("light_gray_vertical_shipping_container", LightGrayVerticalShippingContainerBlockEntity::new)
        .validBlocks(AllBlocks.LIGHT_GRAY_VERTICAL_SHIPPING_CONTAINER)
        .register();

    public static final BlockEntityEntry<LimeVerticalShippingContainerBlockEntity> LIME_VERTICAL_SHIPPING_CONTAINER = CreateVibrantVaults.REGISTRATE.blockEntity("lime_vertical_shipping_container", LimeVerticalShippingContainerBlockEntity::new)
        .validBlocks(AllBlocks.LIME_VERTICAL_SHIPPING_CONTAINER)
        .register();

    public static final BlockEntityEntry<MagentaVerticalShippingContainerBlockEntity> MAGENTA_VERTICAL_SHIPPING_CONTAINER = CreateVibrantVaults.REGISTRATE.blockEntity("magenta_vertical_shipping_container", MagentaVerticalShippingContainerBlockEntity::new)
        .validBlocks(AllBlocks.MAGENTA_VERTICAL_SHIPPING_CONTAINER)
        .register();

    public static final BlockEntityEntry<OrangeVerticalShippingContainerBlockEntity> ORANGE_VERTICAL_SHIPPING_CONTAINER = CreateVibrantVaults.REGISTRATE.blockEntity("orange_vertical_shipping_container", OrangeVerticalShippingContainerBlockEntity::new)
        .validBlocks(AllBlocks.ORANGE_VERTICAL_SHIPPING_CONTAINER)
        .register();

    public static final BlockEntityEntry<PinkVerticalShippingContainerBlockEntity> PINK_VERTICAL_SHIPPING_CONTAINER = CreateVibrantVaults.REGISTRATE.blockEntity("pink_vertical_shipping_container", PinkVerticalShippingContainerBlockEntity::new)
        .validBlocks(AllBlocks.PINK_VERTICAL_SHIPPING_CONTAINER)
        .register();

    public static final BlockEntityEntry<PurpleVerticalShippingContainerBlockEntity> PURPLE_VERTICAL_SHIPPING_CONTAINER = CreateVibrantVaults.REGISTRATE.blockEntity("purple_vertical_shipping_container", PurpleVerticalShippingContainerBlockEntity::new)
        .validBlocks(AllBlocks.PURPLE_VERTICAL_SHIPPING_CONTAINER)
        .register();

    public static final BlockEntityEntry<RedVerticalShippingContainerBlockEntity> RED_VERTICAL_SHIPPING_CONTAINER = CreateVibrantVaults.REGISTRATE.blockEntity("red_vertical_shipping_container", RedVerticalShippingContainerBlockEntity::new)
        .validBlocks(AllBlocks.RED_VERTICAL_SHIPPING_CONTAINER)
        .register();

    public static final BlockEntityEntry<WhiteVerticalShippingContainerBlockEntity> WHITE_VERTICAL_SHIPPING_CONTAINER = CreateVibrantVaults.REGISTRATE.blockEntity("white_vertical_shipping_container", WhiteVerticalShippingContainerBlockEntity::new)
        .validBlocks(AllBlocks.WHITE_VERTICAL_SHIPPING_CONTAINER)
        .register();

    public static final BlockEntityEntry<YellowVerticalShippingContainerBlockEntity> YELLOW_VERTICAL_SHIPPING_CONTAINER = CreateVibrantVaults.REGISTRATE.blockEntity("yellow_vertical_shipping_container", YellowVerticalShippingContainerBlockEntity::new)
        .validBlocks(AllBlocks.YELLOW_VERTICAL_SHIPPING_CONTAINER)
        .register();

    public static final BlockEntityEntry<BasicShippingContainerBlockEntity> BASIC_SHIPPING_CONTAINER = CreateVibrantVaults.REGISTRATE.blockEntity("basic_shipping_container", BasicShippingContainerBlockEntity::new)
        .validBlocks(AllBlocks.BASIC_SHIPPING_CONTAINER)
        .register();

    public static final BlockEntityEntry<BlackBasicShippingContainerBlockEntity> BLACK_BASIC_SHIPPING_CONTAINER = CreateVibrantVaults.REGISTRATE.blockEntity("black_basic_shipping_container", BlackBasicShippingContainerBlockEntity::new)
        .validBlocks(AllBlocks.BLACK_BASIC_SHIPPING_CONTAINER)
        .register();

    public static final BlockEntityEntry<BlueBasicShippingContainerBlockEntity> BLUE_BASIC_SHIPPING_CONTAINER = CreateVibrantVaults.REGISTRATE.blockEntity("blue_basic_shipping_container", BlueBasicShippingContainerBlockEntity::new)
        .validBlocks(AllBlocks.BLUE_BASIC_SHIPPING_CONTAINER)
        .register();

    public static final BlockEntityEntry<BrownBasicShippingContainerBlockEntity> BROWN_BASIC_SHIPPING_CONTAINER = CreateVibrantVaults.REGISTRATE.blockEntity("brown_basic_shipping_container", BrownBasicShippingContainerBlockEntity::new)
        .validBlocks(AllBlocks.BROWN_BASIC_SHIPPING_CONTAINER)
        .register();

    public static final BlockEntityEntry<CyanBasicShippingContainerBlockEntity> CYAN_BASIC_SHIPPING_CONTAINER = CreateVibrantVaults.REGISTRATE.blockEntity("cyan_basic_shipping_container", CyanBasicShippingContainerBlockEntity::new)
        .validBlocks(AllBlocks.CYAN_BASIC_SHIPPING_CONTAINER)
        .register();

    public static final BlockEntityEntry<GrayBasicShippingContainerBlockEntity> GRAY_BASIC_SHIPPING_CONTAINER = CreateVibrantVaults.REGISTRATE.blockEntity("gray_basic_shipping_container", GrayBasicShippingContainerBlockEntity::new)
        .validBlocks(AllBlocks.GRAY_BASIC_SHIPPING_CONTAINER)
        .register();

    public static final BlockEntityEntry<GreenBasicShippingContainerBlockEntity> GREEN_BASIC_SHIPPING_CONTAINER = CreateVibrantVaults.REGISTRATE.blockEntity("green_basic_shipping_container", GreenBasicShippingContainerBlockEntity::new)
        .validBlocks(AllBlocks.GREEN_BASIC_SHIPPING_CONTAINER)
        .register();

    public static final BlockEntityEntry<LightBlueBasicShippingContainerBlockEntity> LIGHT_BLUE_BASIC_SHIPPING_CONTAINER = CreateVibrantVaults.REGISTRATE.blockEntity("light_blue_basic_shipping_container", LightBlueBasicShippingContainerBlockEntity::new)
        .validBlocks(AllBlocks.LIGHT_BLUE_BASIC_SHIPPING_CONTAINER)
        .register();

    public static final BlockEntityEntry<LightGrayBasicShippingContainerBlockEntity> LIGHT_GRAY_BASIC_SHIPPING_CONTAINER = CreateVibrantVaults.REGISTRATE.blockEntity("light_gray_basic_shipping_container", LightGrayBasicShippingContainerBlockEntity::new)
        .validBlocks(AllBlocks.LIGHT_GRAY_BASIC_SHIPPING_CONTAINER)
        .register();

    public static final BlockEntityEntry<LimeBasicShippingContainerBlockEntity> LIME_BASIC_SHIPPING_CONTAINER = CreateVibrantVaults.REGISTRATE.blockEntity("lime_basic_shipping_container", LimeBasicShippingContainerBlockEntity::new)
        .validBlocks(AllBlocks.LIME_BASIC_SHIPPING_CONTAINER)
        .register();

    public static final BlockEntityEntry<MagentaBasicShippingContainerBlockEntity> MAGENTA_BASIC_SHIPPING_CONTAINER = CreateVibrantVaults.REGISTRATE.blockEntity("magenta_basic_shipping_container", MagentaBasicShippingContainerBlockEntity::new)
        .validBlocks(AllBlocks.MAGENTA_BASIC_SHIPPING_CONTAINER)
        .register();

    public static final BlockEntityEntry<OrangeBasicShippingContainerBlockEntity> ORANGE_BASIC_SHIPPING_CONTAINER = CreateVibrantVaults.REGISTRATE.blockEntity("orange_basic_shipping_container", OrangeBasicShippingContainerBlockEntity::new)
        .validBlocks(AllBlocks.ORANGE_BASIC_SHIPPING_CONTAINER)
        .register();

    public static final BlockEntityEntry<PinkBasicShippingContainerBlockEntity> PINK_BASIC_SHIPPING_CONTAINER = CreateVibrantVaults.REGISTRATE.blockEntity("pink_basic_shipping_container", PinkBasicShippingContainerBlockEntity::new)
        .validBlocks(AllBlocks.PINK_BASIC_SHIPPING_CONTAINER)
        .register();

    public static final BlockEntityEntry<PurpleBasicShippingContainerBlockEntity> PURPLE_BASIC_SHIPPING_CONTAINER = CreateVibrantVaults.REGISTRATE.blockEntity("purple_basic_shipping_container", PurpleBasicShippingContainerBlockEntity::new)
        .validBlocks(AllBlocks.PURPLE_BASIC_SHIPPING_CONTAINER)
        .register();

    public static final BlockEntityEntry<RedBasicShippingContainerBlockEntity> RED_BASIC_SHIPPING_CONTAINER = CreateVibrantVaults.REGISTRATE.blockEntity("red_basic_shipping_container", RedBasicShippingContainerBlockEntity::new)
        .validBlocks(AllBlocks.RED_BASIC_SHIPPING_CONTAINER)
        .register();

    public static final BlockEntityEntry<WhiteBasicShippingContainerBlockEntity> WHITE_BASIC_SHIPPING_CONTAINER = CreateVibrantVaults.REGISTRATE.blockEntity("white_basic_shipping_container", WhiteBasicShippingContainerBlockEntity::new)
        .validBlocks(AllBlocks.WHITE_BASIC_SHIPPING_CONTAINER)
        .register();

    public static final BlockEntityEntry<YellowBasicShippingContainerBlockEntity> YELLOW_BASIC_SHIPPING_CONTAINER = CreateVibrantVaults.REGISTRATE.blockEntity("yellow_basic_shipping_container", YellowBasicShippingContainerBlockEntity::new)
        .validBlocks(AllBlocks.YELLOW_BASIC_SHIPPING_CONTAINER)
        .register();

    public static final BlockEntityEntry<VerticalBasicShippingContainerBlockEntity> VERTICAL_BASIC_SHIPPING_CONTAINER = CreateVibrantVaults.REGISTRATE.blockEntity("vertical_basic_shipping_container", VerticalBasicShippingContainerBlockEntity::new)
        .validBlocks(AllBlocks.VERTICAL_BASIC_SHIPPING_CONTAINER)
        .register();

    public static final BlockEntityEntry<BlackVerticalBasicShippingContainerBlockEntity> BLACK_VERTICAL_BASIC_SHIPPING_CONTAINER = CreateVibrantVaults.REGISTRATE.blockEntity("black_vertical_basic_shipping_container", BlackVerticalBasicShippingContainerBlockEntity::new)
        .validBlocks(AllBlocks.BLACK_VERTICAL_BASIC_SHIPPING_CONTAINER)
        .register();

    public static final BlockEntityEntry<BlueVerticalBasicShippingContainerBlockEntity> BLUE_VERTICAL_BASIC_SHIPPING_CONTAINER = CreateVibrantVaults.REGISTRATE.blockEntity("blue_vertical_basic_shipping_container", BlueVerticalBasicShippingContainerBlockEntity::new)
        .validBlocks(AllBlocks.BLUE_VERTICAL_BASIC_SHIPPING_CONTAINER)
        .register();

    public static final BlockEntityEntry<BrownVerticalBasicShippingContainerBlockEntity> BROWN_VERTICAL_BASIC_SHIPPING_CONTAINER = CreateVibrantVaults.REGISTRATE.blockEntity("brown_vertical_basic_shipping_container", BrownVerticalBasicShippingContainerBlockEntity::new)
        .validBlocks(AllBlocks.BROWN_VERTICAL_BASIC_SHIPPING_CONTAINER)
        .register();

    public static final BlockEntityEntry<CyanVerticalBasicShippingContainerBlockEntity> CYAN_VERTICAL_BASIC_SHIPPING_CONTAINER = CreateVibrantVaults.REGISTRATE.blockEntity("cyan_vertical_basic_shipping_container", CyanVerticalBasicShippingContainerBlockEntity::new)
        .validBlocks(AllBlocks.CYAN_VERTICAL_BASIC_SHIPPING_CONTAINER)
        .register();

    public static final BlockEntityEntry<GrayVerticalBasicShippingContainerBlockEntity> GRAY_VERTICAL_BASIC_SHIPPING_CONTAINER = CreateVibrantVaults.REGISTRATE.blockEntity("gray_vertical_basic_shipping_container", GrayVerticalBasicShippingContainerBlockEntity::new)
        .validBlocks(AllBlocks.GRAY_VERTICAL_BASIC_SHIPPING_CONTAINER)
        .register();

    public static final BlockEntityEntry<GreenVerticalBasicShippingContainerBlockEntity> GREEN_VERTICAL_BASIC_SHIPPING_CONTAINER = CreateVibrantVaults.REGISTRATE.blockEntity("green_vertical_basic_shipping_container", GreenVerticalBasicShippingContainerBlockEntity::new)
        .validBlocks(AllBlocks.GREEN_VERTICAL_BASIC_SHIPPING_CONTAINER)
        .register();

    public static final BlockEntityEntry<LightBlueVerticalBasicShippingContainerBlockEntity> LIGHT_BLUE_VERTICAL_BASIC_SHIPPING_CONTAINER = CreateVibrantVaults.REGISTRATE.blockEntity("light_blue_vertical_basic_shipping_container", LightBlueVerticalBasicShippingContainerBlockEntity::new)
        .validBlocks(AllBlocks.LIGHT_BLUE_VERTICAL_BASIC_SHIPPING_CONTAINER)
        .register();

    public static final BlockEntityEntry<LightGrayVerticalBasicShippingContainerBlockEntity> LIGHT_GRAY_VERTICAL_BASIC_SHIPPING_CONTAINER = CreateVibrantVaults.REGISTRATE.blockEntity("light_gray_vertical_basic_shipping_container", LightGrayVerticalBasicShippingContainerBlockEntity::new)
        .validBlocks(AllBlocks.LIGHT_GRAY_VERTICAL_BASIC_SHIPPING_CONTAINER)
        .register();

    public static final BlockEntityEntry<LimeVerticalBasicShippingContainerBlockEntity> LIME_VERTICAL_BASIC_SHIPPING_CONTAINER = CreateVibrantVaults.REGISTRATE.blockEntity("lime_vertical_basic_shipping_container", LimeVerticalBasicShippingContainerBlockEntity::new)
        .validBlocks(AllBlocks.LIME_VERTICAL_BASIC_SHIPPING_CONTAINER)
        .register();

    public static final BlockEntityEntry<MagentaVerticalBasicShippingContainerBlockEntity> MAGENTA_VERTICAL_BASIC_SHIPPING_CONTAINER = CreateVibrantVaults.REGISTRATE.blockEntity("magenta_vertical_basic_shipping_container", MagentaVerticalBasicShippingContainerBlockEntity::new)
        .validBlocks(AllBlocks.MAGENTA_VERTICAL_BASIC_SHIPPING_CONTAINER)
        .register();

    public static final BlockEntityEntry<OrangeVerticalBasicShippingContainerBlockEntity> ORANGE_VERTICAL_BASIC_SHIPPING_CONTAINER = CreateVibrantVaults.REGISTRATE.blockEntity("orange_vertical_basic_shipping_container", OrangeVerticalBasicShippingContainerBlockEntity::new)
        .validBlocks(AllBlocks.ORANGE_VERTICAL_BASIC_SHIPPING_CONTAINER)
        .register();

    public static final BlockEntityEntry<PinkVerticalBasicShippingContainerBlockEntity> PINK_VERTICAL_BASIC_SHIPPING_CONTAINER = CreateVibrantVaults.REGISTRATE.blockEntity("pink_vertical_basic_shipping_container", PinkVerticalBasicShippingContainerBlockEntity::new)
        .validBlocks(AllBlocks.PINK_VERTICAL_BASIC_SHIPPING_CONTAINER)
        .register();

    public static final BlockEntityEntry<PurpleVerticalBasicShippingContainerBlockEntity> PURPLE_VERTICAL_BASIC_SHIPPING_CONTAINER = CreateVibrantVaults.REGISTRATE.blockEntity("purple_vertical_basic_shipping_container", PurpleVerticalBasicShippingContainerBlockEntity::new)
        .validBlocks(AllBlocks.PURPLE_VERTICAL_BASIC_SHIPPING_CONTAINER)
        .register();

    public static final BlockEntityEntry<RedVerticalBasicShippingContainerBlockEntity> RED_VERTICAL_BASIC_SHIPPING_CONTAINER = CreateVibrantVaults.REGISTRATE.blockEntity("red_vertical_basic_shipping_container", RedVerticalBasicShippingContainerBlockEntity::new)
        .validBlocks(AllBlocks.RED_VERTICAL_BASIC_SHIPPING_CONTAINER)
        .register();

    public static final BlockEntityEntry<WhiteVerticalBasicShippingContainerBlockEntity> WHITE_VERTICAL_BASIC_SHIPPING_CONTAINER = CreateVibrantVaults.REGISTRATE.blockEntity("white_vertical_basic_shipping_container", WhiteVerticalBasicShippingContainerBlockEntity::new)
        .validBlocks(AllBlocks.WHITE_VERTICAL_BASIC_SHIPPING_CONTAINER)
        .register();

    public static final BlockEntityEntry<YellowVerticalBasicShippingContainerBlockEntity> YELLOW_VERTICAL_BASIC_SHIPPING_CONTAINER = CreateVibrantVaults.REGISTRATE.blockEntity("yellow_vertical_basic_shipping_container", YellowVerticalBasicShippingContainerBlockEntity::new)
        .validBlocks(AllBlocks.YELLOW_VERTICAL_BASIC_SHIPPING_CONTAINER)
        .register();

    public static void register() {}
}
