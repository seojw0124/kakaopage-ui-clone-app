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
                "375.7만\n",
                9.9
            ),
            ContentDetailInfo(
                8,
                "https://page-images.kakaoentcdn.com/download/resource?kid=bqKCVV/hAd48vVZUq/zMxgBOpPspyj7EksmnU3n1&filename=o1/dims/resize/384",
                "진짜 가주는 나였다",
                "HON,파란맛솜사탕",
                "웹툰·로판",
                "375.7만\n",
                9.9
            ),
        )
    }

    fun getList(): List<ContentDetailInfo> = contentList

    fun getDetailInfo(id: Int): ContentDetailInfo? {
        return contentList.find { it.id == id }
    }
}