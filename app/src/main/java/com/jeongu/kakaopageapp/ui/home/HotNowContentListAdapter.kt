package com.jeongu.kakaopageapp.ui.home

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
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

private const val VIEW_TYPE_VIEW_PAGER = 0
private const val VIEW_TYPE_SECTION_TITLE = 1
private const val VIEW_TYPE_GRID_CONTENT = 2
private const val VIEW_TYPE_LINEAR_HORIZONTAL_CONTENT = 3

class HotNowContentListAdapter(
    private val items: List<HotNowInfo>,
    private val listener: ContentItemClickListener
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

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
                val item = items[position] as HotNowViewPager
                holder.bind(item)
            }
            is HotNowSectionTitleViewHolder -> {
                val item = items[position] as HotNowSectionTitle
                holder.bind(item)
            }
            is HotNowGridViewHolder -> {
                val item = items[position] as HotNowGridContent
                holder.bind(item)
            }
            is HotNowLinearViewHolder -> {
                val item = items[position] as HotNowLinearContent
                holder.bind(item)
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun getItemViewType(position: Int): Int {
        return when (items[position]) {
            is HotNowViewPager -> VIEW_TYPE_VIEW_PAGER
            is HotNowSectionTitle -> VIEW_TYPE_SECTION_TITLE
            is HotNowGridContent -> VIEW_TYPE_GRID_CONTENT
            is HotNowLinearContent -> VIEW_TYPE_LINEAR_HORIZONTAL_CONTENT
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
                return HotNowViewPagerViewHolder(ItemHotNowViewPagerBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    ))
            }
        }
    }

    class HotNowSectionTitleViewHolder(private val binding: ItemHotNowSectionTitleBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: HotNowSectionTitle) {
            binding.tvSectionTitle.text = item.title
        }

        companion object {
            fun from(parent: ViewGroup): HotNowSectionTitleViewHolder {
                return HotNowSectionTitleViewHolder(ItemHotNowSectionTitleBinding.inflate(LayoutInflater.from(parent.context), parent, false))
            }
        }
    }

    class HotNowGridViewHolder(
        private val binding: ItemHotNowGridContentBinding,
        private val listener: ContentItemClickListener
    ): RecyclerView.ViewHolder(binding.root) {

        private val gridContentAdapter = GridContentListAdapter { content ->
//            val intent = Intent(binding.root.context, ContentDetailActivity::class.java)
//            intent.putExtra(EXTRA_CONTENT_ID, content.id)
//            binding.root.context.startActivity(intent)
            // ContentDetailFragment로 이동
//            val contentDetailFragment = ContentDetailFragment()
//            val bundle = Bundle()
//            bundle.putInt(EXTRA_CONTENT_ID, content.id)
//            contentDetailFragment.arguments = bundle
//            (binding.root.context as MainActivity).supportFragmentManager.beginTransaction()
//                .replace(R.id.container_home, contentDetailFragment)
//                .addToBackStack(null)
//                .commit()
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