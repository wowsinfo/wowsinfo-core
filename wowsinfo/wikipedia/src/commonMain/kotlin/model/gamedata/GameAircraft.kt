package model.gamedata

import kotlinx.serialization.Serializable

@Serializable
data class GameAircraft(
    val type: String,
    val nation: String,
    val name: String,
    val health: Double?,
    val totalPlanes: Int?,
    val visibility: Double?,
    val speed: Double?,
    val aircraft: AircraftInfo?,
)

@Serializable
data class AircraftInfo(
    val restoreTime: Double,
    val maxAircraft: Int,
    val attacker: Int,
    val attackCount: Int,
    val cooldown: Double,
    val minSpeed: Double,
    val maxSpeed: Double,
    val boostTime: Double,
    val boostReload: Double?,
    val bombName: String,
    val consumables: List<List<GameConsumable>>?,
)
