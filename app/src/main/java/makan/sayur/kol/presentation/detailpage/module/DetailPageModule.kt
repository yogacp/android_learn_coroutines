package makan.sayur.kol.presentation.detailpage.module

import makan.sayur.kol.presentation.detailpage.presenter.DetailPagePresenter
import org.koin.dsl.module.module

/**
 * Created by Yoga C. Pranata on 17/01/2019.
 * Android Engineer
 */
val detailPageModule = module {
    single { DetailPagePresenter() }
}