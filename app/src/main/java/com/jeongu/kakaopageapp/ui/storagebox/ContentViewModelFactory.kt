package com.jeongu.kakaopageapp.ui.storagebox

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jeongu.kakaopageapp.data.repository.RecentlyViewedRepository
import com.jeongu.kakaopageapp.ui.home.ContentViewModel

class ContentViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(ContentViewModel::class.java) -> {
                ContentViewModel(RecentlyViewedRepository(context.applicationContext)) as T
            }
            else -> throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}