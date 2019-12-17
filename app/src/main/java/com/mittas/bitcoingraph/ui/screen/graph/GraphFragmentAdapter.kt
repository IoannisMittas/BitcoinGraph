package com.mittas.bitcoingraph.ui.screen.graph

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class GraphFragmentAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {

    override fun getItemCount() = FRAGMENT_COUNT

    override fun createFragment(position: Int): Fragment {
        return GraphFragment.newInstance(position)
    }

    companion object {
        const val FRAGMENT_COUNT = 3
    }
}