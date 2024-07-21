package com.jeongu.kakaopageapp.domain

import com.jeongu.kakaopageapp.data.model.HotNowInfo

interface HomeContentRepository {
    fun getHotNowContentList(): List<HotNowInfo>

    fun getRealtimeRankingContentList(): List<HotNowInfo>
}