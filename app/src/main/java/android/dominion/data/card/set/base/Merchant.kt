package android.dominion.data.card.set.base

import android.dominion.data.card.BaseCard
import android.dominion.data.card.basicSupply.Silver
import android.dominion.data.card.type.Action
import android.dominion.data.engine.player.PlayerBase

/**
 * Created by michaelkrakauer on 02/01/2018.
 */
class Merchant : BaseCard(3), Action {

    override fun invokeAction(player: PlayerBase) {
        player.addActions(1)
        player.drawCard()
    }

    override fun additionToCoinSum(cardsInPlay: List<BaseCard>, alreadySummedCards: List<BaseCard>): Int {
        if (!alreadySummedCards.contains(Merchant())
                && cardsInPlay.contains(Silver())) {
            return 1
        }

        return 0
    }
}