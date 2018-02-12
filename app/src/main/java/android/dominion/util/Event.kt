package android.dominion.util

/**
 * Created by michaelkrakauer on 13/01/2018.
 */
class Event<T> {
    private val handlers = arrayListOf<(T) -> Unit>()

    operator fun plusAssign(handler: (T) -> Unit) {
        handlers.add(handler)
    }

    operator fun invoke(value: T) {
        handlers.forEach { it(value) }
    }
}