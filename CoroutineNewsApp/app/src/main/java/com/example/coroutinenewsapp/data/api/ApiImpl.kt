package com.example.coroutinenewsapp.data.api


class ApiImpl(val apiService: ApiService) : ApiHelper {

    override suspend fun getNews() = apiService.getNews()

    override suspend fun getMoreNews() = apiService.getMoreNews()
}