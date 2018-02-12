package android.dominion.data.card.basicSupply

import android.dominion.data.card.BaseCard
import android.dominion.data.card.type.Victory

/**
 * Created by michaelkrakauer on 17/10/2017.
 */
class Province : BaseCard(8), Victory {
    override fun sumVictoryPoints(cards: List<BaseCard>) = 8
}