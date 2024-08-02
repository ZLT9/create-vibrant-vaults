package net.zlt.create_vibrant_vaults.ct.shipping_container.vertical;

import com.simibubi.create.foundation.block.connected.CTSpriteShiftEntry;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_vibrant_vaults.block.shipping_container.vertical.MagentaVerticalShippingContainerBlock;
import net.zlt.create_vibrant_vaults.ct.AbstractVerticalItemVaultCTBehaviour;
import net.zlt.create_vibrant_vaults.ct.AllSpriteShifts;

public class MagentaVerticalShippingContainerCTBehaviour extends AbstractVerticalItemVaultCTBehaviour {
    @Override
    protected Direction.Axis getVaultBlockAxis(BlockState state) {
        return MagentaVerticalShippingContainerBlock.sGetVaultBlockAxis(state);
    }

    @Override
    protected boolean isLarge(BlockState state) {
        return MagentaVerticalShippingContainerBlock.sIsLarge(state);
    }

    @Override
    protected CTSpriteShiftEntry getTopSpriteShiftEntry(boolean small) {
        return AllSpriteShifts.MAGENTA_VERTICAL_SHIPPING_CONTAINER_TOP.get(small);
    }

    @Override
    protected CTSpriteShiftEntry getSideSpriteShiftEntry(boolean small) {
        return AllSpriteShifts.MAGENTA_VERTICAL_SHIPPING_CONTAINER_SIDE.get(small);
    }
}