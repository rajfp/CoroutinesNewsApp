package com.example.coroutinenewsapp.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {

    private const val BASE_URL = "https://demo9376629.mockable.io/"

    private fun getRetrofitBuilder() = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val apiService:ApiService = getRetrofitBuilder().create(ApiService::class.java)
}