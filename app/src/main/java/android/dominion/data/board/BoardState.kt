package android.dominion.data.board

import android.dominion.data.card.BaseCard
import android.dominion.data.card.CardFactory
import android.dominion.data.card.CardTemplate

interface BoardState {
    val supplyCards: Map<CardTemplate, List<BaseCard>>
    val kingdomCards: Map<CardTemplate, List<BaseCard>>
    val trash: List<BaseCard>
}

interface MutableBoardState {
    val supplyCards: MutableMap<CardTemplate, List<BaseCard>>
    val kingdomCards: MutableMap<CardTemplate, List<BaseCard>>
    val trash: MutableList<BaseCard>
}

class CompleteBoardState(players: List<String>,
                         kingdomCardTypes: List<CardTemplate>)
    : MutableBoardState {
    val userStates = mutableMapOf<String, UserState>()
    override val supplyCards = mutableMapOf<CardTemplate, List<BaseCard>>()
    override val kingdomCards = mutableMapOf<CardTemplate, List<BaseCard>>()
    override val trash = mutableListOf<BaseCard>()

    init {
        kingdomCardTypes.forEach {
            kingdomCards[it] = CardFactory.getCardPile(it, 10)
        }
        initSupplyCards(players)
    }

    private fun initSupplyCards(players: List<String>) {
        when (players.size) {
            2 -> {
                supplyCards[CardTemplate.COPPER] = CardFactory.getCardPile(CardTemplate.COPPER, 46)
                supplyCards[CardTemplate.SILVER] = CardFactory.getCardPile(CardTemplate.SILVER, 40)
                supplyCards[CardTemplate.GOLD] = CardFactory.getCardPile(CardTemplate.GOLD, 30)
                supplyCards[CardTemplate.CURSE] = CardFactory.getCardPile(CardTemplate.CURSE, 10)
                supplyCards[CardTemplate.ESTATE] = CardFactory.getCardPile(CardTemplate.ESTATE, 8)
                supplyCards[CardTemplate.DUCHY] = CardFactory.getCardPile(CardTemplate.DUCHY, 8)
                supplyCards[CardTemplate.PROVINCE] = CardFactory.getCardPile(CardTemplate.PROVINCE, 8)
            }
            3 -> {
                supplyCards[CardTemplate.COPPER] = CardFactory.getCardPile(CardTemplate.COPPER, 39)
                supplyCards[CardTemplate.SILVER] = CardFactory.getCardPile(CardTemplate.SILVER, 40)
                supplyCards[CardTemplate.GOLD] = CardFactory.getCardPile(CardTemplate.GOLD, 30)
                supplyCards[CardTemplate.CURSE] = CardFactory.getCardPile(CardTemplate.CURSE, 20)
                supplyCards[CardTemplate.ESTATE] = CardFactory.getCardPile(CardTemplate.ESTATE, 12)
                supplyCards[CardTemplate.DUCHY] = CardFactory.getCardPile(CardTemplate.DUCHY, 12)
                supplyCards[CardTemplate.PROVINCE] = CardFactory.getCardPile(CardTemplate.PROVINCE, 12)
            }
            4 -> {
                supplyCards[CardTemplate.COPPER] = CardFactory.getCardPile(CardTemplate.COPPER, 32)
                supplyCards[CardTemplate.SILVER] = CardFactory.getCardPile(CardTemplate.SILVER, 40)
                supplyCards[CardTemplate.GOLD] = CardFactory.getCardPile(CardTemplate.GOLD, 30)
                supplyCards[CardTemplate.CURSE] = CardFactory.getCardPile(CardTemplate.CURSE, 30)
                supplyCards[CardTemplate.ESTATE] = CardFactory.getCardPile(CardTemplate.ESTATE, 12)
                supplyCards[CardTemplate.DUCHY] = CardFactory.getCardPile(CardTemplate.DUCHY, 12)
                supplyCards[CardTemplate.PROVINCE] = CardFactory.getCardPile(CardTemplate.PROVINCE, 12)
            }
            else -> throw IllegalArgumentException("Current player number can't be supported")
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
    override val supplyCards = mutableMapOf<CardTemplate, List<BaseCard>>()
    override val kingdomCards = mutableMapOf<CardTemplate, List<BaseCard>>()
    override val trash = mutableListOf<BaseCard>()
}