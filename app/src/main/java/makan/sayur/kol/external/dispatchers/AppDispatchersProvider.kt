package makan.sayur.kol.external.dispatchers

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi

/**
 * Created by Yoga C. Pranata on 17/01/2019.
 * Android Engineer
 */
class AppDispatchersProvider : DispatchersProvider {
    override fun ui(): CoroutineDispatcher = Dispatchers.Main
    override fun io(): CoroutineDispatcher = Dispatchers.IO
    override fun mainThread(): CoroutineDispatcher = Dispatchers.Main
    override fun default(): CoroutineDispatcher = Dispatchers.Default

    @ExperimentalCoroutinesApi
    override fun unconfined(): CoroutineDispatcher = Dispatchers.Unconfined
}