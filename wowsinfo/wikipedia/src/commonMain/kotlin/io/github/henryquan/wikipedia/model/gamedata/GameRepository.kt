package io.github.henryquan.wikipedia.model.gamedata

import kotlinx.serialization.Serializable

@Serializable
data class GameRepository(
    val ships: Map<String, GameShip>,
    val achievements: Map<String, GameAchievement>,
    val exteriors: Map<String, GameExterior>,
    val modernizations: Map<String, GameModernization>,
    val projectiles: Map<String, GameProjectile>,
    val aircrafts: Map<String, GameAircraft>,
    val abilities: Map<String, GameAbility>,
    val aliases: Map<String, GameAlias>,
    val skills: Map<String, GameSkill>,
    val game: GameInfo,
    val version: String,
    val number: Map<String, WoWsNumber>,
)

@Serializable
data class GameAlias(
    val alias: String,
)

@Serializable
data class GameInfo(
    val regions: List<String>,
    val types: List<String>,
)

@Serializable
data class WoWsNumber(
    val damage: Long,
    val frags: Double,
    val winrate: Double,
    val battles: Long,
)
