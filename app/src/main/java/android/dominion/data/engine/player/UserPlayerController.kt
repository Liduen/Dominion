package android.dominion.data.engine.player

import android.dominion.data.card.BaseCard
import android.dominion.data.engine.pile.Board
import android.dominion.data.engine.GameEngineBase
import android.dominion.ui.util.PlayerCardPileType
import android.dominion.util.Event

/**
 * Created by michaelkrakauer on 13/01/2018.
 */
class UserPlayerController : PlayerBase() {
    override fun selectCardsToBeMoved(from: PlayerCardPileType, to: PlayerCardPileType, amount: Int, maxAmount: Int): List<BaseCard> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onGameOver() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    val onGameStarted: Event<Board> = Event()
    val onTurnStart: Event<String> = Event()

    override fun setEngine(engine: GameEngineBase) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onGameStarted(board: Board) {
        onGameStarted(board)
    }

    override fun onTurnStart() {
        onTurnStart(getId())
    }
}