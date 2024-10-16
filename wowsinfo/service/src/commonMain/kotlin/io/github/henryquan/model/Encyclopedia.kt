package io.github.henryquan.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

typealias EncyclopediaCollectionMap = Map<String, EncyclopediaCollection>
typealias EncyclopediaCollectionItemMap = Map<String, EncyclopediaCollectionItem>
// The key is just an index number
typealias EncyclopediaMapMap = Map<String, EncyclopediaMap>

@Serializable
data class EncyclopediaCollection(
    val name: String,
    val image: String,
    val tag: String,
    @SerialName("card_cost") val cardCost: Int,
    @SerialName("collection_id") val collectionId: Int,
    val description: String
)

@Serializable
data class EncyclopediaCollectionItem(
    @SerialName("card_id") val cardId: Int,
    @SerialName("collection_id") val collectionId: Int,
    val description: String?,
    val name: String,
    val tag: String,
    val images: EncyclopediaCollectionItemImage
)

@Serializable
data class EncyclopediaCollectionItemImage(
    @SerialName("large") val large: String?,
    @SerialName("medium") val medium: String?,
    @SerialName("small") val small: String?
)

@Serializable
data class EncyclopediaMap(
    @SerialName("battle_arena_id") val battleArenaId: Int,
    val description: String,
    val icon: String,
    val name: String
)
