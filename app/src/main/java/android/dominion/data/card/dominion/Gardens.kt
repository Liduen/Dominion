package android.dominion.data.card.dominion

import android.dominion.data.card.CardTemplate
import android.dominion.data.card.KingdomCard
import android.dominion.data.card.type.VictoryCard

class Gardens : KingdomCard(), VictoryCard {
    override val template: CardTemplate = CardTemplate.GARDENS
    override val cost: Int = 4
}