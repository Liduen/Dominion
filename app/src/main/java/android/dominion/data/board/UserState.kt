package android.dominion.data.board

import android.dominion.data.card.BaseCard
import android.dominion.data.card.base.Copper
import android.dominion.data.card.base.Estate
import java.util.*

class UserState {
    // user
    //  deck -> stack
    //  hand -> list
    //  discard -> list
    //  in the future we can add the board components for duration cards and etc'
    val deck = Stack<BaseCard>()
    val hand = listOf<BaseCard>()
    val discard = listOf<BaseCard>()

    init {
        repeat(3) {
            deck.push(Estate())
        }
        repeat(7) {
            deck.push(Copper())
        }
        deck.shuffle()
    }
}