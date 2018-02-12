package android.dominion.ui.viewModel

import android.content.Intent
import android.dominion.ui.activity.HostingActivity
import android.dominion.ui.base.BaseViewModel
import android.dominion.ui.provider.Navigator
import java.util.logging.Level
import java.util.logging.Logger

/**
 * Created by michaelkrakauer on 17/11/2017.
 */
class MenuViewModel(private val navigator: Navigator) : BaseViewModel() {
    val TAG = javaClass.simpleName

    fun hostGame() {
        Logger.getAnonymousLogger().log(Level.INFO, "$TAG - Navigating to hosting activity")
        navigator.startActivity(Intent(context, HostingActivity::class.java))
    }

    fun joinRemoteGame() {
    }
}