package net.zlt.create_vibrant_vaults.data;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.simibubi.create.Create;
import com.simibubi.create.foundation.utility.FilesHelper;
import com.tterrag.registrate.providers.ProviderType;
import com.tterrag.registrate.providers.RegistrateBlockstateProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.BlockModelBuilder;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.data.event.GatherDataEvent;
import net.zlt.create_vibrant_vaults.CreateVibrantVaults;
import net.zlt.create_vibrant_vaults.block.ModBlocks;
import net.zlt.create_vibrant_vaults.duck.ModelBuilderMixinDuck;

import java.util.Map;
import java.util.function.BiConsumer;

public class CreateVibrantVaultsDatagen {
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        CreateVibrantVaults.REGISTRATE.addDataGenerator(ProviderType.LANG, provider -> provideDefaultLang("interface", provider::add));
        CreateVibrantVaults.REGISTRATE.addDataGenerator(ProviderType.BLOCKSTATE, CreateVibrantVaultsDatagen::providePackageFrogportModels);
        CreateVibrantVaultsTagProvider.addGenerators();
        generator.addProvider(true, new CreateVibrantVaultsRecipeProvider(output));
        generator.addProvider(true, new CreateVibrantVaultsCreateSplashingRecipeProvider(output));
    }

    private static void provideDefaultLang(String filename, BiConsumer<String, String> consumer) {
        String path = "assets/create_vibrant_vaults/lang/default/" + filename + ".json";
        JsonElement jsonElement = FilesHelper.loadJsonResource(path);
        if (jsonElement == null) {
            throw new IllegalStateException(String.format("Could not find default lang file: %s", path));
        }
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue().getAsString();
            consumer.accept(key, value);
        }
    }

    @SuppressWarnings("unchecked")
    private static void providePackageFrogportModels(RegistrateBlockstateProvider provider) {
        ModBlocks.VibrantVaultColor[] colors = ModBlocks.VibrantVaultColor.values();
        for (ModBlocks.VibrantVaultColor color : colors) {
            if (color != ModBlocks.VibrantVaultColor.BASE) {
                String colorId = color.asId();

                provider.models()
                    .getBuilder("block/" + colorId + "_package_frogport/block")
                    .parent(new ModelFile.UncheckedModelFile(Create.asResource("block/package_frogport/block")))
                    .texture("0", provider.modLoc("block/package_frogport/" + colorId + "/port2"))
                    .texture("particle", provider.modLoc("block/item_vault/" + colorId + "/vault_top_small"));

                provider.models()
                    .getBuilder("block/" + colorId + "_package_frogport/body")
                    .parent(new ModelFile.UncheckedModelFile(Create.asResource("block/package_frogport/body")))
                    .texture("0", provider.modLoc("block/package_frogport/" + colorId + "/port2"))
                    .texture("1", provider.modLoc("block/package_frogport/" + colorId + "/port"))
                    .texture("particle", provider.modLoc("block/package_frogport/" + colorId + "/port2"));

                provider.models()
                    .getBuilder("block/" + colorId + "_package_frogport/head")
                    .parent(new ModelFile.UncheckedModelFile(Create.asResource("block/package_frogport/head")))
                    .texture("0", provider.modLoc("block/package_frogport/" + colorId + "/port2"))
                    .texture("1", provider.modLoc("block/package_frogport/" + colorId + "/port"))
                    .texture("particle", provider.modLoc("block/package_frogport/" + colorId + "/port2"));

                BlockModelBuilder headGogglesBuilder = provider.models().getBuilder("block/" + colorId + "_package_frogport/head_goggles");
                headGogglesBuilder
                    .parent(new ModelFile.UncheckedModelFile(Create.asResource("block/package_frogport/head_goggles")))
                    .texture("0", provider.modLoc("block/package_frogport/" + colorId + "/port2"))
                    .texture("1", provider.modLoc("block/package_frogport/" + colorId + "/port"));
                ((ModelBuilderMixinDuck<BlockModelBuilder>) headGogglesBuilder).createVibrantVaults$uncheckedTexture("2", Create.asResource("block/froggles"));
                headGogglesBuilder.texture("particle", provider.modLoc("block/package_frogport/" + colorId + "/port2"));

                provider.models()
                    .getBuilder("block/" + colorId + "_package_frogport/item")
                    .parent(new ModelFile.UncheckedModelFile(Create.asResource("block/package_frogport/item")))
                    .texture("0", provider.modLoc("block/package_frogport/" + colorId + "/port2"))
                    .texture("1", provider.modLoc("block/package_frogport/" + colorId + "/port"))
                    .texture("particle", provider.modLoc("block/item_vault/" + colorId + "/vault_top_small"));

                provider.models()
                    .getBuilder("block/" + colorId + "_package_frogport/tongue")
                    .parent(new ModelFile.UncheckedModelFile(Create.asResource("block/package_frogport/tongue")))
                    .texture("0", provider.modLoc("block/package_frogport/" + colorId + "/port2"))
                    .texture("particle", provider.modLoc("block/package_frogport/" + colorId + "/port2"));
            }
        }
    }
}
