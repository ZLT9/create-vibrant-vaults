package net.zlt.create_vibrant_vaults.data;

import com.simibubi.create.AllBlocks;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.DifferenceIngredient;
import net.minecraftforge.common.crafting.IntersectionIngredient;
import net.zlt.create_vibrant_vaults.CreateVibrantVaults;
import net.zlt.create_vibrant_vaults.block.ModBlocks;
import net.zlt.create_vibrant_vaults.block.VerticalVaultBlock;
import net.zlt.create_vibrant_vaults.block.VibrantVaultBlock;
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
        for (ModBlocks.VibrantVaultType type : ModBlocks.VibrantVaultType.values()) {
            for (ModBlocks.VibrantVaultColor color : ModBlocks.VibrantVaultColor.values()) {
                if (color == ModBlocks.VibrantVaultColor.BASE) {
                    continue;
                }

                BlockEntry<VibrantVaultBlock> horizontalVault = ModBlocks.getVibrantVault(type, color, false);
                Ingredient typeAndHorizontalIngredient = IntersectionIngredient.of(Ingredient.of(ModItemTags.ofType(type).tag), Ingredient.of(ModItemTags.ofOrientation(false).tag));
                ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, horizontalVault)
                    .requires(typeAndHorizontalIngredient)
                    .requires(DyeItem.byColor(DyeColor.byId(color.ordinal())))
                    .unlockedBy("has_vault", inventoryTrigger(CreateVibrantVaultsItemPredicateBuilder.create().ingredient(typeAndHorizontalIngredient).build()))
                    .save(exporter, CreateVibrantVaults.ID + ":" + getItemName(horizontalVault) + "_from_dyeing");

                BlockEntry<VibrantVaultBlock> verticalVault = ModBlocks.getVibrantVault(type, color, true);
                Ingredient typeAndVerticalIngredient = IntersectionIngredient.of(Ingredient.of(ModItemTags.ofType(type).tag), Ingredient.of(ModItemTags.ofOrientation(true).tag));
                ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, verticalVault)
                    .requires(typeAndVerticalIngredient)
                    .requires(DyeItem.byColor(DyeColor.byId(color.ordinal())))
                    .unlockedBy("has_vault", inventoryTrigger(CreateVibrantVaultsItemPredicateBuilder.create().ingredient(typeAndVerticalIngredient).build()))
                    .save(exporter, CreateVibrantVaults.ID + ":" + getItemName(verticalVault) + "_from_dyeing");
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
                    .save(exporter, CreateVibrantVaults.ID + ":" + getItemName(vault) + "_from_" + colorId + "_" + (vertical ? "vertical" : "horizontal") + "_vaults");
                ItemLike rotatedVault = block.type == ModBlocks.VibrantVaultType.ITEM_VAULT && block.color == ModBlocks.VibrantVaultColor.BASE ? AllBlocks.ITEM_VAULT : ModBlocks.getVibrantVault(block.type, block.color, !vertical);
                ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, vault)
                    .requires(rotatedVault)
                    .unlockedBy("has_rotated_vault", has(rotatedVault))
                    .save(exporter, CreateVibrantVaults.ID + ":" + getItemName(vault) + "_from_" + getItemName(rotatedVault));
            }
        }

        Ingredient colorAndOrientationIngredient = DifferenceIngredient.of(IntersectionIngredient.of(Ingredient.of(ModItemTags.BASE_VAULTS.tag), Ingredient.of(ModItemTags.HORIZONTAL_VAULTS.tag)), Ingredient.of(ModItemTags.ITEM_VAULTS.tag));
        String baseColorId = ModBlocks.VibrantVaultColor.BASE.asId();
        SingleItemRecipeBuilder.stonecutting(colorAndOrientationIngredient, RecipeCategory.MISC, AllBlocks.ITEM_VAULT)
            .unlockedBy("has_" + baseColorId + "_horizontal_vault", inventoryTrigger(CreateVibrantVaultsItemPredicateBuilder.create().ingredient(colorAndOrientationIngredient).build()))
            .save(exporter, CreateVibrantVaults.ID + ":" + getItemName(AllBlocks.ITEM_VAULT) + "_from_" + baseColorId + "_horizontal_vaults");
        BlockEntry<VibrantVaultBlock> rotatedVault = ModBlocks.getVibrantVault(ModBlocks.VibrantVaultType.ITEM_VAULT, ModBlocks.VibrantVaultColor.BASE, true);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, AllBlocks.ITEM_VAULT)
            .requires(rotatedVault)
            .unlockedBy("has_rotated_vault", has(rotatedVault))
            .save(exporter, CreateVibrantVaults.ID + ":" + getItemName(AllBlocks.ITEM_VAULT) + "_from_" + getItemName(rotatedVault));
    }
}
