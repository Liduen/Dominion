package android.dominion.data.card.type

import android.dominion.data.engine.PlayerAction
import android.dominion.data.engine.player.PlayerBase

/**
 * Created by michaelkrakauer on 16/10/2017.
 */
interface Reaction {
    val triggerActionType: PlayerAction

    fun invokeReaction(player: PlayerBase)
}