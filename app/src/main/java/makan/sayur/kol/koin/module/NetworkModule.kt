package makan.sayur.kol.koin.module

import makan.sayur.kol.data.network.httpclient.coroutinesRestClient
import makan.sayur.kol.data.network.httpclient.coroutinesServices
import makan.sayur.kol.data.network.httpclient.httpClient
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module.module

/**
 * Created by Yoga C. Pranata on 17/01/2019.
 * Android Engineer
 */
val networkModule = module {
    factory { httpClient(androidApplication()) }
    single { coroutinesRestClient(get()) }
    single { coroutinesServices(get()) }
}