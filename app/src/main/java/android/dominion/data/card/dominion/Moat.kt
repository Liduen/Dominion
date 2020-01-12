package android.dominion.data.card.dominion

import android.dominion.data.card.CardTemplate
import android.dominion.data.card.KingdomCard
import android.dominion.data.card.type.ActionCard
import android.dominion.data.card.type.ReactionCard

class Moat : KingdomCard(), ActionCard, ReactionCard {
    override val template: CardTemplate = CardTemplate.MOAT
    override val cost: Int = 2
}