package makan.sayur.kol.koin.module

import com.google.gson.Gson
import makan.sayur.kol.domain.router.ScreenRouter
import makan.sayur.kol.domain.router.ScreenRouterImpl
import makan.sayur.kol.external.dispatchers.AppDispatchersProvider
import makan.sayur.kol.external.dispatchers.DispatchersProvider
import org.koin.dsl.module.module

/**
 * Created by Yoga C. Pranata on 17/01/2019.
 * Android Engineer
 */
val appModule = module {
    factory<ScreenRouter> { ScreenRouterImpl() }
    factory<DispatchersProvider> { AppDispatchersProvider() }
    factory { Gson() }
}