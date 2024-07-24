package xyz.aikoyori.palettenocrashy.mixins;

import net.minecraft.world.chunk.IdListPalette;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(IdListPalette.class)
public class IDListPaletteMixin<T> {
    @Inject(method = "get",at = @At(value = "INVOKE", target = "Lnet/minecraft/world/chunk/EntryMissingException;<init>(I)V",shift = At.Shift.BEFORE),cancellable = true)
    void noCrashPls(int id, CallbackInfoReturnable<T> cir)
    {
        cir.setReturnValue((((IdListPalette<T>)(Object)(this)).get(0)));
    }
}
