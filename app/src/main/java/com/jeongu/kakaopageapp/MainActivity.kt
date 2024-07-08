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
        R.drawable.img_content_01,
        R.drawable.img_content_01,
        R.drawable.img_content_01,
        R.drawable.img_content_01
    )

    private val TitleList = listOf(
        R.drawable.img_content_01_title

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
    }

    private fun initViewPager2() {
        val viewPager = findViewById<ViewPager2>(R.id.view_pager)
        val adapter = ViewPagerAdapter(thumbnailImageList, pageList)
        viewPager.adapter = adapter
        //viewPager.setCurrentItem(Int.MAX_VALUE / 2, false) // 중앙으로 설정
    }

    private fun navigateToCashShop() {
        // 암시적 인텐트, url로 이동
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://page.kakao.com/history/cash"))
        startActivity(intent)
    }
}