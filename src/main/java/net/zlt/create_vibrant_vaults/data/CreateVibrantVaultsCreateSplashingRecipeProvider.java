package net.zlt.create_vibrant_vaults.data;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.simibubi.create.AllBlocks;
import com.simibubi.create.Create;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricCodecDataProvider;
import net.fabricmc.fabric.api.recipe.v1.ingredient.DefaultCustomIngredients;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Ingredient;
import net.zlt.create_vibrant_vaults.CreateVibrantVaults;
import net.zlt.create_vibrant_vaults.block.ModBlocks;
import net.zlt.create_vibrant_vaults.item.ModItemTags;

import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

// TODO: move to normal recipe provider
public class CreateVibrantVaultsCreateSplashingRecipeProvider extends FabricCodecDataProvider<CreateVibrantVaultsCreateSplashingRecipeProvider.Entry> {
    protected CreateVibrantVaultsCreateSplashingRecipeProvider(FabricDataOutput dataOutput) {
        super(dataOutput, PackOutput.Target.DATA_PACK, "recipes", Entry.CODEC);
    }

    @Override
    protected void configure(BiConsumer<ResourceLocation, Entry> provider) {
        for (ModBlocks.VibrantVaultType type : ModBlocks.VibrantVaultType.values()) {
            DefaultCustomIngredients.difference(Ingredient.of(ModItemTags.ofType(type).tag), Ingredient.of(ModItemTags.BASE_VAULTS.tag));
            if (type == ModBlocks.VibrantVaultType.ITEM_VAULT) {
                provider.accept(CreateVibrantVaults.asResource(ModBlocks.VibrantVaultType.ITEM_VAULT.asId(false) + "_color_washing"), new Entry(ModItemTags.COLORED_HORIZONTAL_ITEM_VAULTS.tag.location(), AllBlocks.ITEM_VAULT.getId()));
            } else {
                provider.accept(CreateVibrantVaults.asResource(type.asId(false) + "_color_washing"), new Entry(ModItemTags.ofColored(type, false).tag.location(), ModBlocks.getVibrantVault(type, ModBlocks.VibrantVaultColor.BASE, false).getId()));
            }
            provider.accept(CreateVibrantVaults.asResource(type.asId(true) + "_color_washing"), new Entry(ModItemTags.ofColored(type, true).tag.location(), ModBlocks.getVibrantVault(type, ModBlocks.VibrantVaultColor.BASE, true).getId()));
        }
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
