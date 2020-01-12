package android.dominion.data.card.base

import android.dominion.data.card.CardTemplate
import android.dominion.data.card.SupplyCard

class Curse : SupplyCard() {
    override val template: CardTemplate = CardTemplate.CURSE
    override val cost: Int = 0
}