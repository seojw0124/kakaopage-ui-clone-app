package com.jeongu.kakaopageapp.ui.contentdetail

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.jeongu.kakaopageapp.ui.contentdetail.ContentInfo.ContentInfoFragment
import com.jeongu.kakaopageapp.ui.contentdetail.Episode.EpisodeFragment
import com.jeongu.kakaopageapp.ui.contentdetail.News.NewsFragment
import com.jeongu.kakaopageapp.ui.contentdetail.comment.CommentFragment

class DetailPagerStateAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount() = 4
    override fun createFragment(position: Int) = when (position) {
        0 -> EpisodeFragment()
        1 -> ContentInfoFragment()
        2 -> NewsFragment()
        3 -> CommentFragment()
        else -> throw IllegalStateException("Invalid position: $position")
    }
}