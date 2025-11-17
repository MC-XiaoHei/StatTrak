group = "neoforge"
version = "neoforge"

plugins {
    alias(libs.plugins.neoforgeModdev)
}

java {
    toolchain.languageVersion = JavaLanguageVersion.of(21)
}

neoForge {
    version = "20.6.139"

    parchment {
        mappingsVersion = "2024.06.16"
        minecraftVersion = "1.20.6"
    }

    mods {
        create("stat_trak").sourceSet(sourceSets["main"])
    }
}

dependencies {
    implementation(project(":api"))
}