package android.dominion.ui.activity

import android.dominion.R
import android.dominion.databinding.GameBinding
import android.dominion.ui.base.BaseActivity
import android.dominion.ui.viewModel.GameViewModel
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.get

class GameActivity : BaseActivity<GameViewModel, GameBinding>(R.layout.activity_game) {
    override val viewModel by lazy {
        ViewModelProviders.of(this).get<GameViewModel>()
    }
}
