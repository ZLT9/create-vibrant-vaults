package net.zlt.create_vibrant_vaults.data;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllItems;
import com.simibubi.create.AllRecipeTypes;
import com.simibubi.create.api.data.recipe.BaseRecipeProvider;
import com.simibubi.create.content.processing.recipe.ProcessingRecipe;
import com.simibubi.create.content.processing.recipe.ProcessingRecipeBuilder;
import com.simibubi.create.content.processing.recipe.ProcessingRecipeSerializer;
import com.simibubi.create.foundation.recipe.IRecipeTypeInfo;
import com.tterrag.registrate.util.entry.BlockEntry;
import io.github.fabricators_of_create.porting_lib.tags.Tags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.recipe.v1.ingredient.DefaultCustomIngredients;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.zlt.create_vibrant_vaults.CreateVibrantVaults;
import net.zlt.create_vibrant_vaults.block.*;
import net.zlt.create_vibrant_vaults.item.CreateVibrantVaultsItemPredicateBuilder;
import net.zlt.create_vibrant_vaults.item.ModItemTags;
import net.zlt.create_vibrant_vaults.item.crafting.ModRecipeSerializers;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

public class CreateVibrantVaultsRecipeProvider extends FabricRecipeProvider {
    public CreateVibrantVaultsRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void buildRecipes(Consumer<FinishedRecipe> exporter) {
        SpecialRecipeBuilder.special(ModRecipeSerializers.VAULT_COLORING).save(exporter, "vault_coloring");
        SpecialRecipeBuilder.special(ModRecipeSerializers.VAULT_ROTATING).save(exporter, "vault_rotating");

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

            Ingredient vibrantColorVaults = color == ModBlocks.VibrantVaultColor.BASE ? DefaultCustomIngredients.difference(Ingredient.of(ModItemTags.ofColor(color).tag), Ingredient.of(AllBlocks.ITEM_VAULT)) : Ingredient.of(ModItemTags.ofColor(color).tag);

            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, frogport)
                .define('A', vibrantColorVaults)
                .define('B', Tags.Items.SLIMEBALLS)
                .define('C', AllItems.ANDESITE_ALLOY)
                .pattern("B")
                .pattern("A")
                .pattern("C")
                .unlockedBy("has_item", has(AllItems.CARDBOARD))
                .save(exporter, CreateVibrantVaults.ID + ":crafting/" + getItemName(frogport));

            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, stockLink)
                .define('B', vibrantColorVaults)
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
        }

        for (List<BlockEntry<VibrantVaultBlock>> vaults : ModBlocks.VIBRANT_VAULTS) {
            for (BlockEntry<VibrantVaultBlock> vault : vaults) {
                VibrantVaultBlock block = vault.get();
                String colorId = block.color.asId();
                boolean vertical = block instanceof VerticalVaultBlock;
                Ingredient colorAndOrientationIngredient = DefaultCustomIngredients.difference(DefaultCustomIngredients.all(Ingredient.of(ModItemTags.ofColor(block.color).tag), Ingredient.of(ModItemTags.ofOrientation(vertical).tag)), Ingredient.of(ModItemTags.ofType(block.type).tag));
                SingleItemRecipeBuilder.stonecutting(colorAndOrientationIngredient, RecipeCategory.MISC, vault)
                    .unlockedBy("has_" + colorId + "_" + (vertical ? "vertical" : "horizontal") + "_vault", inventoryTrigger(CreateVibrantVaultsItemPredicateBuilder.create().ingredient(colorAndOrientationIngredient).build()))
                    .save(exporter, CreateVibrantVaults.ID + ":" + getItemName(vault) + "_from_" + colorId + "_"  + (vertical ? "vertical" : "horizontal") + "_vaults");
            }
        }

        Ingredient colorAndOrientationIngredient = DefaultCustomIngredients.difference(DefaultCustomIngredients.all(Ingredient.of(ModItemTags.BASE_VAULTS.tag), Ingredient.of(ModItemTags.HORIZONTAL_VAULTS.tag)), Ingredient.of(ModItemTags.ITEM_VAULTS.tag));
        String baseColorId = ModBlocks.VibrantVaultColor.BASE.asId();
        SingleItemRecipeBuilder.stonecutting(colorAndOrientationIngredient, RecipeCategory.MISC, AllBlocks.ITEM_VAULT)
            .unlockedBy("has_" + baseColorId + "_horizontal_vault", inventoryTrigger(CreateVibrantVaultsItemPredicateBuilder.create().ingredient(colorAndOrientationIngredient).build()))
            .save(exporter, CreateVibrantVaults.ID + ":" + getItemName(AllBlocks.ITEM_VAULT) + "_from_" + baseColorId + "_horizontal_vaults");

        CreateProcessingRecipeProvider.of(AllRecipeTypes.SPLASHING, exporter)
            .add("frogport_color_washing", b -> b
                .require(ModItemTags.VIBRANT_FROGPORTS.tag)
                .output(AllBlocks.PACKAGE_FROGPORT))
            .add("stock_link_color_washing", b -> b
                .require(ModItemTags.VIBRANT_STOCK_LINKS.tag)
                .output(AllBlocks.STOCK_LINK))
            .add("redstone_requester_color_washing", b -> b
                .require(ModItemTags.VIBRANT_REDSTONE_REQUESTERS.tag)
                .output(AllBlocks.REDSTONE_REQUESTER))
            .add("packager_color_washing", b -> b
                .require(ModItemTags.VIBRANT_PACKAGERS.tag)
                .output(AllBlocks.PACKAGER));
    }

    public abstract static class CreateProcessingRecipeProvider {
        public static CreateProcessingRecipeProvider of(IRecipeTypeInfo recipeType, Consumer<FinishedRecipe> exporter) {
            return new CreateProcessingRecipeProvider() {
                @Override
                public IRecipeTypeInfo getRecipeType() {
                    return recipeType;
                }

                @Override
                public void register(BaseRecipeProvider.GeneratedRecipe recipe) {
                    recipe.register(exporter);
                }
            };
        }

        public <T extends ProcessingRecipe<?>> BaseRecipeProvider.GeneratedRecipe recipe(String name, UnaryOperator<ProcessingRecipeBuilder<T>> transform) {
            return output -> transform.apply(new ProcessingRecipeBuilder<>(getRecipeType().<ProcessingRecipeSerializer<T>>getSerializer().getFactory(), CreateVibrantVaults.asResource(name))).build(output);
        }

        public <T extends ProcessingRecipe<?>> CreateProcessingRecipeProvider add(String name, UnaryOperator<ProcessingRecipeBuilder<T>> transform) {
            register(recipe(name, transform));
            return this;
        }

        public <T> CreateProcessingRecipeProvider forEach(T[] values, BiFunction<CreateProcessingRecipeProvider, T, List<BaseRecipeProvider.GeneratedRecipe>> recipes) {
            for (T value : values) {
                for (BaseRecipeProvider.GeneratedRecipe recipe : recipes.apply(this, value)) {
                    register(recipe);
                }
            }
            return this;
        }

        public abstract IRecipeTypeInfo getRecipeType();

        public abstract void register(BaseRecipeProvider.GeneratedRecipe recipe);
    }
}
