package com.mittas.bitcoingraph.ui.screen.graph

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.mittas.bitcoingraph.R
import com.mittas.bitcoingraph.domain.entity.charts.MarketPriceChart

class GraphActivity : AppCompatActivity() {

    private val viewModel: GraphViewModel by lazy { ViewModelProviders.of(this).get(GraphViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_graph)
        subscribeToViewModel()
    }

    private fun subscribeToViewModel() {
        viewModel.bitcoinPriceChart.observe(this, Observer {
            updateGraph(it)
        })
    }

    private fun updateGraph(chart: MarketPriceChart) {

    }


}
