java {
    toolchain.languageVersion = JavaLanguageVersion.of(21)
}

plugins {
    id("io.papermc.paperweight.userdev") version "2.0.0-beta.19"
}

dependencies {
    implementation(project(":api"))
    paperweight.paperDevBundle("1.20.6-R0.1-SNAPSHOT") // some error on 1.20.5 api process, so use 1.20.6 dev bundle
}