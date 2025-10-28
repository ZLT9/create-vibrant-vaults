package net.zlt.create_vibrant_vaults.data;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.simibubi.create.Create;
import com.simibubi.create.foundation.utility.FilesHelper;
import com.tterrag.registrate.providers.ProviderType;
import com.tterrag.registrate.providers.RegistrateBlockstateProvider;
import io.github.fabricators_of_create.porting_lib.data.ExistingFileHelper;
import io.github.fabricators_of_create.porting_lib.models.generators.ModelFile;
import io.github.fabricators_of_create.porting_lib.models.generators.block.BlockModelBuilder;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.zlt.create_vibrant_vaults.CreateVibrantVaults;
import net.zlt.create_vibrant_vaults.block.ModBlocks;
import net.zlt.create_vibrant_vaults.duck.ModelBuilderMixinDuck;

import java.util.Map;
import java.util.function.BiConsumer;

public class CreateVibrantVaultsDatagen implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        ExistingFileHelper helper = ExistingFileHelper.withResourcesFromArg();
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        CreateVibrantVaults.REGISTRATE.setupDatagen(pack, helper);
        CreateVibrantVaults.REGISTRATE.addDataGenerator(ProviderType.LANG, provider -> provideDefaultLang("interface", provider::add));
        CreateVibrantVaults.REGISTRATE.addDataGenerator(ProviderType.BLOCKSTATE, CreateVibrantVaultsDatagen::providePackageFrogportModels);
        CreateVibrantVaults.REGISTRATE.addDataGenerator(ProviderType.BLOCKSTATE, CreateVibrantVaultsDatagen::provideRedstoneRequesterModels);
        CreateVibrantVaults.REGISTRATE.addDataGenerator(ProviderType.BLOCKSTATE, CreateVibrantVaultsDatagen::providePackagerModels);
        CreateVibrantVaults.REGISTRATE.addDataGenerator(ProviderType.BLOCKSTATE, CreateVibrantVaultsDatagen::provideGaugeModels);
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
                    .texture("particle", provider.modLoc("block/item_vault/" + colorId + "/vault_top_small"))
                    .renderType("cutout");

                provider.models()
                    .getBuilder("block/" + colorId + "_package_frogport/body")
                    .parent(new ModelFile.UncheckedModelFile(Create.asResource("block/package_frogport/body")))
                    .texture("0", provider.modLoc("block/package_frogport/" + colorId + "/port2"))
                    .texture("1", provider.modLoc("block/package_frogport/" + colorId + "/port"))
                    .texture("particle", provider.modLoc("block/package_frogport/" + colorId + "/port2"))
                    .renderType("cutout");

                provider.models()
                    .getBuilder("block/" + colorId + "_package_frogport/head")
                    .parent(new ModelFile.UncheckedModelFile(Create.asResource("block/package_frogport/head")))
                    .texture("0", provider.modLoc("block/package_frogport/" + colorId + "/port2"))
                    .texture("1", provider.modLoc("block/package_frogport/" + colorId + "/port"))
                    .texture("particle", provider.modLoc("block/package_frogport/" + colorId + "/port2"))
                    .renderType("cutout");

                BlockModelBuilder headGogglesBuilder = provider.models().getBuilder("block/" + colorId + "_package_frogport/head_goggles");
                headGogglesBuilder
                    .parent(new ModelFile.UncheckedModelFile(Create.asResource("block/package_frogport/head_goggles")))
                    .texture("0", provider.modLoc("block/package_frogport/" + colorId + "/port2"))
                    .texture("1", provider.modLoc("block/package_frogport/" + colorId + "/port"));
                ((ModelBuilderMixinDuck<BlockModelBuilder>) headGogglesBuilder).createVibrantVaults$uncheckedTexture("2", Create.asResource("block/froggles"));
                headGogglesBuilder
                    .texture("particle", provider.modLoc("block/package_frogport/" + colorId + "/port2"))
                    .renderType("cutout");

                provider.models()
                    .getBuilder("block/" + colorId + "_package_frogport/item")
                    .parent(new ModelFile.UncheckedModelFile(Create.asResource("block/package_frogport/item")))
                    .texture("0", provider.modLoc("block/package_frogport/" + colorId + "/port2"))
                    .texture("1", provider.modLoc("block/package_frogport/" + colorId + "/port"))
                    .texture("particle", provider.modLoc("block/item_vault/" + colorId + "/vault_top_small"))
                    .renderType("cutout");

                provider.models()
                    .getBuilder("block/" + colorId + "_package_frogport/tongue")
                    .parent(new ModelFile.UncheckedModelFile(Create.asResource("block/package_frogport/tongue")))
                    .texture("0", provider.modLoc("block/package_frogport/" + colorId + "/port2"))
                    .texture("particle", provider.modLoc("block/package_frogport/" + colorId + "/port2"))
                    .renderType("cutout");
            }
        }
    }

    private static void provideRedstoneRequesterModels(RegistrateBlockstateProvider provider) {
        ModBlocks.VibrantVaultColor[] colors = ModBlocks.VibrantVaultColor.values();
        for (ModBlocks.VibrantVaultColor color : colors) {
            if (color != ModBlocks.VibrantVaultColor.BASE) {
                String colorId = color.asId();

                provider.models()
                    .getBuilder("block/" + colorId + "_redstone_requester/block")
                    .parent(new ModelFile.UncheckedModelFile(Create.asResource("block/redstone_requester/block")))
                    .texture("0", CreateVibrantVaults.asResource("block/redstone_requester/" + colorId + "/redstone_requester"))
                    .texture("1", CreateVibrantVaults.asResource("block/redstone_requester/" + colorId + "/redstone_requester_unpowered"))
                    .texture("particle", CreateVibrantVaults.asResource("block/redstone_requester/" + colorId + "/redstone_requester_unpowered"));

                provider.models()
                    .withExistingParent("block/" + colorId + "_redstone_requester/block_powered", CreateVibrantVaults.asResource("block/" + colorId + "_redstone_requester/block"))
                    .texture("1", CreateVibrantVaults.asResource("block/redstone_requester/" + colorId + "/redstone_requester_powered"))
                    .texture("particle", CreateVibrantVaults.asResource("block/redstone_requester/" + colorId + "/redstone_requester_powered"));
            }
        }
    }

    @SuppressWarnings("unchecked")
    private static void providePackagerModels(RegistrateBlockstateProvider provider) {
        ModBlocks.VibrantVaultColor[] colors = ModBlocks.VibrantVaultColor.values();
        for (ModBlocks.VibrantVaultColor color : colors) {
            if (color != ModBlocks.VibrantVaultColor.BASE) {
                String colorId = color.asId();

                BlockModelBuilder hatchClosedBuilder = provider.models()
                    .getBuilder("block/" + colorId + "_packager/hatch_closed")
                    .parent(new ModelFile.UncheckedModelFile(Create.asResource("block/packager/hatch_closed")))
                    .texture("1", CreateVibrantVaults.asResource("block/packager/" + colorId + "/packager_details"));
                ((ModelBuilderMixinDuck<BlockModelBuilder>) hatchClosedBuilder).createVibrantVaults$uncheckedTexture("3", Create.asResource("block/packager_iris_closed"));
                hatchClosedBuilder.texture("particle", CreateVibrantVaults.asResource("block/item_vault/" + colorId + "/vault_front_small"));

                ((ModelBuilderMixinDuck<BlockModelBuilder>) provider.models()
                    .withExistingParent("block/" + colorId + "_packager/hatch_open", CreateVibrantVaults.asResource("block/" + colorId + "_packager/hatch_closed")))
                    .createVibrantVaults$uncheckedTexture("3", Create.asResource("block/packager_iris_open"));

                BlockModelBuilder builder = provider.models()
                    .getBuilder("block/" + colorId + "_packager/item")
                    .parent(new ModelFile.UncheckedModelFile(Create.asResource("block/packager/item")));
                ((ModelBuilderMixinDuck<BlockModelBuilder>) builder).createVibrantVaults$uncheckedTexture("0", Create.asResource("block/packager_frame"));
                builder
                    .texture("1", CreateVibrantVaults.asResource("block/packager/" + colorId + "/packager_details"))
                    .texture("2", CreateVibrantVaults.asResource("block/packager/" + colorId + "/packager_horizontal_unpowered"));
                ((ModelBuilderMixinDuck<BlockModelBuilder>) builder).createVibrantVaults$uncheckedTexture("3", Create.asResource("block/packager_iris_closed"));
                builder.texture("particle", CreateVibrantVaults.asResource("block/packager/" + colorId + "/packager_particle"));

                provider.models()
                    .getBuilder("block/" + colorId + "_packager/tray")
                    .parent(new ModelFile.UncheckedModelFile(Create.asResource("block/packager/tray")))
                    .texture("1", CreateVibrantVaults.asResource("block/packager/" + colorId + "/packager_details"));
            }
        }
    }

    private static void provideGaugeModels(RegistrateBlockstateProvider provider) {
        ModBlocks.VibrantVaultColor[] colors = ModBlocks.VibrantVaultColor.values();
        for (ModBlocks.VibrantVaultColor color : colors) {
            if (color != ModBlocks.VibrantVaultColor.BASE) {
                String colorId = color.asId();

                provider.models()
                    .getBuilder("block/" + colorId + "_factory_gauge/panel_restocker")
                    .parent(new ModelFile.UncheckedModelFile(Create.asResource("block/factory_gauge/panel")))
                    .texture("0", CreateVibrantVaults.asResource("block/factory_gauge/" + colorId + "/factory_panel_packager_mode"))
                    .texture("particle", CreateVibrantVaults.asResource("block/factory_gauge/" + colorId + "/factory_panel_packager_mode"));

                provider.models()
                    .getBuilder("block/" + colorId + "_factory_gauge/panel_restocker_with_bulb")
                    .parent(new ModelFile.UncheckedModelFile(Create.asResource("block/factory_gauge/panel_with_bulb")))
                    .texture("0", CreateVibrantVaults.asResource("block/factory_gauge/" + colorId + "/factory_panel_packager_mode"))
                    .texture("particle", CreateVibrantVaults.asResource("block/factory_gauge/" + colorId + "/factory_panel_packager_mode"));
            }
        }
    }
}
