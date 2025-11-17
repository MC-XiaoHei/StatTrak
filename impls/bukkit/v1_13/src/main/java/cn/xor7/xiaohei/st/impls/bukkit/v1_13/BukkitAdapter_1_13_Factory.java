package cn.xor7.xiaohei.st.impls.bukkit.v1_13;

import cn.xor7.xiaohei.st.api.MinecraftVersion;
import cn.xor7.xiaohei.st.api.Platform;
import cn.xor7.xiaohei.st.api.PlatformAdapter;
import cn.xor7.xiaohei.st.api.factory.J8VersionedAdapterFactory;
import com.google.auto.service.AutoService;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings({"rawtypes", "RedundantSuppression"})
@AutoService(J8VersionedAdapterFactory.class)
public class BukkitAdapter_1_13_Factory implements J8VersionedAdapterFactory<JavaPlugin> {
    @Override
    public Platform getPlatform() {
        return Platform.Bukkit;
    }

    @Override
    public boolean isCompatibleWith(@NotNull MinecraftVersion ver) {
        return isApiCompatible(ver) && shouldUseBukkitManifest(ver);
    }

    @Override
    public PlatformAdapter createAdapter(JavaPlugin loader) {
        return new BukkitAdapter_1_13(loader);
    }

    private boolean isApiCompatible(@NotNull MinecraftVersion version) {
        return version.isGreaterThanOrEqualTo("1.13");
    }

    private boolean shouldUseBukkitManifest(@NotNull MinecraftVersion version) {
        return version.isLessThan("1.20.5");
    }
}
