package cn.xor7.xiaohei.st.adapters.bukkit;

import cn.xor7.xiaohei.st.api.MinecraftVersion;
import cn.xor7.xiaohei.st.api.Platform;
import cn.xor7.xiaohei.st.api.PlatformAdapter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import static cn.xor7.xiaohei.st.api.AdapterUtils.createAdapter;

@SuppressWarnings("unused")
public final class StatTrakBukkitEntry extends JavaPlugin {
    private static PlatformAdapter platformAdapter;

    @Override
    public void onLoad() {
        String versionStr = getMinecraftVersionStr();
        MinecraftVersion version = new MinecraftVersion(versionStr);
        platformAdapter = createAdapter(getClassLoader(), version, Platform.Bukkit, this);
    }

    @Override
    public void onEnable() {
        if (platformAdapter == null) throw new IllegalStateException("Platform adapter is not initialized");
        platformAdapter.initialize();
    }

    @Override
    public void onDisable() {
        if (platformAdapter == null) throw new IllegalStateException("Platform adapter is not initialized");
        platformAdapter.shutdown();
    }

    private String getMinecraftVersionStr() {
        String versionString = Bukkit.getServer().getBukkitVersion();
        return versionString.split("-")[0];
    }
}
