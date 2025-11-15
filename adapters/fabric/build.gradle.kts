import xyz.jpenilla.resourcefactory.fabric.Environment

plugins {
    alias(libs.plugins.resourceFactoryFabric)
}

fabricModJson {
    id = rootProject.name.pascalToSnake()
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

private fun String.pascalToSnake(): String {
    if (this.isEmpty()) return this
    val sb = StringBuilder()
    for (i in this.indices) {
        val c = this[i]
        if (c.isUpperCase()) {
            if (i > 0) {
                val prev = this[i - 1]
                val next = this.getOrNull(i + 1)
                if (prev.isLowerCase() || prev.isDigit() || (next != null && next.isLowerCase())) {
                    sb.append('_')
                }
            }
            sb.append(c.lowercaseChar())
        } else {
            sb.append(c)
        }
    }
    return sb.toString()
}