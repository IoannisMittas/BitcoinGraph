package com.mittas.bitcoingraph.ui.screen.graph

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mittas.bitcoingraph.domain.entity.charts.MarketPriceChart
import com.mittas.bitcoingraph.domain.usecases.charts.GetMarketPriceChartUseCase
import javax.inject.Inject

class GraphViewModel @Inject constructor(private val getMarketPriceChartUseCase: GetMarketPriceChartUseCase) :
    ViewModel() {

    private val _bitcoinPriceChart: MutableLiveData<MarketPriceChart> = MutableLiveData()
    val bitcoinPriceChart: LiveData<MarketPriceChart>
        get() = _bitcoinPriceChart

    init {

    }

    private fun fetchBitcoinPriceChart() {


    }

}