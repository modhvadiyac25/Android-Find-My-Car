package com.example.findmycar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SearchList : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_list)
        startActivity(Intent(this,CarDetails::class.java))
    }
    
}
