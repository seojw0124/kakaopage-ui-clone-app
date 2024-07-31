package com.jeongu.kakaopageapp.data.source.local

import com.jeongu.kakaopageapp.R
import com.jeongu.kakaopageapp.data.model.GridContentInfo
import com.jeongu.kakaopageapp.data.model.HotNowGridContent
import com.jeongu.kakaopageapp.data.model.HotNowInfo
import com.jeongu.kakaopageapp.data.model.HotNowLinearContent
import com.jeongu.kakaopageapp.data.model.HotNowSectionTitle
import com.jeongu.kakaopageapp.data.model.HotNowViewPager
import com.jeongu.kakaopageapp.data.model.LinearContentInfo
import com.jeongu.kakaopageapp.data.model.TopContentInfo

object HotNowManager {

    private val hotNowContentList: MutableList<HotNowInfo> by lazy { getDummyData() }

    private fun getDummyData(): MutableList<HotNowInfo> {
        return mutableListOf(
            HotNowViewPager(
                listOf(
                    TopContentInfo(
                        1,
                        R.drawable.img_content_01,
                        R.drawable.img_content_01_title,
                        "레전드의 귀환을 경배하라!",
                        R.drawable.ic_free_3_days_waiting,
                        R.drawable.ic_up,
                        "웹소설·판타지",
                        "1/5",
                    ),
                    TopContentInfo(
                        16,
                        R.drawable.img_content_16,
                        R.drawable.img_content_16_title,
                        "천재적 작품 감상하면 캐시!",
                        null,
                        null,
                        null,
                        "2/5",
                    ),
                    TopContentInfo(
                        17,
                        R.drawable.img_content_17,
                        R.drawable.img_content_17_title,
                        "이세계에 떨어진 무림고수?",
                        null,
                        null,
                        null,
                        "3/5",
                    ),
                    TopContentInfo(
                        18,
                        R.drawable.img_content_18,
                        R.drawable.img_content_18_title,
                        "지금 바로 캐시 선물 받아가세요!",
                        null,
                        null,
                        null,
                        "4/5",
                    ),
                    TopContentInfo(
                        19,
                        R.drawable.img_content_19,
                        R.drawable.img_content_19_title,
                        "왕년에 주먹 쓴 놈이 돌아왔다",
                        R.drawable.ic_free_serial,
                        null,
                        "웹툰·액션·349.8만",
                        "5/5"
                    ),
                )
            ),
            HotNowGridContent(
                listOf(
                    GridContentInfo(
                        2,
                        R.drawable.img_content_02,
                        R.drawable.img_content_02_title,
                        "5억",
                        R.drawable.ic_free_3_days_waiting,
                        null,
                        null,
                        null,
                    ),
                    GridContentInfo(
                        4,
                        R.drawable.img_content_04,
                        R.drawable.img_content_04_title,
                        "캐시선물 적립하세요",
                        null,
                        null,
                        null,
                        null,
                    ),
                    GridContentInfo(
                        3,
                        R.drawable.img_content_03,
                        R.drawable.img_content_03_title,
                        "1.5억",
                        R.drawable.ic_free_3_days_waiting,
                        R.drawable.ic_up,
                        null,
                        null,
                    ),
                    GridContentInfo(
                        5,
                        R.drawable.img_content_05,
                        R.drawable.img_content_05_title,
                        "5,960만",
                        R.drawable.ic_free_3_days_waiting,
                        null,
                        null,
                        null,
                    ),
                    GridContentInfo(
                        6,
                        R.drawable.img_content_06,
                        R.drawable.img_content_02_title,
                        "1.4억",
                        R.drawable.ic_clock,
                        null,
                        null,
                        null,
                    ),
                    GridContentInfo(
                        7,
                        R.drawable.img_content_07,
                        R.drawable.img_content_07_title,
                        "334.3만",
                        R.drawable.ic_clock,
                        null,
                        R.drawable.ic_event,
                        null,
                    ),
                )
            ),
            HotNowSectionTitle("최근 본 작품"),
            HotNowLinearContent(
                listOf(
                    LinearContentInfo(
                        8,
                        R.drawable.img_content_08,
                        "북검전기",
                        "웹툰",
                        R.drawable.ic_free_3_days_waiting
                    ),
                    LinearContentInfo(
                        9,
                        R.drawable.img_content_09,
                        "던전 견문록",
                        "웹툰",
                        R.drawable.ic_free_3_days_waiting
                    ),
                    LinearContentInfo(
                        10,
                        R.drawable.img_content_10,
                        "나 혼자만 레벨업",
                        "웹툰",
                        R.drawable.ic_free_3_days_waiting
                    ),
                    LinearContentInfo(
                        14,
                        R.drawable.img_content_14,
                        "말단 병사에서 군주까지",
                        "웹툰",
                        R.drawable.ic_clock
                    ),
                    LinearContentInfo(
                        11,
                        R.drawable.img_content_11,
                        "블랙기업조선",
                        "웹툰",
                        R.drawable.ic_free_3_days_waiting
                    ),
                    LinearContentInfo(
                        12,
                        R.drawable.img_content_12,
                        "로그인 무림",
                        "웹툰",
                        R.drawable.ic_free_3_days_waiting
                    ),
                    LinearContentInfo(
                        13,
                        R.drawable.img_content_13,
                        "관존 이강진",
                        "웹툰",
                        R.drawable.ic_free_serial
                    ),
                    LinearContentInfo(
                        5,
                        R.drawable.img_content_15,
                        "흑백무제",
                        "웹툰",
                        R.drawable.ic_free_3_days_waiting
                    ),
                )
            ),
            HotNowSectionTitle("지금, 신작!"),
            HotNowGridContent(
                listOf(
                    GridContentInfo(
                        2,
                        R.drawable.img_content_02,
                        R.drawable.img_content_02_title,
                        "5억",
                        R.drawable.ic_free_3_days_waiting,
                        null,
                        null,
                        null,
                    ),
                    GridContentInfo(
                        4,
                        R.drawable.img_content_04,
                        R.drawable.img_content_04_title,
                        "캐시선물 적립하세요",
                        null,
                        null,
                        null,
                        null,
                    ),
                    GridContentInfo(
                        3,
                        R.drawable.img_content_03,
                        R.drawable.img_content_03_title,
                        "1.5억",
                        R.drawable.ic_free_3_days_waiting,
                        R.drawable.ic_up,
                        null,
                        null,
                    ),
                    GridContentInfo(
                        5,
                        R.drawable.img_content_05,
                        R.drawable.img_content_05_title,
                        "5,960만",
                        R.drawable.ic_free_3_days_waiting,
                        null,
                        null,
                        null,
                    ),
                    GridContentInfo(
                        6,
                        R.drawable.img_content_06,
                        R.drawable.img_content_02_title,
                        "1.4억",
                        R.drawable.ic_clock,
                        null,
                        null,
                        null,
                    ),
                    GridContentInfo(
                        7,
                        R.drawable.img_content_07,
                        R.drawable.img_content_07_title,
                        "334.3만",
                        R.drawable.ic_clock,
                        null,
                        R.drawable.ic_event,
                        null,
                    ),
                )
            ),
        )
    }

    fun getList(): MutableList<HotNowInfo> = hotNowContentList

    fun getRecentlyViewedList(): List<HotNowLinearContent> {
        return hotNowContentList.filterIsInstance<HotNowLinearContent>()
    }

    fun addRecentlyViewedItem(content: HotNowInfo) {
        if (content !is HotNowLinearContent) return
        hotNowContentList.indexOfFirst { it is HotNowLinearContent }
            .takeIf { it != -1 }
            ?.let {
                if (hotNowContentList[it] == content) {
                    hotNowContentList.remove(content)
                    hotNowContentList.add(it, content)
                } else {
                    hotNowContentList.add(it, content)
                }
            }
    }

    fun removeRecentlyViewedItem(content: HotNowInfo) {
        if (content !is HotNowLinearContent) return
        hotNowContentList.remove(content)
    }


    // 임의로 데이터 필터링
    fun getRealtimeRankingList(): List<HotNowInfo> {
        // HotNowViewPager 제외
        return hotNowContentList.filter { it !is HotNowViewPager }
    }
}