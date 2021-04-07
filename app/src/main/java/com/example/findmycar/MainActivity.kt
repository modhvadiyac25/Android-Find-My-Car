package com.example.findmycar

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import android.widget.Toolbar
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() ,NavigationView.OnNavigationItemSelectedListener {

    //for drawer layout
    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //new drawerlauout code

        setSupportActionBar(toolbar1)

        val toggle = ActionBarDrawerToggle(this,drawerlayout,toolbar1,R.string.open,R.string.close)
        drawerlayout.addDrawerListener(toggle)

        toggle.syncState()


        //Drawer menu
       // toggle = ActionBarDrawerToggle(this, drawerlayout, R.string.open, R.string.close)
       // drawerlayout.addDrawerListener(toggle)

        // to connect this toggle with drawer layout
        //toggle.syncState()
        Toast.makeText(this,"email :  ${intent.getStringExtra("email_id").toString()}",Toast.LENGTH_LONG).show()
       // tv_email.text = "iamcheta@gmail.com" //intent.getStringExtra("email_id").toString()

//        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        navigation_view.setNavigationItemSelectedListener{
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
                R.id.nav_populer_cars -> {
                    val intent =
                        Intent(this@MainActivity, PopularCars::class.java)
                    intent.putExtra(
                        "user_id",
                        FirebaseAuth.getInstance().currentUser!!.uid
                    )
                    startActivity(intent)
                }

                R.id.nav_car_details -> {
                    val intent =
                        Intent(this@MainActivity, CarDetails::class.java)
                    intent.putExtra(
                        "user_id",
                        FirebaseAuth.getInstance().currentUser!!.uid
                    )
                    startActivity(intent)
                }

                R.id.EMI -> {
                    val intent =
                        Intent(this@MainActivity,  CarDetails::class.java)
                    intent.putExtra(
                        "user_id",
                        FirebaseAuth.getInstance().currentUser!!.uid
                    )
                    startActivity(intent)
                }
            }
            true
        }

        //redirect to the search avtivity
        search_relative_layout.setOnClickListener {
            startActivity(Intent(this,Search::class.java))
        }

        //login logo
//        profile_icon.setOnClickListener {
//            val intent =
//                Intent(this@MainActivity, UserProfile::class.java)
//            intent.putExtra(
//                "user_id",
//                FirebaseAuth.getInstance().currentUser!!.uid
//            )
//            startActivity(intent)
//        }

        //onclick of drawer menu icon
//        drawermenu_icon.setOnClickListener() {
//
//            //calling drawer menu
//
//        }
    }

    //UDF function for drawerlayout
//    fun navMenu() {
//
//    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }


    override fun onNavigationItemSelected(it: MenuItem): Boolean {
        TODO("Not yet implemented")


    }
}
