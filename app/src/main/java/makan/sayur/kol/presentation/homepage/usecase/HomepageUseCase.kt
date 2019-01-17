package makan.sayur.kol.presentation.homepage.usecase

import kotlinx.coroutines.Deferred
import makan.sayur.kol.data.responses.leagues.Leagues
import makan.sayur.kol.data.responses.teams.Teams

/**
 * Created by Yoga C. Pranata on 17/01/2019.
 * Android Engineer
 */
interface HomepageUseCase {
    suspend fun searchAllTeams(league: String) : Deferred<Teams.Response>
    suspend fun getAllLeagues() : Deferred<Leagues.Response>
}