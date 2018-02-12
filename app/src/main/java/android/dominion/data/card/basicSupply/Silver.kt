package android.dominion.data.card.basicSupply

import android.dominion.data.card.BaseCard
import android.dominion.data.card.type.Treasure

/**
 * Created by michaelkrakauer on 16/10/2017.
 */
class Silver : BaseCard(3, 40), Treasure {
    override val value = 2
}