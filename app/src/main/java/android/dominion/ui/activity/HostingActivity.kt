package android.dominion.ui.activity

import android.dominion.R
import android.dominion.databinding.HostingBinding
import android.dominion.ui.base.BaseActivity
import android.dominion.ui.provider.Navigator
import android.dominion.ui.viewModel.HostingViewModel
import android.os.Bundle
import android.view.MenuItem

class HostingActivity : BaseActivity<HostingViewModel, HostingBinding>(R.layout.activity_hosting),
        Navigator {
    override val viewModel = HostingViewModel(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(findViewById(R.id.action_toolbar))
        supportActionBar?.let {
            it.setDisplayHomeAsUpEnabled(true)
            it.title = "Hosting Activity"
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        item?.let {
            if (it.itemId == android.R.id.home) {
                finish()
            }
        }

        return super.onOptionsItemSelected(item)
    }
}