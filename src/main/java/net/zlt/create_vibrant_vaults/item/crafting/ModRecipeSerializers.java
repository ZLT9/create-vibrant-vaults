package net.zlt.create_vibrant_vaults.item.crafting;

import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SimpleCraftingRecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.zlt.create_vibrant_vaults.CreateVibrantVaults;

public final class ModRecipeSerializers {
    private ModRecipeSerializers() {
    }

    private static final DeferredRegister<RecipeSerializer<?>> REGISTER = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, CreateVibrantVaults.ID);

    public static final RegistryObject<RecipeSerializer<VaultColoringRecipe>> VAULT_COLORING = REGISTER.register("crafting_special_vaultcoloring", () -> new SimpleCraftingRecipeSerializer<>(VaultColoringRecipe::new));
    public static final RegistryObject<RecipeSerializer<VaultRotatingRecipe>> VAULT_ROTATING = REGISTER.register("crafting_special_vaultrotating", () -> new SimpleCraftingRecipeSerializer<>(VaultRotatingRecipe::new));

    public static void init(IEventBus modEventBus) {
        REGISTER.register(modEventBus);
    }
}
