package android.dominion.data.card

import android.dominion.data.card.base.*
import android.dominion.data.card.dominion.*
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

            CardTemplate.CELLAR -> Cellar()
            CardTemplate.CHAPEL -> Chapel()
            CardTemplate.MOAT -> Moat()
            CardTemplate.HARBINGER -> Harbinger()
            CardTemplate.MERCHANT -> Merchant()
            CardTemplate.VASSAL -> Vassal()
            CardTemplate.VILLAGE -> Village()
            CardTemplate.WORKSHOP -> Workshop()
            CardTemplate.BUREAUCRAT -> Bureaucrat()
            CardTemplate.GARDENS -> Gardens()
            CardTemplate.MILITIA -> Militia()
            CardTemplate.MONEYLENDER -> Moneylender()
            CardTemplate.POACHER -> Poacher()
            CardTemplate.REMODEL -> Remodel()
            CardTemplate.SMITHY -> Smithy()
            CardTemplate.THRONE_ROOM -> ThroneRoom()

            CardTemplate.OASIS -> Oasis()

            CardTemplate.PLATINUM -> Platinum()
            else -> throw IllegalArgumentException("Card type - $cardTemplate failed to initialize.")
        }
    }

    fun getCardPile(cardTemplate: CardTemplate, count: Int): List<BaseCard> {
        return List(count) {
            getCard(cardTemplate)
        }
    }
}