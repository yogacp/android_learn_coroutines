package makan.sayur.kol.presentation.homepage.module

import makan.sayur.kol.data.network.repository.SportDbDataStore
import makan.sayur.kol.data.network.repository.SportDbRepository
import makan.sayur.kol.presentation.homepage.presenter.HomePagePresenter
import makan.sayur.kol.presentation.homepage.router.HomepageRouter
import makan.sayur.kol.presentation.homepage.usecase.HomepageInteractor
import makan.sayur.kol.presentation.homepage.usecase.HomepageUseCase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module.module

/**
 * Created by Yoga C. Pranata on 17/01/2019.
 * Android Engineer
 */
val homePageModule = module {
    single<SportDbRepository> { SportDbDataStore(get(), get()) }
    single<HomepageUseCase> { HomepageInteractor(get()) }
    single { HomepageRouter(get(), androidContext()) }
    single { HomePagePresenter(get(), get()) }
}