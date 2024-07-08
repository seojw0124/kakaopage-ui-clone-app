package com.jeongu.kakaopageapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2

class MainActivity : AppCompatActivity() {

    private val thumbnailImageList = listOf(
        R.drawable.img_content_01,
        R.drawable.img_content_16,
        R.drawable.img_content_17,
        R.drawable.img_content_18,
        R.drawable.img_content_19
    )

    private val TitleList = listOf(
        R.drawable.img_content_01_title,
        R.drawable.img_content_16_title,
        R.drawable.img_content_17_title,
        R.drawable.img_content_18_title,
        R.drawable.img_content_19_title
    )

    private val descriptionList = listOf(
        "레전드의 귀환을 경배하라!",
        "천재적 작품 감상하면 캐시!",
        "이세계에 떨어진 무림고수?",
        "지금 바로 캐시 선물 받아가세요!",
        "왕년에 주먹 쓴 놈이 돌아왔다"
    )

    private val freeTypeList = listOf(
        R.drawable.ic_free_3_days_waiting,
        null,
        null,
        null,
        R.drawable.ic_free_serial
    )

    private val upList = listOf(
        R.drawable.ic_up,
        null,
        null,
        null,
        null
    )

    private val genreList = listOf(
        "웹소설·판타지",
        null,
        null,
        null,
        "웹툰·액션·349.8만"
    )

    private val pageList = listOf(
        "1/5",
        "2/5",
        "3/5",
        "4/5",
        "5/5"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, 50, systemBars.right, 0)
            insets
        }

        initViewPager2()
        val toolbar = findViewById<View>(R.id.layout_toolbar)
        toolbar.findViewById<View>(R.id.iv_toolbar_cash).setOnClickListener {
            navigateToCashShop()
        }

        val topBanner = findViewById<View>(R.id.view_top_banner)
        topBanner.setOnClickListener {
            navigateToCashEvent()
        }
    }

    private fun initViewPager2() {
        val viewPager = findViewById<ViewPager2>(R.id.view_pager)
        val adapter = ViewPagerAdapter(thumbnailImageList, TitleList, descriptionList, freeTypeList, upList, genreList, pageList)
        viewPager.adapter = adapter
        //viewPager.setCurrentItem(Int.MAX_VALUE / 2, false) // 중앙으로 설정
    }

    private fun navigateToCashShop() {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://page.kakao.com/history/cash"))
        startActivity(intent)
    }

    private fun navigateToCashEvent() {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://page.kakao.com/event/4ff6db86b64489c957dbd92b8d79d8ea"))
        startActivity(intent)
    }
}