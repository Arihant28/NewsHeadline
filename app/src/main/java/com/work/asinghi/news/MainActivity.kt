package com.work.asinghi.news

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.work.asinghi.news.adapter.NewsAdapter
import com.work.asinghi.news.data.network.Status
import com.work.asinghi.news.viewmodel.NewsViewModel
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), HasSupportFragmentInjector {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var newsViewModel: NewsViewModel


    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    override fun supportFragmentInjector() = dispatchingAndroidInjector

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val adapter = NewsAdapter {
            Toast.makeText(this, "Clicked on item", Toast.LENGTH_SHORT).show()
        }
        news_list.adapter = adapter
        news_list.layoutManager = LinearLayoutManager(this)

        newsViewModel = ViewModelProviders.of(this, viewModelFactory).get(NewsViewModel::class.java)

        // Observing for data change
        newsViewModel.getNewsArticles().observe(this, Observer {

            when (it.status) {
                Status.SUCCESS, Status.ERROR -> {
                }
                Status.LOADING -> {
                }
            }

            if (!it.status.isLoading()) {

            }

            it?.let { it.data?.let { it1 -> adapter.replaceItems(it1) } }
        })

    }
}
