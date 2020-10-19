package com.example.coroutinenewsapp.ui.newslist.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Adapter
import android.widget.LinearLayout
import android.widget.Toast
import androidx.lifecycle.*
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.coroutinenewsapp.R
import com.example.coroutinenewsapp.data.api.ApiHelper
import com.example.coroutinenewsapp.data.api.ApiImpl
import com.example.coroutinenewsapp.data.api.RetrofitBuilder
import com.example.coroutinenewsapp.data.model.News
import com.example.coroutinenewsapp.ui.base.ViewModelFactory
import com.example.coroutinenewsapp.ui.newslist.adapter.NewsListAdapter
import com.example.coroutinenewsapp.ui.newslist.viewmodel.NewsListViewModel
import com.example.coroutinenewsapp.utils.Status
import kotlinx.android.synthetic.main.news_list_activity.*

class NewsListActivity : AppCompatActivity() {

    private lateinit var newsViewModel: NewsListViewModel
    private lateinit var adapter: NewsListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.news_list_activity)
        setupUi()
        setupViewModel()
        setupObserver()
    }

    private fun setupUi() {
        recycler_view.layoutManager = LinearLayoutManager(this)
        adapter = NewsListAdapter(arrayListOf())
        recycler_view.adapter = adapter
    }

    private fun setupObserver() {

        newsViewModel.getNews().observe(this, Observer {
            when (it.status) {

                Status.SUCCESS -> {
                    progress.visibility = View.GONE
                    it.data?.let { it1 -> renderList(it1) }
                    recycler_view.visibility= View.VISIBLE
                }

                Status.LOADING ->{
                    progress.visibility = View.VISIBLE
                    recycler_view.visibility= View.GONE
                }

                Status.ERROR -> {
                    progress.visibility = View.GONE
                    recycler_view.visibility= View.GONE
                    Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                }

            }
        })
    }

    private fun renderList(list: List<News>) {
        adapter.addData(list)
        adapter.notifyDataSetChanged()
    }

    private fun setupViewModel() {
        newsViewModel = ViewModelProviders.of(
            this, ViewModelFactory(ApiImpl(RetrofitBuilder.apiService))
        ).get(NewsListViewModel::class.java)
    }
}