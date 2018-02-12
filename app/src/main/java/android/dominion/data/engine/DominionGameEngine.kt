package android.dominion.data.engine

import android.dominion.data.card.BaseCard
import android.dominion.data.card.CardSet
import android.dominion.data.card.type.Treasure
import android.dominion.data.card.type.Victory
import android.dominion.data.engine.pile.Board
import android.dominion.data.engine.pile.ReadonlyBoard
import java.util.*

/**
 * Created by michaelkrakauer on 25/10/2017.
 */
class DominionGameEngine : GameEngineBase {

    private val playersQueue: Queue<EngineNotificationListener> = ArrayDeque<EngineNotificationListener>()
    private lateinit var currentBoard: Board

    fun register(player: EngineNotificationListener) {
        playersQueue.add(player)
        player.setEngine(this)
    }

    fun startGame(user: EngineNotificationListener, cardSets: List<CardSet>) {
        register(user)
        currentBoard = Board(cardSets)
        playersQueue.forEach { it.onGameStarted(currentBoard) }
        nextPlayerPlay()
    }

    private fun nextPlayerPlay() {
        val nextPlayer = playersQueue.remove()
        playersQueue.add(nextPlayer)
        nextPlayer.onTurnStart()
    }

    override fun notifyPlayerAction(player: EngineNotificationListener, actionType: PlayerAction, associatedCards: List<BaseCard>) {
        if (actionType == PlayerAction.BUY
                || actionType == PlayerAction.GAIN) {
            associatedCards.first().let {
                val cardsPile = when (it) {
                    is Treasure -> currentBoard.treasureCards
                    is Victory -> currentBoard.victoryCards
                    else -> currentBoard.kingdomCards
                }

                require(cardsPile.contains(it))
                val count = cardsPile[it]
                cardsPile[it] = (count!! - 1)
            }
        }

        playersQueue
                .filter { it.getId() != player.getId() }
                .forEach { it.onPlayerAction(player, actionType, associatedCards) }
    }

    override fun notifyCompletedTurn(player: EngineNotificationListener) {
        if ((currentBoard.isGameOver())) {
            playersQueue.forEach { it.onGameOver() }
        } else {
            nextPlayerPlay()
        }
    }

    interface EngineNotificationListener {
        fun getId() = UUID.randomUUID().toString()

        fun setEngine(engine: GameEngineBase)

        fun onGameStarted(board: ReadonlyBoard)

        fun onTurnStart()

        fun onPlayerAction(player: EngineNotificationListener, action: PlayerAction, associatedCards: List<BaseCard>)

        fun onGameOver()
    }
}