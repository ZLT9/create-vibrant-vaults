package net.zlt.create_vibrant_vaults.data;

import com.simibubi.create.AllBlocks;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.recipe.v1.ingredient.DefaultCustomIngredients;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.SingleItemRecipeBuilder;
import net.minecraft.data.recipes.SpecialRecipeBuilder;
import net.minecraft.world.item.crafting.Ingredient;
import net.zlt.create_vibrant_vaults.CreateVibrantVaults;
import net.zlt.create_vibrant_vaults.block.ModBlocks;
import net.zlt.create_vibrant_vaults.block.VerticalVaultBlock;
import net.zlt.create_vibrant_vaults.block.VibrantVaultBlock;
import net.zlt.create_vibrant_vaults.item.CreateVibrantVaultsItemPredicateBuilder;
import net.zlt.create_vibrant_vaults.item.ModItemTags;
import net.zlt.create_vibrant_vaults.item.crafting.ModRecipeSerializers;

import java.util.List;
import java.util.function.Consumer;

public class CreateVibrantVaultsRecipeProvider extends FabricRecipeProvider {
    public CreateVibrantVaultsRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void buildRecipes(Consumer<FinishedRecipe> exporter) {
        SpecialRecipeBuilder.special(ModRecipeSerializers.VAULT_COLORING).save(exporter, CreateVibrantVaults.ID + "vault_coloring");

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
    }
}
