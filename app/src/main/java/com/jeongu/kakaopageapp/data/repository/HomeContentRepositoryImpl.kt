package com.jeongu.kakaopageapp.data.repository

import com.jeongu.kakaopageapp.data.model.HotNowInfo
import com.jeongu.kakaopageapp.data.source.local.CacheDataSource
import com.jeongu.kakaopageapp.domain.HomeContentRepository

class HomeContentRepositoryImpl(
    private val cacheDataSource: CacheDataSource
) : HomeContentRepository {

    override fun getHotNowContentList(): List<HotNowInfo> {
        return cacheDataSource.getHotNowContentList()
    }

    override fun getRealtimeRankingContentList(): List<HotNowInfo> {
        return cacheDataSource.getRealtimeRankingContentList()
    }

    override fun addRecentlyViewedItem(content: HotNowInfo) {
        cacheDataSource.addRecentlyViewedItem(content)
    }

    override fun removeRecentlyViewedItem(content: HotNowInfo) {
        cacheDataSource.removeRecentlyViewedItem(content)
    }
}