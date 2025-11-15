package cn.xor7.xiaohei.st.api;

import java.util.ArrayList;
import java.util.Collection;

public interface PlatformAdapter {

    void initialize();

    @SuppressWarnings("unused")
    default void setMinecraftVersion(MinecraftVersion version) {
    }

    default Collection<String> getMixinConfigs() {
        return new ArrayList<>();
    }

    default void shutdown() {
    }
}
