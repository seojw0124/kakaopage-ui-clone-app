package com.jeongu.kakaopageapp.data

data class GridContentInfo(
    val id: Int,
    val thumbnailImage: Int,
    val title: Int,
    val description: String,
    val freeTypeImage: Int?,
    val uploadImage: Int?,
    val eventImage: Int?,
    val ageLimitImage: Int?
)
