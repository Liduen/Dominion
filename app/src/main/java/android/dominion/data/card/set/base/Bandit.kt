package android.dominion.data.card.set.base

import android.dominion.data.card.BaseCard
import android.dominion.data.card.basicSupply.Copper
import android.dominion.data.card.basicSupply.Gold
import android.dominion.data.card.type.Action
import android.dominion.data.card.type.Attack
import android.dominion.data.card.type.Treasure
import android.dominion.data.engine.player.PlayerBase
import android.dominion.ui.util.PlayerCardPileType

/**
 * Created by michaelkrakauer on 15/01/2018.
 */
class Bandit : BaseCard(5), Action, Attack {
    override fun invokeAction(player: PlayerBase) {
        player.gainCard(Gold())
    }

    override fun executeAttack(victim: PlayerBase) {
        (1..2).forEach {
            victim.drawCard {
                if (it is Treasure
                        && it !is Copper) {
                    PlayerCardPileType.TRASH
                }

                PlayerCardPileType.DISCARD
            }
        }
    }
}