package android.dominion.data.card.type

import android.dominion.data.engine.player.PlayerBase

/**
 * Created by michaelkrakauer on 16/10/2017.
 */
interface Action {
    fun invokeAction(player: PlayerBase)
}