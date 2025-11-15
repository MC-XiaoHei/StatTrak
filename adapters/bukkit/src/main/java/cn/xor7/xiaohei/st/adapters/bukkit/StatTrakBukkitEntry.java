package cn.xor7.xiaohei.st.adapters.bukkit;

import cn.xor7.xiaohei.st.api.MinecraftVersion;
import cn.xor7.xiaohei.st.api.Platform;
import cn.xor7.xiaohei.st.api.PlatformAdapter;
import cn.xor7.xiaohei.st.api.VersionedAdapterFactory;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.ServiceLoader;

public final class StatTrakBukkitEntry extends JavaPlugin {
    private PlatformAdapter<JavaPlugin> platformAdapter;

    @Override
    public void onEnable() {
        String minecraftVersion = getMinecraftVersionStr();
        MinecraftVersion version = new MinecraftVersion(minecraftVersion);
        platformAdapter = getAdapterFactory(version);
    }

    @Override
    public void onDisable() {
        if (platformAdapter == null) return;
        platformAdapter.shutdown();
    }

    private String getMinecraftVersionStr() {
        String versionString = Bukkit.getServer().getBukkitVersion();
        return versionString.split("-")[0];
    }

    @Contract(" -> new")
    @SuppressWarnings("rawtypes")
    private @NotNull ServiceLoader<VersionedAdapterFactory> getAdapterServiceLoader() {
        return ServiceLoader.load(VersionedAdapterFactory.class, getClassLoader());
    }

    @SuppressWarnings("unchecked")
    private @NotNull PlatformAdapter<JavaPlugin> getAdapterFactory(MinecraftVersion version) {
        for (VersionedAdapterFactory<?> factory : getAdapterServiceLoader()) {
            if (factory.getPlatform() == Platform.Bukkit && factory.isCompatibleWith(version)) {
                VersionedAdapterFactory<JavaPlugin> bukkitFactory = (VersionedAdapterFactory<JavaPlugin>) factory;
                PlatformAdapter<JavaPlugin> adapter = bukkitFactory.createAdapter(this);
                adapter.initialize(this);
                return adapter;
            }
        }
        throw new IllegalStateException("No compatible platform adapter found for Minecraft " + version);
    }
}
