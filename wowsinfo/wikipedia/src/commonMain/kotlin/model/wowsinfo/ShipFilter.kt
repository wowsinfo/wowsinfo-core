package model.wowsinfo

interface ShipFilterable {
    val name: String
    val tier: Int
    val region: String
    val type: String
}

class ShipFilter(
    private val name: String,
    private val tiers: List<Int>,
    private val regions: List<String>,
    private val types: List<String>,
) {
    val isEmpty: Boolean
        get() = name.isBlank() && tiers.isEmpty() && regions.isEmpty() && types.isEmpty()

    fun shouldDisplay(ship: ShipFilterable, shipName: String): Boolean {
        return name.isBlank() ||
                (name.lowercase() in ship.name.lowercase()) &&
                (tiers.isEmpty() || ship.tier in tiers) &&
                (regions.isEmpty() || ship.region in regions) &&
                (types.isEmpty() || ship.type in types)
    }
}
