package makan.sayur.kol.koin.component

import makan.sayur.kol.koin.module.appModule
import makan.sayur.kol.koin.module.networkModule
import makan.sayur.kol.presentation.detailpage.module.detailPageModule
import makan.sayur.kol.presentation.homepage.module.homePageModule
import org.koin.dsl.module.Module

/**
 * Created by Yoga C. Pranata on 17/01/2019.
 * Android Engineer
 */
val appComponent: List<Module> = listOf(appModule, networkModule, homePageModule, detailPageModule)