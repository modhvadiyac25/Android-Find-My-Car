package com.example.findmycar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.SearchView
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_search.*

class Search : AppCompatActivity() {

    var database: DatabaseReference = FirebaseDatabase.getInstance().getReference("cars")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        var names : ArrayList<String> = ArrayList()
        names.clear()

        // show profile
      //  val id = intent.getStringExtra("user_id").toString()

        var getdata = object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {

            }
            override fun onDataChange(snapshot: DataSnapshot) {
                //var sb = StringBuilder()
                for (i in snapshot.children) {
                    names.add(i.child("").child("name").getValue().toString())
                }
            }
        }

        database.addValueEventListener(getdata)
        database.addListenerForSingleValueEvent(getdata)

        val adapter: ArrayAdapter<String> =
            ArrayAdapter(this, android.R.layout.simple_list_item_1, names)



        list_view.adapter = adapter
        search.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                search.clearFocus()
                if (names.contains(query)) {
                    adapter.filter.filter(query)
                    var intent = Intent(this@Search, CarDetails::class.java)
                    intent.putExtra("Name", query)
                    startActivity(intent)
                   //  Toast.makeText(this@Search," " + query + " <-->" + adapter.filter.filter(query),Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(this@Search, "Item not Found ", Toast.LENGTH_LONG).show()
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