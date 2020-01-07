package android.dominion.ui.viewModel

import android.app.Application
import android.dominion.data.board.BoardState
import android.dominion.data.board.BoardUserSubState
import android.dominion.data.card.BaseCard
import android.dominion.engine.DominionClientEventListener
import android.dominion.engine.DominionEngine
import android.dominion.engine.DominionService
import android.dominion.engine.GameType
import android.dominion.engine.client.DominionClient
import android.dominion.player.BigMoneyPlayer
import android.dominion.ui.base.BaseViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

/**
 * Created by michaelkrakauer on 01/01/2018.
 */

class GameViewModel(application: Application) : BaseViewModel(application) {

    private val eventListener = object : DominionClientEventListener {
        override fun onSubscribed(client: DominionClient, userId: String) {
            gameClient = client
            gameUserId = userId
        }

        override fun onGameStarted(userBoardSubState: BoardUserSubState) {
        }

        override fun onTurn(userBoardSubState: BoardUserSubState) {
            innerBoard.postValue(userBoardSubState)
            innerHand.postValue(userBoardSubState.UserState.hand)
            isGameRunning.postValue(true)
        }

        override fun onEvent() {

        }

        override fun onGameOver() {
            isGameRunning.value = false
        }
    }
    val log = MutableLiveData<String>().also {
        it.value = ""
    }
    private val innerHand = MutableLiveData<List<BaseCard>>()
    val hand: LiveData<List<BaseCard>>
        get() = innerHand
    private val innerBoard = MutableLiveData<BoardState>()
    val board: LiveData<BoardState>
        get() = innerBoard
    val isGameRunning = MutableLiveData<Boolean>().also {
        it.value = false
    }
    private lateinit var gameUserId: String
    lateinit var gameClient: DominionClient

    override fun initialize() {
        DominionEngine.onLogEvent.observeForever {
            log.value += "\n-----------\n$it"
        }
        DominionService().launchGame(eventListener, GameType.LOCAL)
        DominionService().addLocalUser(BigMoneyPlayer())
        DominionService().addLocalUser(BigMoneyPlayer())
    }

    fun startGame() {
        DominionEngine.startGame(gameUserId)
    }
}