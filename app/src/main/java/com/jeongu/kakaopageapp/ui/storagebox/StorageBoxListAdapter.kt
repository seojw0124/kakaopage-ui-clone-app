package com.jeongu.kakaopageapp.ui.storagebox

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jeongu.kakaopageapp.data.model.ContentDetailInfo
import com.jeongu.kakaopageapp.data.model.LinearContentInfo
import com.jeongu.kakaopageapp.databinding.ItemLinearHorizontalContentBinding
import com.jeongu.kakaopageapp.databinding.ItemStorageBoxBinding
import com.jeongu.kakaopageapp.ui.home.adapter.LinearContentListAdapter

class StorageBoxListAdapter(private val onClick: (ContentDetailInfo) -> Unit) : ListAdapter<ContentDetailInfo, StorageBoxListAdapter.StorageBoxViewHolder>(
    StorageBoxDiffCallback()
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StorageBoxViewHolder {
        val binding =
            ItemStorageBoxBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return StorageBoxViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StorageBoxViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class StorageBoxViewHolder(private val binding: ItemStorageBoxBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(content: ContentDetailInfo) {
            itemView.setOnClickListener {
                onClick(content)
            }
            with(binding) {
                Glide.with(ivStorageContentThumbnailImage)
                    .load(content.thumbnailImage)
                    .into(ivStorageContentThumbnailImage)
                tvStorageContentTitle.text = content.title
                tvStorageContentDescription.text = content.creator
            }
        }
    }
}

private class StorageBoxDiffCallback : DiffUtil.ItemCallback<ContentDetailInfo>() {
    override fun areItemsTheSame(oldItem: ContentDetailInfo, newItem: ContentDetailInfo): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: ContentDetailInfo, newItem: ContentDetailInfo): Boolean {
        return oldItem == newItem
    }
}