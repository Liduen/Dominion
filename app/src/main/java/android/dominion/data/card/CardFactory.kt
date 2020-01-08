package android.dominion.data.card

import android.dominion.data.card.base.*
import android.dominion.data.card.dominion.Village
import android.dominion.data.card.hinterlands.Oasis
import android.dominion.data.card.prosperity.Platinum

object CardFactory {
    fun getCard(cardTemplate: CardTemplate): BaseCard {
        return when (cardTemplate) {
            CardTemplate.COPPER -> Copper()
            CardTemplate.SILVER -> Silver()
            CardTemplate.GOLD -> Gold()
            CardTemplate.ESTATE -> Estate()
            CardTemplate.DUCHY -> Duchy()
            CardTemplate.PROVINCE -> Province()
            CardTemplate.CURSE -> Curse()
            CardTemplate.VILLAGE -> Village()
            CardTemplate.PLATINUM -> Platinum()
            CardTemplate.OASIS -> Oasis()
            else -> throw IllegalArgumentException("Card type - $cardTemplate failed to initialize.")
        }
    }

    fun getCardPile(cardTemplate: CardTemplate, count: Int): List<BaseCard> {
        return List(count) {
            getCard(cardTemplate)
        }
    }
}