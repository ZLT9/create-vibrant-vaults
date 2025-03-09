package net.zlt.create_vibrant_vaults.item.crafting;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SimpleCraftingRecipeSerializer;
import net.zlt.create_vibrant_vaults.CreateVibrantVaults;

public final class ModRecipeSerializers {
    private ModRecipeSerializers() {
    }

    public static final RecipeSerializer<VaultColoringRecipe> VAULT_COLORING = register("crafting_special_vaultcoloring", new SimpleCraftingRecipeSerializer<>(VaultColoringRecipe::new));
    public static final RecipeSerializer<VaultRotatingRecipe> VAULT_ROTATING = register("crafting_special_vaultrotating", new SimpleCraftingRecipeSerializer<>(VaultRotatingRecipe::new));

    private static <S extends RecipeSerializer<T>, T extends Recipe<?>> S register(String name, S recipeSerializer) {
        return Registry.register(BuiltInRegistries.RECIPE_SERIALIZER, CreateVibrantVaults.asResource(name), recipeSerializer);
    }

    public static void init() {
    }
}
