package android.dominion.data.card.base

import android.dominion.data.card.CardTemplate
import android.dominion.data.card.SupplyCard

class Silver : SupplyCard() {
    override val template: CardTemplate = CardTemplate.SILVER
    override val cost: Int = 3
}