package android.dominion.ui.activity

import android.dominion.R
import android.dominion.databinding.GameBinding
import android.dominion.ui.adapter.HandRecyclerViewAdapter
import android.dominion.ui.base.BaseActivity
import android.dominion.ui.viewModel.GameViewModel
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.get
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class GameActivity : BaseActivity<GameViewModel, GameBinding>(R.layout.activity_game) {

    lateinit var handAdapter: HandRecyclerViewAdapter
    override val viewModel by lazy {
        ViewModelProviders.of(this).get<GameViewModel>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        handAdapter = HandRecyclerViewAdapter(viewModel.hand.value!!)
        viewModel.hand.observe(this, Observer {
            handAdapter.updateCards(it)
        })
        viewModel.board.observe(this, Observer {

        })
        viewModel.initialize()
        binding.rvHand.adapter = handAdapter
        binding.rvHand.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
    }
}
