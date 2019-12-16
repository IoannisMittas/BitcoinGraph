package com.mittas.bitcoingraph.ui.screen.graph

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mittas.bitcoingraph.domain.entity.charts.MarketPriceChart
import com.mittas.bitcoingraph.domain.repository.charts.MarketPriceChartParams
import com.mittas.bitcoingraph.domain.usecases.charts.GetMarketPriceChartUseCase
import io.reactivex.disposables.CompositeDisposable
import timber.log.Timber
import javax.inject.Inject

class GraphViewModel @Inject constructor(private val getMarketPriceChartUseCase: GetMarketPriceChartUseCase) :
    ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    private val _bitcoinPriceChart: MutableLiveData<MarketPriceChart> = MutableLiveData()
    val bitcoinPriceChart: LiveData<MarketPriceChart>
        get() = _bitcoinPriceChart

    init {
        fetchBitcoinPriceChart()
    }

    private fun fetchBitcoinPriceChart() {
        val params = MarketPriceChartParams(
            timespan = null,
            rollingAverage = null,
            start = null,
            format = null,
            sampled = null
        )
        compositeDisposable.add(
            getMarketPriceChartUseCase.getChart(params)
                .subscribe({
                    it?.let { _bitcoinPriceChart.postValue(it) }
                }, {
                    it.printStackTrace()
                    Timber.d("Error on fetching price chart.")
                })
        )
    }

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }
}