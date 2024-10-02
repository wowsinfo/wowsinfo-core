plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.kotlinx.serialization)
}

kotlin {
    // experiment with JavaScript first
    js {
        moduleName = "wowsinfo-service"
        binaries.executable()
        generateTypeScriptDefinitions()
        nodejs()
    }    
    // jvm {
    //     withJava()
    //     testRuns.named("test") {
    //         executionTask.configure {
    //             useJUnitPlatform()
    //         }
    //     }
    // }
    // iosX64()
    // iosArm64()
    // iosSimulatorArm64()

    sourceSets {
        commonMain.dependencies {
            implementation(libs.ktor.client.core)
            implementation(libs.ktor.client.content.negotiation)
            implementation(libs.ktor.client.serialization)

            implementation(libs.kotlinx.serialization.json)
            implementation(libs.kotlinx.coroutines.core)
        }
        commonTest.dependencies {
            implementation(kotlin("test"))
        }
        jsMain.dependencies {
            implementation(libs.ktor.client.js)
        }

        all {
            languageSettings {
                optIn("kotlin.js.ExperimentalJsExport")
            }
        }
    }
}
