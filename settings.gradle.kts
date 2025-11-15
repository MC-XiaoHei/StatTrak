rootProject.name = "StatTrak"

println("Scanning project structure...")

include("api", "dist")
println("Found static modules :api, :dist")

val adaptersDir = rootDir.resolve("adapters")
if (adaptersDir.exists() && adaptersDir.isDirectory) {
    adaptersDir.listFiles { file -> file.isDirectory }?.forEach { loaderDir ->
        if (!loaderDir.resolve("build.gradle.kts").exists()) return@forEach
        val projectPath = ":adapters:${loaderDir.name}"
        include(projectPath)
        println("Found Adapter $projectPath")
    }
}

val libsDir = rootDir.resolve("libs")
if (libsDir.exists() && libsDir.isDirectory) {
    libsDir.listFiles { file -> file.isDirectory }?.forEach { platformDir ->
        platformDir.listFiles { file -> file.isDirectory }?.forEach { libDir ->
            if (!libDir.resolve("build.gradle.kts").exists()) return@forEach
            val projectPath = ":libs:${platformDir.name}:${libDir.name}"
            include(projectPath)
            println("Found Lib $projectPath")
        }
    }
}

val implementationsDir = rootDir.resolve("impls")
if (implementationsDir.exists() && implementationsDir.isDirectory) {
    implementationsDir.listFiles { file -> file.isDirectory }?.forEach { platformDir ->
        platformDir.listFiles { file -> file.isDirectory }?.forEach { versionDir ->
            if (!versionDir.resolve("build.gradle.kts").exists()) return@forEach
            val projectPath = ":impls:${platformDir.name}:${versionDir.name}"
            include(projectPath)
            println("Found Implementation $projectPath")
        }
    }
}

println("Project structure scan complete.")

pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
        maven("https://maven.neoforged.net/releases")
        maven("https://repo.papermc.io/repository/maven-public/")
        maven("https://maven.fabricmc.net/")
        maven("https://maven.minecraftforge.net/")
    }
}

private fun println(message: String) = kotlin.io.println("[root] $message")