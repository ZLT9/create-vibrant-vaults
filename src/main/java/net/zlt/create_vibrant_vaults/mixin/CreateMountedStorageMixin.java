package net.zlt.create_vibrant_vaults.mixin;

import com.simibubi.create.content.contraptions.MountedStorage;
import com.simibubi.create.content.logistics.crate.BottomlessItemHandler;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.items.ItemStackHandler;
import net.zlt.create_vibrant_vaults.block.entity.AbstractItemVaultBlockEntity;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Final;
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

    @Shadow @Final
    private static ItemStackHandler dummyHandler;

    @Shadow
    ItemStackHandler handler;

    @Shadow
    boolean noFuel;

    @Shadow
    boolean valid;

    @Inject(method = "canUseAsStorage", at = @At("HEAD"), cancellable = true, remap = false)
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
        if (blockEntity.getCapability(ForgeCapabilities.ITEM_HANDLER).orElse(dummyHandler) == dummyHandler || !(blockEntity instanceof AbstractItemVaultBlockEntity<?> be)) {
            return;
        }

        handler = be.getInventoryOfBlock();
        valid = true;
        ci.cancel();
    }

    @Inject(method = "addStorageToWorld", at = @At("HEAD"), cancellable = true, remap = false)
    private void createVibrantVaults$addStorageToWorld(BlockEntity be, CallbackInfo ci) {
        if (handler instanceof BottomlessItemHandler || !(be instanceof AbstractItemVaultBlockEntity<?> be2)) {
            return;
        }

        be2.applyInventoryToBlock(handler);
        ci.cancel();
    }
}
