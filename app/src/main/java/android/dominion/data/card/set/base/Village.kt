package android.dominion.data.card.set.base

import android.dominion.data.card.BaseCard
import android.dominion.data.card.type.Action
import android.dominion.data.engine.player.PlayerBase

/**
 * Created by michaelkrakauer on 15/01/2018.
 */
class Village : BaseCard(3), Action {
    override fun invokeAction(player: PlayerBase) {
        player.addActions(2)
        player.drawCard()
    }
}