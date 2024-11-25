package net.zlt.create_vibrant_vaults.ct.basic_shipping_container;

import com.simibubi.create.foundation.block.connected.CTSpriteShiftEntry;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_vibrant_vaults.block.basic_shipping_container.BasicShippingContainerBlock;
import net.zlt.create_vibrant_vaults.ct.AbstractItemVaultCTBehaviour;
import net.zlt.create_vibrant_vaults.ct.AllSpriteShifts;

public class BasicShippingContainerCTBehaviour extends AbstractItemVaultCTBehaviour {
    @Override
    protected Direction.Axis getVaultBlockAxis(BlockState state) {
        return BasicShippingContainerBlock.sGetVaultBlockAxis(state);
    }

    @Override
    protected boolean isLarge(BlockState state) {
        return BasicShippingContainerBlock.sIsLarge(state);
    }

    @Override
    protected CTSpriteShiftEntry getFrontSpriteShiftEntry(boolean small) {
        return AllSpriteShifts.BASIC_SHIPPING_CONTAINER_FRONT.get(small);
    }

    @Override
    protected CTSpriteShiftEntry getTopSpriteShiftEntry(boolean small) {
        return AllSpriteShifts.BASIC_SHIPPING_CONTAINER_TOP.get(small);
    }

    @Override
    protected CTSpriteShiftEntry getBottomSpriteShiftEntry(boolean small) {
        return AllSpriteShifts.BASIC_SHIPPING_CONTAINER_BOTTOM.get(small);
    }

    @Override
    protected CTSpriteShiftEntry getSideSpriteShiftEntry(boolean small) {
        return AllSpriteShifts.BASIC_SHIPPING_CONTAINER_SIDE.get(small);
    }
}
