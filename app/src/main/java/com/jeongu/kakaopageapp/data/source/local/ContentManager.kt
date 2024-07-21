package com.jeongu.kakaopageapp.data.source.local

import com.jeongu.kakaopageapp.R
import com.jeongu.kakaopageapp.data.model.ContentDetailInfo

object ContentManager {

    private val contentList: List<ContentDetailInfo> by lazy { getDummyData() }

    private fun getDummyData(): List<ContentDetailInfo> {
        return listOf(
            ContentDetailInfo(
                2,
                R.drawable.img_content_10,
                "나 혼자만 레벨업",
                "현군,장성락(REDICE STUDIO),주공",
                "웹툰·판타지·완결",
                "5억",
                10.0
            ),
        )
    }

    fun getList(): List<ContentDetailInfo> = contentList

    fun getDetailInfo(id: Int): ContentDetailInfo? {
        return contentList.find { it.id == id }
    }
}