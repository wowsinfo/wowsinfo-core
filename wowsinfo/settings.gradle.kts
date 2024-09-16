pluginManagement {
    val kotlinVersion: String by settings
    plugins {
        kotlin("multiplatform") version kotlinVersion apply false
        kotlin("plugin.serialization") version kotlinVersion apply false
    }
    repositories {
        mavenCentral()
        gradlePluginPortal()
    }
}

rootProject.name = "wowsinfo"
include(":wikipedia")
include(":language")

val wowsinfoGroup = "io.github.henryquan"
extra["group"] = "io.github.henryquan"
extra["version"] = "1.0"
