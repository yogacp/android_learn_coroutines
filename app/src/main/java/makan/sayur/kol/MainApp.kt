package makan.sayur.kol

import android.app.Application
import makan.sayur.kol.koin.component.appComponent
import org.koin.android.ext.android.startKoin

/**
 * Created by Yoga C. Pranata on 17/01/2019.
 * Android Engineer
 */
class MainApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin(this, appComponent)
    }
}