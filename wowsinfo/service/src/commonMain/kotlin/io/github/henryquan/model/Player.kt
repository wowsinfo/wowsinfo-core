package io.github.henryquan.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// WarGaming usually returns a map because you can query multiple players at once
typealias PlayerList = List<Player>
typealias PlayerPersonalDataMap = Map<String, PlayerPersonalData>
typealias PlayerAchievementsMap = Map<String, PlayerAchievements>


//region Player

@JsExport
@Serializable
data class Player(
    @SerialName("account_id") val accountId: String,  // numeric field for account ID, need to be string to avoid overflow
    val nickname: String   // string field for player name
)

//endregion

//region PlayerPersonalData

@JsExport
@Serializable
data class PlayerPersonalData(
    @SerialName("last_battle_time") val lastBattleTime: Long,
    @SerialName("account_id") val accountId: Long,
    @SerialName("leveling_tier") val levelingTier: Int,
    @SerialName("created_at") val createdAt: Long,
    @SerialName("leveling_points") val levelingPoints: Int,
    @SerialName("updated_at") val updatedAt: Long,
    // val private: Any?, // null is represented by Any? in Kotlin
    @SerialName("hidden_profile") val hiddenProfile: Boolean,
    @SerialName("logout_at") val logoutAt: Long,
    // val karma: Any?, // null is represented by Any? in Kotlin
    @SerialName("statistics") val statistics: PlayerStatistics,
    val nickname: String,
    @SerialName("stats_updated_at") val statsUpdatedAt: Long
)

@JsExport
@Serializable
data class PlayerStatistics(
    val distance: Int,
    val battles: Int,
    val pvp: GeneralBattleStats?,
    val club: GeneralBattleStats?,
    @SerialName("oper_div") val operationDiv: GeneralBattleStats?,
    @SerialName("oper_div_hard") val operationDivHard: GeneralBattleStats?,
    @SerialName("oper_solo") val operationSolo: GeneralBattleStats?,
    val pve: GeneralBattleStats?,
    @SerialName("pve_div2") val pveDiv2: GeneralBattleStats?,
    @SerialName("pve_div3") val pveDiv3: GeneralBattleStats?,
    @SerialName("pve_solo") val pveSolo: GeneralBattleStats?,
    @SerialName("pvp_div2") val pvpDiv2: GeneralBattleStats?,
    @SerialName("pvp_div3") val pvpDiv3: GeneralBattleStats?,
    @SerialName("pvp_solo") val pvpSolo: GeneralBattleStats?,
    @SerialName("rank_div2") val rankDiv2: GeneralBattleStats?,
    @SerialName("rank_div3") val rankDiv3: GeneralBattleStats?,
    @SerialName("rank_solo") val rankSolo: GeneralBattleStats?
)

/**
 * General PvP stats for a player including most of the stats.
 * This data model is shared with all types of battles, rank, pve, operation, pvp, clan, etc.
 */
@JsExport
@Serializable
data class GeneralBattleStats(
    @SerialName("max_xp") val maxXP: Int,
    @SerialName("damage_to_buildings") val damageToBuildings: Int,
    @SerialName("main_battery") val mainBatteryStats: MainBatteryStats,
    @SerialName("max_ships_spotted_ship_id") val maxShipsSpottedShipId: Long,
    @SerialName("max_damage_scouting") val maxDamageScouting: Int,
    @SerialName("art_agro") val artAgro: Long,
    @SerialName("max_xp_ship_id") val maxXPShipId: Long,
    @SerialName("ships_spotted") val shipsSpotted: Int,
    @SerialName("second_battery") val secondBattery: SecondBatteryStats,
    @SerialName("max_frags_ship_id") val maxFragsShipId: Long,
    val xp: Int,
    @SerialName("survived_battles") val survivedBattles: Int,
    @SerialName("dropped_capture_points") val droppedCapturePoints: Int,
    @SerialName("max_damage_dealt_to_buildings") val maxDamageDealtToBuildings: Int,
    @SerialName("torpedo_agro") val torpedoAgro: Long,
    val draws: Int,
    @SerialName("control_captured_points") val controlCapturedPoints: Int,
    @SerialName("battles_since_510") val battlesSince510: Int,
    @SerialName("max_total_agro_ship_id") val maxTotalAgroShipId: Long,
    @SerialName("planes_killed") val planesKilled: Int,
    val battles: Int,
    @SerialName("max_ships_spotted") val maxShipsSpotted: Int,
    @SerialName("max_suppressions_ship_id") val maxSuppressionsShipId: Long,
    @SerialName("survived_wins") val survivedWins: Int,
    val frags: Int,
    @SerialName("damage_scouting") val damageScouting: Int,
    @SerialName("max_total_agro") val maxTotalAgro: Int,
    @SerialName("max_frags_battle") val maxFragsBattle: Int,
    @SerialName("capture_points") val capturePoints: Int,
    val ramming: RammingStats,
    @SerialName("suppressions_count") val suppressionsCount: Int,
    @SerialName("max_suppressions_count") val maxSuppressionsCount: Int,
    val torpedoes: TorpedoesStats,
    val aircraft: AircraftStats,
    @SerialName("team_capture_points") val teamCapturePoints: Int,
    @SerialName("control_dropped_points") val controlDroppedPoints: Int,
    @SerialName("max_damage_dealt") val maxDamageDealt: Int,
    @SerialName("max_damage_dealt_to_buildings_ship_id") val maxDamageDealtToBuildingsShipId: Long,
    @SerialName("max_damage_dealt_ship_id") val maxDamageDealtShipId: Long,
    val wins: Int,
    val losses: Int,
    val damageDealt: Int,
    @SerialName("max_planes_killed") val maxPlanesKilled: Int,
    @SerialName("max_scouting_damage_ship_id") val maxScoutingDamageShipId: Long,
    @SerialName("team_dropped_capture_points") val teamDroppedCapturePoints: Int,
    @SerialName("battles_since_512") val battlesSince512: Int
)

@JsExport
@Serializable
data class MainBatteryStats(
    @SerialName("max_frags_battle") val maxFragsBattle: Int,
    val frags: Int,
    val hits: Int,
    @SerialName("max_frags_ship_id") val maxFragsShipId: Long,
    val shots: Int
)

@JsExport
@Serializable
data class SecondBatteryStats(
    @SerialName("max_frags_battle") val maxFragsBattle: Int,
    val frags: Int,
    val hits: Int,
    @SerialName("max_frags_ship_id") val maxFragsShipId: Long,
    val shots: Int
)

@JsExport
@Serializable
data class RammingStats(
    @SerialName("max_frags_battle") val maxFragsBattle: Int,
    val frags: Int,
    @SerialName("max_frags_ship_id") val maxFragsShipId: Long
)

@JsExport
@Serializable
data class TorpedoesStats(
    @SerialName("max_frags_battle") val maxFragsBattle: Int,
    val frags: Int,
    val hits: Int,
    @SerialName("max_frags_ship_id") val maxFragsShipId: Long,
    val shots: Int
)

@JsExport
@Serializable
data class AircraftStats(
    @SerialName("max_frags_battle") val maxFragsBattle: Int,
    val frags: Int,
    @SerialName("max_frags_ship_id") val maxFragsShipId: Long
)

//endregion

//region Player's achievements

@JsExport
@Serializable
data class PlayerAchievements(
    val battle: Map<String, Int>,
    val progress: Map<String, Int>
)

//endregion
