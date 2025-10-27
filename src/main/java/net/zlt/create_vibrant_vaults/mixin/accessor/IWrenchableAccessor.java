package net.zlt.create_vibrant_vaults.mixin.accessor;

import com.simibubi.create.content.equipment.wrench.IWrenchable;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(IWrenchable.class)
public interface IWrenchableAccessor {
    @Invoker("playRotateSound")
    static void createVibrantVaults$invokePlayRotateSound(Level level, BlockPos pos) {
        throw new AssertionError();
    }
}
