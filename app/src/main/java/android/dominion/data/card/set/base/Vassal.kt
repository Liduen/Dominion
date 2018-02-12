package android.dominion.data.card.set.base

import android.dominion.data.card.BaseCard
import android.dominion.data.card.type.Action
import android.dominion.data.engine.player.PlayerBase
import android.dominion.ui.util.PlayerCardPileType

/**
 * Created by michaelkrakauer on 15/01/2018.
 */
class Vassal : BaseCard(3), Action {
    override fun invokeAction(player: PlayerBase) {
        player.drawCard {
            player.determineMovement(it, listOf(PlayerCardPileType.DISCARD, PlayerCardPileType.IN_PLAY))
        }
    }

    override fun additionToCoinSum(cardsInPlay: List<BaseCard>, alreadySummedCards: List<BaseCard>) = 2
}