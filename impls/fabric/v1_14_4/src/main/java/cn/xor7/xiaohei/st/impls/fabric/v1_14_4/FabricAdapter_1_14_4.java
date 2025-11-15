package cn.xor7.xiaohei.st.impls.fabric.v1_14_4;

import cn.xor7.xiaohei.st.api.PlatformAdapter;

import java.util.ArrayList;
import java.util.Collection;

public class FabricAdapter_1_14_4 implements PlatformAdapter {

    public FabricAdapter_1_14_4() {
    }

    @Override
    public void initialize() {
        System.out.println("StatTrak Fabric Adapter for Minecraft 1.14.4+ initialized.");
    }

    @Override
    public Collection<String> getMixinConfigs() {
        Collection<String> mixins = new ArrayList<>();
        mixins.add("st.fabric.1.14.4.mixins.json");
        return mixins;
    }
}
