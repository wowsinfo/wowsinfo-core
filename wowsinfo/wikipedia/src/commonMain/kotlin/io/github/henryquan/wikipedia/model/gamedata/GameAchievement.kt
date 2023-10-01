package io.github.henryquan.wikipedia.model.gamedata

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable

@Serializable
data class GameAchievement(
    val icon: String,
    val name: String,
    val description: String,
    val type: List<String>,
    val id: Long,
    val added: Int?, // 1 or null
    val constants: Map<String, Map<String, @Contextual Any>>?,
)
