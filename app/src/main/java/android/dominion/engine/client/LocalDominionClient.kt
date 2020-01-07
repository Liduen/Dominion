package android.dominion.engine.client

import android.dominion.data.board.BoardUserSubState
import android.dominion.data.card.BaseCard
import android.dominion.data.card.CardTemplate
import android.dominion.engine.DominionClientEventListener

class LocalDominionClient(private val listener: DominionClientEventListener)
    : DominionClient,
        DominionClientEventListener {

    lateinit var boardState: BoardUserSubState

    override fun onSubscribed(client: DominionClient, userId: String) {
        listener.onSubscribed(client, userId)
    }

    override fun onEvent() {
        listener.onEvent()
    }

    override fun onGameStarted(userBoardSubState: BoardUserSubState) {
        listener.onGameStarted(userBoardSubState)
        boardState = userBoardSubState
    }

    override fun onTurn(userBoardSubState: BoardUserSubState) {
        listener.onTurn(userBoardSubState)
    }

    override fun onTurnCompleted(userSubState: BoardUserSubState) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun drawCard(): BaseCard {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun playCard(baseCard: BaseCard) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun buyCard(cardTemplate: CardTemplate) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun cleanup() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    // ------


    override fun onGameOver() {
        listener.onGameOver()
    }
}