package android.dominion.ui.viewModel

import android.content.Context
import android.databinding.ObservableArrayList
import android.databinding.ObservableField
import android.dominion.data.card.BaseCard
import android.dominion.data.card.CardSet
import android.dominion.data.card.type.Curser
import android.dominion.data.engine.pile.Board
import android.dominion.data.engine.DominionGameEngine
import android.dominion.data.engine.PlayerAction
import android.dominion.data.engine.player.UserPlayerController
import android.dominion.injection.component.DaggerDominionComponent
import android.dominion.ui.adapter.CardListRecyclerAdapter
import android.dominion.ui.base.BaseViewModel
import android.dominion.ui.util.BoardCardPileType
import android.os.Bundle
import android.text.TextUtils
import javax.inject.Inject

/**
 * Created by michaelkrakauer on 01/01/2018.
 */

class GameViewModel : BaseViewModel() {
    @Inject
    lateinit var gameEngine: DominionGameEngine
    private lateinit var currentBoard: Board
    private lateinit var user: UserPlayerController

    val boardCardTypes = ObservableArrayList<String>()
    val supplyPilesAdapter = ObservableField<CardListRecyclerAdapter>()
    val actionsLog = ObservableField("")

    override fun attachView(context: Context, bundle: Bundle?) {
        DaggerDominionComponent.builder().build().injectGame(this)
        super.attachView(context, bundle)
        user = UserPlayerController()
        gameEngine.startGame(user, listOf(CardSet.BASE))
    }

    fun onGameStarted(board: Board) {
        currentBoard = board
        boardCardTypes.addAll(listOf(BoardCardPileType.Treasure.name, BoardCardPileType.Victory.name))
//        boardCardTypes.addAll(board.kingdomCards.map { it.key.price }.distinct().map { it.toString() })

//        if (board.kingdomCards.map { it.key }.any { it is Curser }) {
//            boardCardTypes.add(BoardCardPileType.Unavailable.name)
//        }

        logAction("GAME STARTED")
    }

    fun onTurnStart() {
        logAction("YOUR TURN")

        repeat(5) {
            drawCard()
        }
    }

    private fun drawCard() {
    }

    fun onPlayerAction(player: DominionGameEngine.EngineNotificationListener, action: PlayerAction, associatedCards: List<BaseCard>) {
        logAction("player $player - action: $action - cards - ${TextUtils.join(", ", associatedCards.map { it.javaClass.simpleName })} ")
    }

    fun onGameOver() {
        logAction("GAME OVER")
    }

    private fun logAction(log: String) {
        var currentText = actionsLog.get()
        currentText += "\n$log"
        actionsLog.set(currentText)
    }

    fun displayCardPile(index: Int) {
//        val displayedCards = when (boardCardTypes[index]) {
//            BoardCardPileType.Victory.name -> currentBoard.victoryCards
//            BoardCardPileType.Treasure.name -> currentBoard.treasureCards
//            BoardCardPileType.Unavailable.name -> currentBoard.unavailableCards
//            else -> currentBoard.kingdomCards.filter { it.key.price == boardCardTypes[index].toInt() }
//        }
//
//        supplyPilesAdapter.set(CardListRecyclerAdapter(displayedCards.toList().toMutableList(), { x -> }, true))
    }
}