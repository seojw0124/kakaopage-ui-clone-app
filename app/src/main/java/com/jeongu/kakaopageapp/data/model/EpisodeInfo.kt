package com.jeongu.kakaopageapp.data.model

data class EpisodeInfo(
    val id: Int,
    val contentId: Int,
    val title: String,
    val thumbnailImage: Int,
    val date: String,
    val page: Int?,
    val isFree: Boolean,
    val isViewed: Boolean,
    val isLastViewed: Boolean
)
