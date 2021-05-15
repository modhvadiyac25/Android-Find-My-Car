package com.example.findmycar

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth
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


        navigation_view.setNavigationItemSelectedListener{
            when (it.itemId) {


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
                R.id.nav_top10_cars -> {
                    val intent =
                        Intent(this@MainActivity, PopularCars::class.java)
                    intent.putExtra(
                        "user_id",
                        FirebaseAuth.getInstance().currentUser!!.uid
                    )
                    startActivity(intent)
                }
                R.id.JustLaunchedCars -> {
                    val intent =
                        Intent(this@MainActivity, PopularCars::class.java)
                    intent.putExtra(
                        "user_id",
                        FirebaseAuth.getInstance().currentUser!!.uid
                    )
                    startActivity(intent)
                }

                R.id.nav_upcomming_cars -> {
                    val intent =
                        Intent(this@MainActivity, PopularCars::class.java)
                    intent.putExtra(
                        "user_id",
                        FirebaseAuth.getInstance().currentUser!!.uid
                    )
                    startActivity(intent)
                }
                R.id.news-> {
                    val intent =
                        Intent(this@MainActivity, NewsFeed::class.java)
                    intent.putExtra(
                        "user_id",
                        FirebaseAuth.getInstance().currentUser!!.uid
                    )
                    startActivity(intent)
                }


                R.id.EMI -> {
                    val intent =
                        Intent(this@MainActivity,  EmiCalculator::class.java)
                    intent.putExtra(
                        "user_id",
                        FirebaseAuth.getInstance().currentUser!!.uid
                    )
                    startActivity(intent)
                }
                R.id.logout -> {
                    FirebaseAuth.getInstance().signOut()
                    startActivity(Intent(this, LoginActivity::class.java))
                    finish()
                }
            }
            true
        }

        //redirect to the search avtivity
        context_search.setOnClickListener {
            startActivity(Intent(this,Search::class.java))
        }
    }



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