package android.dominion.ui.base

import android.content.Context
import android.os.Bundle
import android.support.annotation.CallSuper

/**
 * Created by michaelkrakauer on 16/10/2017.
 */
abstract class BaseViewModel {
    protected lateinit var context: Context

    @CallSuper
    open fun attachView(context: Context, bundle: Bundle?) {
        this.context = context
    }

    open fun detachView() {}

    protected open fun loadInstanceState(sis: Bundle?) {}
    protected open fun saveInstanceState(outState: Bundle?) {}
}