package android.dominion.data.engine.pile

import android.dominion.data.card.BaseCard

/**
 * Created by michaelkrakauer on 12/02/2018.
 */
class DiscardPile {
    private val pile: MutableList<BaseCard> = mutableListOf()

    fun add(card: BaseCard) {
        pile.add(card)
    }

    fun list(): List<BaseCard> {
        return pile
    }

    fun empty(): List<BaseCard> {
        val currentPile = pile
        pile.clear()

        return currentPile
    }
}