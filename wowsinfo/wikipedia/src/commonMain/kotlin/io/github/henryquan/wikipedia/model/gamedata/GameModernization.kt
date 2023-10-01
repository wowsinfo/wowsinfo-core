package io.github.henryquan.wikipedia.model.gamedata

import kotlinx.serialization.Serializable

@Serializable
data class GameModernization(
    val slot: Int,
    val id: Int,
    val costCR: Int,
    val name: String,
    val icon: String,
    val description: String,
    val level: List<Int>?,
    val type: List<String>?,
    val nation: List<String>?,
    val modifiers: GameModifier,
    val ships: List<Int>?,
    val excludes: List<Int>?,
    val special: Boolean?,
    val unique: Boolean?,
)
