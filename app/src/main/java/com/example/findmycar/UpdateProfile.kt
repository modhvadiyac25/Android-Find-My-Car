package com.example.findmycar


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.google.firebase.storage.FirebaseStorage
import kotlinx.android.synthetic.main.activity_updateprofile.*


class UpdateProfile : AppCompatActivity() {

    var database: DatabaseReference = FirebaseDatabase.getInstance().getReference("users")
    private var mFirebaseInstance: FirebaseDatabase? = null
    var uid = FirebaseAuth.getInstance().currentUser?.uid



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_updateprofile)

        //load profile image from the firebase
        var imageref = FirebaseStorage.getInstance().reference.child("pics/" + uid!!)
        imageref.downloadUrl.addOnSuccessListener { Uri ->

            val imageURL = Uri.toString()
            var IV = findViewById<ImageView>(R.id.image_view)
            Glide.with(this)
                .load(imageURL)
                .into(IV)
        }


        //Delete user
        delete.setOnClickListener {

            database.child(uid!!).removeValue()
            FirebaseAuth.getInstance().currentUser!!.delete().addOnCompleteListener{task->
                if(task.isSuccessful){
                    Toast.makeText(this,"Account is Deleted",Toast.LENGTH_LONG).show()
                }else{
                    Toast.makeText(this,"" + task.exception,Toast.LENGTH_LONG).show()
                }
            }


            startActivity(Intent(this, RegisterActivity::class.java))
            finish()

        }


        //if someone try to change email
        email.setOnClickListener {
            Toast.makeText(this,"You cannot Update Email Id.",Toast.LENGTH_LONG).show()
        }

        // update button

        update.setOnClickListener {

            var fn = findViewById<EditText>(R.id.fn)
            var ln = findViewById<EditText>(R.id.ln)
            var mobile_no = findViewById<EditText>(R.id.mobile_no)

            if(!TextUtils.isEmpty(fn.getText().toString()) && !TextUtils.isEmpty(ln.getText().toString()) && !TextUtils.isEmpty(mobile_no.getText().toString())){

                database.child(uid!!).child("fname").setValue(fn.getText().toString())
                database.child(uid!!).child("lname").setValue(ln.getText().toString())
                database.child(uid!!).child("mobile_no").setValue(mobile_no.getText().toString())
                Toast.makeText(this,"Hurry ! Update Successfully !!",Toast.LENGTH_LONG).show()
            }
            else{
                Toast.makeText(this,"Opps ! Update Faild !!",Toast.LENGTH_LONG).show()
            } 
        }

        // show profile

        val id  = intent.getStringExtra("user_id").toString()
        var getdata = object : ValueEventListener {

            override fun onCancelled(error: DatabaseError) {

            }

            override fun onDataChange(snapshot: DataSnapshot) {

                //var sb = StringBuilder()
                for (i in snapshot.children) {
                    if (id.equals(i.child("uid").getValue())) {
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
//
//        logout.setOnClickListener {
//            FirebaseAuth.getInstance().signOut()
//            startActivity(Intent(this, LoginActivity::class.java))
//            finish()
//        }

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
