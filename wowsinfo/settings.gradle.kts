rootProject.name = "wowsinfo-core"

pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

include(":wikipedia")
include(":language")
include(":general")
include(":service")

val wowsinfoGroup = "io.github.henryquan"
extra["group"] = "io.github.henryquan"
extra["version"] = "1.0"
