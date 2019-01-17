package makan.sayur.kol.presentation.homepage.view

import android.net.Uri
import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ProgressBar
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_homepage.*
import kotlinx.android.synthetic.main.item_list_football.view.*
import makan.sayur.kol.R
import makan.sayur.kol.data.responses.teams.Teams
import makan.sayur.kol.external.adapter.setUp
import makan.sayur.kol.presentation.homepage.contract.HomePageContract
import makan.sayur.kol.presentation.homepage.presenter.HomePagePresenter
import makan.sayur.kol.presentation.homepage.router.HomepageRouter
import org.jetbrains.anko.toast
import org.koin.android.ext.android.inject

/**
 * Created by Yoga C. Pranata on 17/01/2019.
 * Android Engineer
 */
class HomePageActivity : AppCompatActivity(), HomePageContract.View, SwipeRefreshLayout.OnRefreshListener {

    val presenter: HomePagePresenter by inject()
    val router: HomepageRouter by inject()

    lateinit var mLayoutManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homepage)

        presenter.onAttachedView(this)
        mLayoutManager = GridLayoutManager(applicationContext, 1)
        mainSwipeLayout.setOnRefreshListener(this)
        setupToolbar(resources.getString(R.string.menu_football_list))
    }

    override fun onBackPressed() {
        finish()
    }

    override fun onRefresh() {
        presenter.getListFootballClub(presenter.mLeague)
    }

    override fun initData() {
        presenter.getAllLeagues()
    }

    override fun showProgressBar() {
        mainSwipeLayout.isRefreshing = true
    }

    override fun hideProgressBar() {
        mainSwipeLayout.isRefreshing = false
    }

    override fun showEmptyView() {
        rlLeaguesEmpty.visibility = View.VISIBLE
        rvFootballClubList.visibility = View.GONE
    }

    override fun hideEmptyView() {
        rlLeaguesEmpty.visibility = View.GONE
        rvFootballClubList.visibility = View.VISIBLE
    }

    override fun clearTeamList() {
        presenter.mTeamsData.clear()
    }

    override fun showError(message: String) {
        toast(message)
    }

    override fun setupToolbar(title: String?) {
        supportActionBar?.title = title
    }

    override fun setupUiSpinner() {
        spLeagues.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {}
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                presenter.mLeague = Uri.parse(presenter.mArrLeagues[position]).toString()
                presenter.getListFootballClub(presenter.mLeague)
            }
        }
    }

    override fun loadImageToImageView(imageSource: String?, imgView: ImageView, progressBar: ProgressBar) {
        Picasso.get()
            .load(imageSource)
            .fit()
            .centerCrop()
            .into(imgView, object : Callback {
                override fun onSuccess() {
                    progressBar.visibility = View.GONE
                }

                override fun onError(e: Exception?) {
                    progressBar.visibility = View.GONE
                }
            })
    }

    override fun setupAdapter(fcList: ArrayList<Teams.TeamsData>?) {
        if (fcList != null) {
            presenter.mTeamsData = fcList
            rvFootballClubList.setUp(
                presenter.mTeamsData,
                R.layout.item_list_football,
                {
                    loadImageToImageView(it.strTeamBadge, imgItemFootball, pbItemFc)
                    tvItemFootball.text = it.strTeam
                },
                {
                    router.goToDetailPage(it.strTeam, it.strDescriptionEN, it.strTeamBadge)
                },
                mLayoutManager
            )
        } else {
            showEmptyView()
        }
    }

    override fun setupLeaguesAdapter(leagues: ArrayList<String>) {
        presenter.mArrLeagues = leagues
        presenter.mArrLeagues.sortBy { it }
        val mAdapter = ArrayAdapter(
            this,
            R.layout.item_spinner,
            presenter.mArrLeagues
        )
        mAdapter.setDropDownViewResource(R.layout.item_spinner)
        spLeagues.adapter = mAdapter
        setupUiSpinner()
    }
}