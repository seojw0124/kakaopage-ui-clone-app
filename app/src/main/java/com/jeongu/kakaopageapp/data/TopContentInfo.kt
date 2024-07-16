package com.jeongu.kakaopageapp.data

data class TopContentInfo(
    val id: Int,
    val thumbnailImage: Int,
    val title: Int,
    val description: String,
    val freeTypeImage: Int?,
    val uploadImage: Int?,
    val genre: String?,
    val page: String,
)
