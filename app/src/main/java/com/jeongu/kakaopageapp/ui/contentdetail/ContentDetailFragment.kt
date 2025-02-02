package com.jeongu.kakaopageapp.ui.contentdetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.tabs.TabLayoutMediator
import com.jeongu.kakaopageapp.ui.MainActivity
import com.jeongu.kakaopageapp.R
import com.jeongu.kakaopageapp.data.model.ContentDetailInfo
import com.jeongu.kakaopageapp.data.source.local.ContentManager
import com.jeongu.kakaopageapp.databinding.FragmentContentDetailBinding
import com.jeongu.kakaopageapp.ui.home.ContentViewModel
import com.jeongu.kakaopageapp.ui.storagebox.StorageBoxViewModel
import com.jeongu.kakaopageapp.ui.storagebox.ContentViewModelFactory
import jp.wasabeef.glide.transformations.BlurTransformation

class ContentDetailFragment : Fragment() {

    private var _binding: FragmentContentDetailBinding? = null
    private val binding get() = _binding!!
    //private var contentId = -1

    private val args: ContentDetailFragmentArgs by navArgs()

    private val contentDetailTabTitles = arrayOf(
        "회차",
        "정보",
        "소식",
        "댓글"
    )

    private val viewModel: ContentViewModel by activityViewModels {
        ContentViewModelFactory(requireContext())
    }
    private lateinit var contentInfo: ContentDetailInfo

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentContentDetailBinding.inflate(inflater, container, false)
        //hideBottomNavigation(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setLayout()
    }

    private fun setLayout() {
        getContentId()
        setTabLayout()
        //setToolbar()
        binding.tvContentDetailTitle.setOnClickListener {
            viewModel.addRecentlyViewedItem(contentInfo)
            Toast.makeText(context, "최근 본 작품에 추가되었습니다.", Toast.LENGTH_SHORT).show()
        }
    }

    private fun getContentId() {
        val contentId = args.contentId
        if (contentId != -1) {
            setContentInfo(contentId)
        }
    }

    private fun setContentInfo(contentId: Int) {
        contentInfo = ContentManager.getDetailInfo(contentId) ?: return
        with(binding) {
            Glide.with(ivContentDetailBlurImage)
                .load(contentInfo.thumbnailImage)
                .apply(RequestOptions.bitmapTransform(BlurTransformation(70, 3)))
                .into(ivContentDetailBlurImage)
            //ivContentDetailThumbnailImage.setImageResource(contentInfo.thumbnailImage)
            Glide.with(ivContentDetailThumbnailImage)
                .load(contentInfo.thumbnailImage)
                .into(ivContentDetailThumbnailImage)
            tvContentDetailTitle.text = contentInfo.title
            tvContentDetailCreator.text = contentInfo.creator
            tvContentDetailGenre.text = contentInfo.genre
            tvContentDetailViews.text = contentInfo.views
            tvContentDetailRating.text = contentInfo.rating.toString()
        }
    }

    private fun setTabLayout() {
        with(binding) {
            viewpagerContentDetail.adapter = DetailPagerStateAdapter(this@ContentDetailFragment)
            TabLayoutMediator(tabContentDetail, viewpagerContentDetail) { tab, position ->
                tab.text = contentDetailTabTitles[position]
            }.attach()
        }
    }

    private fun hideBottomNavigation(isHide: Boolean) {
        (activity as MainActivity)
            .findViewById<BottomNavigationView>(R.id.bottom_navigation_home)
            .isVisible = !isHide
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        //hideBottomNavigation(false)
    }
}