package android.dominion.data.card.dominion

import android.dominion.data.card.CardTemplate
import android.dominion.data.card.KingdomCard
import android.dominion.data.card.type.ActionCard
import android.dominion.data.card.type.ReactionCard

class Harbinger : KingdomCard(), ActionCard {
    override val template: CardTemplate = CardTemplate.HARBINGER
    override val cost: Int = 3
}