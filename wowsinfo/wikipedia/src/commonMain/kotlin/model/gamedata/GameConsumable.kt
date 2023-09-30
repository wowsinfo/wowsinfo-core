package model.gamedata

import kotlinx.serialization.Serializable

@Serializable
data class GameConsumable(
    val name: String,
    val type: String,
)
