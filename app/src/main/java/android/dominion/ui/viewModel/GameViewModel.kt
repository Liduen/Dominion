package android.dominion.ui.viewModel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import android.dominion.ui.base.BaseViewModel

/**
 * Created by michaelkrakauer on 01/01/2018.
 */

class GameViewModel(application: Application) : BaseViewModel(application) {

    val log = MutableLiveData<String>().also {
        it.value = ""
    }

    override fun initialize() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}