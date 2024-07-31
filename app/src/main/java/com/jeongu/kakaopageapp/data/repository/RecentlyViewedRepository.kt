package com.jeongu.kakaopageapp.data.repository

import android.content.Context
import com.jeongu.kakaopageapp.data.model.ContentDetailInfo
import com.jeongu.kakaopageapp.data.model.HotNowInfo
import com.jeongu.kakaopageapp.data.model.HotNowLinearContent
import com.jeongu.kakaopageapp.data.model.LinearContentInfo
import com.jeongu.kakaopageapp.data.source.local.HotNowManager

class RecentlyViewedRepository(context: Context) {
    // 최근 본 리스트
    private val _recentlyViewedList = mutableListOf<ContentDetailInfo>()
    val recentlyViewedList: List<ContentDetailInfo>
        get() = _recentlyViewedList.toList()

    init {
        loadContent()
    }

    private fun loadContent() {
        _recentlyViewedList.addAll(HotNowManager.getRecentlyViewedList())
    }

    fun addRecentlyViewedItem(content: ContentDetailInfo) {
        if (!_recentlyViewedList.contains(content)) {
            _recentlyViewedList.add(0, content)
        } else {
            _recentlyViewedList.remove(content)
            _recentlyViewedList.add(0, content)
        }
    }

    fun removeRecentlyViewedItem(content: ContentDetailInfo) {
        _recentlyViewedList.remove(content)
    }
}