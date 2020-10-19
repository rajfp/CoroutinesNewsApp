package com.example.coroutinenewsapp.data.repository

import com.example.coroutinenewsapp.data.model.News

interface NewsListRepository {

    suspend fun getNews(): List<News>

    suspend fun getMoreNews(): List<News>


}