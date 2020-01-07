package android.dominion.engine

import android.dominion.data.board.BoardUserSubState
import android.dominion.engine.client.DominionClient

interface DominionClientEventListener {
    fun onSubscribed(client: DominionClient, userId: String)

    fun onGameStarted(userBoardSubState: BoardUserSubState)

    fun onTurn(userBoardSubState: BoardUserSubState)

    fun onEvent()

    fun onGameOver()
}