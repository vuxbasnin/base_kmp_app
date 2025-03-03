package vbn.base.kmpapp

import android.app.Application
import org.koin.android.ext.koin.androidContext
import vbn.base.kmpapp.di.initKoin

class BookApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@BookApplication)
        }
    }
}