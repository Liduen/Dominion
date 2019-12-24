package android.dominion.ui.bindingAdapter

import androidx.databinding.BindingAdapter
import android.widget.BaseAdapter
import android.widget.ListView


/**
 * Created by michaelkrakauer on 28/10/2017.
 */
object ListViewBindingAdapter {
    @BindingAdapter("adapter")
    @JvmStatic
    fun setAdapter(view: ListView, adapter: BaseAdapter) {
        view.adapter = adapter
    }
}