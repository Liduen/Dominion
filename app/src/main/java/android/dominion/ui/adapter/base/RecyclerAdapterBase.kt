package android.dominion.ui.adapter.base

import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView

/**
 * Created by michaelkrakauer on 11/12/2017.
 */
abstract class RecyclerAdapterBase<ItemType>(private var items: MutableList<ItemType>)
    : RecyclerView.Adapter<RecyclerAdapterBase.ViewHolderBase>() {

    protected open val enableFooter = false
    protected open val enableHeader = false

    override fun getItemCount(): Int {
        var initialCount = items.count()

        if (enableHeader)
            initialCount++

        if (enableFooter)
            initialCount++

        return initialCount
    }

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            0 -> if (enableHeader) ListItemType.HEADER else ListItemType.ITEM
            else -> ListItemType.ITEM
        }.value
    }

    enum class ListItemType(val value: Int) {
        ITEM(1),
        HEADER(2),
        FOOTER(3)
    }


    abstract class ViewHolderBase(binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root)
}