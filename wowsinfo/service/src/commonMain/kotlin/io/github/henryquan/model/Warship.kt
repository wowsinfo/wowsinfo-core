package io.github.henryquan.model


import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

typealias PlayerWarshipStatsListMap = Map<String, List<PlayerWarshipStats>?>

@Serializable
data class PlayerWarshipStats(
    @SerialName("account_id") val accountId: Int,
    val battles: Int,
    val distance: Int, // Assuming miles as a double for precision
    @SerialName("last_battle_time") val lastBattleTime: Long,
    @SerialName("ship_id") val shipId: Int,
    @SerialName("updated_at") val updatedAt: Long,
    val pvp: GeneralWarshipStats?,
    val club: GeneralWarshipStats?,
    @SerialName("oper_div") val operDiv: GeneralWarshipStats?,
    @SerialName("oper_div_hard") val operDivHard: GeneralWarshipStats?,
    @SerialName("oper_solo") val operSolo: GeneralWarshipStats?,
    val pve: GeneralWarshipStats?,
    @SerialName("pve_div2") val pveDiv2: GeneralWarshipStats?,
    @SerialName("pve_div3") val pveDiv3: GeneralWarshipStats?,
    @SerialName("pve_solo") val pveSolo: GeneralWarshipStats?,
    @SerialName("pvp_div2") val pvpDiv2: GeneralWarshipStats?,
    @SerialName("pvp_div3") val pvpDiv3: GeneralWarshipStats?,
    @SerialName("pvp_solo") val pvpSolo: GeneralWarshipStats?,
    @SerialName("rank_div2") val rankDiv2: GeneralWarshipStats?,
    @SerialName("rank_div3") val rankDiv3: GeneralWarshipStats?,
    @SerialName("rank_solo") val rankSolo: GeneralWarshipStats?
)

@Serializable
data class GeneralWarshipStats(
    @SerialName("art_agro") val artAgro: Int,
    val battles: Int,
    @SerialName("battles_since_510") val battlesSince510: Int,
    @SerialName("battles_since_512") val battlesSince512: Int,
    @SerialName("capture_points") val capturePoints: Int,
    @SerialName("damage_dealt") val damageDealt: Int,
    @SerialName("damage_scouting") val damageScouting: Int,
    @SerialName("damage_to_buildings") val damageToBuildings: Int,
    val draws: Int,
    @SerialName("dropped_capture_points") val droppedCapturePoints: Int,
    val frags: Int,
    val losses: Int,
    @SerialName("max_damage_dealt") val maxDamageDealt: Int,
    @SerialName("max_damage_dealt_to_buildings") val maxDamageDealtToBuildings: Int,
    @SerialName("max_damage_scouting") val maxDamageScouting: Int,
    @SerialName("max_frags_battle") val maxFragsBattle: Int,
    @SerialName("max_planes_killed") val maxPlanesKilled: Int,
    @SerialName("max_ships_spotted") val maxShipsSpotted: Int,
    @SerialName("max_suppressions_count") val maxSuppressionsCount: Int,
    @SerialName("max_total_agro") val maxTotalAgro: Int,
    @SerialName("max_xp") val maxXp: Int,
    @SerialName("planes_killed") val planesKilled: Int,
    @SerialName("ships_spotted") val shipsSpotted: Int,
    @SerialName("suppressions_count") val suppressionsCount: Int,
    @SerialName("survived_battles") val survivedBattles: Int,
    @SerialName("survived_wins") val survivedWins: Int,
    @SerialName("team_capture_points") val teamCapturePoints: Int,
    @SerialName("team_dropped_capture_points") val teamDroppedCapturePoints: Int,
    @SerialName("torpedo_agro") val torpedoAgro: Int,
    val wins: Int,
    val xp: Int,
    val aircraft: WarshipAircraftStats?,
    @SerialName("main_battery") val mainBattery: WarshipMainBatteryStats?,
    val ramming: WarshipRammingStats?,
    @SerialName("second_battery") val secondBattery: WarshipSecondBatteryStats?,
    val torpedoes: WarshipTorpedoesStats?
)

@Serializable
data class WarshipAircraftStats(
    val frags: Int,
    @SerialName("max_frags_battle") val maxFragsBattle: Int
)

@Serializable
data class WarshipMainBatteryStats(
    val frags: Int,
    val hits: Int,
    @SerialName("max_frags_battle") val maxFragsBattle: Int,
    val shots: Int
)

@Serializable
data class WarshipRammingStats(
    val frags: Int,
    @SerialName("max_frags_battle") val maxFragsBattle: Int
)

@Serializable
data class WarshipSecondBatteryStats(
    val frags: Int,
    val hits: Int,
    @SerialName("max_frags_battle") val maxFragsBattle: Int,
    val shots: Int
)

@Serializable
data class WarshipTorpedoesStats(
    val frags: Int,
    val hits: Int,
    @SerialName("max_frags_battle") val maxFragsBattle: Int,
    val shots: Int
)
