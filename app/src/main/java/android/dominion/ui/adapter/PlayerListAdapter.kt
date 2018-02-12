package android.dominion.ui.adapter

import android.databinding.*
import android.dominion.R
import android.dominion.data.PlayerType
import android.dominion.databinding.AddPlayerListBinding
import android.dominion.databinding.AddPlayerListFooterBinding
import android.dominion.ui.util.ListItemType
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter

/**
 * Created by michaelkrakauer on 25/12/2017.
 */
class PlayerListAdapter(private var players: MutableList<PlayerType>,
                        private var footerCallback: () -> Unit,
                        private var onTypeChangeCallback: (Int, PlayerType) -> Unit) : BaseAdapter() {

    override fun getView(position: Int, previousView: View?, parent: ViewGroup?): View {
        val layoutInflater = LayoutInflater.from(parent?.context)

        if (position != players.count()) {
            val binding: AddPlayerListBinding = if (previousView == null || position < players.count()) {
                DataBindingUtil.inflate(layoutInflater, R.layout.list_item_add_player, parent, false)
            } else {
                DataBindingUtil.findBinding(previousView)
            }

            val viewModel = PlayerListItemViewModel(position, onTypeChangeCallback)
            viewModel.bind(players[position], position)
            binding.viewModel = viewModel

            return binding.root
        } else {
            val binding: AddPlayerListFooterBinding = DataBindingUtil.inflate(layoutInflater, R.layout.list_item_add_player_footer, parent, false)
            val viewModel = PlayerListFooterViewModel(footerCallback)
            binding.viewModel = viewModel

            return binding.root
        }
    }

    override fun getItemViewType(position: Int)
            = when (position) {
        players.count() -> ListItemType.FOOTER
        else -> ListItemType.ITEM
    }.value


    override fun getItem(position: Int): Any {
        return players[position]
    }

    override fun getItemId(position: Int) = position.toLong()

    override fun getCount(): Int = players.count() + 1

    class PlayerListItemViewModel(private var playerIndex: Int,
                                  private var callback: (Int, PlayerType) -> Unit) {
        private var ignoreUpdates = false
        val name = ObservableField<String>("LocalPlayerBase $playerIndex")
        val playerTypes = ObservableArrayList<String>().apply { addAll(PlayerType.values().filter { it != PlayerType.USER }.map { it.name }) }
        val selectedPlayerTypeIndex = ObservableInt(0).apply {
            addOnPropertyChangedCallback(object : Observable.OnPropertyChangedCallback() {
                override fun onPropertyChanged(p0: Observable?, p1: Int) {
                    (p0 as? ObservableInt)?.let {
                        if (!ignoreUpdates) {
                            callback(playerIndex, PlayerType.AGGRESSIVE.byIndex(it.get()))
                        }
                    }
                }
            })
        }

        fun bind(player: PlayerType, position: Int) {
            playerIndex = position
            ignoreUpdates = true
            selectedPlayerTypeIndex.set(PlayerType.values().indexOf(player))
            ignoreUpdates = false
            name.set("LocalPlayerBase $playerIndex")
        }
    }

    class PlayerListFooterViewModel(private var callback: () -> Unit) {
        fun add() {
            callback()
        }
    }

    fun updateList(updatedList: MutableList<PlayerType>) {
        players = updatedList
        notifyDataSetChanged()
    }
}