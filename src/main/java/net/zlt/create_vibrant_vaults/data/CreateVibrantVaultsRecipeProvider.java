package net.zlt.create_vibrant_vaults.data;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllItems;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.DifferenceIngredient;
import net.minecraftforge.common.crafting.IntersectionIngredient;
import net.zlt.create_vibrant_vaults.CreateVibrantVaults;
import net.zlt.create_vibrant_vaults.block.*;
import net.zlt.create_vibrant_vaults.item.CreateVibrantVaultsItemPredicateBuilder;
import net.zlt.create_vibrant_vaults.item.ModItemTags;

import java.util.List;
import java.util.function.Consumer;

public class CreateVibrantVaultsRecipeProvider extends RecipeProvider {
    public CreateVibrantVaultsRecipeProvider(PackOutput output) {
        super(output);
    }

    @Override
    public void buildRecipes(Consumer<FinishedRecipe> exporter) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, AllBlocks.FACTORY_GAUGE, 2)
            .requires(ModItemTags.VIBRANT_STOCK_LINKS.tag)
            .requires(AllItems.PRECISION_MECHANISM)
            .unlockedBy("has_stock_link", has(ModItemTags.VIBRANT_STOCK_LINKS.tag))
            .save(exporter, CreateVibrantVaults.ID + ":crafting/" + getItemName(AllBlocks.FACTORY_GAUGE) + "_from_vibrant_stock_links");
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, AllBlocks.STOCK_TICKER)
            .define('A', ModItemTags.VIBRANT_STOCK_LINKS.tag)
            .define('B', Tags.Items.INGOTS_GOLD)
            .define('C', Tags.Items.GLASS)
            .pattern("C")
            .pattern("A")
            .pattern("B")
            .unlockedBy("has_item", has(AllItems.CARDBOARD))
            .save(exporter, CreateVibrantVaults.ID + ":crafting/" + getItemName(AllBlocks.STOCK_TICKER) + "_from_vibrant_stock_links");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, AllBlocks.REPACKAGER)
            .requires(ModItemTags.VIBRANT_PACKAGERS.tag)
            .unlockedBy("has_packager", has(ModItemTags.VIBRANT_PACKAGERS.tag))
            .save(exporter, CreateVibrantVaults.ID + ":crafting/" + getItemName(AllBlocks.REPACKAGER) + "_from_vibrant_packagers");

        for (ModBlocks.VibrantVaultColor color : ModBlocks.VibrantVaultColor.values()) {
            Block frogport = color == ModBlocks.VibrantVaultColor.BASE ? AllBlocks.PACKAGE_FROGPORT.get() : ModBlocks.getVibrantFrogport(color).get();
            Block stockLink = color == ModBlocks.VibrantVaultColor.BASE ? AllBlocks.STOCK_LINK.get() : ModBlocks.getVibrantStockLink(color).get();

            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, frogport)
                .define('A', ModItemTags.ofColor(color).tag)
                .define('B', Tags.Items.SLIMEBALLS)
                .define('C', AllItems.ANDESITE_ALLOY)
                .pattern("B")
                .pattern("A")
                .pattern("C")
                .unlockedBy("has_item", has(AllItems.CARDBOARD))
                .save(exporter, CreateVibrantVaults.ID + ":crafting/" + getItemName(frogport));

            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, stockLink)
                .define('B', ModItemTags.ofColor(color).tag)
                .define('C', AllItems.TRANSMITTER)
                .pattern("C")
                .pattern("B")
                .unlockedBy("has_item", has(AllItems.CARDBOARD))
                .save(exporter, CreateVibrantVaults.ID + ":crafting/" + getItemName(stockLink));

            if (color == ModBlocks.VibrantVaultColor.BASE) {
                continue;
            }

            ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, frogport)
                .requires(ModItemTags.FROGPORTS.tag)
                .requires(DyeItem.byColor(DyeColor.byId(color.ordinal())))
                .unlockedBy("has_frogport", has(ModItemTags.FROGPORTS.tag))
                .save(exporter, CreateVibrantVaults.ID + ":crafting/" + getItemName(frogport) + "_from_dyeing");

            ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, stockLink)
                .requires(stockLink)
                .unlockedBy("has_item", has(stockLink))
                .save(exporter, CreateVibrantVaults.ID + ":crafting/" + getItemName(stockLink) + "_clear");
            ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, stockLink)
                .requires(ModItemTags.STOCK_LINKS.tag)
                .requires(DyeItem.byColor(DyeColor.byId(color.ordinal())))
                .unlockedBy("has_stock_link", has(ModItemTags.STOCK_LINKS.tag))
                .save(exporter, CreateVibrantVaults.ID + ":crafting/" + getItemName(stockLink) + "_from_dyeing");

            BlockEntry<VibrantRedstoneRequesterBlock> redstoneRequester = ModBlocks.getVibrantRedstoneRequester(color);
            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, redstoneRequester)
                .define('A', stockLink)
                .define('B', Tags.Items.INGOTS_IRON)
                .define('C', Tags.Items.DUSTS_REDSTONE)
                .pattern("C")
                .pattern("A")
                .pattern("B")
                .unlockedBy("has_item", has(AllItems.CARDBOARD))
                .save(exporter, CreateVibrantVaults.ID + ":crafting/" + getItemName(redstoneRequester));
            ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, redstoneRequester)
                .requires(redstoneRequester)
                .unlockedBy("has_item", has(redstoneRequester))
                .save(exporter, CreateVibrantVaults.ID + ":crafting/" + getItemName(redstoneRequester) + "_clear");
            ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, redstoneRequester)
                .requires(ModItemTags.REDSTONE_REQUESTERS.tag)
                .requires(DyeItem.byColor(DyeColor.byId(color.ordinal())))
                .unlockedBy("has_redstone_requester", has(ModItemTags.REDSTONE_REQUESTERS.tag))
                .save(exporter, CreateVibrantVaults.ID + ":crafting/" + getItemName(redstoneRequester) + "_from_dyeing");

            BlockEntry<VibrantPackagerBlock> packager = ModBlocks.getVibrantPackager(color);
            ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, packager)
                .requires(ModItemTags.PACKAGERS.tag)
                .requires(DyeItem.byColor(DyeColor.byId(color.ordinal())))
                .unlockedBy("has_packager", has(ModItemTags.PACKAGERS.tag))
                .save(exporter, CreateVibrantVaults.ID + ":crafting/" + getItemName(packager));

            for (ModBlocks.VibrantVaultType type : ModBlocks.VibrantVaultType.values()) {
                BlockEntry<VibrantVaultBlock> horizontalVault = ModBlocks.getVibrantVault(type, color, false);
                Ingredient typeAndHorizontalIngredient = IntersectionIngredient.of(Ingredient.of(ModItemTags.ofType(type).tag), Ingredient.of(ModItemTags.ofOrientation(false).tag));
                ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, horizontalVault)
                    .requires(typeAndHorizontalIngredient)
                    .requires(DyeItem.byColor(DyeColor.byId(color.ordinal())))
                    .unlockedBy("has_vault", inventoryTrigger(CreateVibrantVaultsItemPredicateBuilder.create().ingredient(typeAndHorizontalIngredient).build()))
                    .save(exporter, CreateVibrantVaults.ID + ":crafting/" + getItemName(horizontalVault) + "_from_dyeing");

                BlockEntry<VibrantVaultBlock> verticalVault = ModBlocks.getVibrantVault(type, color, true);
                Ingredient typeAndVerticalIngredient = IntersectionIngredient.of(Ingredient.of(ModItemTags.ofType(type).tag), Ingredient.of(ModItemTags.ofOrientation(true).tag));
                ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, verticalVault)
                    .requires(typeAndVerticalIngredient)
                    .requires(DyeItem.byColor(DyeColor.byId(color.ordinal())))
                    .unlockedBy("has_vault", inventoryTrigger(CreateVibrantVaultsItemPredicateBuilder.create().ingredient(typeAndVerticalIngredient).build()))
                    .save(exporter, CreateVibrantVaults.ID + ":crafting/" + getItemName(verticalVault) + "_from_dyeing");
            }
        }

        for (List<BlockEntry<VibrantVaultBlock>> vaults : ModBlocks.VIBRANT_VAULTS) {
            for (BlockEntry<VibrantVaultBlock> vault : vaults) {
                VibrantVaultBlock block = vault.get();
                String colorId = block.color.asId();
                boolean vertical = block instanceof VerticalVaultBlock;
                Ingredient colorAndOrientationIngredient = DifferenceIngredient.of(IntersectionIngredient.of(Ingredient.of(ModItemTags.ofColor(block.color).tag), Ingredient.of(ModItemTags.ofOrientation(vertical).tag)), Ingredient.of(ModItemTags.ofType(block.type).tag));
                SingleItemRecipeBuilder.stonecutting(colorAndOrientationIngredient, RecipeCategory.MISC, vault)
                    .unlockedBy("has_" + colorId + "_" + (vertical ? "vertical" : "horizontal") + "_vault", inventoryTrigger(CreateVibrantVaultsItemPredicateBuilder.create().ingredient(colorAndOrientationIngredient).build()))
                    .save(exporter, CreateVibrantVaults.ID + ":stonecutting/" + getItemName(vault) + "_from_" + colorId + "_" + (vertical ? "vertical" : "horizontal") + "_vaults");
                ItemLike rotatedVault = block.type == ModBlocks.VibrantVaultType.ITEM_VAULT && block.color == ModBlocks.VibrantVaultColor.BASE ? AllBlocks.ITEM_VAULT : ModBlocks.getVibrantVault(block.type, block.color, !vertical);
                ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, vault)
                    .requires(rotatedVault)
                    .unlockedBy("has_rotated_vault", has(rotatedVault))
                    .save(exporter, CreateVibrantVaults.ID + ":crafting/" + getItemName(vault) + "_from_rotating");
            }
        }

        Ingredient colorAndOrientationIngredient = DifferenceIngredient.of(IntersectionIngredient.of(Ingredient.of(ModItemTags.BASE_VAULTS.tag), Ingredient.of(ModItemTags.HORIZONTAL_VAULTS.tag)), Ingredient.of(ModItemTags.ITEM_VAULTS.tag));
        String baseColorId = ModBlocks.VibrantVaultColor.BASE.asId();
        SingleItemRecipeBuilder.stonecutting(colorAndOrientationIngredient, RecipeCategory.MISC, AllBlocks.ITEM_VAULT)
            .unlockedBy("has_" + baseColorId + "_horizontal_vault", inventoryTrigger(CreateVibrantVaultsItemPredicateBuilder.create().ingredient(colorAndOrientationIngredient).build()))
            .save(exporter, CreateVibrantVaults.ID + ":stonecutting/" + getItemName(AllBlocks.ITEM_VAULT) + "_from_" + baseColorId + "_horizontal_vaults");
        BlockEntry<VibrantVaultBlock> rotatedVault = ModBlocks.getVibrantVault(ModBlocks.VibrantVaultType.ITEM_VAULT, ModBlocks.VibrantVaultColor.BASE, true);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, AllBlocks.ITEM_VAULT)
            .requires(rotatedVault)
            .unlockedBy("has_rotated_vault", has(rotatedVault))
            .save(exporter, CreateVibrantVaults.ID + ":crafting/" + getItemName(AllBlocks.ITEM_VAULT) + "_from_" + getItemName(rotatedVault));
    }
}
