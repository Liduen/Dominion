package android.dominion.ui.activity

import android.dominion.R
import android.dominion.databinding.GameBinding
import android.dominion.ui.adapter.BoardRecyclerViewAdapter
import android.dominion.ui.adapter.HandRecyclerViewAdapter
import android.dominion.ui.base.BaseActivity
import android.dominion.ui.viewModel.GameViewModel
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.get
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class GameActivity : BaseActivity<GameViewModel, GameBinding>(R.layout.activity_game) {

    private lateinit var handAdapter: HandRecyclerViewAdapter
    private lateinit var supplyBoardAdapter: BoardRecyclerViewAdapter
    private lateinit var kingdomBoardAdapter: BoardRecyclerViewAdapter
    override val viewModel by lazy {
        ViewModelProviders.of(this).get<GameViewModel>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        handAdapter = HandRecyclerViewAdapter(viewModel.hand.value!!) {}
        supplyBoardAdapter = BoardRecyclerViewAdapter(mapOf(), BoardRecyclerViewAdapter.Type.SUPPLY) {}
        kingdomBoardAdapter = BoardRecyclerViewAdapter(mapOf(), BoardRecyclerViewAdapter.Type.KINGDOM) {}
        viewModel.hand.observe(this, Observer {
            handAdapter.updateCards(it)
        })
        viewModel.board.observe(this, Observer {
            supplyBoardAdapter.updateCards(it.supplyCards)
            kingdomBoardAdapter.updateCards(it.kingdomCards)
        })
        viewModel.initialize()
        binding.rvHand.adapter = handAdapter
        binding.rvHand.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        binding.rvBoardSupply.adapter = supplyBoardAdapter
        binding.rvBoardSupply.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        binding.rvBoardKingdom.adapter = kingdomBoardAdapter
        binding.rvBoardKingdom.layoutManager = GridLayoutManager(this, 2, RecyclerView.HORIZONTAL, false)
    }
}
