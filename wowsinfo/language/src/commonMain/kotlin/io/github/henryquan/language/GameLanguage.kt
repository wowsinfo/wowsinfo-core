package io.github.henryquan.language

import kotlinx.serialization.json.Json

typealias GameLanguageMap = Map<String, Map<String, String>>

enum class SupportedLanguage(val code: String) {
    ENGLISH("en"),
    JAPANESE("ja"),
    CHINESE_SIMPLIFIED("zh_sg"),
    CHINESE_TRADITIONAL("zh_tw"),
}

interface GameLanguageProvider {
    fun provide(): GameLanguage
}

interface ResourceProvider {
    fun provide(): String
}

/**
 * Recommend to have a singleton object to provide the language map.
 */
class GameLanguage private constructor(private val languageMap: GameLanguageMap) {
    companion object {
        /**
         * Create a GameLanguage object from the provider.
         * Ensure to call setLanguage() before using the object.
         */
        fun build(provider: ResourceProvider): GameLanguage {
            val rawMap: GameLanguageMap = Json.decodeFromString(provider.provide())
            return GameLanguage(rawMap)
        }
    }

    private lateinit var languageKey: String
    fun setLanguage(language: SupportedLanguage) {
        this.languageKey = language.code
    }

    fun get(key: String): String {
        return languageMap[languageKey]?.get(key) ?: "MISSING"
    }
}
