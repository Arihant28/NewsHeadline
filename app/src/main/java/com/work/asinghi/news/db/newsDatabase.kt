package com.work.asinghi.news.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.work.asinghi.news.data.NewsArticles

@Database(entities = [NewsArticles::class], version = 1)
abstract class newsDatabase : RoomDatabase() {

    /**
     * Get news article DAO
     */
    abstract fun newsArticlesDao(): newsDao
}