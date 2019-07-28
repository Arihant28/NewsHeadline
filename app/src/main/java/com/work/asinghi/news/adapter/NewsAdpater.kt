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

    /**
     * List of news articles
     */
    private var newsArticles: List<NewsArticles> = emptyList()

    /**
     * Inflate the view
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        NewsHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_news, parent, false))

    /**
     * Bind the view with the data
     */
    override fun onBindViewHolder(newsHolder: NewsHolder, position: Int) =
        newsHolder.bind(newsArticles[position], listener)

    /**
     * Number of items in the list to display
     */
    override fun getItemCount() = newsArticles.size

    /**
     * View Holder Pattern
     */
    class NewsHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        /**
         * Binds the UI with the data and handles clicks
         */
        fun bind(newsArticle: NewsArticles, listener: (NewsArticles) -> Unit) = with(itemView) {
            //news_title.text = newsArticle.title
            //news_description.text = newsArticle.description
            tvNewsItemTitle.text = newsArticle.title
            tvNewsAuthor.text = newsArticle.author
            //TODO: need to format date
            //tvListItemDateTime.text = getFormattedDate(newsArticle.publishedAt)
            tvListItemDateTime.text = newsArticle.publishedAt
            Picasso.with(context)
                .load(newsArticle.urlToImage)
                .into(ivNewsImage)
            setOnClickListener { listener(newsArticle) }


        }

    }

    /**
     * Swap function to set new data on updating
     */
    fun replaceItems(items: List<NewsArticles>) {
        newsArticles = items
        notifyDataSetChanged()
    }
}
