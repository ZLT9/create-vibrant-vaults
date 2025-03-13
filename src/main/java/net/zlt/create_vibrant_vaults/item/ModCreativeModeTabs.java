package net.zlt.create_vibrant_vaults.item;

import com.simibubi.create.AllCreativeModeTabs;
import com.tterrag.registrate.util.entry.RegistryEntry;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.zlt.create_vibrant_vaults.CreateVibrantVaults;
import net.zlt.create_vibrant_vaults.block.ModBlocks;

public final class ModCreativeModeTabs {
    private ModCreativeModeTabs() {
    }

    private static final DeferredRegister<CreativeModeTab> REGISTER = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CreateVibrantVaults.ID);

    public static final RegistryObject<CreativeModeTab> BASE_CREATIVE_TAB = REGISTER.register("base", () -> CreativeModeTab.builder()
        .title(Component.translatable("itemGroup.create_vibrant_vaults.base"))
        .withTabsBefore(AllCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
        .icon(() -> ModBlocks.getVibrantVault(ModBlocks.VibrantVaultType.SHIPPING_CONTAINER, ModBlocks.VibrantVaultColor.BASE, false).asStack())
        .displayItems((parameters, output) -> {
            for (RegistryEntry<Block> entry : CreateVibrantVaults.REGISTRATE.getAll(Registries.BLOCK)) {
                output.accept(new ItemStack(entry.get().asItem()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            }
        })
        .build());

    public static void init(IEventBus modEventBus) {
        REGISTER.register(modEventBus);
    }
}
