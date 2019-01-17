package makan.sayur.kol.presentation.detailpage.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.widget.ImageView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail_page.*
import kotlinx.android.synthetic.main.fragment_detail_page.*
import makan.sayur.kol.R
import makan.sayur.kol.presentation.detailpage.contract.DetailPageContract
import makan.sayur.kol.presentation.detailpage.presenter.DetailPagePresenter
import org.koin.android.ext.android.inject

/**
 * Created by Yoga C. Pranata on 17/01/2019.
 * Android Engineer
 */
class DetailPageActivity : AppCompatActivity(), DetailPageContract.View {

    val presenter : DetailPagePresenter by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_page)
        presenter.onAttachedView(this)

        val data = intent.extras
        if(data != null) {
            presenter.getFootballClub(data)
        }
    }

    override fun onBackPressed() {
        finish()
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item!!.itemId) {
            android.R.id.home -> onBackPressed()
        }
        return true
    }

    override fun loadImageToImageView(imageSource: String, imgView: ImageView) {
        Picasso.get()
            .load(imageSource)
            .fit()
            .centerCrop()
            .into(imgView)
    }

    override fun setupToolbar(title: String?) {
        setSupportActionBar(toolbarDetailFc)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        collapsingToolbarDetailFc.title = title
        collapsingToolbarDetailFc.setExpandedTitleColor(resources.getColor(android.R.color.transparent))
    }

    override fun setContentDetail(fcName: String?, fcDesc: String?, fcImage: String?) {
        tvDetailFcTitle.text = fcName
        tvDetailFcDesc.text = fcDesc
        if (fcImage != null) loadImageToImageView(fcImage, imgDetailFc)
    }

}