import xyz.jpenilla.resourcefactory.bukkit.BukkitPluginYaml

plugins {
    id("xyz.jpenilla.resource-factory-bukkit-convention") version "1.3.1"
    id("xyz.jpenilla.resource-factory-paper-convention") version "1.3.1"
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
    foliaSupported = false // TODO: true someday
}

@Suppress("VulnerableLibrariesLocal")
dependencies {
    implementation(project(":api"))
    compileOnly("org.spigotmc:spigot-api:1.13-R0.1-SNAPSHOT")
}