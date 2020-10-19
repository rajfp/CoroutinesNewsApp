package com.example.coroutinenewsapp.data.api

import com.example.coroutinenewsapp.data.model.News

interface ApiHelper {

    suspend fun getNews(): List<News>

    suspend fun getMoreNews(): List<News>

}