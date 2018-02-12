package android.dominion.data.engine.player

import android.dominion.data.card.BaseCard
import android.dominion.data.card.type.Action
import android.dominion.data.card.type.Attack
import android.dominion.data.card.type.Treasure
import android.dominion.data.engine.DominionGameEngine
import android.dominion.data.engine.GameEngineBase
import android.dominion.data.engine.PlayerAction
import android.dominion.data.engine.pile.ReadonlyBoard
import android.dominion.ui.util.PlayerCardPileType
import android.dominion.util.shuffle
import android.support.annotation.CallSuper
import android.util.Log
import java.util.*

/**
 * Created by michaelkrakauer on 13/01/2018.
 */
abstract class PlayerBase : DominionGameEngine.EngineNotificationListener {
    protected val deck: Queue<BaseCard> = ArrayDeque<BaseCard>()
    protected val hand: MutableList<BaseCard> = mutableListOf()
    protected val selectedCards: MutableList<BaseCard> = mutableListOf()
    protected val discardPile: Queue<BaseCard> = ArrayDeque<BaseCard>()
    protected val cardsInPlay = mutableListOf<BaseCard>()
    protected var buyCounter = 0
    protected var actionCounter = 0
    protected var treasuresUsed = 0
    protected lateinit var board: ReadonlyBoard
    protected lateinit var gameEngine: GameEngineBase

    override fun setEngine(engine: GameEngineBase) {
        gameEngine = engine
    }

    override fun onGameStarted(board: ReadonlyBoard) {
        this.board = board
    }

    @CallSuper
    override fun onTurnStart() {
        buyCounter = 1
        actionCounter = 1
        treasuresUsed = 0

        for (i in 1..5) {
            drawCard()
        }
    }

    override fun onPlayerAction(player: DominionGameEngine.EngineNotificationListener, action: PlayerAction, associatedCards: List<BaseCard>) {
        when (action) {
            PlayerAction.DRAW -> TODO()
            PlayerAction.PLAY_CARD -> TODO()
            PlayerAction.GAIN -> TODO()
            PlayerAction.ATTACK -> {
                if (!hand.any { it.negatesAttack }) {
                    (associatedCards.first() as Attack).executeAttack(this)
                }
            }
            PlayerAction.BUY -> TODO()
            PlayerAction.TRASH -> TODO()
            PlayerAction.DISCARD -> TODO()
        }
    }

    private fun invokeTreasureCard(card: BaseCard) {
        cardsInPlay.add(card)
    }

    private fun invokeActionCard(card: BaseCard) {
        (card as Action).let {
            it.invokeAction(this)
            cardsInPlay.add(card)
            gameEngine.notifyPlayerAction(this, PlayerAction.PLAY_CARD, listOf(card))
        }
    }

    private fun getOwningPile(card: BaseCard): MutableMap<BaseCard, Int> {
        val pile = when {
            board.victoryCards.containsKey(card) -> board.victoryCards
            board.kingdomCards.containsKey(card) -> board.kingdomCards
            board.treasureCards.containsKey(card) -> board.treasureCards
            board.unavailableCards.containsKey(card) -> board.unavailableCards
            else -> null
        }

        checkNotNull(pile)

        return pile!!
    }

    fun addActions(amount: Int) {
        actionCounter += amount
    }

    fun addBuy(amount: Int) {
        buyCounter += amount
    }

    fun sumTreasureAmount(): Int {
        var currentSum = 0
        val summedCards = mutableListOf<BaseCard>()

        for (card in cardsInPlay) {
            currentSum += card.additionToCoinSum(cardsInPlay, summedCards)
            summedCards.add(card)
        }

        return currentSum
    }

    fun playCard(indexInHand: Int) {
        require(indexInHand < hand.size, { Log.e(this::class.simpleName, "card index out of bounds") })
        val card = hand[indexInHand]

        if (card is Action) {
            require(actionCounter > 0)
            actionCounter--
        }

        invokeCard(card)
    }

    fun invokeCard(card: BaseCard) {
        when (card) {
            is Action -> invokeActionCard(card)
            is Treasure -> invokeTreasureCard(card)
        }

        if (card is Attack) {
            gameEngine.notifyPlayerAction(this, PlayerAction.ATTACK, listOf(card))
        }
    }

    fun drawCard(): BaseCard? {
        return drawCard { PlayerCardPileType.DECK }
    }

    fun drawCard(pilePicker: (BaseCard) -> PlayerCardPileType): BaseCard? {
        val card = when {
            deck.any() -> {
                val card = deck.remove()
                gameEngine.notifyPlayerAction(this, PlayerAction.DRAW, listOf())

                card
            }
            discardPile.any() -> {
                deck.addAll(discardPile.shuffle())
                discardPile.clear()
                val card = deck.remove()
                gameEngine.notifyPlayerAction(this, PlayerAction.DRAW, listOf())

                card
            }
            else -> null
        }

        if (card != null) {
            when (pilePicker(card)) {
                PlayerCardPileType.DECK -> deck.add(card)
                PlayerCardPileType.HAND -> hand.add(card)
                PlayerCardPileType.IN_PLAY -> invokeCard(card)
                PlayerCardPileType.DISCARD -> discardCard(card)
                PlayerCardPileType.TRASH -> trashCard(card)
            }
        }

        return card
    }

    fun trashCard(card: BaseCard) {
        board.trashPile.add(card)
        gameEngine.notifyPlayerAction(this, PlayerAction.TRASH, listOf(card))
    }
    
    fun discardCard(card: BaseCard) {
        discardPile.add(card)
        gameEngine.notifyPlayerAction(this, PlayerAction.DISCARD, listOf(card))
    }

    fun buyCard(card: BaseCard) {
        val pile = getOwningPile(card)

        if (pile[card] ?: 0 > 0) {
            require(sumTreasureAmount() - treasuresUsed >= card.price)
            treasuresUsed += card.price
            buyCounter--
            discardPile.add(card)
            gameEngine.notifyPlayerAction(this, PlayerAction.BUY, listOf(card))
        }
    }

    fun gainCard(card: BaseCard) {
        discardPile.add(card)
        gameEngine.notifyPlayerAction(this, PlayerAction.GAIN, listOf(card))
    }

    fun moveCards(from: PlayerCardPileType, filter: (BaseCard) -> Boolean, to: PlayerCardPileType, amount: Int, maxAmount: Int): Int {
        selectCardsToBeMoved(from, filter, to, amount, maxAmount)

        for (card in selectedCards) {
            when (to) {
                PlayerCardPileType.TRASH -> trashCard(card)
                PlayerCardPileType.DISCARD -> discardCard(card)
                else -> Unit
            }
        }

        val amountMoved = selectedCards.size
        selectedCards.clear()

        return amountMoved
    }

    protected abstract fun selectCardsToBeMoved(from: PlayerCardPileType, filter: (BaseCard) -> Boolean, to: PlayerCardPileType, amount: Int, maxAmount: Int): List<BaseCard>

    abstract fun determineMovement(card: BaseCard, options: List<PlayerCardPileType>): PlayerCardPileType
}