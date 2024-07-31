package com.jeongu.kakaopageapp.ui.storagebox

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jeongu.kakaopageapp.data.model.ContentDetailInfo
import com.jeongu.kakaopageapp.data.model.GridContentInfo
import com.jeongu.kakaopageapp.data.model.HotNowLinearContent
import com.jeongu.kakaopageapp.data.model.LinearContentInfo
import com.jeongu.kakaopageapp.data.repository.RecentlyViewedRepository

class StorageBoxViewModel(private val repository: RecentlyViewedRepository) : ViewModel() {
    private val _recentlyViewedList: MutableLiveData<List<ContentDetailInfo>> = MutableLiveData()
    val recentlyViewedList: LiveData<List<ContentDetailInfo>> = _recentlyViewedList

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
}