package android.dominion.data.card.basicSupply

import android.dominion.data.card.BaseCard
import android.dominion.data.card.type.Treasure

/**
 * Created by michaelkrakauer on 16/10/2017.
 */
class Gold : BaseCard(6, 30), Treasure {
    override val value = 3
}