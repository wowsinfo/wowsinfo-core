plugins {
    kotlin("multiplatform")
}

kotlin {
    jvm {
        // jvmToolchain(8)
        withJava()
        testRuns.named("test") {
            executionTask.configure {
                useJUnitPlatform()
            }
        }
    }
    js(IR) {
        moduleName = "wowsinfo-general"
        binaries.executable()
        generateTypeScriptDefinitions()
        nodejs()
    }
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    sourceSets {
        val commonMain by getting {
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
    }
}
