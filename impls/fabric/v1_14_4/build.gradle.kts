@file:Suppress("UnstableApiUsage")

group = "fabric"
version = "fabric"

val minecraftVersion = "1.14.4"

plugins {
    alias(libs.plugins.fabricLoom)
}

loom {
    mixin.defaultRefmapName.set("st.fabric.${minecraftVersion}.refmap.json")
}

dependencies {
    implementation(project(":api"))
    minecraft("com.mojang:minecraft:${minecraftVersion}")
    mappings(loom.officialMojangMappings())
    modCompileOnly("net.fabricmc.fabric-api:fabric-api:${libs.versions.fabricApi.get()}+1.14")
}