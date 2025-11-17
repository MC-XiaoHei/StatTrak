package cn.xor7.xiaohei.st.impls.neoforge.v1_20_5.mixins;

import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Player.class)
public class TestMixin {
    @Inject(method = "Lnet/minecraft/world/entity/player/Player;createAttributes()Lnet/minecraft/world/entity/ai/attributes/AttributeSupplier$Builder;", at = @At("HEAD"))
    private static void onCall(CallbackInfoReturnable<AttributeSupplier.Builder> cir) {
        System.out.println("Mixin Test Success!");
    }
}
