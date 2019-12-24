package android.dominion.ui.bindingAdapter

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by michaelkrakauer on 11/12/2017.
 */
object RecyclerViewBindingAdapter {
    @JvmStatic
    @BindingAdapter("recyclerAdapter")
    fun setRecyclerAdapter(recyclerView: androidx.recyclerview.widget.RecyclerView, viewAdapter: androidx.recyclerview.widget.RecyclerView.Adapter<*>?) {
        viewAdapter?.let {
            recyclerView.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(recyclerView.context)
            recyclerView.adapter = it
        }
    }
}