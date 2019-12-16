package com.mittas.bitcoingraph.ui.screen.graph

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mittas.bitcoingraph.domain.entity.charts.MarketPriceChart

class GraphViewModel : ViewModel() {

    private val _bitcoinPriceChart: MutableLiveData<MarketPriceChart> = MutableLiveData()
    val bitcoinPriceChart: LiveData<MarketPriceChart>
        get() = _bitcoinPriceChart

    init {

    }


// todo add viewmodel factory???


}