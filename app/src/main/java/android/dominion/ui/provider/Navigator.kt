package android.dominion.ui.provider

import android.content.Intent

/**
 * Created by michaelkrakauer on 17/11/2017.
 */
interface Navigator {
    fun finish()
    fun startActivity(intent: Intent)
}