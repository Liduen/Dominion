package android.dominion.data.engine

import android.dominion.data.board.BoardUserSubState

interface Engine {
    fun onTurnCompleted(userSubState: BoardUserSubState)
}