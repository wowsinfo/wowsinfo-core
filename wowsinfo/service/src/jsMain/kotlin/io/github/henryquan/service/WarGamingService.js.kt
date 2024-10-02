package io.github.henryquan.service

import promiseScope

@JsExport
class WarGamingServiceJs(
    region: WarGamingRegion,
    private val language: WarGamingLanguage,
    private val key: String
) : WarGamingService(region, language, key) {

    fun getPlayerListJs(query: String) = promiseScope {
        getPlayerList(query)
    }
}