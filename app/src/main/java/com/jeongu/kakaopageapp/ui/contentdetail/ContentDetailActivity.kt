package com.jeongu.kakaopageapp.ui.contentdetail

import android.graphics.Color
import android.os.Bundle
import android.view.ContentInfo
import android.view.ViewTreeObserver
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.jeongu.kakaopageapp.EXTRA_CONTENT_ID
import com.jeongu.kakaopageapp.R
import com.jeongu.kakaopageapp.data.ContentManager
import com.jeongu.kakaopageapp.databinding.ActivityContentDetailBinding
import jp.wasabeef.glide.transformations.BlurTransformation
import kotlin.math.abs

class ContentDetailActivity : AppCompatActivity() {

    private val binding by lazy { ActivityContentDetailBinding.inflate(layoutInflater) }
    private val contentId by lazy { intent.getIntExtra(EXTRA_CONTENT_ID, -1) }
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
        setContentInfo()
        setBlurImage()
        setTabLayout()
        //setToolbar()
    }

    private fun setContentInfo() {
        if (contentId != -1) {
            val contentInfo = ContentManager.getDetailInfo(contentId) ?: return
            with(binding) {
                ivContentDetailThumbnailImage.setImageResource(contentInfo.thumbnailImage)
                tvContentDetailTitle.text = contentInfo.title
                tvContentDetailCreator.text = contentInfo.creator
                tvContentDetailGenre.text = contentInfo.genre
                tvContentDetailViews.text = contentInfo.views
                tvContentDetailRating.text = contentInfo.rating.toString()
            }
        }
    }

    private fun setBlurImage() {
        with(binding) {
            Glide.with(ivContentDetailBlurImage)
                .load(R.drawable.img_content_10)
                .apply(RequestOptions.bitmapTransform(BlurTransformation(70, 3)))
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