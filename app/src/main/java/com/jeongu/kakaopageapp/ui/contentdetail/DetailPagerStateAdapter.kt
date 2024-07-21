package com.jeongu.kakaopageapp.ui.contentdetail

import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class DetailPagerStateAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount() = 4
    override fun createFragment(position: Int) = when (position) {
        0 -> EpisodeFragment()
        1 -> ContentInfoFragment()
        2 -> NewsFragment()
        3 -> CommentFragment()
        else -> throw IllegalStateException("Invalid position: $position")
    }
}