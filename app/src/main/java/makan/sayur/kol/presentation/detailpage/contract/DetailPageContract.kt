package makan.sayur.kol.presentation.detailpage.contract

import android.os.Bundle
import android.widget.ImageView

/**
 * Created by Yoga C. Pranata on 17/01/2019.
 * Android Engineer
 */
class DetailPageContract {
    interface View {
        fun loadImageToImageView(imageSource: String, imgView: ImageView)
        fun setupToolbar(title: String?)
        fun setContentDetail(fcName: String?, fcDesc: String?, fcImage: String?)
    }

    interface UserActionListener {
        fun onAttachedView(activity: View)
        fun getFootballClub(bundle: Bundle)
    }
}