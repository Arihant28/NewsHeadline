package com.work.asinghi.news.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.work.asinghi.news.R
import com.work.asinghi.news.data.NewsArticles
import kotlinx.android.synthetic.main.row_news.view.*

class NewsAdapter(
    private val listener: (NewsArticles) -> Unit
) : RecyclerView.Adapter<NewsAdapter.NewsHolder>() {
    
    private var newsArticles: List<NewsArticles> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        NewsHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_news, parent, false))

    override fun onBindViewHolder(newsHolder: NewsHolder, position: Int) =
        newsHolder.bind(newsArticles[position], listener)

    override fun getItemCount() = newsArticles.size

    class NewsHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


        fun bind(newsArticle: NewsArticles, listener: (NewsArticles) -> Unit) = with(itemView) {

            tvNewsItemTitle.text = newsArticle.title
            tvNewsAuthor.text = newsArticle.author

            tvListItemDateTime.text = newsArticle.publishedAt
            Picasso.with(context)
                .load(newsArticle.urlToImage)
                .into(ivNewsImage)
            setOnClickListener { listener(newsArticle) }


        }

    }

    fun replaceItems(items: List<NewsArticles>) {
        newsArticles = items
        notifyDataSetChanged()
    }
}
