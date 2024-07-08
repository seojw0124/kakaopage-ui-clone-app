package com.jeongu.kakaopageapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2

class MainActivity : AppCompatActivity() {

    private val imageList = listOf(
        R.drawable.img_content_01,
        R.drawable.img_content_01,
        R.drawable.img_content_01,
        R.drawable.img_content_01,
        R.drawable.img_content_01
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
    }

    private fun initViewPager2() {
        val viewPager = findViewById<ViewPager2>(R.id.view_pager)
        val adapter = ViewPagerAdapter(imageList)
        viewPager.adapter = adapter
        viewPager.setCurrentItem(Int.MAX_VALUE / 2, false) // 중앙으로 설정
    }
}