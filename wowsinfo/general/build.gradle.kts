plugins {
    alias(libs.plugins.kotlin.multiplatform)
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
        commonMain.dependencies {  }
        commonTest.dependencies {
            implementation(kotlin("test"))
        }
    }
}
