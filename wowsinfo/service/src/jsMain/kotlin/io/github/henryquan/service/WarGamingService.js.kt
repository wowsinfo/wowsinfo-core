package io.github.henryquan.service

import io.github.henryquan.model.WarGamingLanguage
import io.github.henryquan.model.WarGamingRegion
import promiseScope

@JsExport
class WarGamingServiceJs(
    region: WarGamingRegion, language: WarGamingLanguage, key: String
) : WarGamingService(region, language, key) {

    fun getPlayerListJs(query: String) = promiseScope {
        getPlayerList(query)
    }
}