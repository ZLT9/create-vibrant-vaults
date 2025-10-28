package net.zlt.create_vibrant_vaults.data;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.foundation.data.TagGen;
import com.tterrag.registrate.providers.ProviderType;
import com.tterrag.registrate.providers.RegistrateTagsProvider;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.zlt.create_vibrant_vaults.CreateVibrantVaults;
import net.zlt.create_vibrant_vaults.block.*;
import net.zlt.create_vibrant_vaults.item.ModItemTags;

import java.util.List;

public class CreateVibrantVaultsTagProvider {
    public static void addGenerators() {
        CreateVibrantVaults.REGISTRATE.addDataGenerator(ProviderType.BLOCK_TAGS, CreateVibrantVaultsTagProvider::genBlockTags);
        CreateVibrantVaults.REGISTRATE.addDataGenerator(ProviderType.ITEM_TAGS, CreateVibrantVaultsTagProvider::genItemTags);
    }

    @SuppressWarnings("deprecation")
    private static void genBlockTags(RegistrateTagsProvider<Block> provIn) {
        TagGen.CreateTagsProvider<Block> prov = new TagGen.CreateTagsProvider<>(provIn, Block::builtInRegistryHolder);

        TagGen.CreateTagAppender<Block> vibrantVaultsTag = prov.tag(ModBlockTags.VIBRANT_VAULTS.tag);
        TagGen.CreateTagAppender<Block> horizontalVaultsTag = prov.tag(ModBlockTags.HORIZONTAL_VAULTS.tag);
        TagGen.CreateTagAppender<Block> verticalVaultsTag = prov.tag(ModBlockTags.VERTICAL_VAULTS.tag);
        TagGen.CreateTagAppender<Block> itemVaultsTag = prov.tag(ModBlockTags.ITEM_VAULTS.tag);
        TagGen.CreateTagAppender<Block> shippingContainersTag = prov.tag(ModBlockTags.SHIPPING_CONTAINERS.tag);
        TagGen.CreateTagAppender<Block> basicShippingContainersTag = prov.tag(ModBlockTags.BASIC_SHIPPING_CONTAINERS.tag);
        TagGen.CreateTagAppender<Block> whiteVaultsTag = prov.tag(ModBlockTags.WHITE_VAULTS.tag);
        TagGen.CreateTagAppender<Block> orangeVaultsTag = prov.tag(ModBlockTags.ORANGE_VAULTS.tag);
        TagGen.CreateTagAppender<Block> magentaVaultsTag = prov.tag(ModBlockTags.MAGENTA_VAULTS.tag);
        TagGen.CreateTagAppender<Block> lightBlueVaultsTag = prov.tag(ModBlockTags.LIGHT_BLUE_VAULTS.tag);
        TagGen.CreateTagAppender<Block> yellowVaultsTag = prov.tag(ModBlockTags.YELLOW_VAULTS.tag);
        TagGen.CreateTagAppender<Block> limeVaultsTag = prov.tag(ModBlockTags.LIME_VAULTS.tag);
        TagGen.CreateTagAppender<Block> pinkVaultsTag = prov.tag(ModBlockTags.PINK_VAULTS.tag);
        TagGen.CreateTagAppender<Block> grayVaultsTag = prov.tag(ModBlockTags.GRAY_VAULTS.tag);
        TagGen.CreateTagAppender<Block> lightGrayVaultsTag = prov.tag(ModBlockTags.LIGHT_GRAY_VAULTS.tag);
        TagGen.CreateTagAppender<Block> cyanVaultsTag = prov.tag(ModBlockTags.CYAN_VAULTS.tag);
        TagGen.CreateTagAppender<Block> purpleVaultsTag = prov.tag(ModBlockTags.PURPLE_VAULTS.tag);
        TagGen.CreateTagAppender<Block> blueVaultsTag = prov.tag(ModBlockTags.BLUE_VAULTS.tag);
        TagGen.CreateTagAppender<Block> brownVaultsTag = prov.tag(ModBlockTags.BROWN_VAULTS.tag);
        TagGen.CreateTagAppender<Block> greenVaultsTag = prov.tag(ModBlockTags.GREEN_VAULTS.tag);
        TagGen.CreateTagAppender<Block> redVaultsTag = prov.tag(ModBlockTags.RED_VAULTS.tag);
        TagGen.CreateTagAppender<Block> blackVaultsTag = prov.tag(ModBlockTags.BLACK_VAULTS.tag);
        TagGen.CreateTagAppender<Block> baseVaultsTag = prov.tag(ModBlockTags.BASE_VAULTS.tag);
        TagGen.CreateTagAppender<Block> coloredHorizontalItemVaultsTag = prov.tag(ModBlockTags.COLORED_HORIZONTAL_ITEM_VAULTS.tag);
        TagGen.CreateTagAppender<Block> coloredVerticalItemVaultsTag = prov.tag(ModBlockTags.COLORED_VERTICAL_ITEM_VAULTS.tag);
        TagGen.CreateTagAppender<Block> coloredHorizontalShippingContainersTag = prov.tag(ModBlockTags.COLORED_HORIZONTAL_SHIPPING_CONTAINERS.tag);
        TagGen.CreateTagAppender<Block> coloredVerticalShippingContainersTag = prov.tag(ModBlockTags.COLORED_VERTICAL_SHIPPING_CONTAINERS.tag);
        TagGen.CreateTagAppender<Block> coloredHorizontalBasicShippingContainersTag = prov.tag(ModBlockTags.COLORED_HORIZONTAL_BASIC_SHIPPING_CONTAINERS.tag);
        TagGen.CreateTagAppender<Block> coloredVerticalBasicShippingContainersTag = prov.tag(ModBlockTags.COLORED_VERTICAL_BASIC_SHIPPING_CONTAINERS.tag);
        TagGen.CreateTagAppender<Block> frogportsTag = prov.tag(ModBlockTags.FROGPORTS.tag);
        TagGen.CreateTagAppender<Block> vibrantFrogportsTag = prov.tag(ModBlockTags.VIBRANT_FROGPORTS.tag);
        TagGen.CreateTagAppender<Block> stockLinksTag = prov.tag(ModBlockTags.STOCK_LINKS.tag);
        TagGen.CreateTagAppender<Block> vibrantStockLinksTag = prov.tag(ModBlockTags.VIBRANT_STOCK_LINKS.tag);
        TagGen.CreateTagAppender<Block> redstoneRequestersTag = prov.tag(ModBlockTags.REDSTONE_REQUESTERS.tag);
        TagGen.CreateTagAppender<Block> vibrantRedstoneRequestersTag = prov.tag(ModBlockTags.VIBRANT_REDSTONE_REQUESTERS.tag);

        horizontalVaultsTag.add(AllBlocks.ITEM_VAULT.get());
        itemVaultsTag.add(AllBlocks.ITEM_VAULT.get());
        baseVaultsTag.add(AllBlocks.ITEM_VAULT.get());

        for (List<BlockEntry<VibrantVaultBlock>> vaults : ModBlocks.VIBRANT_VAULTS) {
            for (BlockEntry<VibrantVaultBlock> vault : vaults) {
                VibrantVaultBlock block = vault.get();
                vibrantVaultsTag.add(block);
                boolean vertical = block instanceof VerticalVaultBlock;
                if (vertical) {
                    verticalVaultsTag.add(block);
                } else {
                    horizontalVaultsTag.add(block);
                }
                if (block.type == ModBlocks.VibrantVaultType.ITEM_VAULT) {
                    itemVaultsTag.add(block);

                    if (block.color != ModBlocks.VibrantVaultColor.BASE) {
                        if (vertical) {
                            coloredVerticalItemVaultsTag.add(block);
                        } else {
                            coloredHorizontalItemVaultsTag.add(block);
                        }
                    }
                } else if (block.type == ModBlocks.VibrantVaultType.SHIPPING_CONTAINER) {
                    shippingContainersTag.add(block);

                    if (block.color != ModBlocks.VibrantVaultColor.BASE) {
                        if (vertical) {
                            coloredVerticalShippingContainersTag.add(block);
                        } else {
                            coloredHorizontalShippingContainersTag.add(block);
                        }
                    }
                } else if (block.type == ModBlocks.VibrantVaultType.BASIC_SHIPPING_CONTAINER) {
                    basicShippingContainersTag.add(block);

                    if (block.color != ModBlocks.VibrantVaultColor.BASE) {
                        if (vertical) {
                            coloredVerticalBasicShippingContainersTag.add(block);
                        } else {
                            coloredHorizontalBasicShippingContainersTag.add(block);
                        }
                    }
                }
                if (block.color == ModBlocks.VibrantVaultColor.WHITE) {
                    whiteVaultsTag.add(block);
                } else if (block.color == ModBlocks.VibrantVaultColor.ORANGE) {
                    orangeVaultsTag.add(block);
                } else if (block.color == ModBlocks.VibrantVaultColor.MAGENTA) {
                    magentaVaultsTag.add(block);
                } else if (block.color == ModBlocks.VibrantVaultColor.LIGHT_BLUE) {
                    lightBlueVaultsTag.add(block);
                } else if (block.color == ModBlocks.VibrantVaultColor.YELLOW) {
                    yellowVaultsTag.add(block);
                } else if (block.color == ModBlocks.VibrantVaultColor.LIME) {
                    limeVaultsTag.add(block);
                } else if (block.color == ModBlocks.VibrantVaultColor.PINK) {
                    pinkVaultsTag.add(block);
                } else if (block.color == ModBlocks.VibrantVaultColor.GRAY) {
                    grayVaultsTag.add(block);
                } else if (block.color == ModBlocks.VibrantVaultColor.LIGHT_GRAY) {
                    lightGrayVaultsTag.add(block);
                } else if (block.color == ModBlocks.VibrantVaultColor.CYAN) {
                    cyanVaultsTag.add(block);
                } else if (block.color == ModBlocks.VibrantVaultColor.PURPLE) {
                    purpleVaultsTag.add(block);
                } else if (block.color == ModBlocks.VibrantVaultColor.BLUE) {
                    blueVaultsTag.add(block);
                } else if (block.color == ModBlocks.VibrantVaultColor.BROWN) {
                    brownVaultsTag.add(block);
                } else if (block.color == ModBlocks.VibrantVaultColor.GREEN) {
                    greenVaultsTag.add(block);
                } else if (block.color == ModBlocks.VibrantVaultColor.RED) {
                    redVaultsTag.add(block);
                } else if (block.color == ModBlocks.VibrantVaultColor.BLACK) {
                    blackVaultsTag.add(block);
                } else if (block.color == ModBlocks.VibrantVaultColor.BASE) {
                    baseVaultsTag.add(block);
                }
            }
        }

        frogportsTag.addTag(ModBlockTags.VIBRANT_FROGPORTS.tag);
        frogportsTag.add(AllBlocks.PACKAGE_FROGPORT.get());

        for (BlockEntry<VibrantFrogportBlock> frogport : ModBlocks.VIBRANT_FROGPORTS) {
            vibrantFrogportsTag.add(frogport.get());
        }

        stockLinksTag.addTag(ModBlockTags.VIBRANT_STOCK_LINKS.tag);
        stockLinksTag.add(AllBlocks.STOCK_LINK.get());

        for (BlockEntry<VibrantStockLinkBlock> stockLink : ModBlocks.VIBRANT_STOCK_LINKS) {
            vibrantStockLinksTag.add(stockLink.get());
        }

        redstoneRequestersTag.addTag(ModBlockTags.VIBRANT_REDSTONE_REQUESTERS.tag);
        redstoneRequestersTag.add(AllBlocks.REDSTONE_REQUESTER.get());

        for (BlockEntry<VibrantRedstoneRequesterBlock> redstoneRequester : ModBlocks.VIBRANT_REDSTONE_REQUESTERS) {
            vibrantRedstoneRequestersTag.add(redstoneRequester.get());
        }

        for (ModBlockTags tag : ModBlockTags.values()) {
            prov.getOrCreateRawBuilder(tag.tag);
        }
    }

