package net.zlt.create_vibrant_vaults.ct;

import com.simibubi.create.content.logistics.vault.ItemVaultBlock;
import com.simibubi.create.content.logistics.vault.ItemVaultCTBehaviour;
import com.simibubi.create.foundation.block.connected.CTSpriteShiftEntry;
import net.createmod.catnip.data.Couple;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_vibrant_vaults.block.ModBlocks;
import org.jetbrains.annotations.Nullable;

public class HorizontalVaultCTBehaviour extends ItemVaultCTBehaviour {
    protected final ModBlocks.VibrantVaultType type;
    protected final ModBlocks.VibrantVaultColor color;

    public HorizontalVaultCTBehaviour(ModBlocks.VibrantVaultType type, ModBlocks.VibrantVaultColor color) {
        super();
        this.type = type;
        this.color = color;
    }

    @Override
    public CTSpriteShiftEntry getShift(BlockState state, Direction direction, @Nullable TextureAtlasSprite sprite) {
        Direction.Axis vaultBlockAxis = ItemVaultBlock.getVaultBlockAxis(state);
        if (vaultBlockAxis == null) {
            return null;
        }

        ModSpriteShifts.VibrantVaultSpriteShifts spriteShifts = ModSpriteShifts.ofVibrantVault(type, color, false);
        Couple<CTSpriteShiftEntry> entries = direction.getAxis() == vaultBlockAxis ? spriteShifts.front : direction == Direction.UP ? spriteShifts.top : direction == Direction.DOWN ? spriteShifts.bottom : spriteShifts.side;
        return entries.get(!ItemVaultBlock.isLarge(state));
    }
}
