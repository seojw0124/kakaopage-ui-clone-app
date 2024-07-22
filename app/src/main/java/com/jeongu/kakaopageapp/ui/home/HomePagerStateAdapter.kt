package com.jeongu.kakaopageapp.ui.home

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class HomePagerStateAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount() = 3
    override fun createFragment(position: Int) = when (position) {
        0 -> HotNowFragment()
        1 -> RealtimeRankingFragment()
        2 -> TodayNewContentFragment()
        else -> throw IllegalStateException("Invalid position: $position")
    }
}