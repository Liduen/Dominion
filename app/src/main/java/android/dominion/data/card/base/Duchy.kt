package android.dominion.data.card.base

import android.dominion.data.card.CardTemplate
import android.dominion.data.card.SupplyCard

class Duchy : SupplyCard() {
    override val template: CardTemplate = CardTemplate.DUCHY
    override val cost: Int = 5
}