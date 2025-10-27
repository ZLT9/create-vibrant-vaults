package net.zlt.create_vibrant_vaults.item;

import com.simibubi.create.api.packager.InventoryIdentifier;
import com.simibubi.create.content.logistics.vault.ItemVaultBlockEntity;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.zlt.create_vibrant_vaults.block.ModBlocks;
import net.zlt.create_vibrant_vaults.block.VibrantVaultBlock;

import java.util.List;

public final class ModInventoryIdentifiers {
    private ModInventoryIdentifiers() {
    }

    public static void init() {
        for (List<BlockEntry<VibrantVaultBlock>> vaults : ModBlocks.VIBRANT_VAULTS) {
            for (BlockEntry<VibrantVaultBlock> vault : vaults) {
                InventoryIdentifier.REGISTRY.register(vault.get(), (level, state, face) -> level.getBlockEntity(face.getPos()) instanceof ItemVaultBlockEntity vaultBe ? vaultBe.getInvId() : null);
            }
        }
    }
}
