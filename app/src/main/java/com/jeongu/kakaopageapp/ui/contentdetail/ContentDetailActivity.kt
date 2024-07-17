package com.jeongu.kakaopageapp.ui.contentdetail

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.android.material.tabs.TabLayoutMediator
import com.jeongu.kakaopageapp.R
import com.jeongu.kakaopageapp.databinding.ActivityContentDetailBinding
//import jp.wasabeef.glide.transformations.BlurTransformation

class ContentDetailActivity : AppCompatActivity() {

    private val binding by lazy { ActivityContentDetailBinding.inflate(layoutInflater) }
    private val tabTitles = arrayOf(
        "회차",
        "정보",
        "소식",
        "댓글"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.content_detail)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setLayout()
    }

    private fun setLayout() {
        setBlurImage()
        setTabLayout()
    }

    private fun setBlurImage() {
        with(binding) {
            Glide.with(ivContentDetailBlurImage).load(R.drawable.img_content_02)
                //.apply(RequestOptions.bitmapTransform(BlurTransformation(90, 3)))
                .into(ivContentDetailBlurImage)
        }
    }

    private fun setTabLayout() {
        with(binding) {
            viewpagerContentDetail.adapter = DetailPagerAdapter(this@ContentDetailActivity)
            TabLayoutMediator(tabContentDetail, viewpagerContentDetail) { tab, position ->
                tab.text = tabTitles[position]
            }.attach()
        }
    }
}