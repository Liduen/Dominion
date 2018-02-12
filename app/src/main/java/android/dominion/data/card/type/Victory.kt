package android.dominion.data.card.type

import android.dominion.data.card.BaseCard

/**
 * Created by michaelkrakauer on 16/10/2017.
 */
interface Victory {
    fun sumVictoryPoints(cards: List<BaseCard>): Int
}