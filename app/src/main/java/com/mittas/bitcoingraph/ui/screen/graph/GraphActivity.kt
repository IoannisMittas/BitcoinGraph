package com.mittas.bitcoingraph.ui.screen.graph

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayoutMediator
import com.mittas.bitcoingraph.R
import com.mittas.bitcoingraph.di.DIHelper
import kotlinx.android.synthetic.main.activity_graph.*

class GraphActivity : AppCompatActivity() {

    private lateinit var fragmentAdapter: GraphFragmentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        DIHelper.appComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_graph)
        setupUI()
    }

    private fun setupUI() {
        fragmentAdapter = GraphFragmentAdapter(this)
        viewPager.adapter = fragmentAdapter
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = when (position.timespanForPosition()) {
                Timespan.WEEK -> resources.getString(R.string.timespan_week)
                Timespan.MONTH -> resources.getString(R.string.timespan_month)
                Timespan.YEAR -> resources.getString(R.string.timespan_year)
                else -> ""
            }
        }.attach()
    }

}



