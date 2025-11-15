package cn.xor7.xiaohei.st.api;

public interface PlatformAdapter<T> {

    void initialize(T loader);

    void shutdown();
}
