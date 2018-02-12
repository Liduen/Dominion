package android.dominion.data.card

/**
 * Created by michaelkrakauer on 16/10/2017.
 */
abstract class BaseCard(val price: Int, val imageId: Int = 0, val amountInDeck: Int = 0) {
    open val negatesAttack = false
    open fun additionToCoinSum(cardsInPlay: List<BaseCard>, alreadySummedCards: List<BaseCard>) = 0

    override fun equals(other: Any?): Boolean {
        (other as? BaseCard)?.let {
            return it.hashCode() == hashCode()
        }

        return false
    }

    override fun hashCode(): Int {
        var result = price
        result = 31 * result + imageId
        result = 31 * result + amountInDeck
        result = 31 * result + negatesAttack.hashCode()
        result = 31 * result + this::class.java.simpleName.hashCode()

        return result
    }
}