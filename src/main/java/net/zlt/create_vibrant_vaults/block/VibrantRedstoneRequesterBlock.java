package net.zlt.create_vibrant_vaults.block;

import com.simibubi.create.content.logistics.redstoneRequester.RedstoneRequesterBlock;

public class VibrantRedstoneRequesterBlock extends RedstoneRequesterBlock {
    public final ModBlocks.VibrantVaultColor color;

    public VibrantRedstoneRequesterBlock(ModBlocks.VibrantVaultColor color, Properties pProperties) {
        super(pProperties);
        this.color = color;
    }
}
