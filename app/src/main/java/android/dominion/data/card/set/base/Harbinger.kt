package android.dominion.data.card.set.base

import android.dominion.data.card.BaseCard
import android.dominion.data.card.type.Action
import android.dominion.data.engine.player.PlayerBase
import android.dominion.ui.util.PlayerCardPileType

/**
 * Created by michaelkrakauer on 15/01/2018.
 */
class Harbinger : BaseCard(3), Action {
    override fun invokeAction(player: PlayerBase) {
        player.drawCard()
        player.addActions(1)
        player.moveCards(PlayerCardPileType.DISCARD, PlayerCardPileType.DECK, -1, 1)
    }
}