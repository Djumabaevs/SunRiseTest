package kg.sunrise.dasslerpro.ui.preface

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import kg.sunrise.dasslerpro.base.fragment.BaseFragment
import kg.sunrise.dasslerpro.databinding.FragmentPrefaceBinding

class PrefaceFragment : BaseFragment<FragmentPrefaceBinding>() {
    override fun inflateView(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentPrefaceBinding {
        return FragmentPrefaceBinding.inflate(inflater)
    }

    override fun init() {
        // todo :REMOVE
        binding.ivPreface.setOnClickListener {
            val action = PrefaceFragmentDirections.actionPrefaceFragmentToSliderFragment()
            findNavController().navigate(action)
        }
    }
}