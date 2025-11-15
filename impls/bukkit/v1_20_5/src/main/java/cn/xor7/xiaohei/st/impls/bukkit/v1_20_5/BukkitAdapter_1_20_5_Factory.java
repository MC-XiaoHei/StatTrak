package cn.xor7.xiaohei.st.impls.bukkit.v1_20_5;

import cn.xor7.xiaohei.st.api.MinecraftVersion;
import cn.xor7.xiaohei.st.api.Platform;
import cn.xor7.xiaohei.st.api.PlatformAdapter;
import cn.xor7.xiaohei.st.api.factory.ModernVersionedAdapterFactory;
import com.google.auto.service.AutoService;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings({"rawtypes", "RedundantSuppression"})
@AutoService(ModernVersionedAdapterFactory.class)
public class BukkitAdapter_1_20_5_Factory implements ModernVersionedAdapterFactory<JavaPlugin> {
    @Override
    public Platform getPlatform() {
        return Platform.Bukkit;
    }

    @Override
    public boolean isCompatibleWith(@NotNull MinecraftVersion ver) {
        return isApiCompatible(ver);
    }

    @Override
    public PlatformAdapter createAdapter(JavaPlugin loader) {
        return new BukkitAdapter_1_20_5(loader);
    }

    private boolean isApiCompatible(@NotNull MinecraftVersion version) {
        return version.isGreaterThanOrEqualTo("1.20.5");
    }
}
