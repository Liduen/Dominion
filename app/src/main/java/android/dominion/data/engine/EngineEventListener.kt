package android.dominion.data.engine

interface EngineEventListener {
    fun onSubscribed(engine: Engine, userId: String)

    fun onGameStarted()

    fun onTurn()

    fun onEvent()

    fun onGameOver()
}