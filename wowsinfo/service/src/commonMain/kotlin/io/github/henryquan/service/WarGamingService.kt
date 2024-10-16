package io.github.henryquan.service

import BaseService
import io.github.henryquan.model.ClanBattleSeasonStatsMap
import io.github.henryquan.model.ClanDetailMap
import io.github.henryquan.model.ClanList
import io.github.henryquan.model.ClanPlayerDataMap
import io.github.henryquan.model.PlayerAchievementsMap
import io.github.henryquan.model.PlayerList
import io.github.henryquan.model.PlayerPersonalDataMap
import io.github.henryquan.model.PlayerWarshipStatsListMap
import io.github.henryquan.model.WarGamingLanguage
import io.github.henryquan.model.WarGamingRegion
import io.github.henryquan.model.WarGamingResponse
import io.github.henryquan.model.WarGamingShipStatsType
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
     * Prepare common parameters for WarGaming API requests,
     * such as the application ID and language.
     * @param params The parameters to prepare.
     * @return The parameters with the application ID and language added.
     */
    private fun prepareParams(params: Map<String, String>): Map<String, String> {
        return params + mapOf("application_id" to key, "language" to language.code)
    }

    //region Player

    /**
     * Get a list of players based on a query.
     * @param query The search query, usually a player name.
     */
    suspend fun getPlayerList(query: String): WarGamingResponse<PlayerList> {
        return getObject("/account/list/", prepareParams(mapOf("search" to query)))
    }

    /**
     * Get personal data for a list of players.
     * @param accountIds A list of account IDs.
     * @param extras An array of extra stats data to include in the response.
     */
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

    /**
     * Get achievements for a list of players.
     * @param accountIds A list of account IDs.
     */
    suspend fun getPlayerAchievements(accountIds: List<String>): WarGamingResponse<PlayerAchievementsMap> {
        return getObject(
            "/account/achievements/", prepareParams(
                mapOf("account_id" to accountIds.joinToString(","))
            )
        )
    }

    //endregion

    //region Warships

    /**
     * Get detailed stats for a list of warships for a single player.
     * @param accountId The account ID of the player.
     * @param shipIds A list of ship IDs, optional.
     */
    suspend fun getPlayerWarshipStatsList(
        accountId: String,
        extras: Array<WarGamingShipStatsType> = WarGamingShipStatsType.pvpTypes,
        shipIds: List<String> = emptyList(),
    ): WarGamingResponse<PlayerWarshipStatsListMap> {
        return getObject(
            "/ships/stats/", prepareParams(
                mapOf(
                    "account_id" to accountId,
                    "extra" to extras.joinToString(","),
                    "ship_id" to shipIds.joinToString(",")
                ),
            )
        )
    }

    //endregion

    //region Clan

    /**
     * Get a list of clans based on a query.
     * @param query The search query, usually the clan tag.
     */
    suspend fun getClanList(query: String): WarGamingResponse<ClanList> {
        return getObject("/clans/list/", prepareParams(mapOf("search" to query)))
    }

    /**
     * Get detailed information for a list of clans.
     * @param clanIds A list of clan IDs.
     * @param includeMembers Whether to include member data in the response.
     */
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

    /**
     * Get player data for a list of clans.
     * @param accountIds A list of account IDs.
     * @param includeClanData Whether to include player's clan data.
     */
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

    /**
     * Get clan battle season stats for a single player.
     * @param accountId The account ID of the player.
     */
    suspend fun getClanBattleSeasonStats(
        accountId: String,
    ): WarGamingResponse<ClanBattleSeasonStatsMap> {
        return getObject(
            "/clans/seasonstats/", prepareParams(mapOf("account_id" to accountId))
        )
    }

    //endregion
}
