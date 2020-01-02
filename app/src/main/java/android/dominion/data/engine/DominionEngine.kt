package android.dominion.data.engine

import android.dominion.data.board.BoardUserSubState
import android.dominion.data.board.CompleteBoardState
import android.dominion.data.card.KingdomCard
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.*


class DominionEngine private constructor() : Engine {
    private var state: EngineState = EngineState.REGISTERING_USERS
    private val users = mutableMapOf<String, EngineEventListener>()
    private val usersQueue = ArrayDeque<String>()
    private lateinit var hostUserId: String
    private lateinit var boardState: CompleteBoardState

    fun addUser(listener: EngineEventListener): String {
        if (users.values.contains(listener))
            throw IllegalArgumentException("User was already added to engine.")

        val userId = UUID.randomUUID().toString()
        if (users.isEmpty())
            hostUserId = userId
        users[userId] = listener

        return userId
    }

    fun startGame(userId: String) {
        if (userId != hostUserId)
            throw IllegalArgumentException("user $userId")
        eventLogSubject.postValue("Initializing board...")
        initializeBoard()
        state = EngineState.GAME_IN_PROGRESS
        users.forEach {
            it.value.onGameStarted()
            usersQueue.add(it.key)
        }
        eventLogSubject.postValue("Game started!")
        GlobalScope.launch {
            runGame()
        }
    }

    private fun initializeBoard() {
        val cards = listOf<KingdomCard>()
        boardState = CompleteBoardState(users.keys.toList(), cards)
    }

    private fun runGame() {
        if (isGameOver()) {
            notifyGameOver()
        } else {
            GlobalScope.launch {
                startTurn()
            }
        }
    }

    private fun startTurn() {
        val currentUserId = usersQueue.pop()
        val userCallback = users[currentUserId]!!
        val userBoardSubState = boardState.getUserSubset(currentUserId)
        userCallback.onTurn(userBoardSubState)
    }

    override fun onTurnCompleted(userSubState: BoardUserSubState) {

    }

    private fun notifyGameOver() {

    }

    private fun isGameOver(): Boolean {
        return false
    }

    enum class EngineState {
        REGISTERING_USERS,
        INITIALIZING_BOARD,
        GAME_IN_PROGRESS
    }

    companion object {
        private val engine = DominionEngine()
        private val eventLogSubject = MutableLiveData<String>()
        val onLogEvent: LiveData<String>
            get() {
                return eventLogSubject
            }

        fun registerUser(listener: EngineEventListener) {
            val id = engine.addUser(listener)
            listener.onSubscribed(engine, id)
        }

        fun startGame(userId: String) {
            engine.startGame(userId)
        }
    }
}