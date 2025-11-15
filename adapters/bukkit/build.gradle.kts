import xyz.jpenilla.resourcefactory.bukkit.BukkitPluginYaml

plugins {
    alias(libs.plugins.resourceFactoryBukkit)
    alias(libs.plugins.resourceFactoryPaper)
}

lateinit var bukkit: BukkitPluginYaml

bukkitPluginYaml {
    name = rootProject.name
    version = rootProject.version.toString()
    main = "cn.xor7.xiaohei.st.adapters.bukkit.StatTrakBukkitEntry"
    apiVersion = "1.13"
    authors = listOf("MC_XiaoHei")
    bukkit = this
}

paperPluginYaml {
    name = bukkit.name
    version = bukkit.version
    main = bukkit.main
    apiVersion = "1.20"
    authors = bukkit.authors
    foliaSupported = true
}

@Suppress("VulnerableLibrariesLocal")
dependencies {
    implementation(project(":api"))
    compileOnly("org.spigotmc:spigot-api:1.13-R0.1-SNAPSHOT")
}