package com.jeongu.kakaopageapp.data

data class EpisodeInfo(
    val id: Int,
    val contentId: Int,
    val title: String,
    val thumbnailImage: String,
    val date: String,
    val page: Int?,
    val isFree: Boolean,
    var isViewed: Boolean = false,
)
