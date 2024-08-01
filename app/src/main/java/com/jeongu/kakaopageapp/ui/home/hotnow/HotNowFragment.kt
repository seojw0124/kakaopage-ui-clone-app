package com.jeongu.kakaopageapp.ui.home.hotnow

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.jeongu.kakaopageapp.R
import com.jeongu.kakaopageapp.data.model.LinearContentInfo
import com.jeongu.kakaopageapp.data.repository.HomeContentRepositoryImpl
import com.jeongu.kakaopageapp.data.source.local.CacheDataSource
import com.jeongu.kakaopageapp.databinding.FragmentHotNowBinding
import com.jeongu.kakaopageapp.ui.common.ContentItemClickListener
import com.jeongu.kakaopageapp.ui.home.ContentViewModel

class HotNowFragment : Fragment(), ContentItemClickListener {

    private var _binding: FragmentHotNowBinding? = null
    private val binding get() = _binding!!

    private val contentRepository = HomeContentRepositoryImpl(CacheDataSource.getCacheDataSource())
    private val hotNowContentListAdapter by lazy {
        HotNowContentListAdapter(this)
    }

    private val viewModel by activityViewModels<ContentViewModel>()


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

    private fun setLayout() {
        initRecyclerView()
        initViewModel()
        setTopBanner()
    }

    private fun initRecyclerView() {
        binding.rvHotNowContentList.apply {
            adapter = hotNowContentListAdapter
            //hotNowContentListAdapter.submitList(contentRepository.getHotNowContentList())
        }
    }

    private fun initViewModel() = with(viewModel) {
        hotNowContentList.observe(viewLifecycleOwner) { contentList ->
            hotNowContentListAdapter.submitList(contentList)
        }
    }

    private fun setTopBanner() {
        binding.viewTopBanner.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://page.kakao.com/event/4ff6db86b64489c957dbd92b8d79d8ea"))
            startActivity(intent)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
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

        val action = HotNowFragmentDirections.actionGlobalContentDetail(contentId)
        findNavController().navigate(action)
    }
}