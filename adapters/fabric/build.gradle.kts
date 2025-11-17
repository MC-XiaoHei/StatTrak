import xyz.jpenilla.resourcefactory.fabric.Environment

plugins {
    alias(libs.plugins.resourceFactoryFabric)
}

fabricModJson {
    id = "stat_trak"
    name = rootProject.name
    mitLicense()
    version = rootProject.version.toString()
    authors = listOf(person("MC_XiaoHei"))
    environment = Environment.ANY

    val entry = "cn.xor7.xiaohei.st.adapters.fabric.StatTrakFabricEntry"
    mainEntrypoint(entry)
    entrypoint("preLaunch", entry)

    depends("minecraft", ">=1.14.4")
}

dependencies {
    implementation(project(":api"))
    compileOnly(libs.fabricLoader)
}