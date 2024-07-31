package com.jeongu.kakaopageapp.ui.home.hotnow

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jeongu.kakaopageapp.EXTRA_CONTENT_ID
import com.jeongu.kakaopageapp.data.model.HotNowGridContent
import com.jeongu.kakaopageapp.data.model.HotNowInfo
import com.jeongu.kakaopageapp.data.model.HotNowLinearContent
import com.jeongu.kakaopageapp.data.model.HotNowSectionTitle
import com.jeongu.kakaopageapp.data.model.HotNowViewPager
import com.jeongu.kakaopageapp.databinding.ItemHotNowGridContentBinding
import com.jeongu.kakaopageapp.databinding.ItemHotNowLinearContentBinding
import com.jeongu.kakaopageapp.databinding.ItemHotNowSectionTitleBinding
import com.jeongu.kakaopageapp.databinding.ItemHotNowViewPagerBinding
import com.jeongu.kakaopageapp.ui.common.ContentItemClickListener
import com.jeongu.kakaopageapp.ui.contentdetail.ContentDetailActivity
import com.jeongu.kakaopageapp.ui.home.adapter.GridContentListAdapter
import com.jeongu.kakaopageapp.ui.home.adapter.LinearContentListAdapter
import com.jeongu.kakaopageapp.ui.home.adapter.ViewPagerAdapter

private const val VIEW_TYPE_VIEW_PAGER = 0
private const val VIEW_TYPE_SECTION_TITLE = 1
private const val VIEW_TYPE_GRID_CONTENT = 2
private const val VIEW_TYPE_LINEAR_HORIZONTAL_CONTENT = 3

class HotNowContentListAdapter(
    private val listener: ContentItemClickListener
) : ListAdapter<HotNowInfo, RecyclerView.ViewHolder>(HotNowDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            VIEW_TYPE_VIEW_PAGER -> HotNowViewPagerViewHolder.from(parent)
            VIEW_TYPE_SECTION_TITLE -> HotNowSectionTitleViewHolder.from(parent)
            VIEW_TYPE_GRID_CONTENT -> HotNowGridViewHolder.from(parent, listener)
            VIEW_TYPE_LINEAR_HORIZONTAL_CONTENT -> HotNowLinearViewHolder.from(parent)
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is HotNowViewPagerViewHolder -> {
                val item = getItem(position) as HotNowViewPager
                holder.bind(item)
            }
            is HotNowSectionTitleViewHolder -> {
                val item = getItem(position) as HotNowSectionTitle
                holder.bind(item)
            }
            is HotNowGridViewHolder -> {
                val item = getItem(position) as HotNowGridContent
                holder.bind(item)
            }
            is HotNowLinearViewHolder -> {
                val item = getItem(position) as HotNowLinearContent
                holder.bind(item)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is HotNowViewPager -> VIEW_TYPE_VIEW_PAGER
            is HotNowSectionTitle -> VIEW_TYPE_SECTION_TITLE
            is HotNowGridContent -> VIEW_TYPE_GRID_CONTENT
            is HotNowLinearContent -> VIEW_TYPE_LINEAR_HORIZONTAL_CONTENT
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    class HotNowViewPagerViewHolder(private val binding: ItemHotNowViewPagerBinding) : RecyclerView.ViewHolder(binding.root) {
        private val viewPagerAdapter = ViewPagerAdapter()

        init {
            binding.viewpagerHotNow.adapter = viewPagerAdapter
        }

        fun bind(item: HotNowViewPager) {
            viewPagerAdapter.add(item.viewPagerItems)
        }

        companion object {
            fun from(parent: ViewGroup): HotNowViewPagerViewHolder {
                return HotNowViewPagerViewHolder(
                    ItemHotNowViewPagerBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
        }
    }

    class HotNowSectionTitleViewHolder(private val binding: ItemHotNowSectionTitleBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: HotNowSectionTitle) {
            binding.tvSectionTitle.text = item.title
        }

        companion object {
            fun from(parent: ViewGroup): HotNowSectionTitleViewHolder {
                return HotNowSectionTitleViewHolder(
                    ItemHotNowSectionTitleBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
        }
    }

    class HotNowGridViewHolder(
        private val binding: ItemHotNowGridContentBinding,
        private val listener: ContentItemClickListener
    ): RecyclerView.ViewHolder(binding.root) {

        private val gridContentAdapter = GridContentListAdapter { content ->
            listener.onContentItemClick(content.id)
        }

        init {
            binding.rvHotNowGridContent.adapter = gridContentAdapter
        }

        fun bind(item: HotNowGridContent) {
            gridContentAdapter.submitList(item.gridItems)
        }

        companion object {
            fun from(parent: ViewGroup, listener: ContentItemClickListener): HotNowGridViewHolder {
                return HotNowGridViewHolder(
                    ItemHotNowGridContentBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    ),
                    listener
                )
            }
        }
    }

    class HotNowLinearViewHolder(private val binding: ItemHotNowLinearContentBinding): RecyclerView.ViewHolder(binding.root) {

        private val linearContentAdapter = LinearContentListAdapter { content ->
            val intent = Intent(binding.root.context, ContentDetailActivity::class.java)
            intent.putExtra(EXTRA_CONTENT_ID, content.id)
            binding.root.context.startActivity(intent)
        }

        init {
            binding.rvHotNowLinearContent.adapter = linearContentAdapter
        }

        fun bind(item: HotNowLinearContent) {
            linearContentAdapter.submitList(item.linearItems)
        }

        companion object {
            fun from(parent: ViewGroup): HotNowLinearViewHolder {
                return HotNowLinearViewHolder(
                    ItemHotNowLinearContentBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
        }
    }
}

class HotNowDiffCallback : DiffUtil.ItemCallback<HotNowInfo>() {
    override fun areItemsTheSame(oldItem: HotNowInfo, newItem: HotNowInfo): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: HotNowInfo, newItem: HotNowInfo): Boolean {
        return oldItem == newItem
    }
}
