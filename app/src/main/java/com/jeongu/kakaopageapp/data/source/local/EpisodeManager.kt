package com.jeongu.kakaopageapp.data.source.local

import com.jeongu.kakaopageapp.R
import com.jeongu.kakaopageapp.data.model.EpisodeInfo

object EpisodeManager {

    private val episodeList: List<EpisodeInfo> by lazy { getDummyData() }

    private fun getDummyData(): List<EpisodeInfo> {
        return listOf(
            EpisodeInfo(
                0,
                2,
                "프롤로그",
                R.drawable.img_content_02_ep_prolog,
                "18.03.04",
                48,
                true,
                isViewed = false,
                isLastViewed = false
            ),
            EpisodeInfo(
                1,
                2,
                "나 혼자만 레벨업 1화",
                R.drawable.img_content_02_ep_001,
                "18.03.04",
                64,
                true,
                isViewed = false,
                isLastViewed = false
            ),
            EpisodeInfo(
                2,
                2,
                "나 혼자만 레벨업 2화",
                R.drawable.img_content_02_ep_002,
                "18.03.04",
                55,
                true,
                isViewed = false,
                isLastViewed = false
            ),
            EpisodeInfo(
                3,
                2,
                "나 혼자만 레벨업 3화",
                R.drawable.img_content_02_ep_003,
                "18.03.04",
                81,
                true,
                isViewed = false,
                isLastViewed = false
            ),
            EpisodeInfo(
                4,
                2,
                "나 혼자만 레벨업 4화",
                R.drawable.img_content_02_ep_004,
                "18.03.04",
                78,
                false,
                isViewed = true,
                isLastViewed = false
            ),
            EpisodeInfo(
                5,
                2,
                "나 혼자만 레벨업 5화",
                R.drawable.img_content_02_ep_005,
                "18.03.04",
                76,
                false,
                isViewed = false,
                isLastViewed = false
            ),
            EpisodeInfo(
                6,
                2,
                "나 혼자만 레벨업 6화",
                R.drawable.img_content_02_ep_006,
                "18.03.04",
                98,
                false,
                isViewed = true,
                isLastViewed = false
            ),
            EpisodeInfo(
                176,
                2,
                "나 혼자만 레벨업 176화",
                R.drawable.img_content_02_ep_176,
                "21.12.08",
                173,
                false,
                isViewed = false,
                isLastViewed = false
            ),
            EpisodeInfo(
                177,
                2,
                "나 혼자만 레벨업 177화",
                R.drawable.img_content_02_ep_177,
                "21.12.15",
                141,
                false,
                isViewed = true,
                isLastViewed = true
            ),
            EpisodeInfo(
                178,
                2,
                "나 혼자만 레벨업 178화",
                R.drawable.img_content_02_ep_178,
                "21.12.22",
                145,
                false,
                isViewed = true,
                isLastViewed = false
            ),
            EpisodeInfo(
                179,
                2,
                "나 혼자만 레벨업 179화 (완결)",
                R.drawable.img_content_02_ep_179,
                "21.12.29",
                151,
                false,
                isViewed = false,
                isLastViewed = false
            ),
            EpisodeInfo(
                180,
                2,
                "나 혼자만 레벨업 외전 1화",
                R.drawable.img_content_02_ep_180,
                "23.01.20",
                177,
                false,
                isViewed = true,
                isLastViewed = false
            ),
        )
    }

    fun getList(): List<EpisodeInfo> {
        return episodeList.sortedByDescending { it.id }
    }
}