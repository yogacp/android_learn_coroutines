package makan.sayur.kol.domain.router

import android.content.Context
import android.content.Intent
import makan.sayur.kol.presentation.detailpage.view.DetailPageActivity

/**
 * Created by Yoga C. Pranata on 17/01/2019.
 * Android Engineer
 */
class ScreenRouterImpl : ScreenRouter {

    override fun getScreenIntent(context: Context, screen: ScreenRouter.ActivityScreen): Intent? {
        val c: Class<*>? = when (screen) {
            ScreenRouter.ActivityScreen.DetailFootballClub -> DetailPageActivity::class.java
        }
        return if (c == null) null else Intent(context, c)
    }

}