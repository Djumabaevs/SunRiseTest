package kg.sunrise.dasslerpro.ui.main.handbook

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kg.sunrise.dasslerpro.R

class HandbookFragment : Fragment() {

    companion object {
        fun newInstance() = HandbookFragment()
    }

    private lateinit var viewModel: HandbookViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_handbook, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(HandbookViewModel::class.java)
        // TODO: Use the ViewModel
    }

}