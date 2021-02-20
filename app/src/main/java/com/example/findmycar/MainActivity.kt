package com.example.findmycar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var navigationController : NavController
    private lateinit var appBarConfiguration : AppBarConfiguration
    private lateinit var  drawerLayout :DrawerLayout
    private lateinit var listener : NavController.OnDestinationChangedListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userId = intent.getStringExtra("user_id")
        val emailId = intent.getStringExtra("email_id")

        u_id.text = "User Id :: $userId"
        emailid.text = "Email Id :: $emailId"

        logout.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            startActivity(Intent(this@MainActivity,LoginActivity::class.java))
            finish()
        }
/*
        navigationController = findNavController(R.id.fragment)
        drawerLayout = findViewById(R.id.drawerlayout)
        navigation_view.setupWithNavController(navigationController)

        appBarConfiguration = AppBarConfiguration(navigationController.graph , drawerLayout)

        setupActionBarWithNavController(navigationController,appBarConfiguration)

        listener = NavController.OnDestinationChangedListener{ controller, destination, arguments ->

            if(destination.id == R.id.login_fragment){

            }else if(destination.id == R.id.signup_fragment){

            }
        }
*/

    }
/*
    override fun onSupportNavigateUp(): Boolean {
        var navController = findNavController(R.id.fragment)

        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

 */


}
