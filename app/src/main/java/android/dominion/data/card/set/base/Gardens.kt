package android.dominion.data.card.set.base

import android.dominion.data.card.BaseCard
import android.dominion.data.card.type.Victory

/**
 * Created by michaelkrakauer on 17/10/2017.
 */
class Gardens : BaseCard(4), Victory {
    override fun sumVictoryPoints(cards: List<BaseCard>) = cards.count() / 10
}