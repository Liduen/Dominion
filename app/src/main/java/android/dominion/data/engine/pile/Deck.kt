package android.dominion.data.engine.pile

import android.dominion.data.card.BaseCard
import android.dominion.util.shuffle
import java.util.*

/**
 * Created by michaelkrakauer on 11/02/2018.
 */
class Deck(private val discardPile: DiscardPile) {
    private val pile: Queue<BaseCard> = ArrayDeque<BaseCard>()

    private fun verifyDeck() {
        if (!pile.any()) {
            val cards = discardPile.empty()
            fill(cards)
        }
    }

    fun fill(cards: List<BaseCard>) {
        pile.addAll(cards)
        shuffle()
    }

    fun draw(): BaseCard? {
        verifyDeck()

        return pile.poll()
    }

    fun peek(): BaseCard? {
        verifyDeck()

        return pile.peek()
    }

    fun shuffle() {
        val current = pile
        pile.clear()
        current.addAll(current.shuffle())
    }

    fun insert(card: BaseCard, position: DeckPosition) {
        when (position) {
            Deck.DeckPosition.TOP -> {
                pile.toMutableList().add(card)
            }
            Deck.DeckPosition.RANDOM -> {
                pile.toMutableList().add(Random(0).nextInt(pile.size - 1), card)
            }
        }
    }

    enum class DeckPosition {
        TOP,
        RANDOM
    }
}