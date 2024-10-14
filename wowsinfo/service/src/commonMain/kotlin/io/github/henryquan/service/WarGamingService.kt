package io.github.henryquan.service

import BaseService
import io.github.henryquan.model.ClanBattleSeasonStatsMap
import io.github.henryquan.model.ClanDetailMap
import io.github.henryquan.model.ClanList
import io.github.henryquan.model.ClanPlayerDataMap
import io.github.henryquan.model.PlayerAchievementsMap
import io.github.henryquan.model.PlayerList
import io.github.henryquan.model.PlayerPersonalDataMap
import io.github.henryquan.model.WarGamingLanguage
import io.github.henryquan.model.WarGamingRegion
import io.github.henryquan.model.WarGamingResponse
import io.github.henryquan.model.WarGamingStatsType


open class WarGamingService(
    region: WarGamingRegion,
    private val language: WarGamingLanguage,
    private val key: String
) : BaseService() {
    override val baseUrl: String = "https://api.worldofwarships.${region.region}/wows"

    /**
     * WarGaming is returning a Text/HTML response instead of JSON.
     * This introduces an exception, NoTransformationFoundException
     * See https://stackoverflow.com/q/65105118
     */
//    override val client = HttpClient(getEngineFactory()) {
//        install(ContentNegotiation) {
//            register(
//                ContentType.Any, KotlinxSerializationConverter(
//                    Json {
//                        isLenient = true
//                        ignoreUnknownKeys = true
//                    }
//                )
//            )
//        }
//    }

    /**
     * Prepare common parameters for WarGaming API requests.
     */
    private fun prepareParams(params: Map<String, String>): Map<String, String> {
        return params + mapOf("application_id" to key, "language" to language.code)
    }

    //region Player

    suspend fun getPlayerList(query: String): WarGamingResponse<PlayerList> {
        return getObject("/account/list/", prepareParams(mapOf("search" to query)))
    }

    suspend fun getPlayerPersonalData(
        accountIds: List<String>,
        extras: Array<WarGamingStatsType> = WarGamingStatsType.pvpStatsType
    ): WarGamingResponse<PlayerPersonalDataMap> {
        return getObject(
            "/account/info/", prepareParams(
                mapOf(
                    "account_id" to accountIds.joinToString(","),
                    "extra" to extras.joinToString(",")
                )
            )
        )
    }

    suspend fun getPlayerAchievements(accountIds: List<String>): WarGamingResponse<PlayerAchievementsMap> {
        return getObject(
            "/account/achievements/", prepareParams(
                mapOf("account_id" to accountIds.joinToString(","))
            )
        )
    }

    //endregion

    //region Clan

    suspend fun getClanList(query: String): WarGamingResponse<ClanList> {
        return getObject("/clans/list/", prepareParams(mapOf("search" to query)))
    }

    suspend fun getClanDetails(
        clanIds: List<String>,
        includeMembers: Boolean = true
    ): WarGamingResponse<ClanDetailMap> {
        return getObject(
            "/clans/info/", prepareParams(
                mapOf(
                    "clan_id" to clanIds.joinToString(","),
                    if (includeMembers) "extra" to "members" else "extra" to ""
                )
            )
        )
    }

    suspend fun getClanPlayerData(
        accountIds: List<String>,
        includeClanData: Boolean = true
    ): WarGamingResponse<ClanPlayerDataMap> {
        return getObject(
            "/clans/accountinfo/", prepareParams(
                mapOf(
                    "account_id" to accountIds.joinToString(","),
                    "extra" to if (includeClanData) "clan" else ""
                )
            )
        )
    }

    suspend fun getClanBattleSeasonStats(
        accountId: String,
    ): WarGamingResponse<ClanBattleSeasonStatsMap> {
        return getObject(
            "/clans/seasonstats/", prepareParams(mapOf("account_id" to accountId))
        )
    }

    //endregion
}
