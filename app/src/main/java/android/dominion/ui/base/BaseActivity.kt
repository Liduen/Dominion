package android.dominion.ui.base

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * Created by michaelkrakauer on 16/10/2017.
 */
abstract class BaseActivity<out ViewModel, DataBinding>(private val layoutId: Int) : AppCompatActivity()
        where ViewModel : BaseViewModel,
              DataBinding : android.databinding.ViewDataBinding {

    companion object {
        val VIEW_MODEL_ERROR = "ViewModel not found, ensure there's a variable in your activity's XML named \"viewModel\""
    }

    protected abstract val viewModel: ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindToLayout()

        viewModel.attachView(this, savedInstanceState)
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.detachView()
    }

    private fun bindToLayout() {
        val binding: DataBinding = DataBindingUtil.setContentView(this, layoutId)
        (binding.javaClass.methods.firstOrNull { it.name == "setViewModel" }
                ?: throw IllegalArgumentException(VIEW_MODEL_ERROR))
                .invoke(binding, viewModel)
    }
}