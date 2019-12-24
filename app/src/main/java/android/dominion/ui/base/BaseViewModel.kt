package android.dominion.ui.base

import android.app.Application
import androidx.lifecycle.AndroidViewModel

/**
 * Created by michaelkrakauer on 16/10/2017.
 */
abstract class BaseViewModel(application: Application) : AndroidViewModel(application) {
    open fun initialize() = Unit
}