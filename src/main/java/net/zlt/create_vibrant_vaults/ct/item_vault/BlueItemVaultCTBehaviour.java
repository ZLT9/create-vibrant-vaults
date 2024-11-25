package net.zlt.create_vibrant_vaults.ct.item_vault;

import com.simibubi.create.foundation.block.connected.CTSpriteShiftEntry;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_vibrant_vaults.block.item_vault.BlueItemVaultBlock;
import net.zlt.create_vibrant_vaults.ct.AbstractItemVaultCTBehaviour;
import net.zlt.create_vibrant_vaults.ct.AllSpriteShifts;

public class BlueItemVaultCTBehaviour extends AbstractItemVaultCTBehaviour {
    @Override
    protected Direction.Axis getVaultBlockAxis(BlockState state) {
        return BlueItemVaultBlock.sGetVaultBlockAxis(state);
    }

    @Override
    protected boolean isLarge(BlockState state) {
        return BlueItemVaultBlock.sIsLarge(state);
    }

    @Override
    protected CTSpriteShiftEntry getFrontSpriteShiftEntry(boolean small) {
        return AllSpriteShifts.BLUE_VAULT_FRONT.get(small);
    }

    @Override
    protected CTSpriteShiftEntry getTopSpriteShiftEntry(boolean small) {
        return AllSpriteShifts.BLUE_VAULT_TOP.get(small);
    }

    @Override
    protected CTSpriteShiftEntry getBottomSpriteShiftEntry(boolean small) {
        return AllSpriteShifts.BLUE_VAULT_BOTTOM.get(small);
    }

    @Override
    protected CTSpriteShiftEntry getSideSpriteShiftEntry(boolean small) {
        return AllSpriteShifts.BLUE_VAULT_SIDE.get(small);
    }
}
