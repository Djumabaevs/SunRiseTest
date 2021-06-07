package kg.sunrise.dasslerpro.ui.preface

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import kg.sunrise.dasslerpro.ui.main.MainActivity
import kg.sunrise.dasslerpro.R
import kg.sunrise.dasslerpro.base.fragment.BaseFragment
import kg.sunrise.dasslerpro.databinding.FragmentSliderBinding
import kg.sunrise.dasslerpro.dto.SliderInfoDto
import kg.sunrise.dasslerpro.ui.preface.sliderAdapter.SliderAdapter
import kg.sunrise.dasslerpro.utils.extensions.gone
import kg.sunrise.dasslerpro.utils.extensions.setOverScrollModeNever
import kg.sunrise.dasslerpro.utils.extensions.visible

class SliderFragment : BaseFragment<FragmentSliderBinding>() {

    private val sliderAdapter = SliderAdapter()

    private val sliderData = arrayListOf(
        SliderInfoDto(R.drawable.ic_slider_1, R.string.slider_desc_1),
        SliderInfoDto(R.drawable.ic_slider_2, R.string.slider_desc_2),
        SliderInfoDto(R.drawable.ic_slider_3, R.string.slider_desc_3)
    )

    private var pagePosition = 0

    override fun inflateView(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentSliderBinding {
        return FragmentSliderBinding.inflate(inflater)
    }

    override fun init() {
        initAdapter()
        initListeners()
    }

    private fun initListeners() {
        binding.btnNext.setOnClickListener {
            if (pagePosition == sliderAdapter.itemCount - 1) {
                navigateToMain()
            } else {
                pagePosition++
                binding.vpSlider.currentItem = pagePosition
            }
        }

        binding.tvSkip.setOnClickListener {
            navigateToMain()
        }
    }

    private fun initAdapter() {
        binding.apply {
            vpSlider.adapter = sliderAdapter
            sliderAdapter.setData(sliderData)
            indicator.setViewPager2(vpSlider)
            vpSlider.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)

                    binding.tvSliderDesc.setText(sliderData[position].str_id)
                    this@SliderFragment.pagePosition = position

                    when (position) {
                        0 -> {
                            binding.tvSkip.visible()
                            binding.btnNext.setText(R.string.Next)
                        }
                        1 -> {
                            binding.tvSkip.visible()
                            binding.btnNext.setText(R.string.Continue)
                        }
                        2 -> {
                            binding.tvSkip.gone()
                            binding.btnNext.setText(R.string.Begin)
                        }
                    }
                }
            })

            vpSlider.setOverScrollModeNever()

        }
    }

    private fun navigateToMain() {
        val intent = Intent(requireContext(), MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        startActivity(intent)
        requireActivity().overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }
}