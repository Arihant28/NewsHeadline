package com.work.asinghi.news.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.work.asinghi.news.data.NewsArticles
import com.work.asinghi.news.data.network.Resource
import com.work.asinghi.news.data.repo.NewsRepository
import javax.inject.Inject

class NewsViewModel @Inject constructor(
    newsRepository: NewsRepository
) : ViewModel() {

    private var newsArticles: LiveData<Resource<List<NewsArticles>?>> = newsRepository.getNewsArticles()

    fun getNewsArticles() = newsArticles
}