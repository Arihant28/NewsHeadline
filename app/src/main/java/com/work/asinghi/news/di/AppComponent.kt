package com.work.asinghi.news.di

import android.app.Application
import com.work.asinghi.news.MainActivity
import com.work.asinghi.news.NewsApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AndroidInjectionModule::class,

        AppModule::class,
        ActivityModule::class,
        ViewModelModule::class
    ]
)
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: Application): Builder
        fun build(): AppComponent
    }
    fun inject(app: NewsApplication)
    fun inject(mainActivity: MainActivity)
}