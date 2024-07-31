package com.jeongu.kakaopageapp.ui.home.realtime

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.jeongu.kakaopageapp.data.repository.HomeContentRepositoryImpl
import com.jeongu.kakaopageapp.data.source.local.CacheDataSource
import com.jeongu.kakaopageapp.databinding.FragmentRealtimeRankingBinding
import com.jeongu.kakaopageapp.ui.common.ContentItemClickListener
import com.jeongu.kakaopageapp.ui.home.hotnow.HotNowContentListAdapter

class RealtimeRankingFragment : Fragment(), ContentItemClickListener {

    private var _binding: FragmentRealtimeRankingBinding? = null
    private val binding get() = _binding!!

    private val contentRepository = HomeContentRepositoryImpl(CacheDataSource.getCacheDataSource())
    private val realtimeRankingListAdapter by lazy {
        HotNowContentListAdapter(this)
    }

//    private val repository = HomeContentRepository()
//    private val realtimeRankingListAdapter by lazy {
//        HotNowContentListAdapter(repository.getRealtimeRankingContentList())
//    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRealtimeRankingBinding.inflate(inflater, container, false)
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
            adapter = realtimeRankingListAdapter
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
//        parentFragmentManager.commit {
//            setReorderingAllowed(true)
//            replace(R.id.container_home, contentDetailFragment)
//            addToBackStack(null)
//        }

        val action = RealtimeRankingFragmentDirections.actionGlobalArticleDetail(contentId)
        findNavController().navigate(action)
    }
}