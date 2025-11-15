plugins {
    id("com.gradleup.shadow") version "9.2.2"
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(21))
}

dependencies {
    implementation(project(":api"))

    rootProject.subprojects {
        if (project.path.startsWith(":adapters:")) {
            implementation(project)
            println("Depend Adapter ${project.path}")
        }
    }

    rootProject.subprojects {
        if (project.path.startsWith(":impls:")) {
            implementation(project)
            println("Depend Implementation ${project.path}")
        }
    }
}

tasks.shadowJar {
    mergeServiceFiles()

    // TODO: relocate dependencies

    archiveFileName.set("${rootProject.name}-${rootProject.version}-hybrid-all.jar")
}

tasks.build {
    dependsOn(tasks.shadowJar)
}

private fun println(message: String) = kotlin.io.println("[dist] $message")