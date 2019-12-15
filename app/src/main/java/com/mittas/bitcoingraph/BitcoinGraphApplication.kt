package com.mittas.bitcoingraph

import android.app.Application
import com.mittas.bitcoingraph.di.DIHelper
import com.mittas.bitcoingraph.di.DaggerBitcoinGraphComponent

class BitcoinGraphApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        initDagger()
    }

    private fun initDagger() {
        DIHelper.appComponent = DaggerBitcoinGraphComponent.create()
    }

}