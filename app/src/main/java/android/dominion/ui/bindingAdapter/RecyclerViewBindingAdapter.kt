package android.dominion.ui.bindingAdapter

import android.databinding.BindingAdapter
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

/**
 * Created by michaelkrakauer on 11/12/2017.
 */
object RecyclerViewBindingAdapter {
    @JvmStatic
    @BindingAdapter("recyclerAdapter")
    fun setRecyclerAdapter(recyclerView: RecyclerView, viewAdapter: RecyclerView.Adapter<*>?) {
        viewAdapter?.let {
            recyclerView.layoutManager = LinearLayoutManager(recyclerView.context)
            recyclerView.adapter = it
        }
    }
}