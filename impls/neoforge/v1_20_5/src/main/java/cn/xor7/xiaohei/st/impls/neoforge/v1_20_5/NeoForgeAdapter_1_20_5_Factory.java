package cn.xor7.xiaohei.st.impls.neoforge.v1_20_5;

import cn.xor7.xiaohei.st.api.MinecraftVersion;
import cn.xor7.xiaohei.st.api.Platform;
import cn.xor7.xiaohei.st.api.PlatformAdapter;
import cn.xor7.xiaohei.st.api.factory.J21VersionedAdapterFactory;
import com.google.auto.service.AutoService;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings({"rawtypes", "RedundantSuppression"})
@AutoService(J21VersionedAdapterFactory.class)
public class NeoForgeAdapter_1_20_5_Factory implements J21VersionedAdapterFactory<Object> {
    @Override
    public Platform getPlatform() {
        return Platform.NeoForge;
    }

    @Override
    public boolean isCompatibleWith(MinecraftVersion ver) {
        return isApiCompatible(ver);
    }

    @Override
    public PlatformAdapter createAdapter(Object ignored) {
        return new NeoForgeAdapter_1_20_5();
    }

    private boolean isApiCompatible(@NotNull MinecraftVersion version) {
        return version.isGreaterThanOrEqualTo("1.20.5");
    }
}