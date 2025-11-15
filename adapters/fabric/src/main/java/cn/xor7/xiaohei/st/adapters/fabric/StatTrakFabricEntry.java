package cn.xor7.xiaohei.st.adapters.fabric;

import cn.xor7.xiaohei.st.api.MinecraftVersion;
import cn.xor7.xiaohei.st.api.MixinUtils;
import cn.xor7.xiaohei.st.api.Platform;
import cn.xor7.xiaohei.st.api.PlatformAdapter;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.fabricmc.loader.api.entrypoint.PreLaunchEntrypoint;

import static cn.xor7.xiaohei.st.api.AdapterUtils.createAdapter;

@SuppressWarnings("unused")
public class StatTrakFabricEntry implements PreLaunchEntrypoint, ModInitializer {
    private static PlatformAdapter platformAdapter;

    @Override
    public void onPreLaunch() {
        String versionStr = getMinecraftVersionStr();
        MinecraftVersion version = new MinecraftVersion(versionStr);
        platformAdapter = createAdapter(getClass().getClassLoader(), version, Platform.Fabric, this);
        MixinUtils.addMixins(platformAdapter.getMixinConfigs());
    }

    @Override
    public void onInitialize() {
        if (platformAdapter == null) throw new IllegalStateException("Platform adapter is not initialized");
        platformAdapter.initialize();
    }

    private String getMinecraftVersionStr() {
        ModContainer container = FabricLoader.getInstance()
            .getModContainer("minecraft")
            .orElseThrow(() -> new IllegalStateException("Could not get minecraft mod container"));
        return container.getMetadata().getVersion().getFriendlyString();
    }
}
