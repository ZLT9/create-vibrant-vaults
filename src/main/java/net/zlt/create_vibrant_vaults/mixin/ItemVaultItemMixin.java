package net.zlt.create_vibrant_vaults.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import com.simibubi.create.content.logistics.vault.ItemVaultItem;
import com.simibubi.create.foundation.blockEntity.IMultiBlockEntityContainer;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_vibrant_vaults.block.ItemVaultConnectivityHelper;
import net.zlt.create_vibrant_vaults.block.ModBlockTags;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ItemVaultItem.class)
public abstract class ItemVaultItemMixin extends BlockItem {
    private ItemVaultItemMixin(Block block, Properties properties) {
        super(block, properties);
    }

    @Redirect(method = "tryMultiPlace", at = @At(value = "INVOKE", target = "Lcom/simibubi/create/content/logistics/vault/ItemVaultBlock;isVault(Lnet/minecraft/world/level/block/state/BlockState;)Z"))
    private boolean createVibrantVaults$isVault(BlockState state) {
        return ItemVaultConnectivityHelper.isVault(state, getBlock());
    }

    @Redirect(method = "tryMultiPlace", at = @At(value = "INVOKE", target = "Lcom/simibubi/create/api/connectivity/ConnectivityHandler;partAt(Lnet/minecraft/world/level/block/entity/BlockEntityType;Lnet/minecraft/world/level/BlockGetter;Lnet/minecraft/core/BlockPos;)Lnet/minecraft/world/level/block/entity/BlockEntity;"))
    private <T extends BlockEntity & IMultiBlockEntityContainer> T createVibrantVaults$partAt(BlockEntityType<?> type, BlockGetter level, BlockPos pos) {
        return ItemVaultConnectivityHelper.partAt(getBlock(), level, pos);
    }

    @ModifyExpressionValue(method = "tryMultiPlace", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/BlockPos;offset(III)Lnet/minecraft/core/BlockPos;", ordinal = 1))
    private BlockPos createVibrantVaults$getVaultPos1(BlockPos original, @Local(ordinal = 2) BlockPos startPos, @Local(ordinal = 2) int xOffset, @Local(ordinal = 3) int zOffset) {
        return ModBlockTags.VERTICAL_VAULTS.matches(getBlock()) ? startPos.offset(xOffset, 0, zOffset) : original;
    }

    @ModifyExpressionValue(method = "tryMultiPlace", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/BlockPos;offset(III)Lnet/minecraft/core/BlockPos;", ordinal = 3), remap = false)
    private BlockPos createVibrantVaults$getVaultPos2(BlockPos original, @Local(ordinal = 2) BlockPos startPos, @Local(ordinal = 2) int xOffset, @Local(ordinal = 3) int zOffset) {
        return ModBlockTags.VERTICAL_VAULTS.matches(getBlock()) ? startPos.offset(xOffset, 0, zOffset) : original;
    }
}
