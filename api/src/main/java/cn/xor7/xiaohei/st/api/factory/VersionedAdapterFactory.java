package cn.xor7.xiaohei.st.api.factory;

import cn.xor7.xiaohei.st.api.MinecraftVersion;
import cn.xor7.xiaohei.st.api.Platform;
import cn.xor7.xiaohei.st.api.PlatformAdapter;

public interface VersionedAdapterFactory<T> {

    Platform getPlatform();

    boolean isCompatibleWith(MinecraftVersion ver);

    PlatformAdapter createAdapter(T loader);
}