package net.zlt.create_vibrant_vaults.data;

import com.mojang.serialization.Codec;
import com.mojang.serialization.JsonOps;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.simibubi.create.AllBlocks;
import com.simibubi.create.Create;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.crafting.DifferenceIngredient;
import net.zlt.create_vibrant_vaults.CreateVibrantVaults;
import net.zlt.create_vibrant_vaults.block.ModBlocks;
import net.zlt.create_vibrant_vaults.item.ModItemTags;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class CreateVibrantVaultsCreateSplashingRecipeProvider implements DataProvider {
    private final PackOutput.PathProvider path;

    protected CreateVibrantVaultsCreateSplashingRecipeProvider(PackOutput output) {
        path = output.createPathProvider(PackOutput.Target.DATA_PACK, "recipes");
    }

    @Override
    public CompletableFuture<?> run(CachedOutput output) {
        Map<ResourceLocation, Entry> entries = new HashMap<>();
        for (ModBlocks.VibrantVaultType type : ModBlocks.VibrantVaultType.values()) {
            DifferenceIngredient.of(Ingredient.of(ModItemTags.ofType(type).tag), Ingredient.of(ModItemTags.BASE_VAULTS.tag));
            if (type == ModBlocks.VibrantVaultType.ITEM_VAULT) {
                entries.put(CreateVibrantVaults.asResource("splashing/" + ModBlocks.VibrantVaultType.ITEM_VAULT.asId(false) + "_color_washing"), new Entry(ModItemTags.COLORED_HORIZONTAL_ITEM_VAULTS.tag.location(), AllBlocks.ITEM_VAULT.getId()));
            } else {
                entries.put(CreateVibrantVaults.asResource("splashing/" + type.asId(false) + "_color_washing"), new Entry(ModItemTags.ofColored(type, false).tag.location(), ModBlocks.getVibrantVault(type, ModBlocks.VibrantVaultColor.BASE, false).getId()));
            }
            entries.put(CreateVibrantVaults.asResource("splashing/" + type.asId(true) + "_color_washing"), new Entry(ModItemTags.ofColored(type, true).tag.location(), ModBlocks.getVibrantVault(type, ModBlocks.VibrantVaultColor.BASE, true).getId()));
        }
        return CompletableFuture.allOf(
            entries.entrySet().stream().map(entry ->
                DataProvider.saveStable(output,
                    Entry.CODEC.encodeStart(JsonOps.INSTANCE, entry.getValue()).resultOrPartial(CreateVibrantVaults.LOGGER::error).orElseThrow(),
                    path.json(entry.getKey())
                )
            ).toArray(CompletableFuture[]::new)
        );
    }

    @Override
    public String getName() {
        return "Create: Vibrant Vaults Create Splashing Recipes";
    }

    public record Entry(ResourceLocation type, List<Map<String, ResourceLocation>> ingredients, List<Map<String, ResourceLocation>> results) {
        public Entry(ResourceLocation ingredientTag, ResourceLocation resultItem) {
            this(Create.asResource("splashing"), List.of(Map.of("tag", ingredientTag)), List.of(Map.of("item", resultItem)));
        }

        public static final Codec<Entry> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            ResourceLocation.CODEC.fieldOf("type").forGetter(Entry::type),
            Codec.list(Codec.unboundedMap(Codec.STRING, ResourceLocation.CODEC)).fieldOf("ingredients").forGetter(Entry::ingredients),
            Codec.list(Codec.unboundedMap(Codec.STRING, ResourceLocation.CODEC)).fieldOf("results").forGetter(Entry::results)
        ).apply(instance, Entry::new));
    }
}
