package com.example.findmycar

import android.os.Build
import androidx.annotation.RequiresApi
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import java.text.SimpleDateFormat
import java.util.*


//https://newsapi.org/v2/everything?domains=carandbike.com&apiKey=32928a2683a84591987f113ab04c2faf

const val BASE_URL = "https://newsapi.org/"
const val API_KEY = "32928a2683a84591987f113ab04c2faf"
var date = Date()
val formatter = SimpleDateFormat("MMM dd yyyy")
val answer: String = formatter.format(date)


interface NewsInterface {

    @GET("/v2/everything?apiKey=$API_KEY")
    fun getHeadlines(@Query("domains") domains : String,@Query("page") page: Int) : Call<News>

    //https://newsapi.org/v2/everything?apiKey=32928a2683a84591987f113ab04c2faf&domains=carandbike.com&page=1
}

object NewsService {
    val newsInstance: NewsInterface

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        newsInstance = retrofit.create(NewsInterface::class.java)
    }
}