    @SuppressWarnings("deprecation")
    private static void genItemTags(RegistrateTagsProvider<Item> provIn) {
        TagGen.CreateTagsProvider<Item> prov = new TagGen.CreateTagsProvider<>(provIn, Item::builtInRegistryHolder);

        TagGen.CreateTagAppender<Item> vibrantVaultsTag = prov.tag(ModItemTags.VIBRANT_VAULTS.tag);
        TagGen.CreateTagAppender<Item> horizontalVaultsTag = prov.tag(ModItemTags.HORIZONTAL_VAULTS.tag);
        TagGen.CreateTagAppender<Item> verticalVaultsTag = prov.tag(ModItemTags.VERTICAL_VAULTS.tag);
        TagGen.CreateTagAppender<Item> itemVaultsTag = prov.tag(ModItemTags.ITEM_VAULTS.tag);
        TagGen.CreateTagAppender<Item> shippingContainersTag = prov.tag(ModItemTags.SHIPPING_CONTAINERS.tag);
        TagGen.CreateTagAppender<Item> basicShippingContainersTag = prov.tag(ModItemTags.BASIC_SHIPPING_CONTAINERS.tag);
        TagGen.CreateTagAppender<Item> whiteVaultsTag = prov.tag(ModItemTags.WHITE_VAULTS.tag);
        TagGen.CreateTagAppender<Item> orangeVaultsTag = prov.tag(ModItemTags.ORANGE_VAULTS.tag);
        TagGen.CreateTagAppender<Item> magentaVaultsTag = prov.tag(ModItemTags.MAGENTA_VAULTS.tag);
        TagGen.CreateTagAppender<Item> lightBlueVaultsTag = prov.tag(ModItemTags.LIGHT_BLUE_VAULTS.tag);
        TagGen.CreateTagAppender<Item> yellowVaultsTag = prov.tag(ModItemTags.YELLOW_VAULTS.tag);
        TagGen.CreateTagAppender<Item> limeVaultsTag = prov.tag(ModItemTags.LIME_VAULTS.tag);
        TagGen.CreateTagAppender<Item> pinkVaultsTag = prov.tag(ModItemTags.PINK_VAULTS.tag);
        TagGen.CreateTagAppender<Item> grayVaultsTag = prov.tag(ModItemTags.GRAY_VAULTS.tag);
        TagGen.CreateTagAppender<Item> lightGrayVaultsTag = prov.tag(ModItemTags.LIGHT_GRAY_VAULTS.tag);
        TagGen.CreateTagAppender<Item> cyanVaultsTag = prov.tag(ModItemTags.CYAN_VAULTS.tag);
        TagGen.CreateTagAppender<Item> purpleVaultsTag = prov.tag(ModItemTags.PURPLE_VAULTS.tag);
        TagGen.CreateTagAppender<Item> blueVaultsTag = prov.tag(ModItemTags.BLUE_VAULTS.tag);
        TagGen.CreateTagAppender<Item> brownVaultsTag = prov.tag(ModItemTags.BROWN_VAULTS.tag);
        TagGen.CreateTagAppender<Item> greenVaultsTag = prov.tag(ModItemTags.GREEN_VAULTS.tag);
        TagGen.CreateTagAppender<Item> redVaultsTag = prov.tag(ModItemTags.RED_VAULTS.tag);
        TagGen.CreateTagAppender<Item> blackVaultsTag = prov.tag(ModItemTags.BLACK_VAULTS.tag);
        TagGen.CreateTagAppender<Item> baseVaultsTag = prov.tag(ModItemTags.BASE_VAULTS.tag);
        TagGen.CreateTagAppender<Item> coloredHorizontalItemVaultsTag = prov.tag(ModItemTags.COLORED_HORIZONTAL_ITEM_VAULTS.tag);
        TagGen.CreateTagAppender<Item> coloredVerticalItemVaultsTag = prov.tag(ModItemTags.COLORED_VERTICAL_ITEM_VAULTS.tag);
        TagGen.CreateTagAppender<Item> coloredHorizontalShippingContainersTag = prov.tag(ModItemTags.COLORED_HORIZONTAL_SHIPPING_CONTAINERS.tag);
        TagGen.CreateTagAppender<Item> coloredVerticalShippingContainersTag = prov.tag(ModItemTags.COLORED_VERTICAL_SHIPPING_CONTAINERS.tag);
        TagGen.CreateTagAppender<Item> coloredHorizontalBasicShippingContainersTag = prov.tag(ModItemTags.COLORED_HORIZONTAL_BASIC_SHIPPING_CONTAINERS.tag);
        TagGen.CreateTagAppender<Item> coloredVerticalBasicShippingContainersTag = prov.tag(ModItemTags.COLORED_VERTICAL_BASIC_SHIPPING_CONTAINERS.tag);
        TagGen.CreateTagAppender<Item> frogportsTag = prov.tag(ModItemTags.FROGPORTS.tag);
        TagGen.CreateTagAppender<Item> vibrantFrogportsTag = prov.tag(ModItemTags.VIBRANT_FROGPORTS.tag);
        TagGen.CreateTagAppender<Item> stockLinksTag = prov.tag(ModItemTags.STOCK_LINKS.tag);
        TagGen.CreateTagAppender<Item> vibrantStockLinksTag = prov.tag(ModItemTags.VIBRANT_STOCK_LINKS.tag);
        TagGen.CreateTagAppender<Item> redstoneRequestersTag = prov.tag(ModItemTags.REDSTONE_REQUESTERS.tag);
        TagGen.CreateTagAppender<Item> vibrantRedstoneRequestersTag = prov.tag(ModItemTags.VIBRANT_REDSTONE_REQUESTERS.tag);

        horizontalVaultsTag.add(AllBlocks.ITEM_VAULT.asItem());
        itemVaultsTag.add(AllBlocks.ITEM_VAULT.asItem());
        baseVaultsTag.add(AllBlocks.ITEM_VAULT.asItem());

        for (List<BlockEntry<VibrantVaultBlock>> vaults : ModBlocks.VIBRANT_VAULTS) {
            for (BlockEntry<VibrantVaultBlock> vault : vaults) {
                VibrantVaultBlock block = vault.get();
                Item item = vault.asItem();
                vibrantVaultsTag.add(item);
                boolean vertical = vault.get() instanceof VerticalVaultBlock;
                if (vertical) {
                    verticalVaultsTag.add(item);
                } else {
                    horizontalVaultsTag.add(item);
                }
                if (block.type == ModBlocks.VibrantVaultType.ITEM_VAULT) {
                    itemVaultsTag.add(item);

                    if (block.color != ModBlocks.VibrantVaultColor.BASE) {
                        if (vertical) {
                            coloredVerticalItemVaultsTag.add(item);
                        } else {
                            coloredHorizontalItemVaultsTag.add(item);
                        }
                    }
                } else if (block.type == ModBlocks.VibrantVaultType.SHIPPING_CONTAINER) {
                    shippingContainersTag.add(item);

                    if (block.color != ModBlocks.VibrantVaultColor.BASE) {
                        if (vertical) {
                            coloredVerticalShippingContainersTag.add(item);
                        } else {
                            coloredHorizontalShippingContainersTag.add(item);
                        }
                    }
                } else if (block.type == ModBlocks.VibrantVaultType.BASIC_SHIPPING_CONTAINER) {
                    basicShippingContainersTag.add(item);

                    if (block.color != ModBlocks.VibrantVaultColor.BASE) {
                        if (vertical) {
                            coloredVerticalBasicShippingContainersTag.add(item);
                        } else {
                            coloredHorizontalBasicShippingContainersTag.add(item);
                        }
                    }
                }
                if (block.color == ModBlocks.VibrantVaultColor.WHITE) {
                    whiteVaultsTag.add(item);
                } else if (block.color == ModBlocks.VibrantVaultColor.ORANGE) {
                    orangeVaultsTag.add(item);
                } else if (block.color == ModBlocks.VibrantVaultColor.MAGENTA) {
                    magentaVaultsTag.add(item);
                } else if (block.color == ModBlocks.VibrantVaultColor.LIGHT_BLUE) {
                    lightBlueVaultsTag.add(item);
                } else if (block.color == ModBlocks.VibrantVaultColor.YELLOW) {
                    yellowVaultsTag.add(item);
                } else if (block.color == ModBlocks.VibrantVaultColor.LIME) {
                    limeVaultsTag.add(item);
                } else if (block.color == ModBlocks.VibrantVaultColor.PINK) {
                    pinkVaultsTag.add(item);
                } else if (block.color == ModBlocks.VibrantVaultColor.GRAY) {
                    grayVaultsTag.add(item);
                } else if (block.color == ModBlocks.VibrantVaultColor.LIGHT_GRAY) {
                    lightGrayVaultsTag.add(item);
                } else if (block.color == ModBlocks.VibrantVaultColor.CYAN) {
                    cyanVaultsTag.add(item);
                } else if (block.color == ModBlocks.VibrantVaultColor.PURPLE) {
                    purpleVaultsTag.add(item);
                } else if (block.color == ModBlocks.VibrantVaultColor.BLUE) {
                    blueVaultsTag.add(item);
                } else if (block.color == ModBlocks.VibrantVaultColor.BROWN) {
                    brownVaultsTag.add(item);
                } else if (block.color == ModBlocks.VibrantVaultColor.GREEN) {
                    greenVaultsTag.add(item);
                } else if (block.color == ModBlocks.VibrantVaultColor.RED) {
                    redVaultsTag.add(item);
                } else if (block.color == ModBlocks.VibrantVaultColor.BLACK) {
                    blackVaultsTag.add(item);
                } else if (block.color == ModBlocks.VibrantVaultColor.BASE) {
                    baseVaultsTag.add(item);
                }
            }
        }

        frogportsTag.addTag(ModItemTags.VIBRANT_FROGPORTS.tag);
        frogportsTag.add(AllBlocks.PACKAGE_FROGPORT.asItem());

        for (BlockEntry<VibrantFrogportBlock> frogport : ModBlocks.VIBRANT_FROGPORTS) {
            vibrantFrogportsTag.add(frogport.asItem());
        }

        stockLinksTag.addTag(ModItemTags.VIBRANT_STOCK_LINKS.tag);
        stockLinksTag.add(AllBlocks.STOCK_LINK.asItem());

        for (BlockEntry<VibrantStockLinkBlock> stockLink : ModBlocks.VIBRANT_STOCK_LINKS) {
            vibrantStockLinksTag.add(stockLink.asItem());
        }

        redstoneRequestersTag.addTag(ModItemTags.VIBRANT_REDSTONE_REQUESTERS.tag);
        redstoneRequestersTag.add(AllBlocks.REDSTONE_REQUESTER.asItem());

        for (BlockEntry<VibrantRedstoneRequesterBlock> redstoneRequester : ModBlocks.VIBRANT_REDSTONE_REQUESTERS) {
            vibrantRedstoneRequestersTag.add(redstoneRequester.asItem());
        }

        for (ModItemTags tag : ModItemTags.values()) {
            prov.getOrCreateRawBuilder(tag.tag);
        }
    }
}
