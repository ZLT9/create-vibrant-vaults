package net.zlt.create_vibrant_vaults.ct.item_vault.vertical;

import com.simibubi.create.foundation.block.connected.CTSpriteShiftEntry;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_vibrant_vaults.block.item_vault.vertical.GreenVerticalItemVaultBlock;
import net.zlt.create_vibrant_vaults.ct.AbstractVerticalItemVaultCTBehaviour;
import net.zlt.create_vibrant_vaults.ct.AllSpriteShifts;

public class GreenVerticalItemVaultCTBehaviour extends AbstractVerticalItemVaultCTBehaviour {
    @Override
    protected Direction.Axis getVaultBlockAxis(BlockState state) {
        return GreenVerticalItemVaultBlock.sGetVaultBlockAxis(state);
    }

    @Override
    protected boolean isLarge(BlockState state) {
        return GreenVerticalItemVaultBlock.sIsLarge(state);
    }

    @Override
    protected CTSpriteShiftEntry getTopSpriteShiftEntry(boolean small) {
        return AllSpriteShifts.GREEN_VERTICAL_ITEM_VAULT_TOP.get(small);
    }

    @Override
    protected CTSpriteShiftEntry getSideSpriteShiftEntry(boolean small) {
        return AllSpriteShifts.GREEN_VERTICAL_ITEM_VAULT_SIDE.get(small);
    }
}
