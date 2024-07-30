package com.jeongu.kakaopageapp.ui.home

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import com.jeongu.kakaopageapp.EXTRA_CONTENT_ID
import com.jeongu.kakaopageapp.MainActivity
import com.jeongu.kakaopageapp.R
import com.jeongu.kakaopageapp.data.repository.HomeContentRepositoryImpl
import com.jeongu.kakaopageapp.data.source.HomeContentRepository
import com.jeongu.kakaopageapp.data.source.local.CacheDataSource
import com.jeongu.kakaopageapp.data.source.local.HotNowManager
import com.jeongu.kakaopageapp.databinding.FragmentHotNowBinding
import com.jeongu.kakaopageapp.ui.common.ContentItemClickListener
import com.jeongu.kakaopageapp.ui.contentdetail.ContentDetailFragment

class HotNowFragment : Fragment(), ContentItemClickListener {

    private var _binding: FragmentHotNowBinding? = null
    private val binding get() = _binding!!

    private val contentRepository = HomeContentRepositoryImpl(CacheDataSource.getCacheDataSource())
    private val hotNowContentListAdapter by lazy {
        HotNowContentListAdapter(contentRepository.getHotNowContentList(), this)
    }

//    private val repository = HomeContentRepository()
//
//    private val hotNowContentListAdapter by lazy {
//        HotNowContentListAdapter(repository.getHotNowContentList())
//    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHotNowBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setLayout()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setLayout() {
        initRecyclerView()
        setTopBanner()
    }

    private fun initRecyclerView() {
        binding.rvHotNowContentList.apply {
            adapter = hotNowContentListAdapter
        }
    }

    private fun setTopBanner() {
        binding.viewTopBanner.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://page.kakao.com/event/4ff6db86b64489c957dbd92b8d79d8ea"))
            startActivity(intent)
        }

//        val topBanner = findViewById<View>(R.id.view_top_banner)
//        topBanner.setOnClickListener {
//            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://page.kakao.com/event/4ff6db86b64489c957dbd92b8d79d8ea"))
//            startActivity(intent)
//        }
    }

    override fun onContentItemClick(contentId: Int) {
//        val contentDetailFragment = ContentDetailFragment()
//        val bundle = Bundle()
//        bundle.putInt(EXTRA_CONTENT_ID, contentId)
//        contentDetailFragment.arguments = bundle
//        (binding.root.context as MainActivity).supportFragmentManager.commit {
//            setReorderingAllowed(true)
//            replace(R.id.container_home, contentDetailFragment)
//            addToBackStack(null)
//        }

//        (binding.root.context as MainActivity).supportFragmentManager.setFragmentResult("asdf", bundleOf("aaa" to contentId))
//        // ContentDetailFragment 로 이동
//        (binding.root.context as MainActivity).supportFragmentManager.commit {
//            setReorderingAllowed(true)
//            replace(R.id.container_home, ContentDetailFragment())
//            addToBackStack(null)
//        }

        val action = HotNowFragmentDirections.actionGlobalArticleDetail(contentId)
        findNavController().navigate(action)
    }
}