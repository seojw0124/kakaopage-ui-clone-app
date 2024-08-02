package com.jeongu.kakaopageapp.ui.storagebox

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.jeongu.kakaopageapp.databinding.FragmentStorageBoxBinding
import com.jeongu.kakaopageapp.ui.home.ContentViewModel

class StorageBoxFragment : Fragment() {

    private var _binding: FragmentStorageBoxBinding? = null
    private val binding get() = _binding!!

    private val viewModel: ContentViewModel by activityViewModels {
        ContentViewModelFactory(requireContext())
    }
    private val storageBoxAdapter by lazy {
        StorageBoxListAdapter { content ->
            val action = StorageBoxFragmentDirections.actionGlobalContentDetail(content.id)
            findNavController().navigate(action)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentStorageBoxBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setLayout()
    }

    private fun setLayout() {
        initView()
        initViewModel()
    }

    private fun initView() = with(binding) {
        rvStorageBox.adapter = storageBoxAdapter
    }

    private fun initViewModel() = with(viewModel) {
        recentlyViewedList.observe(viewLifecycleOwner) { storageBoxList ->
            storageBoxAdapter.submitList(storageBoxList)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}