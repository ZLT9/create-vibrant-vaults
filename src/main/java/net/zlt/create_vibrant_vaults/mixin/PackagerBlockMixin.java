package net.zlt.create_vibrant_vaults.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import com.simibubi.create.content.logistics.packager.PackagerBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.zlt.create_vibrant_vaults.item.ModItemTags;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PackagerBlock.class)
public abstract class PackagerBlockMixin {
    @Shadow(remap = false)
    @Final
    public static BooleanProperty LINKED;

    @Inject(method = "use", at = @At(value = "INVOKE", target = "Lcom/simibubi/create/content/logistics/packager/PackagerBlock;onBlockEntityUse(Lnet/minecraft/world/level/BlockGetter;Lnet/minecraft/core/BlockPos;Ljava/util/function/Function;)Lnet/minecraft/world/InteractionResult;"), cancellable = true, remap = false)
    private void createVibrantVaults$onUse(BlockState state, Level worldIn, BlockPos pos, Player player, InteractionHand handIn, BlockHitResult hit, CallbackInfoReturnable<InteractionResult> cir, @Local ItemStack itemInHand) {
        if (ModItemTags.VIBRANT_STOCK_LINKS.matches(itemInHand) && !(state.hasProperty(LINKED) && state.getValue(LINKED)) || ModItemTags.VIBRANT_FROGPORTS.matches(itemInHand)) {
            cir.setReturnValue(InteractionResult.PASS);
        }
    }
}
