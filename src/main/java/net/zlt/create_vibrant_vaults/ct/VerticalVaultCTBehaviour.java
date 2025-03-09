package net.zlt.create_vibrant_vaults.ct;

import com.simibubi.create.content.logistics.vault.ItemVaultBlock;
import com.simibubi.create.foundation.block.connected.CTSpriteShiftEntry;
import com.simibubi.create.foundation.utility.Couple;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_vibrant_vaults.block.ModBlocks;
import org.jetbrains.annotations.Nullable;

public class VerticalVaultCTBehaviour extends HorizontalVaultCTBehaviour {
    public VerticalVaultCTBehaviour(ModBlocks.VibrantVaultType type, ModBlocks.VibrantVaultColor color) {
        super(type, color);
    }

    @Override
    public CTSpriteShiftEntry getShift(BlockState state, Direction direction, @Nullable TextureAtlasSprite sprite) {
        if (ItemVaultBlock.getVaultBlockAxis(state) != Direction.Axis.Y) {
            return null;
        }

        ModSpriteShifts.VibrantVaultSpriteShifts spriteShifts = ModSpriteShifts.ofVibrantVault(type, color, true);
        Couple<CTSpriteShiftEntry> entries = direction.getAxis() == Direction.Axis.Y ? spriteShifts.top : spriteShifts.side;
        return entries.get(!ItemVaultBlock.isLarge(state));
    }

    @Override
    protected Direction getUpDirection(BlockAndTintGetter reader, BlockPos pos, BlockState state, Direction face) {
        return face.getAxis() == Direction.Axis.Y ? Direction.NORTH : Direction.UP;
    }

    @Override
    protected Direction getRightDirection(BlockAndTintGetter reader, BlockPos pos, BlockState state, Direction face) {
        return face.getAxis() == Direction.Axis.X ? Direction.SOUTH : Direction.WEST;
    }
}
