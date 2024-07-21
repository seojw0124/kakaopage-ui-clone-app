package com.jeongu.kakaopageapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import com.jeongu.kakaopageapp.R
import com.jeongu.kakaopageapp.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val homeTabTitles = mapOf(
        "지금핫한" to R.drawable.ic_thunder,
        "실시간 랭킹" to R.drawable.ic_crown,
        "오늘신작" to R.drawable.ic_bell,
        "TV속 작품" to R.drawable.ic_popcorn,
        "이벤트" to R.drawable.ic_star,
        "남성인기" to R.drawable.ic_men,
        "여성인기" to R.drawable.ic_women,
        "완결추천" to R.drawable.ic_ring,
        "브랜드" to R.drawable.ic_c_coin,
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
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
        binding.viewpagerHome.adapter = HomePagerStateAdapter(this)
        TabLayoutMediator(binding.tabHome, binding.viewpagerHome) { tab, position ->
            tab.text = homeTabTitles.keys.toList()[position]
            tab.setIcon(homeTabTitles.values.toList()[position])
        }.attach()
    }
}