package com.jeongu.kakaopageapp.data.source.local

import com.jeongu.kakaopageapp.data.model.HotNowInfo

class CacheDataSource {
    companion object {
        private var INSTANCE: CacheDataSource? = null
        fun getCacheDataSource(): CacheDataSource {
            return synchronized(CacheDataSource::class) {
                val newInstance = INSTANCE ?: CacheDataSource()
                INSTANCE = newInstance
                newInstance
            }
        }
    }

    fun getHotNowContentList(): List<HotNowInfo> {
        return HotNowManager.getList()
    }

    fun getRealtimeRankingContentList(): List<HotNowInfo> {
        return HotNowManager.getRealtimeRankingList()
    }

    fun addRecentlyViewedItem(content: HotNowInfo) {
        HotNowManager.addRecentlyViewedItem(content)
    }

    fun removeRecentlyViewedItem(content: HotNowInfo) {
        HotNowManager.removeRecentlyViewedItem(content)
    }
}