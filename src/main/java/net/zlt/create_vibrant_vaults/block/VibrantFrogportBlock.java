package net.zlt.create_vibrant_vaults.block;

import com.simibubi.create.content.logistics.packagePort.frogport.FrogportBlock;

public class VibrantFrogportBlock extends FrogportBlock {
    public final ModBlocks.VibrantVaultColor color;

    public VibrantFrogportBlock(ModBlocks.VibrantVaultColor color, Properties pProperties) {
        super(pProperties);
        this.color = color;
    }
}
