package com.jeongu.kakaopageapp.ui.home

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.jeongu.kakaopageapp.ui.home.hotnow.HotNowFragment
import com.jeongu.kakaopageapp.ui.home.realtime.RealtimeRankingFragment
import com.jeongu.kakaopageapp.ui.home.todaynew.TodayNewContentFragment

class HomePagerStateAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount() = 3
    override fun createFragment(position: Int) = when (position) {
        0 -> HotNowFragment()
        1 -> RealtimeRankingFragment()
        2 -> TodayNewContentFragment()
        else -> throw IllegalStateException("Invalid position: $position")
    }
}