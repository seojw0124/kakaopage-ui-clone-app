package com.jeongu.kakaopageapp.ui.contentdetail

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.tabs.TabLayoutMediator
import com.jeongu.kakaopageapp.EXTRA_CONTENT_ID
import com.jeongu.kakaopageapp.MainActivity
import com.jeongu.kakaopageapp.R
import com.jeongu.kakaopageapp.data.source.local.ContentManager
import com.jeongu.kakaopageapp.databinding.FragmentContentDetailBinding
import jp.wasabeef.glide.transformations.BlurTransformation

class ContentDetailFragment : Fragment() {

    private var _binding: FragmentContentDetailBinding? = null
    private val binding get() = _binding!!
    private var contentId = -1

    private val contentDetailTabTitles = arrayOf(
        "회차",
        "정보",
        "소식",
        "댓글"
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentContentDetailBinding.inflate(inflater, container, false)
        hideBottomNavigation(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setLayout()
    }

    private fun setLayout() {
        getContentId()
        setBlurImage()
        setTabLayout()
        //setToolbar()
    }

    private fun getContentId() {
        setFragmentResultListener("asdf") { _, bundle ->
            contentId = bundle.getInt("aaa")
            if (contentId != -1) {
                setContentInfo(contentId)
            }
        }
    }

    private fun setContentInfo(contentId: Int) {
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
            viewpagerContentDetail.adapter = DetailPagerAdapter(this@ContentDetailFragment)
            TabLayoutMediator(tabContentDetail, viewpagerContentDetail) { tab, position ->
                tab.text = contentDetailTabTitles[position]
            }.attach()
        }
    }

    private fun hideBottomNavigation(isHide: Boolean) {
        (activity as MainActivity)
            .findViewById<BottomNavigationView>(R.id.bottom_navigation_main)
            .isVisible = !isHide
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        hideBottomNavigation(false)
    }
}