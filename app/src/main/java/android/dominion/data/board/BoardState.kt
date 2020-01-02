package android.dominion.data.board

import android.dominion.data.card.BaseCard
import android.dominion.data.card.KingdomCard

interface BoardState {
    val supplyCards: Map<String, List<BaseCard>>
    val kingdomCards: Map<String, List<BaseCard>>
    val trash: List<BaseCard>
}

interface MutableBoardState {
    val supplyCards: MutableMap<String, List<BaseCard>>
    val kingdomCards: MutableMap<String, List<BaseCard>>
    val trash: MutableList<BaseCard>
}

class CompleteBoardState(players: List<String>,
                         kingdomCardTypes: List<KingdomCard>)
    : MutableBoardState {
    val userStates = mutableMapOf<String, UserState>()
    override val supplyCards = mutableMapOf<String, List<BaseCard>>()
    override val kingdomCards = mutableMapOf<String, List<BaseCard>>()
    override val trash = mutableListOf<BaseCard>()

    init {
        val distinctKingdomCards = kingdomCardTypes.distinctBy { it::class.java.simpleName }
        kingdomCards
        when (players.size) {
            2 -> {
            }
            3 -> {
            }
            4 -> {
            }
            else -> {
            }
        }
    }

    fun getUserSubset(userId: String): BoardUserSubState {
        return BoardUserSubState(userStates[userId]!!).also {
            it.supplyCards.putAll(supplyCards)
            it.kingdomCards.putAll(kingdomCards)
            it.trash.addAll(trash)
        }
    }
}

class BoardUserSubState(val UserState: UserState) : BoardState {
    override val supplyCards = mutableMapOf<String, List<BaseCard>>()
    override val kingdomCards = mutableMapOf<String, List<BaseCard>>()
    override val trash = mutableListOf<BaseCard>()
}