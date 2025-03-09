package net.zlt.create_vibrant_vaults.item;

import com.simibubi.create.AllCreativeModeTabs.TabInfo;
import com.simibubi.create.foundation.utility.Components;
import com.tterrag.registrate.util.entry.RegistryEntry;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.zlt.create_vibrant_vaults.CreateVibrantVaults;
import net.zlt.create_vibrant_vaults.block.ModBlocks;

import java.util.function.Supplier;

public final class ModCreativeModeTabs {
    private ModCreativeModeTabs() {
    }

    public static final TabInfo BASE_CREATIVE_TAB = register("base", () -> FabricItemGroup.builder()
        .title(Components.translatable("itemGroup.create_vibrant_vaults.base"))
        .icon(() -> ModBlocks.getVibrantVault(ModBlocks.VibrantVaultType.SHIPPING_CONTAINER, ModBlocks.VibrantVaultColor.BASE, false).asStack())
        .displayItems((parameters, output) -> {
            for (RegistryEntry<Block> entry : CreateVibrantVaults.REGISTRATE.getAll(Registries.BLOCK)) {
                output.accept(new ItemStack(entry.get().asItem()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            }
        })
        .build());

    private static TabInfo register(String name, Supplier<CreativeModeTab> supplier) {
        ResourceLocation id = CreateVibrantVaults.asResource(name);
        ResourceKey<CreativeModeTab> key = ResourceKey.create(Registries.CREATIVE_MODE_TAB, id);
        CreativeModeTab tab = supplier.get();
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, key, tab);
        return new TabInfo(key, tab);
    }

    public static void init() {
    }
}
