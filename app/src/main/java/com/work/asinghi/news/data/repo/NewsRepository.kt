package com.work.asinghi.news.data.repo

import androidx.lifecycle.LiveData
import com.work.asinghi.news.AppExecutors
import com.work.asinghi.news.api.newsService
import com.work.asinghi.news.data.NetworkBoundResource
import com.work.asinghi.news.data.NewsArticles
import com.work.asinghi.news.data.NewsSource
import com.work.asinghi.news.data.network.Resource
import com.work.asinghi.news.db.newsDao
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NewsRepository @Inject constructor(
    private val newsDao: newsDao,
    private val newsSourceService: newsService,
    private val appExecutors: AppExecutors = AppExecutors()
) {

    /**
     * Fetch the news articles from database if exist else fetch from web
     * and persist them in the database
     */
    fun getNewsArticles(): LiveData<Resource<List<NewsArticles>?>> {
        return object : NetworkBoundResource<List<NewsArticles>, NewsSource>(appExecutors) {
            override fun saveCallResult(item: NewsSource) {
                newsDao.insertArticles(item.articles)
            }

            override fun shouldFetch(data: List<NewsArticles>?) = true

            override fun loadFromDb() = newsDao.getNewsArticles()

            override fun createCall() = newsSourceService.getNewsSource()
        }.asLiveData()
    }

}
