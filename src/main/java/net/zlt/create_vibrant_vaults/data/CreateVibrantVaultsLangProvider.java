package net.zlt.create_vibrant_vaults.data;

import com.simibubi.create.foundation.data.TagLangGen;
import com.tterrag.registrate.providers.ProviderType;
import com.tterrag.registrate.providers.RegistrateLangProvider;
import net.zlt.create_vibrant_vaults.CreateVibrantVaults;
import net.zlt.create_vibrant_vaults.item.ModItemTags;

public class CreateVibrantVaultsLangProvider {
    public static void addGenerators() {
        CreateVibrantVaults.REGISTRATE.addDataGenerator(ProviderType.LANG, CreateVibrantVaultsLangProvider::genItemTagLang);
    }

    private static void genItemTagLang(RegistrateLangProvider prov) {
        TagLangGen.TagLangHelper createVibrantVaults = new TagLangGen.TagLangHelper(CreateVibrantVaults.ID, prov);

        for (ModItemTags tag : ModItemTags.values()) {
            createVibrantVaults.auto(tag.asId());
        }
    }
}
