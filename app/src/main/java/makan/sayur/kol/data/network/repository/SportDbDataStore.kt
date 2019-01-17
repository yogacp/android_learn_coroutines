package makan.sayur.kol.data.network.repository

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import makan.sayur.kol.data.network.services.SportDbServices
import makan.sayur.kol.data.responses.leagues.Leagues
import makan.sayur.kol.data.responses.teams.Teams

/**
 * Created by Yoga C. Pranata on 17/01/2019.
 * Android Engineer
 */
class SportDbDataStore (val services: SportDbServices) : SportDbRepository {

    override suspend fun searchAllTeams(league: String): Deferred<Teams.Response> {
        return coroutineScope {
            async { services.searchAllTeams(league).await() }
        }
    }

    override suspend fun getAllLeagues(): Deferred<Leagues.Response> {
        return coroutineScope {
            async { services.getAllLeagues().await() }
        }
    }

}