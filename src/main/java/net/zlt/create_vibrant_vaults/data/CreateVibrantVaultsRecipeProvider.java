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
import net.zlt.create_vibrant_vaults.block.ModBlocks;
import net.zlt.create_vibrant_vaults.block.VerticalVaultBlock;
import net.zlt.create_vibrant_vaults.block.VibrantVaultBlock;
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

        for (ModBlocks.VibrantVaultColor color : ModBlocks.VibrantVaultColor.values()) {
            Block frogport = color == ModBlocks.VibrantVaultColor.BASE ? AllBlocks.PACKAGE_FROGPORT.get() : ModBlocks.getVibrantFrogport(color).get();

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

            if (color == ModBlocks.VibrantVaultColor.BASE) {
                continue;
            }

            ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, frogport)
                .requires(ModItemTags.FROGPORTS.tag)
                .requires(DyeItem.byColor(DyeColor.byId(color.ordinal())))
                .unlockedBy("has_frogport", has(ModItemTags.FROGPORTS.tag))
                .save(exporter, CreateVibrantVaults.ID + ":crafting/" + getItemName(frogport) + "_from_dyeing");
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
                .output(AllBlocks.PACKAGE_FROGPORT));
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
