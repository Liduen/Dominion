package android.dominion.data.card

import android.dominion.data.card.dominion.Village

enum class Deck(kingdomCards: List<CardTemplate> = listOf(),
                supplyCards: List<CardTemplate> = listOf()) {
    DOMINION(kingdomCards = listOf()),
    HINTERLANDS,
    PROSPERITY
}