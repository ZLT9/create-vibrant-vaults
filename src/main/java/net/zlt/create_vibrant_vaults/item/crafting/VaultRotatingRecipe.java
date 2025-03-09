package net.zlt.create_vibrant_vaults.item.crafting;

import com.simibubi.create.content.logistics.vault.ItemVaultBlock;
import net.minecraft.core.RegistryAccess;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.CraftingContainer;
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

public class VaultRotatingRecipe extends CustomRecipe {
    public VaultRotatingRecipe(ResourceLocation id, CraftingBookCategory category) {
        super(id, category);
    }

    @Override
    public boolean matches(CraftingContainer container, Level level) {
        int vaultCount = 0;

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
            } else {
                return false;
            }

            if (vaultCount > 1) {
                return false;
            }
        }

        return vaultCount == 1;
    }

    @Override
    public ItemStack assemble(CraftingContainer container, RegistryAccess registryAccess) {
        ItemVaultBlock vault = null;

        for (int i = 0; i < container.getContainerSize(); ++i) {
            ItemStack stack = container.getItem(i);
            if (!stack.isEmpty()) {
                if (Block.byItem(stack.getItem()) instanceof ItemVaultBlock itemVaultBlock) {
                    vault = itemVaultBlock;
                    break;
                }
            }
        }

        if (vault instanceof VibrantVaultBlock vibrantVault) {
            return new ItemStack(ModBlocks.getVibrantVault(vibrantVault.type, vibrantVault.color, !ModBlockTags.VERTICAL_VAULTS.matches(vibrantVault)));
        }

        return new ItemStack(ModBlocks.getVibrantVault(ModBlocks.VibrantVaultType.ITEM_VAULT, ModBlocks.VibrantVaultColor.BASE, true));
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return width * height >= 1;
    }

    @Override
    public RecipeSerializer<VaultRotatingRecipe> getSerializer() {
        return ModRecipeSerializers.VAULT_ROTATING;
    }
}
