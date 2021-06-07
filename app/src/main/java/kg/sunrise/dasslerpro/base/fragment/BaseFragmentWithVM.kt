package kg.sunrise.dasslerpro.base.fragment

import android.os.Bundle
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding
import kg.sunrise.dasslerpro.base.viewModel.BaseViewModel
import kg.sunrise.dasslerpro.utils.extensions.gone
import kg.sunrise.dasslerpro.utils.extensions.setNoInternetLayoutVisibility
import kg.sunrise.dasslerpro.utils.extensions.toast
import kg.sunrise.dasslerpro.utils.extensions.visible
import kg.sunrise.dasslerpro.utils.network.ErrorCode
import kg.sunrise.dasslerpro.utils.network.State
import kg.sunrise.dasslerpro.utils.network.parseErrorCode
import timber.log.Timber

abstract class BaseFragmentWithVM<Binding: ViewBinding, out VM : BaseViewModel> : BaseFragment<Binding>() {

    protected abstract val viewModel: VM
    protected abstract val progressBar: ConstraintLayout
    protected open var isToShowProgress = true

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initIncludeLayouts()
        initViewModel()
        initErrorStatus()
        bindRefreshBtn()
        makeRequests()
    }

    protected open fun bindRefreshBtn() {
    }

    abstract fun makeRequests()

    protected open fun initIncludeLayouts() { }

    private fun initErrorStatus() {
        if (!viewModel.hasInternet) {
            displayErrorLayout(true, ErrorCode.NOINTERNET)
        }
    }

    private fun initViewModel() {
        viewModel.state.observe(viewLifecycleOwner, { state ->
            if (state == null) {

            } else {
                val state = state
                when (state) {
                    is State.LoadingState -> {
                        if (isToShowProgress) {
                            when {
                                state.isLoading -> progressBar.visible()
                                else -> progressBar.gone()
                            }
                        }
                    }

                    is State.ErrorState -> {
                        handleError(state)
                    }

                    is State.SuccessState -> {
                        displayErrorLayout(false)

                        when (state) {
                            is State.SuccessState.NoItemState -> {
                                successRequest()
                            }

                            is State.SuccessState.SuccessObjectState<*> -> {
                                findTypeOfObject(state.data)
                            }

                            is State.SuccessState.SuccessListState<*> -> {
                                findTypeOfListObject(state.data)
                            }
                            else -> { }
                        }
                    }

                    else -> { }
                }
            }
        })
    }

    abstract fun findTypeOfObject(data: Any?)

    abstract fun successRequest()

    protected open fun findTypeOfListObject(data: ArrayList<*>) {
    }

    private fun handleError(state: State.ErrorState) {
        Timber.e("err ${state.message}")
//        FirebaseCrashlytics.getInstance().also {
//            it.setCustomKey(state.errorCode.toString(), state.message)
//            it.log(state.message)
//            it.recordException(Throwable(state.errorCode.toString()))
//        }.sendUnsentReports()

        parseErrorCode(
            state,
            displayErrorLayout = { isError, errorCode ->
                displayErrorLayout(isError, errorCode)
            },
            handleCustomError = { message ->
                handleCustomError(message)
            },
            showErrorAsDialog = { message ->
                showErrorAsDialog(message)
            }
        )
    }

    protected open fun handleCustomError(message: String) {
        showErrorAsDialog(message)
    }

    private fun showErrorAsDialog(message: String) {
        requireContext().toast(message)
    }

    private fun displayErrorLayout(isError: Boolean, code: ErrorCode? = null) {
        if (isError && code != null) {
            viewModel.hasInternet = code != ErrorCode.NOINTERNET
            requireActivity().setNoInternetLayoutVisibility(if (code == ErrorCode.NOINTERNET) View.VISIBLE else View.GONE)
        } else {
            viewModel.hasInternet = true
            requireActivity().setNoInternetLayoutVisibility(View.GONE)
        }
    }
}