package android.dominion.ui.adapter

import android.dominion.data.card.BaseCard
import android.dominion.databinding.ListItemHandCardBinding
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class HandRecyclerViewAdapter(private var items: List<BaseCard>,
                              private val clickCallback: (BaseCard) -> Unit) : RecyclerView.Adapter<HandCardViewHolder>() {

    fun updateCards(newItems: List<BaseCard>) {
        items = newItems
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HandCardViewHolder {
        val binding = ListItemHandCardBinding.inflate(LayoutInflater.from(parent.context))

        return HandCardViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: HandCardViewHolder, position: Int) {
        val card = items[position]
        holder.updateCard(card)
    }
}

class HandCardViewHolder(private val binding: ListItemHandCardBinding)
    : RecyclerView.ViewHolder(binding.root) {
    private lateinit var card: BaseCard

    fun updateCard(updatedCard: BaseCard) {
        card = updatedCard
        binding.ivCardImage.setImageDrawable(ContextCompat.getDrawable(binding.root.context, card.template.imageResId))
    }
}