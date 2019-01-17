package makan.sayur.kol.external.constants

import makan.sayur.kol.BuildConfig

/**
 * Created by Yoga C. Pranata on 17/01/2019.
 * Android Engineer
 */
object RestConstant {

    /**
     * List of endpoint TheSportDb
     */
    object SPORTDB {
        const val BASE_APIKEY = "api/v1/json/${BuildConfig.TSDB_API_KEY}"
        const val searchAllTeams = "$BASE_APIKEY/search_all_teams.php"
        const val getImageTeams = "$BASE_APIKEY/searchteams.php"
        const val getAllLeagues = "$BASE_APIKEY/search_all_leagues.php?s=Soccer"
        const val searchNextEvents = "$BASE_APIKEY/eventsnextleague.php"
        const val searchPrevEvents = "$BASE_APIKEY/eventspastleague.php"
        const val getDetailEvents = "$BASE_APIKEY/lookupevent.php"
    }
}