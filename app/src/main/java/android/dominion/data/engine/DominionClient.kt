package android.dominion.data.engine

import android.dominion.data.board.BoardUserSubState

interface DominionClient {
    fun onTurnCompleted(userSubState: BoardUserSubState)
}