package net.zlt.create_vibrant_vaults.data;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.simibubi.create.foundation.utility.FilesHelper;
import com.tterrag.registrate.providers.ProviderType;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.data.event.GatherDataEvent;
import net.zlt.create_vibrant_vaults.CreateVibrantVaults;

import java.util.Map;
import java.util.function.BiConsumer;

public class CreateVibrantVaultsDatagen {
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        CreateVibrantVaults.REGISTRATE.addDataGenerator(ProviderType.LANG, provider -> provideDefaultLang("interface", provider::add));
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
}
