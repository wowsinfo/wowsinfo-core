plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.kotlinx.serialization)
}

kotlin {
    js {
        moduleName = "wowsinfo-core"
        binaries.executable()
        generateTypeScriptDefinitions()
        nodejs()
        useEsModules()
    }
    jvm {
        withJava()
        testRuns.named("test") {
            executionTask.configure {
                useJUnitPlatform()
            }
        }
    }
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    sourceSets {
        commonMain.dependencies {}
        jsMain.dependencies {}
    }
}
