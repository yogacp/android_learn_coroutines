package makan.sayur.kol.presentation.homepage.router

import android.content.Context
import makan.sayur.kol.domain.router.ScreenRouter
import makan.sayur.kol.external.constants.AppConstant
import makan.sayur.kol.presentation.homepage.contract.HomePageContract

/**
 * Created by Yoga C. Pranata on 17/01/2019.
 * Android Engineer
 */
class HomepageRouter(
    private val mScreenRouter: ScreenRouter,
    private val mContext: Context
) : HomePageContract.Router {

    override fun goToDetailPage(fcName: String?, fcDesc: String?, fcImage: String?) {
        val mScreen = mScreenRouter.getScreenIntent(mContext, ScreenRouter.ActivityScreen.DetailFootballClub)
        mScreen.apply {
            this?.putExtra(AppConstant.INTENT_BUNDLE.TAG_FCNAME, fcName)
            this?.putExtra(AppConstant.INTENT_BUNDLE.TAG_FCDESC, fcDesc)
            this?.putExtra(AppConstant.INTENT_BUNDLE.TAG_FCIMAGE, fcImage)
        }
        mScreen?.run { mContext.startActivity(this) }
    }

}