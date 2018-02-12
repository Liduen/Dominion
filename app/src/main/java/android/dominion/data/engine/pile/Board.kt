package android.dominion.data.engine.pile

import android.dominion.data.card.BaseCard
import android.dominion.data.card.CardSet
import android.dominion.data.card.basicSupply.*
import android.dominion.data.card.type.Curser

/**
 * Created by michaelkrakauer on 17/10/2017.
 */
class Board(cardSets: List<CardSet>) : ReadonlyBoard {
    private val treasureCards = mutableMapOf<BaseCard, Int>()
    private val victoryCards = mutableMapOf<BaseCard, Int>()
    private val kingdomCards = mutableMapOf<BaseCard, Int>()
    private val unavailableCards = mutableMapOf<BaseCard, Int>()
    override val trashPile: TrashPile = TrashPile()

    init {
        val availableCards = cardSets.flatMap { it.includedCards }.toMutableList()
        treasureCards.putAll(listOf<BaseCard>(Copper(), Silver(), Gold()).associate { it to it.amountInDeck })
        victoryCards.putAll(listOf<BaseCard>(Estate(), Duchy(), Province()).associate { it to it.amountInDeck })
        kingdomCards.putAll(availableCards.associate { it to it.amountInDeck })

        if (availableCards.any { it is Curser }) {
            unavailableCards.putAll(listOf<BaseCard>(Curse()).associate { it to it.amountInDeck })
        }
    }

    override fun get(card: BaseCard): Boolean {
        val pile = when {
            victoryCards.containsKey(card) -> victoryCards
            kingdomCards.containsKey(card) -> kingdomCards
            treasureCards.containsKey(card) -> treasureCards
            unavailableCards.containsKey(card) -> unavailableCards
            else -> return false
        }

        val currentAmount = pile[card]

        currentAmount?.let {
            if (currentAmount > 0)
                pile[card] = currentAmount - 1
            else
                return false
        }

        return true
    }

    override fun list(predicate: (BaseCard) -> Boolean): List<BaseCard> {
        return listOf(treasureCards, victoryCards, kingdomCards)
                .flatMap { it.keys }
                .filter(predicate)
    }

    fun isGameOver(): Boolean {
        return (victoryCards[Province()] ?: 0 == 0)
                || listOf(treasureCards, victoryCards, kingdomCards).sumBy { it.count { it.value == 0 } } >= 3
    }
}