package cn.xor7.xiaohei.st.impls.fabric.v1_14_4;

import cn.xor7.xiaohei.st.api.MinecraftVersion;
import cn.xor7.xiaohei.st.api.Platform;
import cn.xor7.xiaohei.st.api.PlatformAdapter;
import cn.xor7.xiaohei.st.api.factory.LegacyVersionedAdapterFactory;
import com.google.auto.service.AutoService;
import net.fabricmc.api.ModInitializer;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings({"rawtypes", "RedundantSuppression"})
@AutoService(LegacyVersionedAdapterFactory.class)
public class FabricAdapter_1_14_4_Factory implements LegacyVersionedAdapterFactory<ModInitializer> {
    @Override
    public Platform getPlatform() {
        return Platform.Fabric;
    }

    @Override
    public boolean isCompatibleWith(@NotNull MinecraftVersion ver) {
        System.out.println(ver);
        return ver.isGreaterThanOrEqualTo("1.14.4");
    }

    @Override
    public PlatformAdapter createAdapter(ModInitializer loader) {
        return new FabricAdapter_1_14_4();
    }
}
