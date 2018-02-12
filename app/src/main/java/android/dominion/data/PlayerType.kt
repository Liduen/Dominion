package android.dominion.data

/**
 * Created by michaelkrakauer on 25/12/2017.
 */
enum class PlayerType(private val index: Int) {
    USER(0),
    AGGRESSIVE(1),
    GREEDY(2);

    fun byIndex(index: Int): PlayerType {
        require(index in PlayerType.values().map { it.index })

        return PlayerType.values().first { it.index == index }
    }
}