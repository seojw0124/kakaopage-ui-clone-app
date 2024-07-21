package com.jeongu.kakaopageapp.ui.contentdetail

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jeongu.kakaopageapp.R
import com.jeongu.kakaopageapp.data.EpisodeInfo
import com.jeongu.kakaopageapp.databinding.ItemContentEpisodeBinding

class EpisodeListAdapter() : ListAdapter<EpisodeInfo, EpisodeListAdapter.EpisodeViewHolder>(
    EpisodeDiffCallback()
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodeViewHolder {
        val binding = ItemContentEpisodeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return EpisodeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: EpisodeViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class EpisodeViewHolder(private val binding: ItemContentEpisodeBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(episode: EpisodeInfo) {
            with(binding) {
                ivEpisodeThumbnailImage.setImageResource(episode.thumbnailImage)
                tvEpisodeTitle.text = episode.title
                tvEpisodeDate.text = episode.date
                tvEpisodePage.text = itemView.context.getString(R.string.format_episode_page, episode.page)

                if (episode.isFree) {
                    tvEpisodeFree.visibility = View.VISIBLE
                    ivEpisodeClock.visibility = View.GONE
                } else {
                    tvEpisodeFree.visibility = View.GONE
                    ivEpisodeClock.visibility = View.VISIBLE
                }
                if (episode.isViewed) {
                    viewEpisodeAlphaArea.visibility = View.VISIBLE

                    ivEpisodeFoldedPaper.isVisible = episode.isLastViewed
                } else {
                    viewEpisodeAlphaArea.visibility = View.GONE
                    ivEpisodeFoldedPaper.visibility = View.GONE
                }
            }
        }
    }
}

private class EpisodeDiffCallback : DiffUtil.ItemCallback<EpisodeInfo>() {
    override fun areItemsTheSame(oldItem: EpisodeInfo, newItem: EpisodeInfo): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: EpisodeInfo, newItem: EpisodeInfo): Boolean {
        return oldItem == newItem
    }
}