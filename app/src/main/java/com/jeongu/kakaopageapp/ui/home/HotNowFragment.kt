package com.jeongu.kakaopageapp.ui.home

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.jeongu.kakaopageapp.data.source.HomeContentRepository
import com.jeongu.kakaopageapp.data.source.local.HotNowManager
import com.jeongu.kakaopageapp.databinding.FragmentHotNowBinding

class HotNowFragment : Fragment() {

    private var _binding: FragmentHotNowBinding? = null
    private val binding get() = _binding!!
    private val repository = HomeContentRepository()

    private val hotNowContentListAdapter by lazy {
        HotNowContentListAdapter(repository.getHotNowContentList())
    }

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
}