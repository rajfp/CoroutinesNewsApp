package com.example.coroutinenewsapp.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.coroutinenewsapp.data.api.ApiHelper
import com.example.coroutinenewsapp.data.repository.NewsListRepository
import com.example.coroutinenewsapp.data.repository.NewsListRepositoryImpl
import com.example.coroutinenewsapp.ui.newslist.viewmodel.NewsListViewModel

class ViewModelFactory(val apiHelper: ApiHelper) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NewsListViewModel::class.java))
            return NewsListViewModel(NewsListRepositoryImpl(apiHelper)) as T
        throw IllegalAccessException("Unknown class name")
    }

}