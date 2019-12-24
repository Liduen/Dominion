package android.dominion.ui.viewModel

import android.arch.lifecycle.MutableLiveData
import android.dominion.ui.base.BaseViewModel

/**
 * Created by michaelkrakauer on 01/01/2018.
 */

class GameViewModel : BaseViewModel() {

    val log = MutableLiveData<String>().also {
        it.value = ""
    }
//    @Inject
//    lateinit var gameEngine: DominionGameEngine
//    private lateinit var currentBoard: Board
//    private lateinit var user: UserPlayerController
//
//    val boardCardTypes = ObservableArrayList<String>()
//    val supplyPilesAdapter = ObservableField<CardListRecyclerAdapter>()
//    val actionsLog = ObservableField("")
//
//    override fun attachView(context: Context, bundle: Bundle?) {
//        DaggerDominionComponent.builder().build().injectGame(this)
//        super.attachView(context, bundle)
//        user = UserPlayerController()
//        gameEngine.startGame(user, listOf(CardSet.BASE))
//    }
//
//    fun onGameStarted(board: Board) {
//        currentBoard = board
//        boardCardTypes.addAll(listOf(BoardCardPileType.Treasure.name, BoardCardPileType.Victory.name))
////        boardCardTypes.addAll(board.kingdomCards.map { it.key.price }.distinct().map { it.toString() })
//
////        if (board.kingdomCards.map { it.key }.any { it is Curser }) {
////            boardCardTypes.add(BoardCardPileType.Unavailable.name)
////        }
//
//        logAction("GAME STARTED")
//    }
//
//    fun onTurnStart() {
//        logAction("YOUR TURN")
//
//        repeat(5) {
//            drawCard()
//        }
//    }
//
//    private fun drawCard() {
//    }
//
//    fun onPlayerAction(player: DominionGameEngine.EngineNotificationListener, action: PlayerAction, associatedCards: List<BaseCard>) {
//        logAction("player $player - action: $action - cards - ${TextUtils.join(", ", associatedCards.map { it.javaClass.simpleName })} ")
//    }
//
//    fun onGameOver() {
//        logAction("GAME OVER")
//    }
//
//    private fun logAction(log: String) {
//        var currentText = actionsLog.get()
//        currentText += "\n$log"
//        actionsLog.set(currentText)
//    }
//
//    fun displayCardPile(index: Int) {
////        val displayedCards = when (boardCardTypes[index]) {
////            BoardCardPileType.Victory.name -> currentBoard.victoryCards
////            BoardCardPileType.Treasure.name -> currentBoard.treasureCards
////            BoardCardPileType.Unavailable.name -> currentBoard.unavailableCards
////            else -> currentBoard.kingdomCards.filter { it.key.price == boardCardTypes[index].toInt() }
////        }
////
////        supplyPilesAdapter.set(CardListRecyclerAdapter(displayedCards.toList().toMutableList(), { x -> }, true))
//    }
}