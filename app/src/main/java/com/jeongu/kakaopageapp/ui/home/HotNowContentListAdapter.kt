//package com.jeongu.kakaopageapp.ui.home
//
//import android.view.LayoutInflater
//import android.view.ViewGroup
//import androidx.recyclerview.widget.RecyclerView
//import com.jeongu.kakaopageapp.data.HotNowGridContent
//import com.jeongu.kakaopageapp.data.HotNowInfo
//import com.jeongu.kakaopageapp.data.HotNowLinearContent
//import com.jeongu.kakaopageapp.data.HotNowSectionTitle
//import com.jeongu.kakaopageapp.data.HotNowViewPager
//import com.jeongu.kakaopageapp.databinding.ItemImageSlideBinding
//
//private const val VIEW_TYPE_VIEW_PAGER = 0
//private const val VIEW_TYPE_SECTION_TITLE = 1
//private const val VIEW_TYPE_GRID_CONTENT = 2
//private const val VIEW_TYPE_LINEAR_HORIZONTAL_CONTENT = 3
//
//class HotNowContentListAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
//
//    private val items = mutableListOf<HotNowInfo>()
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
//        return when (viewType) {
//            VIEW_TYPE_VIEW_PAGER -> HotNowViewPagerViewHolder.from(parent)
//            VIEW_TYPE_SECTION_TITLE -> HotNowSectionTitleViewHolder.from(parent)
//            VIEW_TYPE_GRID_CONTENT -> HotNowGridViewHolder.from(parent)
//            else -> HotNowLinearViewHolder.from(parent)
//        }
//    }
//
//    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
//        when (holder) {
//            is HotNowViewPagerViewHolder -> {
//                val item = items[position] as HotNowViewPager
//                holder.bind(item)
//            }
//            is HotNowSectionTitleViewHolder -> {
//                val item = items[position] as HotNowSectionTitle
//                holder.bind(item)
//            }
//            is HotNowGridViewHolder -> {
//                val item = items[position] as HotNowGridContent
//                holder.bind(item)
//            }
//            is HotNowLinearViewHolder -> {
//                val item = items[position] as HotNowLinearContent
//                holder.bind(item)
//            }
//        }
//    }
//
//    override fun getItemCount(): Int {
//        return items.size
//    }
//
//    override fun getItemViewType(position: Int): Int {
//        return when (items[position]) {
//            is HotNowViewPager -> VIEW_TYPE_VIEW_PAGER
//            is HotNowSectionTitle -> VIEW_TYPE_SECTION_TITLE
//            is HotNowGridContent -> VIEW_TYPE_GRID_CONTENT
//            is HotNowLinearContent -> VIEW_TYPE_LINEAR_HORIZONTAL_CONTENT
//        }
//    }
//
//    private fun initData() {
//        update(HotNowManager.getList())
//    }
//
//    private fun update(hotNowItems: List<HotNowInfo>) {
//        items.clear()
//        items.addAll(hotNowItems)
//        notifyDataSetChanged()
//    }
//
//    class HotNowViewPagerViewHolder(private val binding: ItemImageSlideBinding) : RecyclerView.ViewHolder(binding.root) {
//        private val viewPagerAdapter = ViewPagerAdapter()
//
//        init {
//            binding.viewPager.adapter = viewPagerAdapter
//        }
//
//        companion object {
//            fun from(parent: ViewGroup): HotNowViewPagerViewHolder {
//                return HotNowViewPagerViewHolder(
//                    ItemImageSlideBinding.inflate(
//                        LayoutInflater.from(parent.context),
//                        parent,
//                        false
//                    )
//                )
//            }
//        }
//    }
//}