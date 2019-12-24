package android.dominion.ui.activity

import android.dominion.R
import android.dominion.databinding.HostingBinding
import android.dominion.ui.base.BaseActivity
import android.dominion.ui.viewModel.HostingViewModel

class HostingActivity : BaseActivity<HostingViewModel, HostingBinding>(R.layout.activity_hosting) {
    override val viewModel = HostingViewModel(application)
}