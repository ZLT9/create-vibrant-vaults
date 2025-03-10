package net.zlt.create_vibrant_vaults.block;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.content.logistics.vault.ItemVaultBlock;
import com.simibubi.create.foundation.blockEntity.IMultiBlockEntityContainer;
import net.createmod.catnip.data.Iterate;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.apache.commons.lang3.tuple.Pair;

import javax.annotation.Nullable;
import java.util.*;

public final class ItemVaultConnectivityHelper {
    private ItemVaultConnectivityHelper() {
    }

    public static Direction.Axis getItemVaultPreferredAxis(Block placing, BlockState placedOn) {
        return ModBlockTags.VERTICAL_VAULTS.matches(placedOn) || !isVault(placedOn, placing) ? null : placedOn.getValue(ItemVaultBlock.HORIZONTAL_AXIS);
    }

    public static boolean isVault(Block block) {
        return AllBlocks.ITEM_VAULT.is(block) || ModBlockTags.VIBRANT_VAULTS.matches(block);
    }

    public static boolean isVault(BlockState state) {
        return isVault(state.getBlock());
    }

    public static boolean isVault(Block a, Block b) {
        if (AllBlocks.ITEM_VAULT.is(a)) {
            return AllBlocks.ITEM_VAULT.is(b);
        }

        if (ModBlockTags.VIBRANT_VAULTS.matches(a)) {
            return a == b;
        }

        return false;
    }

    public static boolean isVault(BlockState a, Block b) {
        return isVault(a.getBlock(), b);
    }

    public static boolean isVault(BlockState a, BlockState b) {
        return isVault(a.getBlock(), b.getBlock());
    }

    public static boolean isVault(BlockEntity a, Block b) {
        return isVault(a.getBlockState(), b);
    }

    public static boolean isVault(BlockEntity a, BlockEntity b) {
        return isVault(a.getBlockState(), b.getBlockState());
    }

    public static <T extends BlockEntity & IMultiBlockEntityContainer> void formItemVaultMulti(T be) {
        SearchCache<T> cache = new SearchCache<>();
        List<T> frontier = new ArrayList<>();
        frontier.add(be);
        formItemVaultMulti(be, be.getLevel(), cache, frontier);
    }

    @Nullable
    @SuppressWarnings("unchecked")
    private static <T extends BlockEntity & IMultiBlockEntityContainer> T checked(BlockEntity be) {
        return be instanceof IMultiBlockEntityContainer ? (T) be : null;
    }

    @Nullable
    public static <T extends BlockEntity & IMultiBlockEntityContainer> T partAt(Block block, BlockGetter level, BlockPos pos) {
        BlockEntity be = level.getBlockEntity(pos);
        return be != null && isVault(be, block) && !be.isRemoved() ? checked(be) : null;
    }

    @Nullable
    public static <T extends BlockEntity & IMultiBlockEntityContainer> T partAt(BlockEntity blockEntity, BlockGetter level, BlockPos pos) {
        return partAt(blockEntity.getBlockState().getBlock(), level, pos);
    }

    public static <T extends BlockEntity & IMultiBlockEntityContainer> void splitItemVaultMulti(T be) {
        splitItemVaultMultiAndInvalidate(be, null);
    }

    private static <T extends BlockEntity & IMultiBlockEntityContainer> void splitItemVaultMultiAndInvalidate(T be, @Nullable SearchCache<T> cache) {
        Level level = be.getLevel();
        if (level == null) {
            return;
        }

        be = be.getControllerBE();
        if (be == null) {
            return;
        }

        int height = be.getHeight();
        int width = be.getWidth();
        if (width == 1 && height == 1) {
            return;
        }

        BlockPos origin = be.getBlockPos();
        Direction.Axis axis = be.getMainConnectionAxis();

        for (int yOffset = 0; yOffset < height; yOffset++) {
            for (int xOffset = 0; xOffset < width; xOffset++) {
                for (int zOffset = 0; zOffset < width; zOffset++) {
                    BlockPos pos = switch (axis) {
                        case X -> origin.offset(yOffset, xOffset, zOffset);
                        case Y -> origin.offset(xOffset, yOffset, zOffset);
                        case Z -> origin.offset(xOffset, zOffset, yOffset);
                    };

                    T partAt = partAt(be, level, pos);
                    if (partAt == null) {
                        continue;
                    }

                    if (!partAt.getController().equals(origin)) {
                        continue;
                    }

                    T controllerBE = partAt.getControllerBE();
                    partAt.setExtraData((controllerBE == null ? null : controllerBE.getExtraData()));
                    partAt.removeController(true);

                    if (cache != null) {
                        cache.put(pos, partAt);
                    }
                }
            }
        }
    }

