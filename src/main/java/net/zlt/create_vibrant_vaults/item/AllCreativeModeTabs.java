package net.zlt.create_vibrant_vaults.item;

import com.simibubi.create.foundation.utility.Components;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.zlt.create_vibrant_vaults.CreateVibrantVaults;

import java.util.function.Supplier;

public class AllCreativeModeTabs {
    public static final TabInfo BASE_CREATIVE_TAB = register("base",
        () -> FabricItemGroup.builder()
            .title(Components.translatable("itemGroup.create_vibrant_vaults.base"))
            .icon(com.simibubi.create.AllBlocks.ITEM_VAULT::asStack)
            .build());

    @SuppressWarnings("SameParameterValue")
    private static TabInfo register(String name, Supplier<CreativeModeTab> supplier) {
        ResourceLocation id = CreateVibrantVaults.asResource(name);
        ResourceKey<CreativeModeTab> key = ResourceKey.create(Registries.CREATIVE_MODE_TAB, id);
        CreativeModeTab tab = supplier.get();
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, key, tab);
        return new TabInfo(key, tab);
    }

    public static void register() {}

    public record TabInfo(ResourceKey<CreativeModeTab> key, CreativeModeTab tab) {
    }
}
