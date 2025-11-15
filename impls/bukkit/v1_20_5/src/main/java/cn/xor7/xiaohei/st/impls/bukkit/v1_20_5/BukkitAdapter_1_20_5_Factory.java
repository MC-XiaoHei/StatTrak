package cn.xor7.xiaohei.st.impls.bukkit.v1_20_5;

import cn.xor7.xiaohei.st.api.MinecraftVersion;
import cn.xor7.xiaohei.st.api.Platform;
import cn.xor7.xiaohei.st.api.PlatformAdapter;
import cn.xor7.xiaohei.st.api.VersionedAdapterFactory;
import com.google.auto.service.AutoService;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings({"rawtypes", "RedundantSuppression"})
@AutoService(VersionedAdapterFactory.class)
public class BukkitAdapter_1_20_5_Factory implements VersionedAdapterFactory<JavaPlugin> {
    @Override
    public Platform getPlatform() {
        return Platform.Bukkit;
    }

    @Override
    public boolean isCompatibleWith(@NotNull MinecraftVersion ver) {
        return isGreaterThanApiVersion(ver) && isLessThanPaperHardForkVersion(ver);
    }

    @Override
    public PlatformAdapter<JavaPlugin> createAdapter(JavaPlugin loader) {
        return new BukkitAdapter_1_20_5(loader);
    }

    private boolean isGreaterThanApiVersion(@NotNull MinecraftVersion minecraftVersion) {
        return minecraftVersion.isGreaterThan(new MinecraftVersion(13, 0));
    }

    private boolean isLessThanPaperHardForkVersion(@NotNull MinecraftVersion minecraftVersion) {
        return minecraftVersion.isLessThan(new MinecraftVersion(20, 5));
    }
}
