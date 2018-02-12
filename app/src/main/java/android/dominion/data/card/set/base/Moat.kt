package android.dominion.data.card.set.base

import android.dominion.data.card.BaseCard
import android.dominion.data.card.type.Action
import android.dominion.data.card.type.Reaction
import android.dominion.data.engine.PlayerAction
import android.dominion.data.engine.player.PlayerBase

/**
 * Created by michaelkrakauer on 02/01/2018.
 */
class Moat : BaseCard(2), Action, Reaction {
    override val negatesAttack = true
    override val triggerActionType = PlayerAction.ATTACK

    override fun invokeReaction(player: PlayerBase) = Unit

    override fun invokeAction(player: PlayerBase) {
        player.drawCard()
        player.drawCard()
    }
}