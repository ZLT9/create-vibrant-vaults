package net.zlt.create_vibrant_vaults.data;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.simibubi.create.foundation.utility.FilesHelper;
import com.tterrag.registrate.providers.ProviderType;
import io.github.fabricators_of_create.porting_lib.data.ExistingFileHelper;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.zlt.create_vibrant_vaults.CreateVibrantVaults;

import java.util.Map;
import java.util.function.BiConsumer;

public class CreateVibrantVaultsDatagen implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        ExistingFileHelper helper = ExistingFileHelper.withResourcesFromArg();
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        CreateVibrantVaults.REGISTRATE.setupDatagen(pack, helper);
        CreateVibrantVaults.REGISTRATE.addDataGenerator(ProviderType.LANG, provider -> provideDefaultLang("interface", provider::add));
        CreateVibrantVaultsTagProvider.addGenerators();
        CreateVibrantVaultsLangProvider.addGenerators();
        pack.addProvider(CreateVibrantVaultsRecipeProvider::new);
        pack.addProvider(CreateVibrantVaultsCreateSplashingRecipeProvider::new);
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
}
