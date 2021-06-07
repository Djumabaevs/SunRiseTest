package kg.sunrise.dasslerpro.ui.main.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.ViewModelProvider
import kg.sunrise.dasslerpro.base.fragment.BaseFragmentWithVM
import kg.sunrise.dasslerpro.databinding.FragmentMainBinding
import kg.sunrise.dasslerpro.ui.main.main.mainAdapter.PromotionAdapter
import org.koin.android.viewmodel.ext.android.viewModel

class MainFragment : BaseFragmentWithVM<FragmentMainBinding, MainViewModel>() {

    override val viewModel: MainViewModel by viewModel()
    override val progressBar: ConstraintLayout by lazy { binding.inclProgress.clProgress }

    private val promotionAdapter = PromotionAdapter()

    override fun init() {
        setAdapter()
    }

    private fun setAdapter() {
        binding.rvPromotions.adapter = promotionAdapter
        promotionAdapter.setData(viewModel.getData())
    }

    override fun makeRequests() {

    }


    override fun findTypeOfObject(data: Any?) {

    }

    override fun successRequest() {
    }

    override fun inflateView(inflater: LayoutInflater, container: ViewGroup?): FragmentMainBinding {
        return FragmentMainBinding.inflate(inflater)
    }


}