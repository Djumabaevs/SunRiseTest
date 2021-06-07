package kg.sunrise.dasslerpro.base.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import kg.sunrise.dasslerpro.R

abstract class BaseDialogFragment<Binding : ViewBinding> : DialogFragment() {

    private var _binding : Binding? = null
    val binding : Binding
        get() =  _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        _binding = inflateView(inflater, container)

        return binding.root
    }

    abstract fun inflateView(inflater: LayoutInflater, container: ViewGroup?): Binding

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setStyle(STYLE_NORMAL, R.style.Dialog);
    }
}