package makan.sayur.kol.domain.router

import android.content.Context
import android.content.Intent

/**
 * Created by Yoga C. Pranata on 17/01/2019.
 * Android Engineer
 */
interface ScreenRouter {

    sealed class ActivityScreen {
        object DetailFootballClub : ActivityScreen()
    }

    fun getScreenIntent(context: Context, screen: ActivityScreen): Intent?
}