package com.jeongu.kakaopageapp.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import androidx.lifecycle.switchMap
import com.jeongu.kakaopageapp.R
import com.jeongu.kakaopageapp.data.model.ContentDetailInfo
import com.jeongu.kakaopageapp.data.model.HotNowInfo
import com.jeongu.kakaopageapp.data.model.HotNowLinearContent
import com.jeongu.kakaopageapp.data.model.LinearContentInfo
import com.jeongu.kakaopageapp.data.repository.RecentlyViewedRepository
import com.jeongu.kakaopageapp.data.source.local.HotNowManager

class ContentViewModel(private val repository: RecentlyViewedRepository) : ViewModel() {

    private val _hotNowContentList = MutableLiveData<List<HotNowInfo>>()
    val hotNowContentListWithRecentlyViewedList: LiveData<List<HotNowInfo>> = _hotNowContentList.switchMap { hotNowList ->
        _recentlyViewedList.map { recentlyViewedItems ->
            val newHotNowList = mutableListOf<HotNowInfo>()
            newHotNowList.addAll(hotNowList)
            val hotNowPosition = newHotNowList.indexOfFirst { it is HotNowLinearContent }
            newHotNowList[hotNowPosition] = HotNowLinearContent(recentlyViewedItems.map {
                LinearContentInfo(
                    it.id,
                    R.drawable.img_content_12,
                    it.title,
                    "웹툰",
                    R.drawable.ic_men
                )
            })
//            newHotNowList.add(HotNowLinearContent(recentlyViewedItems.map {
//                LinearContentInfo(
//                    it.id,
//                    R.drawable.img_content_01,
//                    it.title,
//                    "웹툰",
//                    R.drawable.ic_men
//                )
//            }))

            Log.d("HotNowList", hotNowList.size.toString())
            Log.d("HotNowList2", recentlyViewedItems.size.toString())
            newHotNowList
        }
    }
    private val _recentlyViewedList: MutableLiveData<List<ContentDetailInfo>> = MutableLiveData()
    val recentlyViewedList: LiveData<List<ContentDetailInfo>> = _recentlyViewedList
//    val recentlyViewedDetailList: LiveData<List<ContentDetailInfo>> = _recentlyViewedList.map { content ->
//        getDetailConent(content.con)
//    }

    init {
        loadRecentlyViewed()
    }

    private fun loadRecentlyViewed() {
        _recentlyViewedList.value = repository.recentlyViewedList
    }

    fun addRecentlyViewedItem(content: ContentDetailInfo) {
        repository.addRecentlyViewedItem(content)
        _recentlyViewedList.value = repository.recentlyViewedList
    }

    fun removeRecentlyViewedItem(content: ContentDetailInfo) {
        repository.removeRecentlyViewedItem(content)
        _recentlyViewedList.value = repository.recentlyViewedList
    }

    init {
        loadContent()
    }

    private fun loadContent() {
        _hotNowContentList.value = getDummyData()
    }

    fun addRecentlyViewedItem(content: LinearContentInfo) {
        val currentList = _hotNowContentList.value ?: return
        Log.d("ContentViewModel", "currentList: ${currentList.size}")
//        val updatedList = currentList.map {
//            if (it is HotNowLinearContent) {
//                Log.d("ContentViewModel", "addRecentlyViewedItem: ${it.linearItems}")
//                val updatedItems = it.linearItems.map { item ->
//                    if (item.id == content.id) content else item
//                }
//                HotNowLinearContent(updatedItems)
//            } else {
//                it
//            }
//        }
        // 0번째 인덱스에만 추가
        val updatedList = currentList.mapIndexed { index, hotNowInfo ->
            if (index == 0 && hotNowInfo is HotNowLinearContent) {
                val updatedItems = hotNowInfo.linearItems.toMutableList()
                updatedItems.add(0, content)
                HotNowLinearContent(updatedItems)
            } else {
                hotNowInfo
            }
        }
        _hotNowContentList.value = ArrayList(updatedList)
    }

    fun removeRecentlyViewedItem(content: LinearContentInfo) {
        val currentList = _hotNowContentList.value ?: return
        val updatedList = currentList.map {
            if (it is HotNowLinearContent) {
                val updatedItems = it.linearItems.filter { item -> item.id != content.id }
                HotNowLinearContent(updatedItems)
            } else {
                it
            }
        }
        _hotNowContentList.value = updatedList
    }

    private fun getDummyData(): MutableList<HotNowInfo> {
        return HotNowManager.getList()
    }
}
