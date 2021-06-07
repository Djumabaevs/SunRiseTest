package kg.sunrise.dasslerpro.modules

import kg.sunrise.dasslerpro.App.Companion.context
import org.koin.dsl.module
import retrofit2.Retrofit

private val retrofit : Retrofit = createNetworkClient(context)

val networkModule = module {
}