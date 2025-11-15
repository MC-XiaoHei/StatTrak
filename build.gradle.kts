plugins {
    `java-base`
}

allprojects {
    group = "cn.xor7.xiaohei"
    version = "1.0-SNAPSHOT"

    repositories {
        mavenCentral()
        maven("https://repo.papermc.io/repository/maven-public/")
        maven("https://maven.fabricmc.net/")
        maven("https://maven.neoforged.net/releases")
        maven("https://maven.minecraftforge.net/")
    }
}

subprojects {
    apply(plugin = "java-library")

    java {
        toolchain.languageVersion = JavaLanguageVersion.of(8)
        withSourcesJar()
    }

    tasks.withType<JavaCompile> {
        options.encoding = "UTF-8"
    }

    if (project.path.startsWith(":impls:")) afterEvaluate {
        dependencies {
            "annotationProcessor"("com.google.auto.service:auto-service:1.1.1")
            "compileOnly"("com.google.auto.service:auto-service-annotations:1.1.1")
        }
    }
}