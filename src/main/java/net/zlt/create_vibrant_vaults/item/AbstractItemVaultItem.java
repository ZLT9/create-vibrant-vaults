package net.zlt.create_vibrant_vaults.item;

import com.simibubi.create.api.connectivity.ConnectivityHandler;
import com.simibubi.create.content.fluids.tank.FluidTankItem;
import com.simibubi.create.foundation.utility.VecHelper;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_vibrant_vaults.block.entity.AbstractItemVaultBlockEntity;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public abstract class AbstractItemVaultItem<BE extends AbstractItemVaultBlockEntity<BE>> extends BlockItem {
    public AbstractItemVaultItem(Block block, Properties properties) {
        super(block, properties);
    }

    protected abstract void setIsPlacingNbt(boolean isPlacingNBT);

    @Override
    public InteractionResult place(BlockPlaceContext ctx) {
        setIsPlacingNbt(FluidTankItem.checkPlacingNbt(ctx));
        InteractionResult initialResult = super.place(ctx);
        setIsPlacingNbt(false);

        if (initialResult.consumesAction()) {
            tryMultiPlace(ctx);
        }

        return initialResult;
    }

    @Override
    protected boolean updateCustomBlockEntityTag(BlockPos pos, Level level, @Nullable Player player, ItemStack itemStack, BlockState state) {
        MinecraftServer minecraftserver = level.getServer();
        if (minecraftserver == null) {
            return false;
        }

        CompoundTag nbt = itemStack.getTagElement("BlockEntityTag");
        if (nbt != null) {
            nbt.remove("Length");
            nbt.remove("Size");
            nbt.remove("Controller");
            nbt.remove("LastKnownPos");
        }

        return super.updateCustomBlockEntityTag(pos, level, player, itemStack, state);
    }

    protected abstract boolean isVault(BlockState state);

    protected abstract BlockEntityType<BE> getBlockEntityType();

    @Nullable
    protected abstract Direction.Axis getVaultBlockAxis(BlockState state);

    private void tryMultiPlace(BlockPlaceContext ctx) {
        Player player = ctx.getPlayer();
        if (player == null || player.isShiftKeyDown()) {
            return;
        }

        Direction face = ctx.getClickedFace();
        ItemStack stack = ctx.getItemInHand();
        Level world = ctx.getLevel();
        BlockPos pos = ctx.getClickedPos();
        BlockPos placedOnPos = pos.relative(face.getOpposite());
        BlockState placedOnState = world.getBlockState(placedOnPos);

        if (!isVault(placedOnState)) {
            return;
        }

        BE tankAt = ConnectivityHandler.partAt(getBlockEntityType(), world, placedOnPos);
        if (tankAt == null) {
            return;
        }

        BE controllerBE = tankAt.getControllerBE();
        if (controllerBE == null) {
            return;
        }

        int width = controllerBE.radius;
        if (width == 1) {
            return;
        }

        int tanksToPlace = 0;
        Direction.Axis vaultBlockAxis = getVaultBlockAxis(placedOnState);
        if (vaultBlockAxis == null || face.getAxis() != vaultBlockAxis) {
            return;
        }

        Direction vaultFacing = Direction.fromAxisAndDirection(vaultBlockAxis, Direction.AxisDirection.POSITIVE);
        BlockPos startPos = face == vaultFacing.getOpposite() ? controllerBE.getBlockPos().relative(vaultFacing.getOpposite()) : controllerBE.getBlockPos().relative(vaultFacing, controllerBE.length);

        if (VecHelper.getCoordinate(startPos, vaultBlockAxis) != VecHelper.getCoordinate(pos, vaultBlockAxis)) {
            return;
        }

        for (int xOffset = 0; xOffset < width; xOffset++) {
            for (int zOffset = 0; zOffset < width; zOffset++) {
                BlockPos offsetPos = vaultBlockAxis == Direction.Axis.X ? startPos.offset(0, xOffset, zOffset) : startPos.offset(xOffset, zOffset, 0);
                BlockState blockState = world.getBlockState(offsetPos);
                if (isVault(blockState)) {
                    continue;
                }
                if (!blockState.canBeReplaced()) {
                    return;
                }
                tanksToPlace++;
            }
        }

        if (!player.isCreative() && stack.getCount() < tanksToPlace) {
            return;
        }

        for (int xOffset = 0; xOffset < width; xOffset++) {
            for (int zOffset = 0; zOffset < width; zOffset++) {
                BlockPos offsetPos = vaultBlockAxis == Direction.Axis.X ? startPos.offset(0, xOffset, zOffset) : startPos.offset(xOffset, zOffset, 0);
                BlockState blockState = world.getBlockState(offsetPos);
                if (isVault(blockState)) {
                    continue;
                }
                BlockPlaceContext context = BlockPlaceContext.at(ctx, offsetPos, face);
                player.getCustomData().putBoolean("SilenceVaultSound", true);
                setIsPlacingNbt(FluidTankItem.checkPlacingNbt(context));
                super.place(context);
                setIsPlacingNbt(false);
                player.getCustomData().getBoolean("SilenceVaultSound");
            }
        }
    }
}
