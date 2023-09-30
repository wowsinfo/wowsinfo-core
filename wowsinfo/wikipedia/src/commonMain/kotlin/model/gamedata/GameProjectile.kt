package model.gamedata

import kotlinx.serialization.Serializable

@Serializable
data class GameProjectile(
    val type: String,
    val nation: String,
    val name: String,
    val ammoType: String?,
    val weight: Double?,
    val speed: Double?,
    val damage: Double?,
    val ricochetAngle: Double?,
    val ricochetAlways: Double?,
    val diameter: Double?,
    val ap: ArmorPiecingInfo?,
    val overmatch: Int?,
    val fuseTime: Double?,
    val penHe: Double?,
    val penSAP: Double?,
    val burnChance: Double?,
    val visibility: Double?,
    val range: Double?,
    val floodChance: Double?,
    val alphaDamage: Double?,
    val deepWater: Boolean?,
    val ignoreClasses: List<String>?,
)

@Serializable
data class ArmorPiecingInfo(
    val diameter: Double,
    val weight: Double,
    val drag: Double,
    val velocity: Double,
    val krupp: Double
)