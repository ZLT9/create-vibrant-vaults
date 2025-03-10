package net.zlt.create_vibrant_vaults.block;

import com.simibubi.create.content.logistics.packagerLink.PackagerLinkBlock;

public class VibrantStockLinkBlock extends PackagerLinkBlock {
    public final ModBlocks.VibrantVaultColor color;

    public VibrantStockLinkBlock(ModBlocks.VibrantVaultColor color, Properties properties) {
        super(properties);
        this.color = color;
    }
}
