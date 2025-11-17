package cn.xor7.xiaohei.st.impls.fabric.v1_14_4.mixins;

import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Level.class)
public class TestMixin {
    @Inject(method = "Lnet/minecraft/world/level/Level;updateSkyBrightness()V", at = @At("HEAD"))
    private void onCall(CallbackInfo ci) {
        System.out.println("Mixin Test Success!");
    }
}
