package android.dominion.ui.activity

import android.dominion.R
import android.dominion.databinding.MenuBinding
import android.dominion.ui.base.BaseActivity
import android.dominion.ui.provider.Navigator
import android.dominion.ui.viewModel.MenuViewModel

class MenuActivity : BaseActivity<MenuViewModel, MenuBinding>(R.layout.activity_menu), Navigator {
    override val viewModel = MenuViewModel(this)
}