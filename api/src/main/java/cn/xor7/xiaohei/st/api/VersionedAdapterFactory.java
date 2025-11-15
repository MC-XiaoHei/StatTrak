package cn.xor7.xiaohei.st.api;

public interface VersionedAdapterFactory<T> {

    Platform getPlatform();

    boolean isCompatibleWith(MinecraftVersion minecraftVersion);

    PlatformAdapter<T> createAdapter(T loader);
}
