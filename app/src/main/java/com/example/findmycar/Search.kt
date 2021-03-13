package com.example.findmycar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.SearchView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_search.*

class Search : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        val names = arrayOf("Android","java","sql","c","C++")

        val adapter : ArrayAdapter<String> = ArrayAdapter(this,android.R.layout.simple_list_item_1,names)

        list_view.adapter = adapter
        search.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                search.clearFocus()
                if(names.contains(query)){
                    adapter.filter.filter(query)
                    Toast.makeText(this@Search," " + query + " <-->" + adapter.filter.filter(query),Toast.LENGTH_LONG).show()
                }
                else{
                    Toast.makeText(this@Search,"Item not Found",Toast.LENGTH_LONG).show()
                }
                return false
            }

            override fun onQueryTextChange(query: String?): Boolean {

                adapter.filter.filter(query)

                return false
            }
        })

    }
}