package kg.sunrise.dasslerpro.ui.customLayouts.dialogFragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import kg.sunrise.dasslerpro.base.fragment.BaseDialogFragment
import kg.sunrise.dasslerpro.databinding.DialogSuccessFragmentBinding
import kg.sunrise.dasslerpro.utils.extensions.visible


class SuccessDialogFragment(
    @DrawableRes
    private val iconRes: Int,
    @StringRes
    private val textRes: Int,
    @StringRes
    private val iconTextRes: Int? = null,
    private val onBtnClick: (() -> Unit)? = null
) : BaseDialogFragment<DialogSuccessFragmentBinding>() {

    override fun inflateView(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): DialogSuccessFragmentBinding {
        return DialogSuccessFragmentBinding.inflate(inflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.ivIcon.setImageResource(iconRes)
        binding.tvDesc.setText(textRes)

        iconTextRes?.let { iconTextRes ->
            binding.apply {
                gIcon.visible()
                tvIconDesc.setText(iconTextRes)
            }
        }

        binding.btnSuccess.setOnClickListener {
            onBtnClick?.invoke()
            dismiss()
        }
    }
}