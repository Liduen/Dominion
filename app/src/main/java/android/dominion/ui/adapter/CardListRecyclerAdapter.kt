package android.dominion.ui.adapter

import android.databinding.DataBindingUtil
import android.databinding.ObservableField
import android.dominion.R
import android.dominion.data.card.BaseCard
import android.dominion.data.card.basicSupply.Copper
import android.dominion.databinding.CardListItemBinding
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter

/**
 * Created by michaelkrakauer on 03/01/2018.
 */
class CardListRecyclerAdapter(private val cards: MutableList<Pair<BaseCard, Int>>,
                              private val cardClickCallback: (Int) -> Unit,
                              private val displayCardCount: Boolean) : BaseAdapter() {

    override fun getView(position: Int, previousView: View?, parent: ViewGroup?): View {
        val inflater = LayoutInflater.from(parent?.context)
        val binding: CardListItemBinding = previousView?.let {
            DataBindingUtil.findBinding<CardListItemBinding>(it)
        } ?: DataBindingUtil.inflate(inflater, R.layout.list_item_card, parent, false)

        if (binding.viewModel == null) {
            binding.viewModel = CardListItemViewModel(cardClickCallback, displayCardCount)
        }

        binding.viewModel?.bind(position, cards.toList()[position])

        return binding.root
    }

    override fun getItem(position: Int) = cards[position]

    override fun getItemId(position: Int) = position.toLong()

    override fun getCount(): Int = cards.count()

    class CardListItemViewModel(private val clickCallback: (Int) -> Unit, displayCardCount: Boolean) {
        var displayCount = ObservableField<Boolean>(displayCardCount)
        val card = ObservableField<BaseCard>(Copper())
        var cardCount = ObservableField("")
        var position = -1

        fun bind(position: Int, cardPair: Pair<BaseCard, Int>) {
            this.position = position
            card.set(cardPair.first)
            cardCount.set(cardPair.second.toString())
        }

        fun onClick() {
            clickCallback(position)
        }
    }
}