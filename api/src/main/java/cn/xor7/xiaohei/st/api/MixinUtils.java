package cn.xor7.xiaohei.st.api;

import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixins;

import java.util.Collection;

public class MixinUtils {
    public static void addMixins(@NotNull Collection<String> mixinConfigs) {
        mixinConfigs.forEach(Mixins::addConfiguration);
    }
}
