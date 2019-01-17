package makan.sayur.kol.data.network.services

import kotlinx.coroutines.Deferred
import makan.sayur.kol.data.responses.leagues.Leagues
import makan.sayur.kol.data.responses.teams.Teams
import makan.sayur.kol.external.constants.RestConstant
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Yoga C. Pranata on 17/01/2019.
 * Android Engineer
 */
interface SportDbServices {
    @GET(RestConstant.SPORTDB.searchAllTeams)
    fun searchAllTeams(@Query("l") l: String): Deferred<Response<Teams.Response>>

    @GET(RestConstant.SPORTDB.getAllLeagues)
    fun getAllLeagues(): Deferred<Response<Leagues.Response>>
}