package net.zlt.create_vibrant_vaults.block;

import com.simibubi.create.content.logistics.vault.ItemVaultBlock;

public class VibrantVaultBlock extends ItemVaultBlock {
    public final ModBlocks.VibrantVaultType type;
    public final ModBlocks.VibrantVaultColor color;

    public VibrantVaultBlock(ModBlocks.VibrantVaultType type, ModBlocks.VibrantVaultColor color, Properties properties) {
        super(properties);
        this.type = type;
        this.color = color;
    }
}
