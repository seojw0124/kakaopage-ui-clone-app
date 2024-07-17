package com.jeongu.kakaopageapp.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jeongu.kakaopageapp.data.GridContentInfo
import com.jeongu.kakaopageapp.data.LinearContentInfo
import com.jeongu.kakaopageapp.databinding.ItemGridContentBinding
import com.jeongu.kakaopageapp.databinding.ItemLinearHorizontalContentBinding

class LinearContentListAdapter(private val onClick: (LinearContentInfo) -> Unit) : ListAdapter<LinearContentInfo, LinearContentListAdapter.ContentViewHolder>(
    LinearContentDiffCallback()
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContentViewHolder {
        val binding =
            ItemLinearHorizontalContentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ContentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ContentViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ContentViewHolder(private val binding: ItemLinearHorizontalContentBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(content: LinearContentInfo) {
            itemView.setOnClickListener {
                onClick(content)
            }
            with(binding) {
                ivLinearContentThumbnailImage.setImageResource(content.thumbnailImage)
                ivLinearContentFree.setImageResource(content.freeTypeImage)
                tvLinearContentTitle.text = content.title
                tvLinearContentCategory.text = content.category
            }
        }
    }
}

private class LinearContentDiffCallback : DiffUtil.ItemCallback<LinearContentInfo>() {
    override fun areItemsTheSame(oldItem: LinearContentInfo, newItem: LinearContentInfo): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: LinearContentInfo, newItem: LinearContentInfo): Boolean {
        return oldItem == newItem
    }
}