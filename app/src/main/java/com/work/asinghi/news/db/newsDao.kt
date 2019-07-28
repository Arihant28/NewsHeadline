package com.work.asinghi.news.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.work.asinghi.news.data.NewsArticles

@Dao
interface newsDao {

    /**
     * Insert articles into the database
     */
    @Insert
    fun insertArticles(articles: List<NewsArticles>): List<Long>

    /**
     * Get all the articles from database
     */
    @Query("SELECT * FROM news_article")
    fun getNewsArticles(): LiveData<List<NewsArticles>>
}