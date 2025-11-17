package cn.xor7.xiaohei.st.adapters.neoforge;

import cn.xor7.xiaohei.st.api.MinecraftVersion;
import cn.xor7.xiaohei.st.api.MixinUtils;
import cn.xor7.xiaohei.st.api.Platform;
import cn.xor7.xiaohei.st.api.PlatformAdapter;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;

import static cn.xor7.xiaohei.st.api.AdapterUtils.createAdapter;

@Mod("stat_trak")
@Mod.EventBusSubscriber(modid = "stat_trak", bus = Mod.EventBusSubscriber.Bus.MOD)
public class StatTrakNeoForgeEntry {
    private static PlatformAdapter platformAdapter;

    public StatTrakNeoForgeEntry() {
        String versionStr = getMinecraftVersionStr();
        MinecraftVersion version = new MinecraftVersion(versionStr);
        platformAdapter = createAdapter(getClass().getClassLoader(), version, Platform.NeoForge, this);
        MixinUtils.addMixins(platformAdapter.getMixinConfigs());
    }

    @SubscribeEvent
    static void onCommonSetup(FMLCommonSetupEvent event) {
        if (platformAdapter == null) throw new IllegalStateException("Platform adapter is not initialized");
        platformAdapter.initialize();
    }

    private String getMinecraftVersionStr() {
        ModContainer container = ModList.get()
            .getModContainerById("minecraft")
            .orElseThrow(() -> new IllegalStateException("Could not get minecraft mod container"));
        return container.getModInfo().getVersion().toString();
    }
}
