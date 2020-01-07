package android.dominion.data.card

import android.dominion.data.card.base.*
import android.dominion.data.card.dominion.Village

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
            else -> throw IllegalArgumentException("Card type - $cardTemplate failed to initialize.")
        }
    }

    fun getCardPile(cardTemplate: CardTemplate, count: Int): List<BaseCard> {
        return List(count) {
            getCard(cardTemplate)
        }
    }
}