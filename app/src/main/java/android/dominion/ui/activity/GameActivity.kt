package android.dominion.ui.activity

import android.dominion.R
import android.dominion.databinding.GameBinding
import android.dominion.ui.base.BaseActivity
import android.dominion.ui.viewModel.GameViewModel
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import kotlinx.android.synthetic.main.activity_game.*

class GameActivity : BaseActivity<GameViewModel, GameBinding>(R.layout.activity_game) {
    override val viewModel = GameViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        s_supply_selector.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) = Unit

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                viewModel.displayCardPile(p2)
            }
        }
    }
}
