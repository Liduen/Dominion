package android.dominion.ui.base

import androidx.databinding.DataBindingUtil
import android.dominion.BR
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 * Created by michaelkrakauer on 16/10/2017.
 */
abstract class BaseActivity<out ViewModel, DataBinding>(private val layoutId: Int) : AppCompatActivity()
        where ViewModel : BaseViewModel,
              DataBinding : androidx.databinding.ViewDataBinding {

    protected abstract val viewModel: ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindToLayout()
        viewModel.initialize()
    }

    private fun bindToLayout() {
        val binding: DataBinding = DataBindingUtil.setContentView(this, layoutId)
        binding.setVariable(BR.viewModel, viewModel)
    }
}