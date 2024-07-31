package com.jeongu.kakaopageapp.ui.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jeongu.kakaopageapp.data.model.TopContentInfo
import com.jeongu.kakaopageapp.databinding.ItemImageSlideBinding

class ViewPagerAdapter() : RecyclerView.Adapter<ViewPagerAdapter.ViewHolder>() {

    private val items = mutableListOf<TopContentInfo>()

    fun add(items: List<TopContentInfo>) {
        this.items.clear()
        this.items.addAll(items)
    }

    class ViewHolder(val binding: ItemImageSlideBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemImageSlideBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val actualPosition = position % items.size
        val item = items[actualPosition]
        with(holder.binding) {
            ivContent01.setImageResource(item.thumbnailImage)
            ivContent01Title.setImageResource(item.title)
            tvContent01Description.text = item.description

            if (item.freeTypeImage != null) {
                ivContent01Free.visibility = View.VISIBLE
                ivContent01Free.setImageResource(item.freeTypeImage!!)
            } else {
                ivContent01Free.visibility = View.INVISIBLE
            }

            if (item.uploadImage != null) {
                ivContent01Up.visibility = View.VISIBLE
                ivContent01Up.setImageResource(item.uploadImage!!)
            } else {
                ivContent01Up.visibility = View.GONE
            }

            if (item.genre != null) {
                tvContent01Genre.visibility = View.VISIBLE
                tvContent01Genre.text = item.genre
            } else {
                tvContent01Genre.visibility = View.INVISIBLE
            }

            tvContent01CurrentPage.text = item.page
        }
    }

    override fun getItemCount(): Int {
        return items.size * INFINTE_MULTIPLIER
    }

    companion object {
        private const val INFINTE_MULTIPLIER = 100
    }
}