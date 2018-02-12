package android.dominion.data.card.basicSupply

import android.dominion.R
import android.dominion.data.card.BaseCard
import android.dominion.data.card.type.Treasure

/**
 * Created by michaelkrakauer on 16/10/2017.
 */
class Copper : BaseCard(0, R.drawable.i_card_copper, 60), Treasure {
    override val value = 1
}