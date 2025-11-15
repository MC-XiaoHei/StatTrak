java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(21))
}

plugins {
    id("io.papermc.paperweight.userdev") version "2.0.0-beta.19"
}

dependencies {
    implementation(project(":api"))
    paperweight.paperDevBundle("1.21.5-R0.1-SNAPSHOT")
}