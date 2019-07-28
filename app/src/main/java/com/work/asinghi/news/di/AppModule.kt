package com.work.asinghi.news.di

import android.app.Application
import androidx.room.Room
import com.work.asinghi.news.api.newsService
import com.work.asinghi.news.db.newsDao
import com.work.asinghi.news.db.newsDatabase
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class AppModule {

    @Provides
    fun provideNewsService(): newsService {
        return Retrofit.Builder()
            .baseUrl("https://newsapi.org/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(newsService::class.java)
    }


    @Provides
    fun provideDb(app: Application): newsDatabase = Room.databaseBuilder(app, newsDatabase::class.java, "news-db").build()


    @Provides
    fun provideUserDao(db: newsDatabase): newsDao = db.newsArticlesDao()

}