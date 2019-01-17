package makan.sayur.kol.presentation.homepage.presenter

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import makan.sayur.kol.data.responses.teams.Teams
import makan.sayur.kol.external.dispatchers.DispatchersProvider
import makan.sayur.kol.presentation.homepage.contract.HomePageContract
import makan.sayur.kol.presentation.homepage.usecase.HomepageUseCase

/**
 * Created by Yoga C. Pranata on 17/01/2019.
 * Android Engineer
 */
class HomePagePresenter(
    private val usecase: HomepageUseCase,
    dispatcher: DispatchersProvider
) : HomePageContract.UserActionListener {

    var mLeague = ""
    var mArrLeagues = ArrayList<String>()
    var mTeamsData = ArrayList<Teams.TeamsData>()

    private var view: HomePageContract.View? = null
    private val job = SupervisorJob()
    private val scope = CoroutineScope(dispatcher.mainThread() + job)

    override fun onAttachedView(activity: HomePageContract.View) {
        view = activity
        view?.initData()
    }

    override fun getAllLeagues() {
        scope.launch {
            view?.showProgressBar()
            view?.hideEmptyView()

            try {
                val response = usecase.getAllLeagues().await()
                val leaguesName = ArrayList<String>()
                response.leagues?.forEach { leaguesName.add(it.strLeague!!) }
                view?.setupLeaguesAdapter(leaguesName)
            } catch (error: Exception) {
                view?.showEmptyView()
                view?.clearTeamList()
                view?.showError("Error while fetching club list")
            } finally {
                view?.hideProgressBar()
            }
        }
    }

    override fun getListFootballClub(league: String) {
        scope.launch {
            view?.showProgressBar()
            view?.hideEmptyView()

            try {
                val response = usecase.searchAllTeams(league).await()
                val teamList = ArrayList<Teams.TeamsData>()
                response.teams?.forEach {
                    teamList.add(it)
                }
                view?.setupAdapter(teamList)
            } catch (error: Exception) {
                view?.showEmptyView()
                view?.clearTeamList()
                view?.showError("Error while fetching club list")
            } finally {
                view?.hideProgressBar()
            }
        }
    }

}