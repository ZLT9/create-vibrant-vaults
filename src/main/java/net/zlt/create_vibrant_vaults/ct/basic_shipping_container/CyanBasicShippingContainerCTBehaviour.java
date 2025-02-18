package net.zlt.create_vibrant_vaults.ct.basic_shipping_container;

import com.simibubi.create.foundation.block.connected.CTSpriteShiftEntry;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_vibrant_vaults.block.basic_shipping_container.CyanBasicShippingContainerBlock;
import net.zlt.create_vibrant_vaults.ct.AllSpriteShifts;
import net.zlt.create_vibrant_vaults.ct.AbstractItemVaultCTBehaviour;

public class CyanBasicShippingContainerCTBehaviour extends AbstractItemVaultCTBehaviour {
    @Override
    protected Direction.Axis getVaultBlockAxis(BlockState state) {
        return CyanBasicShippingContainerBlock.sGetVaultBlockAxis(state);
    }

    @Override
    protected boolean isLarge(BlockState state) {
        return CyanBasicShippingContainerBlock.sIsLarge(state);
    }

    @Override
    protected CTSpriteShiftEntry getFrontSpriteShiftEntry(boolean small) {
        return AllSpriteShifts.CYAN_BASIC_SHIPPING_CONTAINER_FRONT.get(small);
    }

    @Override
    protected CTSpriteShiftEntry getTopSpriteShiftEntry(boolean small) {
        return AllSpriteShifts.CYAN_BASIC_SHIPPING_CONTAINER_TOP.get(small);
    }

    @Override
    protected CTSpriteShiftEntry getBottomSpriteShiftEntry(boolean small) {
        return AllSpriteShifts.CYAN_BASIC_SHIPPING_CONTAINER_BOTTOM.get(small);
    }

    @Override
    protected CTSpriteShiftEntry getSideSpriteShiftEntry(boolean small) {
        return AllSpriteShifts.CYAN_BASIC_SHIPPING_CONTAINER_SIDE.get(small);
    }
}
