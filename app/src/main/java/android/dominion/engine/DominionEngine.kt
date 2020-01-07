package android.dominion.engine

import android.dominion.data.board.CompleteBoardState
import android.dominion.data.card.CardTemplate
import android.dominion.data.card.Deck
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.*

class DominionEngine private constructor() {
    private var state: EngineState = EngineState.REGISTERING_USERS
    private val users = mutableMapOf<String, DominionClientEventListener>()
    private val usersQueue = ArrayDeque<String>()
    private lateinit var hostUserId: String
    private lateinit var boardState: CompleteBoardState

    private fun reset() {
        eventLogSubject.postValue("Resetting")
        state = EngineState.REGISTERING_USERS
        users.clear()
        usersQueue.clear()
    }

    fun addUser(listener: DominionClientEventListener): String {
        if (users.values.contains(listener))
            throw IllegalArgumentException("User was already added to engine.")

        val userId = UUID.randomUUID().toString()

        eventLogSubject.postValue("Adding user. Id - $userId")

        if (users.isEmpty())
            hostUserId = userId
        users[userId] = listener

        return userId
    }

    fun startGame(userId: String) {
        eventLogSubject.postValue("Starting game...")

        if (userId != hostUserId)
            throw IllegalArgumentException("user $userId")

        eventLogSubject.postValue("Initializing board...")
        state = EngineState.INITIALIZING_BOARD
        initializeBoard()
        state = EngineState.GAME_IN_PROGRESS
        users.forEach {
            it.value.onGameStarted(boardState.getUserSubset(it.key))
            usersQueue.add(it.key)
        }
        eventLogSubject.postValue("Game started!")
        GlobalScope.launch {
            runGame()
        }
    }

    private fun initializeBoard() {
        val decks = listOf(Deck.DOMINION)
        val gameCards = getGameCards(decks)
        boardState = CompleteBoardState(users.keys.toList(), gameCards)
    }

    private fun getGameCards(decks: List<Deck>): List<CardTemplate> {
        return if (decks.size == 1) {
            val deck = decks.single()
            deck.kingdomCards.shuffled().take(10)
        } else {
            val firstDeck = decks.first()
            val secondDeck = decks[1]

            mutableListOf<CardTemplate>().also {
                it.addAll(firstDeck.kingdomCards.shuffled().take(5))
                it.addAll(secondDeck.kingdomCards.shuffled().take(5))
            }
        }
    }

    private fun runGame() {
        eventLogSubject.postValue("Running game...")
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
        eventLogSubject.postValue("Starting turn for user $currentUserId")
        userCallback.onTurn(userBoardSubState)
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

        init {
            onLogEvent.observeForever { Log.d(DominionEngine::class.java.simpleName, it) }
        }

        fun launchGame(listener: DominionClientEventListener): String {
            engine.reset()
            return engine.addUser(listener)
        }

        fun registerUser(listener: DominionClientEventListener): String {
            return engine.addUser(listener)
        }

        fun startGame(userId: String) {
            engine.startGame(userId)
        }
    }
}