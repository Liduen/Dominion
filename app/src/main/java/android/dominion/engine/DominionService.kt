package android.dominion.engine

import android.dominion.engine.client.LocalDominionClient

class DominionService {

    private val autoPlayers = mutableListOf<DominionClientEventListener>()

    fun launchGame(listener: DominionClientEventListener, gameType: GameType) {
        autoPlayers.clear()
        require(gameType == GameType.LOCAL) {
            "game type - $gameType isn't supported yet"
        }

        val localClient = LocalDominionClient(listener)
        val userId = DominionEngine.launchGame(localClient)
        listener.onSubscribed(localClient, userId)
    }

    fun addLocalUser(listener: DominionClientEventListener, isAutoPlayer: Boolean = false) {
        val player = LocalDominionClient(listener)

        if (isAutoPlayer) {
            autoPlayers.add(player)
        }

        val userId = DominionEngine.registerUser(player)
        listener.onSubscribed(player, userId)
    }
}

enum class GameType {
    LOCAL,
    BLUETOOTH,
    NETWORK
}