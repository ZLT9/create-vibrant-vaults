package net.zlt.create_vibrant_vaults.mixin;

import com.simibubi.create.content.contraptions.MountedStorage;
import com.simibubi.create.content.logistics.crate.BottomlessItemHandler;
import io.github.fabricators_of_create.porting_lib.transfer.item.ItemStackHandler;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.zlt.create_vibrant_vaults.block.entity.AbstractItemVaultBlockEntity;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MountedStorage.class)
public abstract class CreateMountedStorageMixin {
    @Shadow
    private BlockEntity blockEntity;

    @Shadow
    boolean noFuel;

    @Shadow
    ItemStackHandler handler;

    @Shadow
    boolean valid;

    @Inject(method = "canUseAsStorage", at = @At("HEAD"), cancellable = true)
    private static void createVibrantVaults$canUseAsStorage(BlockEntity be, CallbackInfoReturnable<Boolean> cir) {
        if (be instanceof AbstractItemVaultBlockEntity) {
            cir.setReturnValue(true);
        }
    }

    @Redirect(method = "<init>", at = @At(value = "FIELD", target = "Lcom/simibubi/create/content/contraptions/MountedStorage;noFuel:Z", opcode = Opcodes.PUTFIELD), remap = false)
    private void createVibrantVaults$init(MountedStorage instance, boolean isItemVaultBlockEntity, BlockEntity be) {
        noFuel = isItemVaultBlockEntity || be instanceof AbstractItemVaultBlockEntity;
    }

    @Inject(method = "removeStorageFromWorld", at = @At("HEAD"), cancellable = true, remap = false)
    private void createVibrantVaults$removeStorageFromWorld(CallbackInfo ci) {
        if (blockEntity instanceof AbstractItemVaultBlockEntity<?> be) {
            handler = be.getInventoryOfBlock();
            valid = true;
            ci.cancel();
        }
    }

    @Inject(method = "addStorageToWorld", at = @At("HEAD"), cancellable = true)
    private void createVibrantVaults$addStorageToWorld(BlockEntity be, CallbackInfo ci) {
        if (handler instanceof BottomlessItemHandler) {
            return;
        }

        if (be instanceof AbstractItemVaultBlockEntity<?> be2) {
            be2.applyInventoryToBlock(handler);
            ci.cancel();
        }
    }
}
