package io.github.henryquan.model

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

@JsExport
enum class WarGamingStatsType(val type: String) {
    CLAN("statistics.clan"),
    CLUB("statistics.club"),
    OPER_DIV("statistics.oper_div"),
    OPER_DIV_HARD("statistics.oper_div_hard"),
    OPER_SOLO("statistics.oper_solo"),
    PVE("statistics.pve"),
    PVE_DIV2("statistics.pve_div2"),
    PVE_DIV3("statistics.pve_div3"),
    PVE_SOLO("statistics.pve_solo"),
    PVP_DIV2("statistics.pvp_div2"),
    PVP_DIV3("statistics.pvp_div3"),
    PVP_SOLO("statistics.pvp_solo"),
    RANK_DIV2("statistics.rank_div2"),
    RANK_DIV3("statistics.rank_div3"),
    RANK_SOLO("statistics.rank_solo");

    companion object {
        val allStatsType: Array<WarGamingStatsType> = enumValues()
        val pvpStatsType: Array<WarGamingStatsType> = arrayOf(PVP_SOLO, PVP_DIV2, PVP_DIV3)
    }
}
