package com.example.findmycar

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_main.*
import java.util.regex.Pattern

class LoginActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btn_register.setOnClickListener {
            //startActivity(Intent(this@LoginActivity, RegisterActivity::class.java))
            // try this after everything ok !!
            onBackPressed()
        }

//        var btn = findViewById<Button>(R.id.btn_forgot_pass)
//        btn.setOnClickListener {
//            Toast.makeText(this@LoginActivity, "Email sent.", Toast.LENGTH_LONG)
//        }





        fun forgotPassword(username: EditText) {
            var email = username.text.toString().trim()
            if (email.isEmpty()) { //username.text.toString()
                return
            }
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                return
            }
            FirebaseAuth.getInstance().sendPasswordResetEmail(email)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this@LoginActivity, "Email sent.", Toast.LENGTH_LONG).show()
                        // Log.d(TAG, "Email sent.")
                    }
                    else{
                        Toast.makeText(this@LoginActivity,task.exception.toString(), Toast.LENGTH_LONG).show()
                    }
                }
        }
        btn_forgot_pass.setOnClickListener {
            Toast.makeText(this@LoginActivity, "Button is pressed", Toast.LENGTH_LONG).show()

            val builder: AlertDialog.Builder = AlertDialog.Builder(this)
            builder.setTitle("Forgot Password")
            val view = layoutInflater.inflate(R.layout.dialig_forget_password, null)
            builder.setView(view)
            val username =  view.findViewById<EditText>(R.id.et_username)

                builder.setPositiveButton("Reset", DialogInterface.OnClickListener { _, _ ->
                    forgotPassword(username)
                })
                builder.setNegativeButton("Close", DialogInterface.OnClickListener { _, _ ->

                })
                builder.show()

        }



        btn_sign_in.setOnClickListener {
            // if the input field is empty then toast will promted
            when {

                TextUtils.isEmpty(email.text.toString().trim() { it <= ' ' }) -> {
                    Toast.makeText(this@LoginActivity, "Please Enter Email", Toast.LENGTH_SHORT)
                        .show()
                }

                TextUtils.isEmpty(password.text.toString().trim() { it <= ' ' }) -> {
                    Toast.makeText(
                        this@LoginActivity,
                        "Please Enter Password",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                else -> {

                    val email: String = email.text.toString().trim() { it <= ' ' }
                    val password: String = password.text.toString().trim() { it <= ' ' }


                    FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(
                            { task ->

                                if (task.isSuccessful) {

                                    //    val firebaseuser: FirebaseUser = task.result!!.user!!

                                    Toast.makeText(
                                        this@LoginActivity,
                                        "You are Logged In succesfully !!",
                                        Toast.LENGTH_SHORT
                                    ).show()

                                    val intent =
                                        Intent(this@LoginActivity, MainActivity::class.java)
                                    // while trafering one activity to another, it will create new layer so to remove that unused layer  FLAGE_ACTIVITY_CLEAR_TASK is used
                                    intent.flags =
                                        Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                                    intent.putExtra(
                                        "user_id",
                                        FirebaseAuth.getInstance().currentUser!!.uid
                                    )
                                    intent.putExtra("email_id", email)
                                    startActivity(intent)
                                    finish()

                                } else {
                                    Toast.makeText(
                                        this@LoginActivity,
                                        task.exception!!.message.toString(),
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                            })
                }
            }
        }
    }




}
