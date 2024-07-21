package com.jeongu.kakaopageapp.data.source

import com.jeongu.kakaopageapp.data.model.HotNowInfo
import com.jeongu.kakaopageapp.data.source.local.HotNowManager

class HomeContentRepository {

    fun getHotNowContentList(): List<HotNowInfo> {
        return HotNowManager.getList()
    }

    fun getRealtimeRankingContentList(): List<HotNowInfo> {
        return HotNowManager.getRealtimeRankingList()
    }
}