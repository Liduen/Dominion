package android.dominion.data.engine.player

import android.dominion.data.card.BaseCard
import android.dominion.data.engine.pile.Board
import android.dominion.data.engine.DominionGameEngine
import android.dominion.data.engine.GameEngineBase
import android.dominion.data.engine.PlayerAction

/**
 * Created by michaelkrakauer on 12/01/2018.
 */
class AggressivePlayer: DominionGameEngine.EngineNotificationListener {
    override fun setEngine(engine: GameEngineBase) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onGameStarted(board: Board) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onTurnStart() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onPlayerAction(player: DominionGameEngine.EngineNotificationListener, action: PlayerAction, associatedCards: List<BaseCard>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onGameOver() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}