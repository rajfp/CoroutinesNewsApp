package com.example.coroutinenewsapp.ui.newslist.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coroutinenewsapp.data.model.News
import com.example.coroutinenewsapp.data.repository.NewsListRepository
import com.example.coroutinenewsapp.utils.Resource
import kotlinx.coroutines.launch
import java.lang.Exception

class NewsListViewModel(private val repository: NewsListRepository) : ViewModel() {

    private val newsList = MutableLiveData<Resource<List<News>>>()

    init {
        fetchNews()
    }

     private fun fetchNews() {
        viewModelScope.launch {
            newsList.postValue(Resource.loading())
            try {
                val news = repository.getNews()
                newsList.postValue(Resource.success(news as ArrayList))
            } catch (e: Exception) {
                newsList.postValue(Resource.error(e.toString()))
            }
        }
    }
    fun getNews() = newsList
}