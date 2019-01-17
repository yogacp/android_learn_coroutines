package makan.sayur.kol.presentation.homepage.usecase

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.withContext
import makan.sayur.kol.data.network.repository.SportDbRepository
import makan.sayur.kol.data.responses.leagues.Leagues
import makan.sayur.kol.data.responses.teams.Teams
import makan.sayur.kol.external.dispatchers.DispatchersProvider
import retrofit2.Response

/**
 * Created by Yoga C. Pranata on 17/01/2019.
 * Android Engineer
 */
class HomepageInteractor(
    private val repository: SportDbRepository,
    private val dispatcher: DispatchersProvider
) : HomepageUseCase {

    override suspend fun searchAllTeams(league: String): Deferred<Response<Teams.Response>> {
        return withContext(dispatcher.mainThread()) {
            withContext(dispatcher.io()) { repository.searchAllTeams(league) }
        }
    }

    override suspend fun getAllLeagues(): Deferred<Response<Leagues.Response>> {
        return withContext(dispatcher.mainThread()) {
            withContext(dispatcher.io()) { repository.getAllLeagues() }
        }
    }
}