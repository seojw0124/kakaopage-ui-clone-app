package com.jeongu.kakaopageapp.data.model

data class LinearContentInfo(
    val id: Int,
    val thumbnailImage: Int,
    val title: String,
    val category: String = "웹툰",
    val freeTypeImage: Int
)
