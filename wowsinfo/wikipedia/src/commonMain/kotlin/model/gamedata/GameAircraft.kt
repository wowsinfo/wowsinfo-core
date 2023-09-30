package model.gamedata

import kotlinx.serialization.Serializable

@Serializable
data class GameAircraft(
    val type: String,
    val nation: String,
    val name: String,
    val health: Float?,
    val totalPlanes: Int?,
    val visibility: Float?,
    val speed: Float?,
    val aircraft: AircraftInfo?,
)

@Serializable
data class AircraftInfo(
    val restoreTime: Float,
    val maxAircraft: Int,
    val attacker: Int,
    val attackCount: Int,
    val cooldown: Float,
    val minSpeed: Float,
    val maxSpeed: Float,
    val boostTime: Float,
    val boostReload: Float?,
    val bombName: String,
    val consumables: List<List<GameConsumable>>?,
)