    private static <T extends BlockEntity & IMultiBlockEntityContainer> int tryToFormNewItemVaultMultiOfWidth(T be, int width, SearchCache<T> cache, boolean simulate) {
        int amount = 0;
        int height = 0;
        Level level = be.getLevel();
        if (level == null) {
            return 0;
        }

        BlockPos origin = be.getBlockPos();
        Direction.Axis axis = be.getMainConnectionAxis();

        Search:
        for (int yOffset = 0; yOffset < be.getMaxLength(axis, width); yOffset++) {
            for (int xOffset = 0; xOffset < width; xOffset++) {
                for (int zOffset = 0; zOffset < width; zOffset++) {
                    BlockPos pos = switch (axis) {
                        case X -> origin.offset(yOffset, xOffset, zOffset);
                        case Y -> origin.offset(xOffset, yOffset, zOffset);
                        case Z -> origin.offset(xOffset, zOffset, yOffset);
                    };
                    Optional<T> part = cache.getOrCache(be, level, pos);
                    if (part.isEmpty()) {
                        break Search;
                    }

                    T controller = part.get();
                    int otherWidth = controller.getWidth();
                    if (otherWidth > width) {
                        break Search;
                    }

                    if (otherWidth == width && controller.getHeight() == be.getMaxLength(axis, width)) {
                        break Search;
                    }

                    Direction.Axis conAxis = controller.getMainConnectionAxis();
                    if (axis != conAxis) {
                        break Search;
                    }

                    BlockPos conPos = controller.getBlockPos();
                    if (!conPos.equals(origin)) {
                        if (axis == Direction.Axis.Y) { // Vertical multi
                            if (conPos.getX() < origin.getX()) {
                                break Search;
                            }
                            if (conPos.getZ() < origin.getZ()) {
                                break Search;
                            }
                            if (conPos.getX() + otherWidth > origin.getX() + width) {
                                break Search;
                            }
                            if (conPos.getZ() + otherWidth > origin.getZ() + width) {
                                break Search;
                            }
                        } else { // Horizontal multi
                            if (axis == Direction.Axis.Z && conPos.getX() < origin.getX()) {
                                break Search;
                            }
                            if (conPos.getY() < origin.getY()) {
                                break Search;
                            }
                            if (axis == Direction.Axis.X && conPos.getZ() < origin.getZ()) {
                                break Search;
                            }
                            if (axis == Direction.Axis.Z && conPos.getX() + otherWidth > origin.getX() + width) {
                                break Search;
                            }
                            if (conPos.getY() + otherWidth > origin.getY() + width) {
                                break Search;
                            }
                            if (axis == Direction.Axis.X && conPos.getZ() + otherWidth > origin.getZ() + width) {
                                break Search;
                            }
                        }
                    }
                }
            }
            amount += width * width;
            height++;
        }

        if (simulate) {
            return amount;
        }

        Object extraData = be.getExtraData();

        for (int yOffset = 0; yOffset < height; yOffset++) {
            for (int xOffset = 0; xOffset < width; xOffset++) {
                for (int zOffset = 0; zOffset < width; zOffset++) {
                    BlockPos pos = switch (axis) {
                        case X -> origin.offset(yOffset, xOffset, zOffset);
                        case Y -> origin.offset(xOffset, yOffset, zOffset);
                        case Z -> origin.offset(xOffset, zOffset, yOffset);
                    };
                    T part = partAt(be, level, pos);
                    if (part == null) {
                        continue;
                    }
                    if (part == be) {
                        continue;
                    }

                    extraData = be.modifyExtraData(extraData);

                    splitItemVaultMultiAndInvalidate(part, cache);
                    part.setController(origin);
                    part.preventConnectivityUpdate();
                    cache.put(pos, be);
                    part.setHeight(height);
                    part.setWidth(width);
                    part.notifyMultiUpdated();
                }
            }
        }
        be.setExtraData(extraData);
        be.notifyMultiUpdated();
        return amount;
    }

