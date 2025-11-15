package cn.xor7.xiaohei.st.impls.bukkit.v1_13;

import cn.xor7.xiaohei.st.api.PlatformAdapter;
import org.bukkit.plugin.java.JavaPlugin;

public class BukkitAdapter_1_13 implements PlatformAdapter<JavaPlugin> {
    private final JavaPlugin plugin;

    public BukkitAdapter_1_13(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public void initialize(JavaPlugin loader) {
        plugin.getLogger().info("StatTrak Bukkit Adapter for Minecraft 1.13 initialized.");
    }

    @Override
    public void shutdown() {
        plugin.getLogger().info("StatTrak Bukkit Adapter for Minecraft 1.13 shutting down.");
    }
}
