package com.jeongu.kakaopageapp.data

import com.jeongu.kakaopageapp.R

object EpisodeManager {

    private val episodeList: List<EpisodeInfo> by lazy { getDummyData() }

    private fun getDummyData(): List<EpisodeInfo> {
        return listOf(
            EpisodeInfo(
                0,
                2,
                "프롤로그",
                "https://mblogthumb-phinf.pstatic.net/MjAxNzAxMjdfNjQg/MDAxNDg1NTE0MzQ3MjE4.wdSb0Ml8pNn7EcmK1YnXS-waOUgwwmj5OekwYVeKiLwg.oef19VR36o657H4eGoEGXxqTT3qnyQy7DkglPjhjIOsg.PNG.logix200/%ED%8C%8C%ED%8C%8C%EA%B3%A0_%EB%A1%9C%EA%B3%A0.png?type=w800",
                "18.03.04",
                48,
                true,
            ),
            EpisodeInfo(
                1,
                2,
                "나 혼자만 레벨업 1화",
                "https://dn-img-page.kakao.com/download/resource?kid=r0y7S/hyjahn3zfQ/jNS8GVbnFOHuTZprXrmKE0&filename=th3",
                "18.03.04",
                64,
                true,
            ),
            EpisodeInfo(
                2,
                2,
                "나 혼자만 레벨업 2화",
                "https://dn-img-page.kakao.com/download/resource?kid=r0y7S/hyjahn3zfQ/jNS8GVbnFOHuTZprXrmKE0&filename=th3",
                "18.03.04",
                55,
                true,
            ),
            EpisodeInfo(
                3,
                2,
                "나 혼자만 레벨업 3화",
                "https://dn-img-page.kakao.com/download/resource?kid=r0y7S/hyjahn3zfQ/jNS8GVbnFOHuTZprXrmKE0&filename=th3",
                "18.03.04",
                81,
                true,
            ),
            EpisodeInfo(
                4,
                2,
                "나 혼자만 레벨업 4화",
                "https://dn-img-page.kakao.com/download/resource?kid=r0y7S/hyjahn3zfQ/jNS8GVbnFOHuTZprXrmKE0&filename=th3",
                "18.03.04",
                78,
                false,
                isViewed = true
            ),
            EpisodeInfo(
                5,
                2,
                "나 혼자만 레벨업 5화",
                "https://dn-img-page.kakao.com/download/resource?kid=r0y7S/hyjahn3zfQ/jNS8GVbnFOHuTZprXrmKE0&filename=th3",
                "18.03.04",
                76,
                false,
            ),
            EpisodeInfo(
                6,
                2,
                "나 혼자만 레벨업 6화",
                "https://flexible.img.hani.co.kr/flexible/normal/970/777/imgdb/resize/2019/0926/00501881_20190926.JPG",
                "18.03.04",
                98,
                false,
                isViewed = true
            ),
            EpisodeInfo(
                176,
                2,
                "나 혼자만 레벨업 176화",
                "https://dn-img-page.kakao.com/download/resource?kid=r0y7S/hyjahn3zfQ/jNS8GVbnFOHuTZprXrmKE0&filename=th3",
                "21.12.08",
                173,
                false,
            ),
            EpisodeInfo(
                177,
                2,
                "나 혼자만 레벨업 177화",
                "https://dn-img-page.kakao.com/download/resource?kid=r0y7S/hyjahn3zfQ/jNS8GVbnFOHuTZprXrmKE0&filename=th3",
                "21.12.15",
                141,
                false,
                isViewed = true
            ),
            EpisodeInfo(
                178,
                2,
                "나 혼자만 레벨업 178화",
                "https://dn-img-page.kakao.com/download/resource?kid=r0y7S/hyjahn3zfQ/jNS8GVbnFOHuTZprXrmKE0&filename=th3",
                "21.12.22",
                145,
                false,
                isViewed = true
            ),
            EpisodeInfo(
                179,
                2,
                "나 혼자만 레벨업 179화 (완결)",
                "https://dn-img-page.kakao.com/download/resource?kid=r0y7S/hyjahn3zfQ/jNS8GVbnFOHuTZprXrmKE0&filename=th3",
                "21.12.29",
                145,
                false,
            ),
            EpisodeInfo(
                180,
                2,
                "나 혼자만 레벨업 외전 1화",
                "https://dn-img-page.kakao.com/download/resource?kid=r0y7S/hyjahn3zfQ/jNS8GVbnFOHuTZprXrmKE0&filename=th3",
                "23.01.20",
                177,
                false,
            ),
        )
    }

    fun getList(): List<EpisodeInfo> {
        return episodeList.sortedByDescending { it.id }
    }
}