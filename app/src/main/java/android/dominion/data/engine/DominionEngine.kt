package android.dominion.data.engine

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import java.util.*
import kotlinx.coroutines.*


class DominionEngine private constructor() : Engine {
    private var state: EngineState = EngineState.REGISTERING_USERS
    private val users = mutableMapOf<String, EngineEventListener>()
    private lateinit var hostUserId: String

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

        state = EngineState.GAME_IN_PROGRESS
        users.values.forEach { it.onGameStarted() }
        eventLogSubject.postValue("Game started!")
        GlobalScope.launch {
            runGame()
        }
    }

    private fun runGame() {
        if (!isGameOver()) {

        }
    }

    private fun isGameOver(): Boolean {
        return false
    }

    enum class EngineState {
        REGISTERING_USERS,
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