package cn.xor7.xiaohei.st.impls.bukkit.v1_20_5;

import cn.xor7.xiaohei.st.api.PlatformAdapter;
import org.bukkit.plugin.java.JavaPlugin;

@SuppressWarnings("ClassCanBeRecord")
public class BukkitAdapter_1_20_5 implements PlatformAdapter<JavaPlugin> {
    private final JavaPlugin plugin;

    public BukkitAdapter_1_20_5(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public void initialize(JavaPlugin loader) {
        plugin.getLogger().info("StatTrak Bukkit Adapter for Minecraft 1.20.5+ initialized.");
    }

    @Override
    public void shutdown() {
        plugin.getLogger().info("StatTrak Bukkit Adapter for Minecraft 1.20.5+ shutting down.");
    }
}
