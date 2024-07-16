package com.jeongu.kakaopageapp.data

import com.jeongu.kakaopageapp.R

object ContentManager {

    private val contentList: List<GridContentInfo> by lazy { getDummyData() }

    private fun getDummyData(): List<GridContentInfo> {
        return listOf(
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
    }

    fun getList(): List<GridContentInfo> = contentList
}