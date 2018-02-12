package android.dominion.data.card.set.base

import android.dominion.data.card.BaseCard
import android.dominion.data.card.type.Action
import android.dominion.data.engine.player.PlayerBase
import android.dominion.ui.util.PlayerCardPileType

/**
 * Created by michaelkrakauer on 02/01/2018.
 */
class Cellar : BaseCard(2), Action {
    override fun invokeAction(player: PlayerBase) {
        val amountDiscarded = player.moveCards(PlayerCardPileType.HAND,
                PlayerCardPileType.DISCARD,
                -1,
                -1)

        if (amountDiscarded > 0) {
            (1..amountDiscarded).forEach {
                player.drawCard()
            }
        }
    }
}