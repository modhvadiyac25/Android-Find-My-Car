package com.example.findmycar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_profile.*

class Profile : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        lateinit var database: DatabaseReference
        // show profile

        val id  = intent.getStringExtra("user_id").toString()
        database = FirebaseDatabase.getInstance().getReference("users")

        var getdata = object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {
            }

            override fun onDataChange(snapshot: DataSnapshot) {
                //var sb = StringBuilder()
                for (i in snapshot.children) {
                    var uid = i.child("uid").getValue()
                    if (id.equals(uid)) {

                        findViewById<EditText>(R.id.email).setText(
                            i.child("email").getValue().toString()
                        )
                        findViewById<EditText>(R.id.fn).setText(
                            i.child("fname").getValue().toString()
                        )
                        findViewById<EditText>(R.id.ln).setText(
                            i.child("lname").getValue().toString()
                        )
                        findViewById<EditText>(R.id.mobile_no).setText(
                            i.child("mobile_no").getValue().toString()
                        )
                    }
                }

            }
        }
        database.addValueEventListener(getdata)
        database.addListenerForSingleValueEvent(getdata)

        //update profile

        logout.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }

    }
}

//  sb.append("key : ${i.key} emai; : $email firstname : $firstname lastname : $lastname mobile no : $mobile password : $password uid : $uid")

//                            var email = i.child("email").getValue()
//                            var firstname = i.child("fname").getValue()
//                            var lastname = i.child("lname").getValue()
//                            var mobile = i.child("mobile_no").getValue()
//

//
//                    lateinit var emailid : String
//                    lateinit var firstname : String
//                    lateinit var lastname : String
//                    lateinit var mobile : String
//                    lateinit var password : String
