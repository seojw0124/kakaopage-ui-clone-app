package com.jeongu.kakaopageapp.ui.contentdetail

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class DetailPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount() = 4
    override fun createFragment(position: Int) = when (position) {
        0 -> EpisodeFragment()
        1 -> ContentInfoFragment()
        2 -> NewsFragment()
        3 -> CommentFragment()
        else -> throw IllegalStateException("Invalid position: $position")
    }
}