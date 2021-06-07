package kg.sunrise.dasslerpro.modules

import kg.sunrise.dasslerpro.ui.main.main.MainViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MainViewModel() }
}