package android.dominion.ui.adapter

import android.dominion.data.card.BaseCard
import android.dominion.data.card.CardTemplate
import android.dominion.databinding.ListItemBoardCardBinding
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class BoardRecyclerViewAdapter(private var boardMap: Map<CardTemplate, List<BaseCard>>,
                               private val type: Type,
                               private val clickCallback: (BaseCard) -> Unit) : RecyclerView.Adapter<BoardCardViewHolder>() {

    private var orderMap = mutableMapOf<Int, CardTemplate>()

    private fun updateOrder() {
        orderMap.clear()
        when (type) {
            Type.KINGDOM -> {
                boardMap.filter { it.value.any() }
                        .keys.sortedWith(Comparator { first, second ->
                    if (first.cost < second.cost) {
                        -1
                    } else if (first.cost > second.cost) {
                        1
                    } else {
                        if (first.name < second.name) {
                            -1
                        } else {
                            1
                        }
                    }
                })
                        .forEachIndexed { index, cardTemplate ->
                            orderMap[index] = cardTemplate
                        }
            }
            Type.SUPPLY -> {
                boardMap.filter { it.value.any() }
                        .keys.sortedBy { it.ordinal }
                        .forEachIndexed { index, cardTemplate ->
                            orderMap[index] = cardTemplate
                        }
            }
        }
    }

    fun updateCards(newItems: Map<CardTemplate, List<BaseCard>>) {
        boardMap = newItems
        updateOrder()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BoardCardViewHolder {
        val binding = ListItemBoardCardBinding.inflate(LayoutInflater.from(parent.context))

        return BoardCardViewHolder(binding)
    }

    override fun getItemCount(): Int = boardMap.count { it.value.any() }

    override fun onBindViewHolder(holder: BoardCardViewHolder, position: Int) {
        val card = orderMap[position]!!
        holder.updateCard(card to boardMap.getValue(card))
    }

    enum class Type {
        KINGDOM,
        SUPPLY
    }
}

class BoardCardViewHolder(private val binding: ListItemBoardCardBinding)
    : RecyclerView.ViewHolder(binding.root) {
    private lateinit var deck: Pair<CardTemplate, List<BaseCard>>

    fun updateCard(updatedCard: Pair<CardTemplate, List<BaseCard>>) {
        deck = updatedCard
        binding.ivCardImage.setImageDrawable(ContextCompat.getDrawable(binding.root.context, deck.first.imageResId))
        binding.tvCount.text = deck.second.count().toString()
    }
}