package com.example.coroutinenewsapp.ui.newslist.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.browser.customtabs.CustomTabsIntent
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.coroutinenewsapp.R
import com.example.coroutinenewsapp.data.model.News
import kotlinx.android.synthetic.main.item_layout.view.*

class NewsListAdapter(val newsList: ArrayList<News>) :
    RecyclerView.Adapter<NewsListAdapter.NewsViewHolder>() {

    class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(news: News) {

            itemView.tv_title.text = news.title
            itemView.tv_description.text = news.description
            itemView.tv_source.text = news.source
            Glide.with(itemView.imageViewBanner.context)
                .load(news.imageUrl)
                .into(itemView.imageViewBanner)
            itemView.setOnClickListener {
                val builder = CustomTabsIntent.Builder()
                val customTabsIntent = builder.build()
                customTabsIntent.launchUrl(it.context, Uri.parse(news.url))
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = NewsViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout, parent, false)
    )

    override fun getItemCount() = newsList.size

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(newsList[position])
    }

    fun addData(list: List<News>) {
        newsList.addAll(list)
    }
}