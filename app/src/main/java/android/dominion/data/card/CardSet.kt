package android.dominion.data.card

import android.dominion.data.card.set.adventures.Magpie
import android.dominion.data.card.set.base.Cellar
import android.dominion.data.card.set.base.Chapel
import android.dominion.data.card.set.base.Moat

/**
 * Created by michaelkrakauer on 02/01/2018.
 */
enum class CardSet(val includedCards: List<BaseCard>) {
    BASE(listOf(Cellar(), Chapel(), Moat())),
    ADVENTURES(listOf(Magpie()))
}