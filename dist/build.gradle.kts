plugins {
    id("com.gradleup.shadow") version "9.2.0"
}

java {
    toolchain.languageVersion = JavaLanguageVersion.of(21)
}

tasks.shadowJar {
    duplicatesStrategy = DuplicatesStrategy.INCLUDE
    mergeServiceFiles()
    exclude("org/jetbrains/annotations/**")
    exclude("org/intellij/lang/annotations/**")
    archiveFileName.set("${rootProject.name}-${rootProject.version}-hybrid-all.jar")
}

dependencies {
    implementation(project(":api"))

    rootProject.subprojects {
        if (project.path.startsWith(":adapters:") && project.path.count { it == ':' } == 2) {
            implementation(project)
            println("Depend Adapter ${project.path}")
        }
    }

    rootProject.subprojects {
        if (project.path.startsWith(":impls:") && project.path.count { it == ':' } == 3) {
            implementation(project)
            println("Depend Implementation ${project.path}")
        }
    }
}

tasks.build {
    dependsOn(tasks.shadowJar)
}

private fun println(message: String) = kotlin.io.println("[dist] $message")