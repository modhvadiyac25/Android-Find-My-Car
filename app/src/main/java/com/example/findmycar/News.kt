package com.example.findmycar

data class News(
    val totalResults: String,
    val articles: List<Article>,
    val description: String,
    val url: String,
    val urlToImage: String
)