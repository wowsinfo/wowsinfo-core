package io.github.henryquan.language.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GameLanguage(
    @SerialName("en")
    val english: Map<String, String>,
    @SerialName("ja")
    val japanese: Map<String, String>,
    @SerialName("zh_sg")
    val chinese: Map<String, String>,
    @SerialName("zh_tw")
    val chineseTraditional: Map<String, String>,
)
