package com.mittas.bitcoingraph.ui.screen.graph

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mittas.bitcoingraph.data.utils.monthsQueryParam
import com.mittas.bitcoingraph.data.utils.weeksQueryParam
import com.mittas.bitcoingraph.data.utils.yearsQueryParam
import com.mittas.bitcoingraph.domain.entity.charts.MarketPriceChart
import com.mittas.bitcoingraph.domain.repository.charts.MarketPriceChartParams
import com.mittas.bitcoingraph.domain.usecases.charts.GetMarketPriceChartUseCase
import io.reactivex.disposables.CompositeDisposable
import timber.log.Timber
import javax.inject.Inject

class GraphViewModel @Inject constructor(private val getMarketPriceChartUseCase: GetMarketPriceChartUseCase) :
    ViewModel() {

    var position: Int = -1
        set(value) {
            field = value
            if (field >= 0) {
                val timespanQueryParam = when (field.timespanForPosition()) {
                    Timespan.WEEK -> 1.weeksQueryParam()
                    Timespan.MONTH -> 1.monthsQueryParam()
                    Timespan.YEAR -> 1.yearsQueryParam()
                    else -> null
                }

                fetchBitcoinPriceChart(MarketPriceChartParams(timespan = timespanQueryParam))
            }
        }

    private val compositeDisposable = CompositeDisposable()

    private val _bitcoinPriceChart: MutableLiveData<MarketPriceChart> = MutableLiveData()
    val bitcoinPriceChart: LiveData<MarketPriceChart>
        get() = _bitcoinPriceChart

    private fun fetchBitcoinPriceChart(params: MarketPriceChartParams) {
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