import org.gradle.kotlin.dsl.neoForgeModsToml

plugins {
    alias(libs.plugins.resourceFactoryNeoforge)
}

java {
    toolchain.languageVersion = JavaLanguageVersion.of(21)
}

neoForgeModsToml {
    modLoader = "javafml"
    loaderVersion = "[1,)"
    mitLicense()

    mods {
        register("stat_trak") {
            displayName = rootProject.name
            version = rootProject.version.toString()
            authors = "MC_XiaoHei"

            dependencies {
                required("neoforge", "[1,)")
                required("minecraft", "[1.20.5,)")
            }
        }
    }

    mixin("st.neoforge.1.20.5.mixins.json")
}

@Suppress("VulnerableLibrariesLocal")
dependencies {
    implementation(project(":api"))
    compileOnly("net.neoforged:neoforge:20.2.93")
}