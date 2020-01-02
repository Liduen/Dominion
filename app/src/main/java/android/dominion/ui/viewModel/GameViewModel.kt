package android.dominion.ui.viewModel

import android.app.Application
import android.dominion.data.board.BoardUserSubState
import android.dominion.data.engine.DominionEngine
import android.dominion.data.engine.Engine
import android.dominion.data.engine.EngineEventListener
import android.dominion.ui.base.BaseViewModel
import androidx.lifecycle.MutableLiveData

/**
 * Created by michaelkrakauer on 01/01/2018.
 */

class GameViewModel(application: Application) : BaseViewModel(application) {
    private val gameClient = DominionUserClient()

    val log = MutableLiveData<String>().also {
        it.value = ""
    }
    private lateinit var userId: String
    lateinit var engine: Engine
    private lateinit var currentBoardState: BoardUserSubState

    override fun initialize() {
        DominionEngine.registerUser(gameClient)
    }

    fun startGame() {
        DominionEngine.startGame(userId)
    }

    inner class DominionUserClient : EngineEventListener {
        override fun onSubscribed(engine: Engine, userId: String) {
            this@GameViewModel.engine = engine
            this@GameViewModel.userId = userId
        }

        override fun onGameStarted() {
        }

        override fun onTurn(userBoardSubState: BoardUserSubState) {
            currentBoardState = userBoardSubState
        }

        override fun onEvent() {
        }

        override fun onGameOver() {
        }
    }
}