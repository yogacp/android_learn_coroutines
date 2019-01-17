package makan.sayur.kol.external.dispatchers

import kotlinx.coroutines.CoroutineDispatcher

/**
 * Created by Yoga C. Pranata on 17/01/2019.
 * Android Engineer
 */
interface DispatchersProvider {
    fun ui(): CoroutineDispatcher
    fun default(): CoroutineDispatcher
    fun unconfined(): CoroutineDispatcher
    fun io(): CoroutineDispatcher
    fun mainThread() : CoroutineDispatcher
}