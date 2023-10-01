package io.github.henryquan.wikipedia.model.gamedata

import kotlinx.serialization.Serializable

@Serializable
data class GameAbility(
    val nation: String,
    val name: String,
    val id: Long,
    val description: String,
    val icon: String,
    val alter: Map<String, AbilityAlter>,
    val filter: String,
    val type: String,
    val abilities: Map<String, GameModifier>?,
)

/**
 * The alternative icon for the ability (consumable)
 */
@Serializable
data class AbilityAlter(
    val name: String,
    val description: String,
)
