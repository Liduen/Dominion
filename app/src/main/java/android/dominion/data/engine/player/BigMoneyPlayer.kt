package android.dominion.data.engine.player

import android.dominion.data.card.BaseCard
import android.dominion.data.card.basicSupply.Gold
import android.dominion.data.card.basicSupply.Province
import android.dominion.data.card.basicSupply.Silver
import android.dominion.data.card.type.Treasure
import android.dominion.data.engine.pile.Board
import android.dominion.ui.util.PlayerCardPileType

/**
 * Created by michaelkrakauer on 12/01/2018.
 */
class BigMoneyPlayer : PlayerBase() {
    private lateinit var gameBoard: Board

    override fun onGameStarted(board: Board) {
        gameBoard = board
    }

    override fun onTurnStart() {
        super.onTurnStart()
        while (hand.any { it is Treasure }) {
            playCard(hand.indexOfFirst { it is Treasure })
        }

        when (sumTreasureAmount()) {
            8 -> buyCard(Province())
            in 6..7 -> buyCard(Gold())
            in 3..5 -> buyCard(Silver())
        }
    }

    override fun onGameOver() = Unit

    override fun selectCardsToBeMoved(from: PlayerCardPileType, to: PlayerCardPileType, amount: Int, maxAmount: Int): List<BaseCard> = listOf()

    override fun determineMovement(card: BaseCard) = Unit
}