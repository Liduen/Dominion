package android.dominion.data.card.dominion

import android.dominion.data.card.CardTemplate
import android.dominion.data.card.KingdomCard
import android.dominion.data.card.type.ActionCard

class Merchant : KingdomCard(), ActionCard {
    override val template: CardTemplate = CardTemplate.MERCHANT
    override val cost: Int = 3
}