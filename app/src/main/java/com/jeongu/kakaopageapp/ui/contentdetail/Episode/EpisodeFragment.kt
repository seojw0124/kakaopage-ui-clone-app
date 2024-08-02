package com.jeongu.kakaopageapp.ui.contentdetail.Episode

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.jeongu.kakaopageapp.data.model.EpisodeInfo
import com.jeongu.kakaopageapp.data.source.local.EpisodeManager
import com.jeongu.kakaopageapp.databinding.FragmentEpisodeBinding
import com.jeongu.kakaopageapp.ui.home.ContentViewModel
import com.jeongu.kakaopageapp.ui.storagebox.StorageBoxViewModel
import com.jeongu.kakaopageapp.ui.storagebox.ContentViewModelFactory

class EpisodeFragment : Fragment() {

    private var _binding: FragmentEpisodeBinding? = null
    private val binding get() = _binding!!
    private val episodeAdapter by lazy { EpisodeListAdapter { episode -> setLastViewed(episode) } }
    private val viewModel: ContentViewModel by activityViewModels {
        ContentViewModelFactory(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEpisodeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.rvEpisodeList.apply {
            adapter = episodeAdapter
            episodeAdapter.submitList(EpisodeManager.getList().toList())
        }
    }

    private fun setLastViewed(episode: EpisodeInfo) {
        val content = EpisodeManager.setLastViewed(episode.id)
        if (content != null) {
            episodeAdapter.submitList(EpisodeManager.getList().toList())
            viewModel.addRecentlyViewedItem(content)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}