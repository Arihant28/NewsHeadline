package com.work.asinghi.news.api

import androidx.lifecycle.LiveData
import com.work.asinghi.news.data.NewsSource
import com.work.asinghi.news.data.network.Resource
import retrofit2.http.GET

interface newsService {

    @GET("articles?source=google-news&apiKey=")
    fun getNewsSource(): LiveData<Resource<NewsSource>>

}