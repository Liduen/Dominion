package android.dominion.data.card

import android.dominion.data.card.base.Copper
import android.dominion.data.card.base.Gold
import android.dominion.data.card.base.Silver

object CardFactory {
    fun getCard(cardTemplate: CardTemplate): BaseCard {
        return when (cardTemplate) {
            CardTemplate.COPPER -> Copper()
            CardTemplate.SILVER -> Silver()
            CardTemplate.GOLD -> Gold()
            else -> throw IllegalArgumentException()
        }
    }

    fun getCardPile(cardTemplate: CardTemplate, count: Int): List<BaseCard> {
        return List(count) {
            getCard(cardTemplate)
        }
    }
}