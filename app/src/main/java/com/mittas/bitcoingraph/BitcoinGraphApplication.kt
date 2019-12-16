package com.mittas.bitcoingraph

import android.app.Application
import com.mittas.bitcoingraph.di.DIHelper
import com.mittas.bitcoingraph.di.DaggerBitcoinGraphComponent
import timber.log.Timber

class BitcoinGraphApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initDagger()
        initTimber()
    }

    private fun initDagger() {
        DIHelper.appComponent = DaggerBitcoinGraphComponent.create()
    }

    private fun initTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

}