package android.dominion.data.engine

import android.dominion.data.board.BoardUserSubState

interface EngineEventListener {
    fun onSubscribed(engine: Engine, userId: String)

    fun onGameStarted()

    fun onTurn(userBoardSubState: BoardUserSubState)

    fun onEvent()

    fun onGameOver()
}