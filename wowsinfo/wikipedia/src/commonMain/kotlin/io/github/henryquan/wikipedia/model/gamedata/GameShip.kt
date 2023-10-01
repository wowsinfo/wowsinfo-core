package io.github.henryquan.wikipedia.model.gamedata

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import io.github.henryquan.wikipedia.model.wowsinfo.ShipFilterable

@Serializable
data class GameShip(
    override val name: String,
    val description: String,
    val year: String,
    val paperShip: Boolean,
    val id: Int,
    val index: String,
    override val tier: Int,
    override val region: String,
    override val type: String,
    val regionId: String,
    val typeId: String,
    val group: String,
    val consumables: List<List<GameConsumable>>,
    val costXp: Int,
    val costGold: Int,
    val costCr: Int,
    val nextShips: List<Int>?,
    val modules: Map<String, List<ShipModule>>,
    val components: Map<String, @Contextual Any>,
    val added: Int?,
) : ShipFilterable

@Serializable
data class ShipModule(
    val cost: ShipCost,
    val index: Int,
    val name: String,
    val components: Map<String, List<String>>,
)

@Serializable
data class ShipCost(
    val costCr: Int,
    val costXp: Int,
)

