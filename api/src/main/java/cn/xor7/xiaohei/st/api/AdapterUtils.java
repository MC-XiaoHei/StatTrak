package cn.xor7.xiaohei.st.api;

import cn.xor7.xiaohei.st.api.factory.J17VersionedAdapterFactory;
import cn.xor7.xiaohei.st.api.factory.J8VersionedAdapterFactory;
import cn.xor7.xiaohei.st.api.factory.J21VersionedAdapterFactory;
import cn.xor7.xiaohei.st.api.factory.VersionedAdapterFactory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ServiceLoader;

public class AdapterUtils {

    @SuppressWarnings({"rawtypes"})
    public static <T> @NotNull PlatformAdapter createAdapter(
        ClassLoader classLoader,
        MinecraftVersion version,
        Platform platform,
        T loader
    ) {
        PlatformAdapter adapter;

        ServiceLoader<J8VersionedAdapterFactory> j8Factories = ServiceLoader.load(J8VersionedAdapterFactory.class, classLoader);
        adapter = getPlatformAdapter(version, platform, loader, j8Factories);
        if (adapter != null) return adapter;

        ServiceLoader<J17VersionedAdapterFactory> j17Factories = ServiceLoader.load(J17VersionedAdapterFactory.class, classLoader);
        adapter = getPlatformAdapter(version, platform, loader, j17Factories);
        if (adapter != null) return adapter;

        ServiceLoader<J21VersionedAdapterFactory> j21Factories = ServiceLoader.load(J21VersionedAdapterFactory.class, classLoader);
        adapter = getPlatformAdapter(version, platform, loader, j21Factories);
        if (adapter != null) return adapter;

        throw new IllegalStateException("No compatible adapter factory found for platform " + platform + " and version " + version);
    }

    @SuppressWarnings("unchecked")
    private static <T, F extends VersionedAdapterFactory<?>> @Nullable PlatformAdapter getPlatformAdapter(MinecraftVersion version, Platform platform, T loader, @NotNull ServiceLoader<F> serviceLoader) {
        for (VersionedAdapterFactory<?> factory : serviceLoader) {
            if (factory.getPlatform() == platform && factory.isCompatibleWith(version)) {
                VersionedAdapterFactory<T> factoryT = (VersionedAdapterFactory<T>) factory;
                PlatformAdapter adapter = factoryT.createAdapter(loader);
                adapter.setMinecraftVersion(version);
                return adapter;
            }
        }
        return null;
    }
}
