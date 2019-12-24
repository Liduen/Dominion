package android.dominion.ui.activity

import android.dominion.R
import android.dominion.databinding.GameBinding
import android.dominion.ui.base.BaseActivity
import android.dominion.ui.viewModel.GameViewModel

class GameActivity : BaseActivity<GameViewModel, GameBinding>(R.layout.activity_game) {
    override val viewModel = GameViewModel()

}