    private static <T extends BlockEntity & IMultiBlockEntityContainer> int tryToFormNewItemVaultMulti(T be, SearchCache<T> cache, boolean simulate) {
        int bestWidth = 1;
        int bestAmount = -1;
        if (!be.isController()) {
            return 0;
        }

        int radius = be.getMaxWidth();
        for (int w = 1; w <= radius; w++) {
            int amount = tryToFormNewItemVaultMultiOfWidth(be, w, cache, true);
            if (amount < bestAmount) {
                continue;
            }

            bestWidth = w;
            bestAmount = amount;
        }

        if (!simulate) {
            int beWidth = be.getWidth();
            if (beWidth == bestWidth && beWidth * beWidth * be.getHeight() == bestAmount) {
                return bestAmount;
            }

            splitItemVaultMultiAndInvalidate(be, cache);
            tryToFormNewItemVaultMultiOfWidth(be, bestWidth, cache, false);

            be.preventConnectivityUpdate();
            be.setWidth(bestWidth);
            be.setHeight(bestAmount / bestWidth / bestWidth);
            be.notifyMultiUpdated();
        }

        return bestAmount;
    }

    private static <T extends BlockEntity & IMultiBlockEntityContainer> void formItemVaultMulti(BlockEntity blockEntity, BlockGetter level, SearchCache<T> cache, List<T> frontier) {
        PriorityQueue<Pair<Integer, T>> creationQueue = new PriorityQueue<>((one, two) -> two.getKey() - one.getKey());
        Set<BlockPos> visited = new HashSet<>();
        Direction.Axis mainAxis = frontier.get(0).getMainConnectionAxis();

        int minX = (mainAxis == Direction.Axis.Y ? Integer.MAX_VALUE : Integer.MIN_VALUE);
        int minY = (mainAxis != Direction.Axis.Y ? Integer.MAX_VALUE : Integer.MIN_VALUE);
        int minZ = (mainAxis == Direction.Axis.Y ? Integer.MAX_VALUE : Integer.MIN_VALUE);

        for (T be : frontier) {
            BlockPos pos = be.getBlockPos();
            minX = Math.min(pos.getX(), minX);
            minY = Math.min(pos.getY(), minY);
            minZ = Math.min(pos.getZ(), minZ);
        }
        if (mainAxis == Direction.Axis.Y) {
            minX -= frontier.get(0).getMaxWidth();
        }
        if (mainAxis != Direction.Axis.Y) {
            minY -= frontier.get(0).getMaxWidth();
        }
        if (mainAxis == Direction.Axis.Y) {
            minZ -= frontier.get(0).getMaxWidth();
        }

        while (!frontier.isEmpty()) {
            T part = frontier.remove(0);
            BlockPos partPos = part.getBlockPos();
            if (visited.contains(partPos)) {
                continue;
            }

            visited.add(partPos);

            int amount = tryToFormNewItemVaultMulti(part, cache, true);
            if (amount > 1) {
                creationQueue.add(Pair.of(amount, part));
            }

            for (Direction.Axis axis : Iterate.axes) {
                Direction dir = Direction.get(Direction.AxisDirection.NEGATIVE, axis);
                BlockPos next = partPos.relative(dir);

                if (next.getX() <= minX || next.getY() <= minY || next.getZ() <= minZ) {
                    continue;
                }
                if (visited.contains(next)) {
                    continue;
                }

                T nextBe = partAt(blockEntity, level, next);
                if (nextBe == null) {
                    continue;
                }
                if (nextBe.isRemoved()) {
                    continue;
                }

                frontier.add(nextBe);
            }
        }
        visited.clear();

        while (!creationQueue.isEmpty()) {
            Pair<Integer, T> next = creationQueue.poll();
            T toCreate = next.getValue();
            if (visited.contains(toCreate.getBlockPos())) {
                continue;
            }

            visited.add(toCreate.getBlockPos());
            tryToFormNewItemVaultMulti(toCreate, cache, false);
        }
    }

    private static class SearchCache<T extends BlockEntity & IMultiBlockEntityContainer> {
        Map<BlockPos, Optional<T>> controllerMap;

        public SearchCache() {
            controllerMap = new HashMap<>();
        }

        void put(BlockPos pos, T target) {
            controllerMap.put(pos, Optional.of(target));
        }

        void putEmpty(BlockPos pos) {
            controllerMap.put(pos, Optional.empty());
        }

        boolean hasVisited(BlockPos pos) {
            return controllerMap.containsKey(pos);
        }

        Optional<T> getOrCache(BlockEntity be, BlockGetter level, BlockPos pos) {
            if (hasVisited(pos))
                return controllerMap.get(pos);

            T partAt = partAt(be, level, pos);
            if (partAt == null) {
                putEmpty(pos);
                return Optional.empty();
            }
            T controller = checked(level.getBlockEntity(partAt.getController()));
            if (controller == null) {
                putEmpty(pos);
                return Optional.empty();
            }
            put(pos, controller);
            return Optional.of(controller);
        }
    }
}
