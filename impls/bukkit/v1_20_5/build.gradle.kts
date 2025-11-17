group = "bukkit"
version = "bukkit"

plugins {
    alias(libs.plugins.paperweightUserdev)
}

java {
    toolchain.languageVersion = JavaLanguageVersion.of(21)
}

dependencies {
    implementation(project(":api"))
    paperweight.paperDevBundle("1.20.6-R0.1-SNAPSHOT") // some error on 1.20.5 api process, so use 1.20.6 dev bundle
}