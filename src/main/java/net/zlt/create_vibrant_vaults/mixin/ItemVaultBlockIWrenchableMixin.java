package net.zlt.create_vibrant_vaults.mixin;

import com.simibubi.create.content.equipment.wrench.IWrenchable;
import com.simibubi.create.content.kinetics.base.GeneratingKineticBlockEntity;
import com.simibubi.create.content.kinetics.base.KineticBlockEntity;
import com.simibubi.create.content.logistics.vault.ItemVaultBlock;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_vibrant_vaults.block.AllBlocks;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ItemVaultBlock.class)
public abstract class ItemVaultBlockIWrenchableMixin implements IWrenchable {
    @Inject(method = "onWrenched", at = @At(value = "INVOKE", target = "Lcom/simibubi/create/content/equipment/wrench/IWrenchable;onWrenched(Lnet/minecraft/world/level/block/state/BlockState;Lnet/minecraft/world/item/context/UseOnContext;)Lnet/minecraft/world/InteractionResult;"), cancellable = true, remap = false)
    private void createVibrantVaults$onWrenched(BlockState state, UseOnContext context, CallbackInfoReturnable<InteractionResult> cir) {
        Direction.Axis targetedAxis = context.getClickedFace().getAxis();
        if (!targetedAxis.isHorizontal() || targetedAxis == state.getValue(ItemVaultBlock.HORIZONTAL_AXIS)) {
            return;
        }

        Level world = context.getLevel();
        BlockState rotated = AllBlocks.VERTICAL_ITEM_VAULT.getDefaultState();
        if (!rotated.canSurvive(world, context.getClickedPos())) {
            cir.setReturnValue(InteractionResult.PASS);
            return;
        }

        KineticBlockEntity.switchToBlockState(world, context.getClickedPos(), updateAfterWrenched(rotated, context));
        BlockEntity be = context.getLevel().getBlockEntity(context.getClickedPos());
        if (be instanceof GeneratingKineticBlockEntity) {
            ((GeneratingKineticBlockEntity)be).reActivateSource = true;
        }
        if (world.getBlockState(context.getClickedPos()) != state) {
            playRotateSound(world, context.getClickedPos());
        }
        cir.setReturnValue(InteractionResult.SUCCESS);
    }
}
