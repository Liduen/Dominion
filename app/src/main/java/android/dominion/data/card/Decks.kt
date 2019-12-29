package android.dominion.data.card

enum class Decks(supplyCards: List<SupplyCard> = listOf(),
                 kingdomCards: List<KingdomCard> = listOf()) {
    BASE,
    HINTERLANDS
}