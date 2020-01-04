package android.dominion.data.engine

import android.dominion.data.board.BoardUserSubState

interface EngineEventListener {
    fun onSubscribed(engine: DominionClient, userId: String)

    fun onGameStarted(userBoardSubState: BoardUserSubState)

    fun onTurn(userBoardSubState: BoardUserSubState)

    fun onEvent()

    fun onGameOver()
}