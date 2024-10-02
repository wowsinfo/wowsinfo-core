package io.github.henryquan.service

import BaseService
import io.github.henryquan.model.WarGamingResponse
import io.ktor.client.call.body
import io.ktor.client.call.receive
import io.ktor.client.statement.HttpResponse

@JsExport
enum class WarGamingRegion(val region: String) {
    NA("com"), EU("eu"), ASIA("asia")
}

@JsExport
enum class WarGamingLanguage(val code: String, val displayName: String) {
    CS("cs", "Czech"),
    DE("de", "German"),
    EN("en", "English"),
    ES("es", "Spanish"),
    FR("fr", "French"),
    JA("ja", "Japanese"),
    PL("pl", "Polish"),
    RU("ru", "Russian"),
    TH("th", "Thai"),
    ZH_HANT("zh-tw", "Traditional Chinese"),
    TR("tr", "Turkish"),
    ZH_HANS("zh-cn", "Simplified Chinese"),
    PT_BR("pt-br", "Portuguese (Brazil)"),
    ES_MX("es-mx", "Spanish (Mexico)")
}

open class WarGamingService(
    region: WarGamingRegion,
    private val language: WarGamingLanguage,
    private val key: String
) : BaseService() {
    override val baseUrl: String = "https://api.worldofwarships.${region.region}/wows/"

    /**
     * Prepare common parameters for WarGaming API requests.
      */
    private fun prepareParams(params: Map<String, String>): Map<String, String> {
        return params + mapOf("application_id" to key, "language" to language.code)
    }

    suspend fun getPlayerList(query: String): WarGamingResponse<List<String>> {
        return getObject("account/list/", prepareParams(mapOf("search" to query)))
    }
}
