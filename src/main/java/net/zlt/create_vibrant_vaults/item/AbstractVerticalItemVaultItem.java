package net.zlt.create_vibrant_vaults.item;

import com.simibubi.create.api.connectivity.ConnectivityHandler;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_vibrant_vaults.block.entity.AbstractItemVaultBlockEntity;

public abstract class AbstractVerticalItemVaultItem<BE extends AbstractItemVaultBlockEntity<BE>> extends AbstractItemVaultItem<BE> {
    public AbstractVerticalItemVaultItem(Block pBlock, Properties pProperties) {
        super(pBlock, pProperties);
    }

    @Override
    protected void tryMultiPlace(BlockPlaceContext ctx) {
        Player player = ctx.getPlayer();
        if (player == null || player.isShiftKeyDown()) {
            return;
        }

        Direction face = ctx.getClickedFace();
        if (!face.getAxis().isVertical()) {
            return;
        }

        ItemStack stack = ctx.getItemInHand();
        Level world = ctx.getLevel();
        BlockPos pos = ctx.getClickedPos();
        BlockPos placedOnPos = pos.relative(face.getOpposite());
        BlockState placedOnState = world.getBlockState(placedOnPos);

        if (!isVault(placedOnState)) {
            return;
        }

        BE vaultAt = ConnectivityHandler.partAt(getBlockEntityType(), world, placedOnPos);
        if (vaultAt == null) {
            return;
        }

        BE controllerBE = vaultAt.getControllerBE();
        if (controllerBE == null) {
            return;
        }

        int width = controllerBE.radius;
        if (width == 1) {
            return;
        }

        int vaultsToPlace = 0;

        BlockPos startPos = face == Direction.DOWN ? controllerBE.getBlockPos().below() : controllerBE.getBlockPos().above(controllerBE.getHeight());

        if (startPos.getY() != pos.getY()) {
            return;
        }

        for (int xOffset = 0; xOffset < width; xOffset++) {
            for (int zOffset = 0; zOffset < width; zOffset++) {
                BlockPos offsetPos = startPos.offset(xOffset, 0, zOffset);
                BlockState blockState = world.getBlockState(offsetPos);
                if (isVault(blockState)) {
                    continue;
                }
                if (!blockState.canBeReplaced()) {
                    return;
                }
                vaultsToPlace++;
            }
        }

        if (!player.isCreative() && stack.getCount() < vaultsToPlace) {
            return;
        }

        for (int xOffset = 0; xOffset < width; xOffset++) {
            for (int zOffset = 0; zOffset < width; zOffset++) {
                BlockPos offsetPos = startPos.offset(xOffset, 0, zOffset);
                BlockState blockState = world.getBlockState(offsetPos);
                if (isVault(blockState)) {
                    continue;
                }
                BlockPlaceContext context = BlockPlaceContext.at(ctx, offsetPos, face);
                player.getPersistentData().putBoolean("SilenceVaultSound", true);
                super.place(context);
                player.getPersistentData().remove("SilenceVaultSound");
            }
        }
    }
}
