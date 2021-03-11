package com.example.findmycar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem

import androidx.appcompat.app.ActionBarDrawerToggle
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.header.*

class MainActivity : AppCompatActivity() {

    //for drawer layout
    lateinit var toggle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //login logo
        profile_icon.setOnClickListener {

            val intent =
                Intent(this@MainActivity, UserProfile::class.java)
            intent.putExtra(
                "user_id",
                FirebaseAuth.getInstance().currentUser!!.uid
            )
            startActivity(intent)

        }

        //onclick of drawer menu icon
        drawermenu_icon.setOnClickListener() {

            //calling drawer menu
            navMenu()
        }
    }

    //UDF function for drawerlayout
    fun navMenu() {
        //for drawer layout
        toggle = ActionBarDrawerToggle(this, drawerlayout, R.string.open, R.string.close)
        drawerlayout.addDrawerListener(toggle)

        // to connect this toggle with drawer layout
        toggle.syncState()
        tv_email.text = intent.getStringExtra("email_id")

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        navigation_view.setNavigationItemSelectedListener {
            when (it.itemId) {

                R.id.login -> {
                    startActivity(
                        Intent(
                            this@MainActivity,
                            UploadPic::class.java
                        )
                    )
                }

                R.id.profile -> {
                    val intent =
                        Intent(this@MainActivity, UserProfile::class.java)
                    intent.putExtra(
                        "user_id",
                        FirebaseAuth.getInstance().currentUser!!.uid
                    )
                    startActivity(intent)
                }

                R.id.EMI -> {
                    val intent =
                        Intent(this@MainActivity, EMICalculator::class.java)
                    intent.putExtra(
                        "user_id",
                        FirebaseAuth.getInstance().currentUser!!.uid
                    )
                    startActivity(intent)
                }
            }
            true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
