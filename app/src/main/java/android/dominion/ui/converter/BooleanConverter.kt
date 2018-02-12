package android.dominion.ui.converter

import android.view.View

/**
 * Created by michaelkrakauer on 13/01/2018.
 */
object BooleanConverter {

    @JvmStatic
    fun showIfTrue(value: Boolean): Int {
        return if (value) View.VISIBLE else View.INVISIBLE
    }

    @JvmStatic
    fun hideIfTrue(value: Boolean): Int {
        return if (value) View.INVISIBLE else View.VISIBLE
    }
}