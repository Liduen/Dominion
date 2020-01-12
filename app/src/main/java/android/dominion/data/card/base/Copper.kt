package android.dominion.data.card.base

import android.dominion.data.card.CardTemplate
import android.dominion.data.card.SupplyCard

class Copper : SupplyCard() {
    override val template: CardTemplate = CardTemplate.COPPER
    override val cost: Int = 0
}