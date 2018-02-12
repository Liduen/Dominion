package android.dominion.data.engine.pile

import android.dominion.data.card.BaseCard

/**
 * Created by michaelkrakauer on 12/02/2018.
 */
interface ReadonlyBoard {
    val trashPile: TrashPile

    fun get(card: BaseCard): Boolean

    fun list(predicate: (BaseCard) -> Boolean): List<BaseCard>
}