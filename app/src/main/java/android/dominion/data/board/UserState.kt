package android.dominion.data.board

import android.dominion.data.card.BaseCard
import android.dominion.data.card.base.Copper
import android.dominion.data.card.base.Estate
import java.util.*

class UserState {
    private val innerDeck = Stack<BaseCard>()
    private val innerHand = mutableListOf<BaseCard>()
    private val innerDiscard = mutableListOf<BaseCard>()

    val deck: List<BaseCard>
        get() = innerDeck

    val hand: List<BaseCard>
        get() = innerHand

    val discard: List<BaseCard>
        get() = innerDiscard

    init {
        repeat(3) {
            innerDeck.push(Estate())
        }
        repeat(7) {
            innerDeck.push(Copper())
        }
        innerDeck.shuffle()

        repeat(5) {
            drawCard()
        }
    }

    fun drawCard(): BaseCard? {
        if (innerDeck.any()) {
            val card = innerDeck.pop()
            innerHand.add(card)

            return card
        } else if (innerDiscard.any()) {
            innerDiscard.shuffled().forEach {
                innerDeck.push(it)
            }
            innerDiscard.clear()

            val card = innerDeck.pop()
            innerHand.add(card)

            return card
        }

        return null
    }
}