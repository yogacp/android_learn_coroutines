package makan.sayur.kol.data.network.repository

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.withContext
import makan.sayur.kol.data.network.services.SportDbServices
import makan.sayur.kol.data.responses.leagues.Leagues
import makan.sayur.kol.data.responses.teams.Teams
import makan.sayur.kol.external.dispatchers.DispatchersProvider
import retrofit2.Response

/**
 * Created by Yoga C. Pranata on 17/01/2019.
 * Android Engineer
 */
class SportDbDataStore (
    private val services: SportDbServices,
    private val dispatcher: DispatchersProvider
) : SportDbRepository {

    override suspend fun searchAllTeams(league: String): Deferred<Response<Teams.Response>> {
        return withContext(dispatcher.io()) {
            coroutineScope {
                async { services.searchAllTeams(league).await() }
            }
        }
    }

    override suspend fun getAllLeagues(): Deferred<Response<Leagues.Response>> {
        return withContext(dispatcher.io()) {
            coroutineScope {
                async { services.getAllLeagues().await() }
            }
        }
    }

}