package android.dominion.data.card

enum class Deck(val kingdomCards: List<CardTemplate> = listOf(),
                val supplyCards: List<CardTemplate> = listOf()) {
    BASIC(supplyCards = listOf(
            CardTemplate.COPPER,
            CardTemplate.SILVER,
            CardTemplate.GOLD,
            CardTemplate.CURSE,
            CardTemplate.ESTATE,
            CardTemplate.DUCHY,
            CardTemplate.PROVINCE)),
    DOMINION(kingdomCards = listOf(CardTemplate.CELLAR,
            CardTemplate.CHAPEL,
            CardTemplate.MOAT,
            CardTemplate.HARBINGER,
            CardTemplate.MERCHANT,
            CardTemplate.VASSAL,
            CardTemplate.VILLAGE,
            CardTemplate.WORKSHOP,
            CardTemplate.BUREAUCRAT,
            CardTemplate.GARDENS,
            CardTemplate.MILITIA,
            CardTemplate.MONEYLENDER,
            CardTemplate.POACHER,
            CardTemplate.REMODEL,
            CardTemplate.SMITHY,
            CardTemplate.THRONE_ROOM)),
    HINTERLANDS,
    PROSPERITY(supplyCards = listOf(CardTemplate.PLATINUM))
}