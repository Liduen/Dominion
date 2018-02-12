package android.dominion

import android.app.Activity
import android.support.multidex.MultiDexApplication
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject


/**
 * Created by michaelkrakauer on 25/10/2017.
 */
class DominionApp : MultiDexApplication(), HasActivityInjector {
    @JvmField
    @Inject
    var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>? = null

    override fun activityInjector() = dispatchingAndroidInjector
}