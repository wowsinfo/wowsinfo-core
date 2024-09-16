package io.github.henryquan.language.model

typealias GameLanguage = Map<String, String>

enum class SupportedLanguage(val code: String) {
    ENGLISH("en"),
    JAPANESE("ja"),
    CHINESE_SIMPLIFIED("zh_sg"),
    CHINESE_TRADITIONAL("zh_tw"),
}
