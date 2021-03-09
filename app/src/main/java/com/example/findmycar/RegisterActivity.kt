package com.example.findmycar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_register.*


class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        btn_register.setOnClickListener {
            startActivity(Intent(this@RegisterActivity, LoginActivity::class.java))
        }

        btn_sign_up.setOnClickListener {
            // if the input field is empty then toast will promted
            when {
                TextUtils.isEmpty(fname.text.toString().trim() { it <= ' ' }) -> {
                    Toast.makeText(
                        this@RegisterActivity,
                        "Please Enter First Name",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                TextUtils.isEmpty(lname.text.toString().trim() { it <= ' ' }) -> {
                    Toast.makeText(
                        this@RegisterActivity,
                        "Please Enter Last Name",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                TextUtils.isEmpty(mobile_no.text.toString().trim() { it <= ' ' }) -> {
                    Toast.makeText(
                        this@RegisterActivity,
                        "Please Enter Mobile No",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                TextUtils.isEmpty(email.text.toString().trim() { it <= ' ' }) -> {
                    Toast.makeText(this@RegisterActivity, "Please Enter Email", Toast.LENGTH_SHORT)
                        .show()
                }

                TextUtils.isEmpty(password.text.toString().trim() { it <= ' ' }) -> {
                    Toast.makeText(
                        this@RegisterActivity,
                        "Please Enter Password",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                TextUtils.isEmpty(cpassword.text.toString().trim() { it <= ' ' }) -> {
                    Toast.makeText(
                        this@RegisterActivity,
                        "Please Enter Confirm Password",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                else -> {

                    val fname: String = fname.text.toString().trim() { it <= ' ' }
                    val lname: String = lname.text.toString().trim() { it <= ' ' }
                    val mobile_no: Long = mobile_no.text.toString().trim() { it <= ' ' }.toLong()
                    val email: String = email.text.toString().trim() { it <= ' ' }
                    val password: String = password.text.toString().trim() { it <= ' ' }
                    val cpassword: String = cpassword.text.toString().trim() { it <= ' ' }
                    //this image url feild will be updated later on profile avtivity
                    val imageUrl = ""

                    var database = FirebaseDatabase.getInstance().getReference().child("users")
                    lateinit var firebaseuser: FirebaseUser
                    if(true){

                        if (password == cpassword) {

                            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                                .addOnCompleteListener(
                                    { task ->

                                        if (task.isSuccessful) {

                                            firebaseuser = task.result!!.user!!
                                            /*
                                                    Toast.makeText(
                                                        this@RegisterActivity,
                                                        "You are Registered succesfully !!",
                                                        Toast.LENGTH_SHORT
                                                    ).show()

                                             */

                                            database.child(firebaseuser.uid)
                                                .setValue(
                                                    User(
                                                        firebaseuser.uid,
                                                        fname,
                                                        lname,
                                                        email,
                                                        mobile_no,
                                                        imageUrl,
                                                        password
                                                    )
                                                )
                                            Toast.makeText(
                                                applicationContext,
                                                " Registration succesfull !! ",
                                                Toast.LENGTH_LONG
                                            ).show()


                                            val intent =
                                                Intent(this@RegisterActivity, MainActivity::class.java)
                                            // while trafering one activity to another, it will create new layer so to remove that unused layer  FLAGE_ACTIVITY_CLEAR_TASK is used
                                            intent.flags =
                                                Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                                            intent.putExtra("user_id", firebaseuser.uid)
                                            intent.putExtra("email_id", email)
                                            startActivity(intent)
                                            finish()

                                        } else {
                                            Toast.makeText(
                                                this@RegisterActivity,
                                                task.exception!!.message.toString(),
                                                Toast.LENGTH_SHORT
                                            ).show()
                                        }
                                    })


                        } else {
                            Toast.makeText(
                                applicationContext,
                                "Password and Confirm Password Does Not Match",
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }else
                    {
                        Toast.makeText(
                            applicationContext,
                            "Mobile no must be 10 digits long",
                            Toast.LENGTH_LONG
                        ).show()
                    }

                }
            }
        }

    }


}

