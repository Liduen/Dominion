package android.dominion.engine.client

import android.dominion.data.board.BoardUserSubState
import android.dominion.data.card.BaseCard
import android.dominion.data.card.CardTemplate

interface DominionClient {
    fun onTurnCompleted(userSubState: BoardUserSubState)

    fun drawCard(): BaseCard

    fun playCard(baseCard: BaseCard)

    fun buyCard(cardTemplate: CardTemplate)

    fun cleanup()
}