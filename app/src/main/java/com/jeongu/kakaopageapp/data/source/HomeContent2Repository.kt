package com.jeongu.kakaopageapp.data.source

import com.jeongu.kakaopageapp.data.model.HotNowInfo
import com.jeongu.kakaopageapp.data.model.HotNowLinearContent
import com.jeongu.kakaopageapp.data.source.local.HotNowManager

class HomeContent2Repository {
    // 최근 본 리스트
    private val _recentlyViewedList = mutableListOf<HotNowLinearContent>()
    val recentlyViewedList: List<HotNowLinearContent>
        get() = _recentlyViewedList

    fun loadContent(): List<HotNowLinearContent> {
        _recentlyViewedList.addAll(HotNowManager.getRecentlyViewedList())
        return _recentlyViewedList
    }

    fun addRecentlyViewedItem(content: HotNowLinearContent) {
        if (!_recentlyViewedList.contains(content)) {
            _recentlyViewedList.add(0, content)
        } else {
            _recentlyViewedList.remove(content)
            _recentlyViewedList.add(0, content)
        }
    }

    fun removeRecentlyViewedItem(content: HotNowLinearContent) {
        _recentlyViewedList.remove(content)
    }

    fun getHotNowContentList(): List<HotNowInfo> {
        return HotNowManager.getList()
    }

    fun getRealtimeRankingContentList(): List<HotNowInfo> {
        return HotNowManager.getRealtimeRankingList()
    }
}