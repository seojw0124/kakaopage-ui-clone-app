package com.jeongu.kakaopageapp.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jeongu.kakaopageapp.data.model.GridContentInfo
import com.jeongu.kakaopageapp.databinding.ItemGridContentBinding

class GridContentListAdapter(private val onClick: (GridContentInfo) -> Unit) : ListAdapter<GridContentInfo, GridContentListAdapter.ContentViewHolder>(
    ContentDiffCallback()
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContentViewHolder {
        val binding =
            ItemGridContentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ContentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ContentViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ContentViewHolder(private val binding: ItemGridContentBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(content: GridContentInfo) {
            itemView.setOnClickListener {
                onClick(content)
            }
            with(binding) {
                ivGridContentThumbnailImage.setImageResource(content.thumbnailImage)
                ivGridContentTitle.setImageResource(content.title)
                tvGridContentDescription.text = content.description
            }
        }
    }
}

private class ContentDiffCallback : DiffUtil.ItemCallback<GridContentInfo>() {
    override fun areItemsTheSame(oldItem: GridContentInfo, newItem: GridContentInfo): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: GridContentInfo, newItem: GridContentInfo): Boolean {
        return oldItem == newItem
    }
}