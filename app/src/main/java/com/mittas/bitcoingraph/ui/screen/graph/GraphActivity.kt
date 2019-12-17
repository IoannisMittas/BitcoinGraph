package com.mittas.bitcoingraph.ui.screen.graph

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.mittas.bitcoingraph.R
import com.mittas.bitcoingraph.di.DIHelper
import com.mittas.bitcoingraph.domain.entity.charts.MarketPriceChart
import kotlinx.android.synthetic.main.activity_graph.*
import javax.inject.Inject

class GraphActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit var viewModel: GraphViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        DIHelper.appComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_graph)
        viewModel = ViewModelProviders.of(this, viewModelFactory)[GraphViewModel::class.java]
        subscribeToViewModel()
    }

    private fun subscribeToViewModel() {
        viewModel.bitcoinPriceChart.observe(this, Observer {
            updateGraph(it)
        })
    }

    private fun updateGraph(bitcoinPriceChart: MarketPriceChart) {
        val entries = mutableListOf<Entry>()
        bitcoinPriceChart.values?.forEach { entries.add(Entry(it.x.toFloat(), it.y.toFloat())) }
        val dataset = LineDataSet(entries, "Psoli")
        dataset.color = R.color.accent
        val linedata = LineData(dataset)
        lineChart.data = linedata
        lineChart.invalidate()
    }
}

