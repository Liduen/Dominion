package android.dominion.data.card.dominion

import android.dominion.data.card.CardTemplate
import android.dominion.data.card.KingdomCard
import android.dominion.data.card.type.ActionCard
import android.dominion.data.card.type.AttackCard
import android.dominion.data.card.type.VictoryCard

class Poacher : KingdomCard(), ActionCard {
    override val template: CardTemplate = CardTemplate.POACHER
    override val cost: Int = 4
}