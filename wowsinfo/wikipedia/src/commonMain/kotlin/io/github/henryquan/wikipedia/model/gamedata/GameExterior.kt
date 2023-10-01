package io.github.henryquan.wikipedia.model.gamedata

import kotlinx.serialization.Serializable

@Serializable
data class GameExterior(
    val id: Int,
    val name: String,
    val icon: String,
    val description: String?,
    val costGold: Int?,
    val costCR: Int?,
    val modifiers: GameModifier?,
    val type: String,
)
