package android.dominion.data.card.set.base

import android.dominion.data.card.BaseCard
import android.dominion.data.card.type.Action
import android.dominion.data.engine.player.PlayerBase
import android.dominion.ui.util.PlayerCardPileType

/**
 * Created by michaelkrakauer on 02/01/2018.
 */
class Chapel : BaseCard(2), Action {
    override fun invokeAction(player: PlayerBase) {
        player.moveCards(PlayerCardPileType.HAND, PlayerCardPileType.TRASH, -1, 4)
    }
}