package net.zlt.create_vibrant_vaults.item.crafting;

import com.simibubi.create.content.logistics.vault.ItemVaultBlock;
import net.minecraft.core.RegistryAccess;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CraftingBookCategory;
import net.minecraft.world.item.crafting.CustomRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.zlt.create_vibrant_vaults.block.ItemVaultConnectivityHelper;
import net.zlt.create_vibrant_vaults.block.ModBlockTags;
import net.zlt.create_vibrant_vaults.block.ModBlocks;
import net.zlt.create_vibrant_vaults.block.VibrantVaultBlock;

public class VaultColoringRecipe extends CustomRecipe {
    public VaultColoringRecipe(ResourceLocation id, CraftingBookCategory category) {
        super(id, category);
    }

    @Override
    public boolean matches(CraftingContainer container, Level level) {
        int vaultCount = 0;
        int dyeCount = 0;

        for (int i = 0; i < container.getContainerSize(); ++i) {
            ItemStack itemStack = container.getItem(i);
            if (itemStack.isEmpty()) {
                continue;
            }

            if (Block.byItem(itemStack.getItem()) instanceof ItemVaultBlock vault) {
                if (!ItemVaultConnectivityHelper.isVault(vault)) {
                    return false;
                }

                ++vaultCount;
            } else if (itemStack.getItem() instanceof DyeItem) {
                ++dyeCount;
            } else {
                return false;
            }

            if (vaultCount > 1 || dyeCount > 1) {
                return false;
            }
        }

        return vaultCount == 1 && dyeCount == 1;
    }

    @Override
    public ItemStack assemble(CraftingContainer container, RegistryAccess registryAccess) {
        ItemVaultBlock vault = null;
        DyeItem dye = null;

        for (int i = 0; i < container.getContainerSize(); ++i) {
            ItemStack stack = container.getItem(i);
            if (!stack.isEmpty()) {
                Item item = stack.getItem();
                if (Block.byItem(item) instanceof ItemVaultBlock itemVaultBlock) {
                    vault = itemVaultBlock;
                } else if (item instanceof DyeItem dyeItem) {
                    dye = dyeItem;
                }

                if (vault != null && dye != null) {
                    break;
                }
            }
        }

        ModBlocks.VibrantVaultColor color = ModBlocks.VibrantVaultColor.byId(dye.getDyeColor().getId());

        if (vault instanceof VibrantVaultBlock vibrantVault) {
            return new ItemStack(ModBlocks.getVibrantVault(vibrantVault.type, color, ModBlockTags.VERTICAL_VAULTS.matches(vibrantVault)));
        }

        return new ItemStack(ModBlocks.getVibrantVault(ModBlocks.VibrantVaultType.ITEM_VAULT, color, false));
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return width * height >= 2;
    }

    @Override
    public RecipeSerializer<VaultColoringRecipe> getSerializer() {
        return ModRecipeSerializers.VAULT_COLORING.get();
    }
}
