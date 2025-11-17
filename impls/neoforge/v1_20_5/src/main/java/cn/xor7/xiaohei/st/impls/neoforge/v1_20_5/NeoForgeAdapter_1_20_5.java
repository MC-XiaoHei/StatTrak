package cn.xor7.xiaohei.st.impls.neoforge.v1_20_5;

import cn.xor7.xiaohei.st.api.PlatformAdapter;

import java.util.ArrayList;
import java.util.Collection;

public class NeoForgeAdapter_1_20_5 implements PlatformAdapter {

    @Override
    public void initialize() {
        System.out.println("StatTrak NeoForge Adapter for Minecraft 1.20.5+ initialized.");
    }

    @Override
    public Collection<String> getMixinConfigs() {
        Collection<String> mixins = new ArrayList<>();
        mixins.add("st.neoforge.1.20.5.mixins.json"); // TODO: seems not work now..
        return mixins;
    }
}
