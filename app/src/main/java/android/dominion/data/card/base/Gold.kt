package android.dominion.data.card.base

import android.dominion.data.card.CardTemplate
import android.dominion.data.card.SupplyCard

class Gold : SupplyCard() {
    override val template: CardTemplate = CardTemplate.GOLD
    override val cost: Int = 6
}