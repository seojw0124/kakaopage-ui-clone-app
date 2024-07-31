package com.jeongu.kakaopageapp.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jeongu.kakaopageapp.data.model.HotNowInfo
import com.jeongu.kakaopageapp.data.model.HotNowLinearContent
import com.jeongu.kakaopageapp.data.model.LinearContentInfo
import com.jeongu.kakaopageapp.data.source.local.HotNowManager

class ContentViewModel : ViewModel() {

    private val _hotNowContentList = MutableLiveData<List<HotNowInfo>>()
    val hotNowContentList: LiveData<List<HotNowInfo>> = _hotNowContentList

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
//                Log.d("ContentViewModel", "addRecentlyViewedItem: ${it.linearItems.size}")
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
