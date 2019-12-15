package com.mittas.bitcoingraph.ui.screen.graph

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.mittas.bitcoingraph.R

class GraphActivity : AppCompatActivity() {

    private val viewModel: GraphViewModel by lazy { ViewModelProviders.of(this).get(GraphViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_graph)
        subscribeToViewModel()
    }

    private fun subscribeToViewModel() {
        // TODO consume values


    }


}
