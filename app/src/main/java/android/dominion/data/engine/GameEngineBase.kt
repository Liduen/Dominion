package android.dominion.data.engine

import android.dominion.data.card.BaseCard

/**
 * Created by michaelkrakauer on 12/01/2018.
 */
interface GameEngineBase {
    fun notifyPlayerAction(player: DominionGameEngine.EngineNotificationListener, actionType: PlayerAction, associatedCards: List<BaseCard>)

    fun notifyCompletedTurn(player: DominionGameEngine.EngineNotificationListener)
}