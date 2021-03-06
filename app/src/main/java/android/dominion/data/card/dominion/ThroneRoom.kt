package android.dominion.data.card.dominion

import android.dominion.data.card.CardTemplate
import android.dominion.data.card.KingdomCard
import android.dominion.data.card.type.ActionCard
import android.dominion.data.card.type.AttackCard
import android.dominion.data.card.type.VictoryCard

class ThroneRoom : KingdomCard(), ActionCard {
    override val template: CardTemplate = CardTemplate.THRONE_ROOM
    override val cost: Int = 4
}