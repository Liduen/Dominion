package android.dominion.data.card.prosperity

import android.dominion.data.card.CardTemplate
import android.dominion.data.card.SupplyCard
import android.dominion.data.card.type.TreasureCard

class Platinum : SupplyCard(), TreasureCard {
    override val template: CardTemplate = CardTemplate.PLATINUM
}