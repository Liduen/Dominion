package android.dominion.data.card

abstract class BaseCard {
    abstract val template: CardTemplate
    abstract val cost: Int
    open val potionCost: Int = 0
    open val debtCost: Int = 0
}