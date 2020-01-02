package android.dominion.data.board

import android.dominion.data.card.BaseCard
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

    fun drawCard() {

    }
}