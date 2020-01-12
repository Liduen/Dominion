package android.dominion.data.card.hinterlands

import android.dominion.data.card.CardTemplate
import android.dominion.data.card.KingdomCard
import android.dominion.data.card.type.ActionCard

class Oasis : KingdomCard(), ActionCard {
    override val template: CardTemplate = CardTemplate.OASIS
    override val cost: Int = 3
}