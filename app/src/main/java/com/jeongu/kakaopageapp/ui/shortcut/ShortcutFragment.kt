package com.jeongu.kakaopageapp.ui.shortcut

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.jeongu.kakaopageapp.ui.EXTRA_STRING_CHIP
import com.jeongu.kakaopageapp.ui.MainActivity
import com.jeongu.kakaopageapp.databinding.FragmentShortcutBinding

class ShortcutFragment : Fragment() {

    private var _binding: FragmentShortcutBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentShortcutBinding.inflate(inflater, container, false)
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
        setCategory()
    }

    private fun setCategory() {
//        val categoryList = listOf(
//            "지금핫한", "실시간 랭킹", "오늘신작", "TV속 작품", "이벤트",
//            "남성인기", "여성인기", "완결추천", "브랜드"
//        )
//        val categoryViewList = listOf(
//            binding.tvCategory1, binding.tvCategory2, binding.tvCategory3,
//            binding.tvCategory4, binding.tvCategory5, binding.tvCategory6,
//            binding.tvCategory7, binding.tvCategory8, binding.tvCategory9
//        )
//        categoryList.forEachIndexed { index, category ->
//            categoryViewList[index].text = category
//            categoryViewList[index].setOnClickListener {
//                navigateToHome(category)
//            }
//        }
    }

    private fun navigateToHome(category: String) {
        val intent = Intent(requireActivity(), MainActivity::class.java)
        intent.putExtra(EXTRA_STRING_CHIP, category)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
    }
}