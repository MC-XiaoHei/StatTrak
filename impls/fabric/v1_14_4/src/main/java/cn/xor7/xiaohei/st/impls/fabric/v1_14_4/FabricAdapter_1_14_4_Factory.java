package cn.xor7.xiaohei.st.impls.fabric.v1_14_4;

import cn.xor7.xiaohei.st.api.MinecraftVersion;
import cn.xor7.xiaohei.st.api.Platform;
import cn.xor7.xiaohei.st.api.PlatformAdapter;
import cn.xor7.xiaohei.st.api.factory.J8VersionedAdapterFactory;
import com.google.auto.service.AutoService;
import net.fabricmc.api.ModInitializer;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings({"rawtypes", "RedundantSuppression"})
@AutoService(J8VersionedAdapterFactory.class)
public class FabricAdapter_1_14_4_Factory implements J8VersionedAdapterFactory<ModInitializer> {
    @Override
    public Platform getPlatform() {
        return Platform.Fabric;
    }

    @Override
    public boolean isCompatibleWith(@NotNull MinecraftVersion ver) {
        return isApiCompatible(ver);
    }

    @Override
    public PlatformAdapter createAdapter(ModInitializer ignored) {
        return new FabricAdapter_1_14_4();
    }

    private boolean isApiCompatible(@NotNull MinecraftVersion version) {
        return version.isGreaterThanOrEqualTo("1.14.4");
    }
}
