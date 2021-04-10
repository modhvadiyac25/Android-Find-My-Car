package com.example.findmycar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.AuthFailureError
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import kotlinx.android.synthetic.main.activity_news_feed.*
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback

class NewsFeed : AppCompatActivity() {

    lateinit var adapter: NewsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_feed)



        getNews()
    }

    private fun getNews() {
        val news: Call<News> = NewsService.newsInstance.getHeadlines("carandbike.com",1)

        news.enqueue(object:Callback<News>{
            override fun onFailure(call: Call<News>, t: Throwable) {
                Log.d("NewsTag","Error in fetching news",t)
            }

            override fun onResponse(call: Call<News>, response: retrofit2.Response<News>) {
                val news = response.body()

                if(news != null) {
                    Log.d("NewsTag",news.toString())

                    adapter = NewsAdapter(this@NewsFeed,news.articles)
                    newsList.adapter = adapter
                    newsList.layoutManager = LinearLayoutManager(this@NewsFeed)
                }
            }
        })
    }
}