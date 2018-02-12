package android.dominion.data.card.set.base

import android.dominion.data.card.BaseCard
import android.dominion.data.card.type.Action
import android.dominion.data.engine.player.PlayerBase

/**
 * Created by michaelkrakauer on 02/01/2018.
 */
class Market : BaseCard(5), Action {
    override fun invokeAction(player: PlayerBase) {
        player.drawCard()
        player.addActions(1)
        player.addBuy(1)
    }

    override fun additionToCoinSum(cardsInPlay: List<BaseCard>, alreadySummedCards: List<BaseCard>) = 1
}