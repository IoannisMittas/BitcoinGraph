package com.mittas.bitcoingraph.ui.screen.graph

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.mittas.bitcoingraph.R
import com.mittas.bitcoingraph.di.DIHelper
import com.mittas.bitcoingraph.domain.entity.charts.MarketPriceChart
import kotlinx.android.synthetic.main.fragment_graph.*
import javax.inject.Inject

class GraphFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: GraphViewModel

    override fun onAttach(context: Context) {
        DIHelper.appComponent.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_graph, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        arguments?.takeIf { it.containsKey(EXTRA_POSITION) }?.apply {
            viewModel = ViewModelProviders.of(this@GraphFragment, viewModelFactory).get(EXTRA_POSITION, GraphViewModel::class.java)
            viewModel.position = getInt(EXTRA_POSITION)
            subscribeToViewModel()
        }
    }

    private fun subscribeToViewModel() {
        viewModel.bitcoinPriceChart.observe(this, Observer {
            updateGraph(it)
        })
    }

    private fun updateGraph(bitcoinPriceChart: MarketPriceChart) {
        val entries = mutableListOf<Entry>()
        bitcoinPriceChart.values?.forEach { entries.add(Entry(it.x.toFloat(), it.y.toFloat())) }

        val lineDataSet = LineDataSet(entries, null).apply {
            setDrawCircles(false)
            setDrawHorizontalHighlightIndicator(false)
            color = ContextCompat.getColor(requireContext(), R.color.accent)
        }

        val lineData = LineData(lineDataSet)

        lineChart.apply {
            xAxis.setDrawGridLines(false)
            xAxis.textColor = ContextCompat.getColor(requireContext(), R.color.accent)
            axisRight.isEnabled = false
            axisLeft.textColor = ContextCompat.getColor(requireContext(), R.color.accent)
            description.isEnabled = false
            legend.isEnabled = false
            data = lineData
            invalidate()
            notifyDataSetChanged()
        }
    }

    companion object {
        const val EXTRA_POSITION = "EXTRA_POSITION"
        fun newInstance(position: Int): GraphFragment {
            val bundle = Bundle().apply { putInt(EXTRA_POSITION, position) }
            return GraphFragment().apply {
                arguments = bundle
            }
        }
    }
}