package makan.sayur.kol.presentation.homepage.contract

import android.widget.ImageView
import android.widget.ProgressBar
import makan.sayur.kol.data.responses.teams.Teams

/**
 * Created by Yoga C. Pranata on 17/01/2019.
 * Android Engineer
 */
class HomePageContract {
    interface View {
        fun initData()
        fun loadImageToImageView(imageSource: String?, imgView: ImageView, progressBar: ProgressBar)
        fun setupAdapter(fcList: ArrayList<Teams.TeamsData>?)
        fun setupLeaguesAdapter(leagues: ArrayList<String?>)
        fun setupToolbar(title: String?)
        fun setupUiSpinner()
        fun showError(message: String)
        fun showProgressBar()
        fun hideProgressBar()
        fun showEmptyView()
        fun hideEmptyView()
        fun clearTeamList()
    }

    interface UserActionListener {
        fun onAttachedView(activity: View)
        fun getListFootballClub(league: String)
        fun getAllLeagues()
        fun emptyOrErrorResult()
    }

    interface Router {
        fun goToDetailPage(fcName: String?, fcDesc: String?, fcImage: String?)
    }
}