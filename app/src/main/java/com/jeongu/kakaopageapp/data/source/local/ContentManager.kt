package com.jeongu.kakaopageapp.data.source.local

import com.jeongu.kakaopageapp.R
import com.jeongu.kakaopageapp.data.model.ContentDetailInfo

object ContentManager {

    private val contentList: List<ContentDetailInfo> by lazy { getDummyData() }

    private fun getDummyData(): List<ContentDetailInfo> {
        return listOf(
            ContentDetailInfo(
                2,
                "https://page-images.kakaoentcdn.com/download/resource?kid=Cf0LJ/hynaH4y8E5/l5Qk7VWfAsyYkE8yKmRFdk&filename=o1/dims/resize/384",
                "나 혼자만 레벨업",
                "현군,장성락(REDICE STUDIO),주공",
                "웹툰·판타지·완결",
                "5억",
                10.0
            ),
            ContentDetailInfo(
                3,
                "https://page-images.kakaoentcdn.com/download/resource?kid=RbyC9/hAd4sHh3Rl/Hkc73O0AxXz4CotZnvifp0&filename=o1/dims/resize/384",
                "이번 생은 가주가 되겠습니다",
                "앤트스튜디오,몬,김로아",
                "웹툰·로판",
                "1.5억",
                10.0
            ),
            ContentDetailInfo(
                5,
                "https://page-images.kakaoentcdn.com/download/resource?kid=jojoL/hAC1Mu9MYF/ZQpg09EYDg0f1sJGqettm1&filename=o1/dims/resize/384",
                "환골탈태",
                "마고(mago)",
                "웹툰·드라마",
                "6,027.9만",
                10.0
            ),
            ContentDetailInfo(
                6,
                "https://page-images.kakaoentcdn.com/download/resource?kid=daeH8j/hyZ8xoB9DK/pbDkLqwNFAyBiwaz7mKxF1&filename=o1/dims/resize/384",
                "창천무신",
                "담호",
                "웹소설·무협",
                "1.4억",
                9.5
            ),
            ContentDetailInfo(
                7,
                "https://page-images.kakaoentcdn.com/download/resource?kid=bqKCVV/hAd48vVZUq/zMxgBOpPspyj7EksmnU3n1&filename=o1/dims/resize/384",
                "진짜 가주는 나였다",
                "HON,파란맛솜사탕",
                "웹툰·로판",
                "375.7만",
                9.9
            ),
            ContentDetailInfo(
                8,
                "https://page-images.kakaoentcdn.com/download/resource?kid=bKwtap/hzVqIa828J/5yBrt9O6oDZnyN0iTc622K&filename=o1/dims/resize/384",
                "북검전기",
                "해민,우각",
                "웹툰·무협",
                "7,312.4만",
                9.9
            ),
            ContentDetailInfo(
                9,
                "https://page-images.kakaoentcdn.com/download/resource?kid=bcnAYU/hzXatC6fM7/A5QMXZqYQYhKryxGOAOsd1&filename=o1/dims/resize/384",
                "던전 견문록",
                "손민우,글럼프",
                "웹툰·판타지",
                "854.1만",
                9.9
            ),

            ContentDetailInfo(
                11,
                "https://page-images.kakaoentcdn.com/download/resource?kid=b2nx7k/hAdNUq2psd/XS710NlcPVzfWSMH4rGjAK&filename=o1/dims/resize/384",
                "블랙기업조선",
                "김펄럭,MOR,홍상기,국뽕",
                "웹툰·드라마",
                "585.1만",
                9.9
            ),
            ContentDetailInfo(
                12,
                "https://page-images.kakaoentcdn.com/download/resource?kid=6T0hj/hAFsF1gCf5/hwClBJtocpYQceIUQAWvf1&filename=o1/dims/resize/384",
                "로그인 무림",
                "장철벽,제로빅",
                "웹툰·무협",
                "4,483.4만",
                9.9
            ),
            ContentDetailInfo(
                13,
                "https://page-images.kakaoentcdn.com/download/resource?kid=ATKSq/hzKkYnQece/oReiJxjMDjqtHvI1n06pr0&filename=o1/dims/resize/384",
                "관존 이강진",
                "노경찬,송윤달",
                "웹툰·무협",
                "947.2만",
                9.9
            ),
            ContentDetailInfo(
                14,
                "https://page-images.kakaoentcdn.com/download/resource?kid=cFaQnD/hzN2iJK9BX/DAfU6hmgNbtNkzDgYIsbY0&filename=o1/dims/resize/384",
                "말단 병사에서 군주까지",
                "doip,2631,소울풍",
                "웹툰·판타지",
                "1,041.1만",
                9.9
            ),
            ContentDetailInfo(
                15,
                "https://page-images.kakaoentcdn.com/download/resource?kid=bpUcGV/hzXapAHCfJ/4AKrLH2TXo22L1Rb0t5yTk&filename=o1/dims/resize/384",
                "흑백무제",
                "백준,VICTOR,현임",
                "웹툰·무협",
                "698.9만",
                9.8
            ),
        )
    }

    fun getList(): List<ContentDetailInfo> = contentList

    fun getDetailInfo(id: Int): ContentDetailInfo? {
        return contentList.find { it.id == id }
    }
}