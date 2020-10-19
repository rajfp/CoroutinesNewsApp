package com.example.coroutinenewsapp.data.repository

import com.example.coroutinenewsapp.data.api.ApiHelper

class NewsListRepositoryImpl(val apiHelper: ApiHelper):NewsListRepository {

    override suspend fun getNews() = apiHelper.getNews()

    override suspend fun getMoreNews() = apiHelper.getMoreNews()
}