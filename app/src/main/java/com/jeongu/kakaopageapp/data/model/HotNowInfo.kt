package com.jeongu.kakaopageapp.data.model

sealed class HotNowInfo

data class HotNowViewPager(
    val viewPagerItems: List<TopContentInfo>
) : HotNowInfo()

data class HotNowSectionTitle(
    val title: String
) : HotNowInfo()

data class HotNowGridContent(
    val gridItems: List<GridContentInfo>
) : HotNowInfo()

data class HotNowLinearContent(
    val linearItems: List<LinearContentInfo>
) : HotNowInfo()