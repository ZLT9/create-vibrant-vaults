package net.zlt.create_vibrant_vaults.block;

import com.simibubi.create.content.logistics.packager.PackagerBlock;

public class VibrantPackagerBlock extends PackagerBlock {
    public final ModBlocks.VibrantVaultColor color;

    public VibrantPackagerBlock(ModBlocks.VibrantVaultColor color, Properties properties) {
        super(properties);
        this.color = color;
    }
}
