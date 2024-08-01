package com.jeongu.kakaopageapp.ui.shortcut

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
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
        with(binding) {
            layoutCategory01.root.setOnClickListener {
                val action = ShortcutFragmentDirections.actionShortcutToHome(layoutCategory01.tvCategory01.text.toString())
                findNavController().navigate(action)
            }
            layoutCategory02.root.setOnClickListener {
                val action = ShortcutFragmentDirections.actionShortcutToHome(layoutCategory02.tvCategory02.text.toString())
                findNavController().navigate(action)
            }
            layoutCategory03.root.setOnClickListener {
                val action = ShortcutFragmentDirections.actionShortcutToHome(layoutCategory03.tvCategory03.text.toString())
                findNavController().navigate(action)
            }
        }
    }

    private fun navigateToHome(category: String) {
        val intent = Intent(requireActivity(), MainActivity::class.java)
        intent.putExtra(EXTRA_STRING_CHIP, category)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
    }
}