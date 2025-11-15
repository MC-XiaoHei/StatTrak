package cn.xor7.xiaohei.st.api;

import cn.xor7.xiaohei.st.api.factory.LegacyVersionedAdapterFactory;
import cn.xor7.xiaohei.st.api.factory.ModernVersionedAdapterFactory;
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
        ServiceLoader<LegacyVersionedAdapterFactory> legacyFactories = ServiceLoader.load(LegacyVersionedAdapterFactory.class, classLoader);
        PlatformAdapter adapter = getPlatformAdapter(version, platform, loader, legacyFactories);
        if (adapter != null) return adapter;

        ServiceLoader<ModernVersionedAdapterFactory> modernFactories = ServiceLoader.load(ModernVersionedAdapterFactory.class, classLoader);
        adapter = getPlatformAdapter(version, platform, loader, modernFactories);
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
