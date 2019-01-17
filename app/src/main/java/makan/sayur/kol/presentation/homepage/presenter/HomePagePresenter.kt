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
    var mArrLeagues = ArrayList<String?>()
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

            val leaguesName = ArrayList<String?>()

            try {
                val response = usecase.getAllLeagues().await()

                response.let {
                    when {
                        it.isSuccessful -> {
                            if(it.body() != null) {
                                it.body()?.leagues?.forEach { leagues -> leaguesName.add(leagues.strLeague) }
                                view?.setupLeaguesAdapter(leaguesName)
                            } else {
                                emptyOrErrorResult()
                            }
                        }
                        else -> {
                            emptyOrErrorResult()
                        }
                    }
                }
            } catch (error: Exception) {
                view?.showError("Error while fetching club list")
            } finally {
                view?.hideProgressBar()

                if(leaguesName.isEmpty()) {
                    emptyOrErrorResult()
                }
            }
        }
    }

    override fun getListFootballClub(league: String) {
        scope.launch {
            view?.showProgressBar()
            view?.hideEmptyView()

            val teamList = ArrayList<Teams.TeamsData>()

            try {
                val response = usecase.searchAllTeams(league).await()

                response.let {
                    when {
                        it.isSuccessful -> {
                            if(it.body() != null) {
                                it.body()?.teams?.forEach { teams -> teamList.add(teams) }
                                view?.setupAdapter(teamList)
                            }
                        }
                        else -> {
                            emptyOrErrorResult()
                        }
                    }
                }
            } catch (error: Exception) {
                view?.showError("Error while fetching club list")
            } finally {
                view?.hideProgressBar()

                if(teamList.isEmpty()) {
                    emptyOrErrorResult()
                }
            }
        }
    }

    override fun emptyOrErrorResult() {
        view?.showEmptyView()
        view?.clearTeamList()
    }

}