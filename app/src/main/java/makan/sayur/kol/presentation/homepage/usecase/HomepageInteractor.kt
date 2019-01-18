package makan.sayur.kol.presentation.homepage.usecase

import kotlinx.coroutines.Deferred
import makan.sayur.kol.data.network.repository.SportDbRepository
import makan.sayur.kol.data.responses.leagues.Leagues
import makan.sayur.kol.data.responses.teams.Teams
import retrofit2.Response

/**
 * Created by Yoga C. Pranata on 17/01/2019.
 * Android Engineer
 */
class HomepageInteractor(private val repository: SportDbRepository) : HomepageUseCase {

    override suspend fun searchAllTeams(league: String): Deferred<Response<Teams.Response>> {
        return repository.searchAllTeams(league)
    }

    override suspend fun getAllLeagues(): Deferred<Response<Leagues.Response>> {
        return repository.getAllLeagues()
    }
}