package com.jeongu.kakaopageapp.data.source.local

import com.jeongu.kakaopageapp.R
import com.jeongu.kakaopageapp.data.model.TopContentInfo

object TopContentManager {

    private val topContentList: List<TopContentInfo> by lazy { getDummyData() }

    private fun getDummyData(): List<TopContentInfo> {
        return listOf(
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
    }

    fun getList(): List<TopContentInfo> = topContentList
}