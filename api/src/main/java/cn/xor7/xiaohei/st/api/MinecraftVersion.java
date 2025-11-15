package cn.xor7.xiaohei.st.api;

import org.jetbrains.annotations.NotNull;

public class MinecraftVersion implements Comparable<MinecraftVersion> {
    public final int minor;
    public final int patch;

    public MinecraftVersion(int minor, int patch) {
        this.minor = minor;
        this.patch = patch;
    }

    public MinecraftVersion(@NotNull String versionString) {
        String[] parts = versionString.split("\\.");
        if (parts.length != 3 || !parts[0].equals("1")) {
            throw new IllegalArgumentException("Invalid Minecraft version format: " + versionString);
        }
        this.minor = Integer.parseInt(parts[1]);
        this.patch = Integer.parseInt(parts[2]);
    }

    @Override
    public String toString() {
        return "1." + minor + "." + patch;
    }

    @Override
    public int compareTo(@NotNull MinecraftVersion o) {
        if (this.minor != o.minor) {
            return Integer.compare(this.minor, o.minor);
        } else {
            return Integer.compare(this.patch, o.patch);
        }
    }

    public boolean isGreaterThan(@NotNull MinecraftVersion other) {
        return this.compareTo(other) > 0;
    }

    public boolean isLessThan(@NotNull MinecraftVersion other) {
        return this.compareTo(other) < 0;
    }
}
